package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.BuildTokenInfo;
import com.applivery.applvsdklib.api.interactors.model.BusinessObject;
import com.applivery.applvsdklib.api.interactors.model.ErrorObject;
import com.applivery.applvsdklib.api.requests.ObtainBuildDownloadTokenRequest;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 9/1/16.
 */
public class ObtainAppBuildDownloadTokenInteractor extends BaseInteractor<BuildTokenInfo> {

  private final ObtainBuildDownloadTokenRequest obtainBuildDownloadTokenRequest;
  private final InteractorCallback<BuildTokenInfo> infoInteractorCallback;

  public ObtainAppBuildDownloadTokenInteractor(AppliveryApiService appliveryApiService,
      String buildId, InteractorCallback<BuildTokenInfo> infoInteractorCallback) {

    this.obtainBuildDownloadTokenRequest = new ObtainBuildDownloadTokenRequest(appliveryApiService, buildId);
    this.infoInteractorCallback = infoInteractorCallback;
  }

  @Override protected void receivedResponse(BuildTokenInfo obj) {
    super.receivedResponse(obj, BuildTokenInfo.class);
  }

  @Override protected void error(ErrorObject serverResponse) {
    infoInteractorCallback.onError(serverResponse);
  }

  @Override protected void success(BuildTokenInfo response) {
    infoInteractorCallback.onSuccess(response);
  }

  @Override protected BusinessObject performRequest() {
    return obtainBuildDownloadTokenRequest.execute();
  }

  public static Runnable getInstance(AppliveryApiService appliveryApiService, String buildId,
    InteractorCallback interactorCallback) {

    ObtainAppBuildDownloadTokenInteractor obtainAppBuildDownloadTokenInteractor =
        new ObtainAppBuildDownloadTokenInteractor(appliveryApiService, buildId, interactorCallback);

    return obtainAppBuildDownloadTokenInteractor;
  }
}
