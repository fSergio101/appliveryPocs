package com.applivery.applvsdklib;

import android.content.Context;
import android.os.AsyncTask;
import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.AppliveryApiServiceBuilder;
import com.applivery.applvsdklib.tools.Validate;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public class AppliverySdk {

  private static final String TAG = AppliverySdk.class.getCanonicalName();
  private static volatile Executor executor;
  private static volatile String applicationId;
  private static volatile String applicationName;
  private static volatile String appClientToken;
  private static volatile AppliveryApiService appliveryApiService;
  private static final String APPLIVERY_COM = "applivery.com";
  private static volatile String appliveryDomain = APPLIVERY_COM;
  private static AtomicLong onProgressThreshold = new AtomicLong(65536);
  private static volatile boolean isDebugEnabled = BuildConfig.DEBUG;
  private static boolean isLegacyTokenUpgradeSupported = false;
  private static Context applicationContext;
  private static final int DEFAULT_CORE_POOL_SIZE = 5;
  private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
  private static final int DEFAULT_KEEP_ALIVE = 1;;
  private static final Object LOCK = new Object();

  private static final int MAX_REQUEST_CODE_RANGE = 100;

  private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE =
      new LinkedBlockingQueue<Runnable>(10);

  private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
    private final AtomicInteger counter = new AtomicInteger(0);

    public Thread newThread(Runnable runnable) {
      return new Thread(runnable, "AppliverySdk #" + counter.incrementAndGet());
    }
  };

  private static Boolean sdkInitialized = false;
  public static synchronized void sdkInitialize(Context applicationContext) {
    if (sdkInitialized) {
      return;
    }

    Validate.notNull(applicationContext, "applicationContext");

    Validate.hasInternetPermissions(applicationContext, false);

    AppliverySdk.applicationContext = applicationContext.getApplicationContext();
    AppliverySdk.appliveryApiService = AppliveryApiServiceBuilder.getAppliveryApiInstance();

    //TODO Assign Access token and appID

    //getExecutor().execute();

    sdkInitialized = true;
  }

  public static Executor getExecutor() {
    synchronized (LOCK) {
      if (AppliverySdk.executor == null) {
        AppliverySdk.executor = AsyncTask.THREAD_POOL_EXECUTOR;
      }
    }
    return AppliverySdk.executor;
  }

  public static void setExecutor(Executor executor) {
    Validate.notNull(executor, "executor");
    synchronized (LOCK) {
      AppliverySdk.executor = executor;
    }
  }

  public static Context getApplicationContext() {
    Validate.sdkInitialized();
    return applicationContext;
  }

  public static synchronized boolean isInitialized() {
    return sdkInitialized;
  }






}
