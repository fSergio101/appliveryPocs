package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.AppliverySdk;
import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.BuildTokenInfo;
import com.applivery.applvsdklib.api.interactors.model.BusinessObject;
import com.applivery.applvsdklib.api.interactors.model.DownloadResult;
import com.applivery.applvsdklib.api.interactors.model.ErrorObject;
import com.applivery.applvsdklib.api.requests.DownloadBuildRequest;
import com.applivery.applvsdklib.api.requests.DownloadStatusListener;
import com.applivery.applvsdklib.tools.AndroidAppInstallerImpl;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 9/1/16.
 */
public class DownloadBuildInteractor extends BaseInteractor<DownloadResult> {

  private final DownloadBuildRequest downloadBuildRequest;
  private final InteractorCallback<DownloadResult> interactorCallback;
  private final DownloadStatusListener downloadStatusListener;
  private final AppInstaller appInstaller;

  public DownloadBuildInteractor(AppliveryApiService appliveryApiService, String appName,
      BuildTokenInfo buildTokenInfo, final InteractorCallback interactorCallback) {

    this.downloadStatusListener = new DownloadStatusListener() {
      @Override public void updateDownloadPercentStatus(double percent) {
        //TODO implement new type of callback if necessary to update progress;
      }
    };

    this.downloadBuildRequest = new DownloadBuildRequest(appliveryApiService, buildTokenInfo,
        appName, downloadStatusListener);
    this.interactorCallback = interactorCallback;
    this.appInstaller = new AndroidAppInstallerImpl(AppliverySdk.getApplicationContext());
  }

  @Override protected void receivedResponse(DownloadResult downloadResult) {
    super.receivedResponse(downloadResult, DownloadResult.class);
  }

  @Override protected void error(ErrorObject serverResponse) {
    interactorCallback.onError(serverResponse);
  }

  @Override protected void success(DownloadResult response) {
    interactorCallback.onSuccess(response);
    appInstaller.installApp(response.getPath());
  }

  @Override protected BusinessObject performRequest() {
    return downloadBuildRequest.execute();
  }

  public static Runnable getInstance(AppliveryApiService appliveryApiService, String appName,
      BuildTokenInfo buildTokenInfo, InteractorCallback interactorCallback) {

    DownloadBuildInteractor downloadBuildInteractor =
        new DownloadBuildInteractor(appliveryApiService, appName, buildTokenInfo, interactorCallback);

    return downloadBuildInteractor;
  }
}
