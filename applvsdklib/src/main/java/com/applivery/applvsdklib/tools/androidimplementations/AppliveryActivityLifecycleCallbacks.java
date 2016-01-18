package com.applivery.applvsdklib.tools.androidimplementations;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.applivery.applvsdklib.AppliverySdk;
import com.applivery.applvsdklib.domain.appconfig.update.AppConfigChecker;
import com.applivery.applvsdklib.domain.appconfig.update.LastConfigReader;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 4/1/16.
 */
public class AppliveryActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks{

  private Stack<ActivityLifecyleWrapper> activityStack = new Stack<>();
  private final AppConfigChecker appConfigChecker;

  public AppliveryActivityLifecycleCallbacks() {
    LastConfigReader lastConfigReader = new AndroidLastConfigReaderImpl();
    this.appConfigChecker = new AppConfigChecker(lastConfigReader);
  }

  @Override public void onActivityResumed(Activity activity) {
    //TODO Register for phase 2 shake detector
    activityStack.peek().setIsPaused(false);
    if (appConfigChecker.shouldCheckAppConfigForUpdate()){
      AppliverySdk.obtainAppConfigForCheckUpdates();
      AppliverySdk.continuePendingPermissionsRequestsIfPossible();
    }
  }

  @Override public void onActivityPaused(Activity activity) {
    //TODO Unregister for phase 2 shake detector
    activityStack.peek().setIsPaused(true);
  }

  public Activity getCurrentActivity() {

    Activity activity = lastForegroundActivity();

    if (activity!=null){
      return activity;
    }

    activity = lastPausedActivity();

    if (activity!=null){
      return activity;
    }

    if (activityStack.size()>0){
      activity = activityStack.peek().getActivity();

      if (activity!=null){
        return activity;
      }
    }

    return null;
  }

  private Activity lastPausedActivity() {
    Iterator<ActivityLifecyleWrapper> iter = activityStack.iterator();

    while (iter.hasNext()){
      ActivityLifecyleWrapper activityLifecyleWrapper = iter.next();
      if (!activityLifecyleWrapper.isStopped()){
        return activityLifecyleWrapper.getActivity();
      }
    }
    return null;
  }

  private Activity lastForegroundActivity() {

    Iterator<ActivityLifecyleWrapper> iter = activityStack.iterator();

    while (iter.hasNext()){
      ActivityLifecyleWrapper activityLifecyleWrapper = iter.next();
      if (!activityLifecyleWrapper.isPaused()){
        return activityLifecyleWrapper.getActivity();
      }
    }
    return null;
  }

  //region methods with not necessary implementation
  @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    this.activityStack.push(new ActivityLifecyleWrapper(activity, true, false));
  }

  @Override public void onActivityStarted(Activity activity) {
    activityStack.peek().setIsStopped(false);
  }

  @Override public void onActivityStopped(Activity activity) {
    activityStack.peek().setIsStopped(true);
  }

  @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

  @Override public void onActivityDestroyed(Activity activity) {
    this.activityStack.pop();
  }
  //endregion

}
