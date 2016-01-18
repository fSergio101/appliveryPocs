package com.applivery.applvsdklib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.applivery.applvsdklib.domain.exceptions.NotForegroundActivityAvailable;
import com.applivery.applvsdklib.network.api.AppliveryApiService;
import com.applivery.applvsdklib.network.api.AppliveryApiServiceBuilder;
import com.applivery.applvsdklib.domain.appconfig.ObtainAppConfigInteractor;
import com.applivery.applvsdklib.tools.androidimplementations.AndroidCurrentAppInfo;
import com.applivery.applvsdklib.tools.androidimplementations.AppliveryActivityLifecycleCallbacks;
import com.applivery.applvsdklib.tools.utils.Validate;
import com.applivery.applvsdklib.tools.permissions.AndroidPermissionCheckerImpl;
import com.applivery.applvsdklib.tools.permissions.PermissionChecker;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public class AppliverySdk {

  private static final String TAG = AppliverySdk.class.getCanonicalName();
  private static volatile Executor executor;
  private static volatile String applicationId;
  private static volatile String appClientToken;
  private static boolean isPlayStoreRelease = false;
  private static volatile AppliveryApiService appliveryApiService;
  private static volatile boolean isDebugEnabled = BuildConfig.DEBUG;
  private static Context applicationContext;
  private static PermissionChecker permissionRequestManager;
  private static AppliveryActivityLifecycleCallbacks activityLifecycle;
  private static final Object LOCK = new Object();

  private static final String APPLIVERY_COM = "applivery.com";
  //private static final int DEFAULT_CORE_POOL_SIZE = 5;
  //private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
  //private static final int DEFAULT_KEEP_ALIVE = 1;
  //
  //private static final int MAX_REQUEST_CODE_RANGE = 100;
  //
  //private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE =
  //    new LinkedBlockingQueue<Runnable>(10);
  //
  //private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
  //  private final AtomicInteger counter = new AtomicInteger(0);
  //
  //  public Thread newThread(Runnable runnable) {
  //    return new Thread(runnable, "AppliverySdk #" + counter.incrementAndGet());
  //  }
  //};

  private static Boolean sdkInitialized = false;

  //Add boolean isPlayStoreRelease --> Add javadoc comment to this variable in order to explain
  // what is and why

  public static synchronized void sdkInitialize(Application app,
      String applicationId, String appClientToken, boolean isPlayStoreRelease) {

    if (sdkInitialized) {

      obtainAppConfig();

      return;

    }else{

      initializeAppliveryConstants(app, applicationId, appClientToken, isPlayStoreRelease);

      sdkInitialized = true;

      obtainAppConfig();
    }

  }

  private static void initializeAppliveryConstants(Application app, String applicationId,
      String appClientToken, boolean isPlayStoreRelease) {

    //region validate some requirements
    Context applicationContext = Validate.notNull(app, "Application").getApplicationContext();
    Validate.notNull(applicationContext, "applicationContext");
    Validate.hasInternetPermissions(applicationContext, false);
    //endregion

    AppliverySdk.applicationId = applicationId;
    AppliverySdk.appClientToken = appClientToken;
    AppliverySdk.isPlayStoreRelease = isPlayStoreRelease;

    AppliverySdk.applicationContext = applicationContext;

    AppliverySdk.appliveryApiService = AppliveryApiServiceBuilder.getAppliveryApiInstance();
    AppliverySdk.permissionRequestManager = new AndroidPermissionCheckerImpl(applicationContext);
    AppliverySdk.activityLifecycle = new AppliveryActivityLifecycleCallbacks();

    app.registerActivityLifecycleCallbacks(activityLifecycle);
  }

  private static void obtainAppConfig() {
    if (!isPlayStoreRelease){
      getExecutor().execute(ObtainAppConfigInteractor.getInstance(appliveryApiService,
          AppliverySdk.applicationId, AppliverySdk.appClientToken,
          new AndroidCurrentAppInfo(applicationContext)));
    }
  }

  public static Executor getExecutor() {
    synchronized (LOCK) {
      if (AppliverySdk.executor == null) {
        AppliverySdk.executor = AsyncTask.THREAD_POOL_EXECUTOR;
      }
    }
    return AppliverySdk.executor;
  }

  //public static void setExecutor(Executor executor) {
  //  Validate.notNull(executor, "executor");
  //  synchronized (LOCK) {
  //    AppliverySdk.executor = executor;
  //  }
  //}

  public static Context getApplicationContext() {
    Validate.sdkInitialized();
    return applicationContext;
  }

  public static PermissionChecker getPermissionRequestManager() {
    Validate.sdkInitialized();
    return permissionRequestManager;
  }

  public static Activity getCurrentActivity() throws NotForegroundActivityAvailable {
    Validate.sdkInitialized();
    Activity activity = activityLifecycle.getCurrentActivity();
    if (activity!=null){
      return activity;
    }else{
      throw new NotForegroundActivityAvailable("There is not any available ActivityContext");
    }
  }

  public static boolean isContextAvailable() {
    Validate.sdkInitialized();
    return (activityLifecycle.getCurrentActivity()!=null)? true : false;
  }

  public static synchronized boolean isInitialized() {
    return sdkInitialized;
  }

  public static void obtainAppConfigForCheckUpdates() {
    Validate.sdkInitialized();
    obtainAppConfig();
  }

  public static String getToken() {
    Validate.sdkInitialized();
    return appClientToken;
  }

  public static void continuePendingPermissionsRequestsIfPossible() {
    Validate.sdkInitialized();
    permissionRequestManager.continuePendingPermissionsRequestsIfPossible();
  }

  public static boolean isStoreRelease() {
    return isPlayStoreRelease;
  }

  public static class Logger {
    private static volatile boolean debug = isDebugEnabled;
    public static void log(String text){
      if (debug){
        Log.d(TAG, text);
      }
    }
  }
}
