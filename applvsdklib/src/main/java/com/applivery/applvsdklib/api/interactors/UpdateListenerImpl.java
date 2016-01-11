package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.AppConfig;
import com.applivery.applvsdklib.ui.UpdateListener;
import com.applivery.applvsdklib.ui.UpdateView;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 10/1/16.
 */
public class UpdateListenerImpl implements UpdateListener {

  private final AppConfig appConfig;
  private final AppliveryApiService apiService;
  private UpdateView updateView;

  public UpdateListenerImpl(AppConfig appConfig, AppliveryApiService apiService) {
    this.appConfig = appConfig;
    this.apiService = apiService;
  }

  @Override public void onUpdateButtonClick() {
    String buildId = appConfig.getSdk().getAndroid().getLastBuildId();

    InteractorCallback interactorCallback = new ObtainBuildTokenInteractorCallback(
        apiService, appConfig.getName(), updateView);

    ObtainAppBuildDownloadTokenInteractor.getInstance(apiService, buildId, interactorCallback);
  }

  @Override public void setUpdateView(UpdateView updateView) {
    this.updateView = updateView;
  }
}
