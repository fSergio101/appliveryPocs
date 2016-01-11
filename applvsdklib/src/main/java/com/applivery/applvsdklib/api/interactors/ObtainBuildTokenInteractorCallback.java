package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.BuildTokenInfo;
import com.applivery.applvsdklib.api.interactors.model.ErrorObject;
import com.applivery.applvsdklib.ui.ShowErrorAlert;
import com.applivery.applvsdklib.ui.UpdateView;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 10/1/16.
 */
public class ObtainBuildTokenInteractorCallback implements InteractorCallback<BuildTokenInfo>{

  private final AppliveryApiService apiService;
  private final String appName;
  private final UpdateView updateView;

  public ObtainBuildTokenInteractorCallback(AppliveryApiService apiService, String appName,
      UpdateView updateView) {
    this.apiService = apiService;
    this.appName = appName;
    this.updateView = updateView;
  }

  @Override public void onSuccess(BuildTokenInfo buildTokenInfo) {
    updateView.showDownloadInProgress();
    InteractorCallback interactorCallback = new DownloadBuildInteractorCallback(updateView);
    DownloadBuildInteractor.getInstance(apiService, appName ,buildTokenInfo, interactorCallback);
  }

  @Override public void onError(ErrorObject error) {
    ShowErrorAlert showErrorAlert = new ShowErrorAlert();
    showErrorAlert.showError(error);
  }
}
