package com.applivery.applvsdklib.tools;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.applivery.applvsdklib.AppliverySdk;
import com.applivery.applvsdklib.api.interactors.AppConfigChecker;
import com.applivery.applvsdklib.io.LastConfigReader;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 4/1/16.
 */
public class AppliveryActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks{

  private Activity activity;
  private final AppConfigChecker appConfigChecker;

  public AppliveryActivityLifecycleCallbacks() {
    LastConfigReader lastConfigReader = new AndroidLastConfigReaderImpl();
    this.appConfigChecker = new AppConfigChecker(lastConfigReader);
  }

  @Override public void onActivityResumed(Activity activity) {
    //TODO Register for phase 2 shake detector
    this.activity = activity;
    if (appConfigChecker.shouldCheckAppConfigForUpdate()){
      AppliverySdk.obtainAppConfigForCheckUpdates();
    }
  }

  @Override public void onActivityPaused(Activity activity) {
    //TODO Unregister for phase 2 shake detector
    this.activity = null;
  }

  public Activity getCurrentActivity() {
    return activity;
  }

  //region methods with not necessary implementation
  @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}

  @Override public void onActivityStarted(Activity activity) {}

  @Override public void onActivityStopped(Activity activity) {}

  @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

  @Override public void onActivityDestroyed(Activity activity) {}
  //endregion

}
