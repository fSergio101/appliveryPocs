package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.api.interactors.model.DownloadResult;
import com.applivery.applvsdklib.api.interactors.model.ErrorObject;
import com.applivery.applvsdklib.ui.ShowErrorAlert;
import com.applivery.applvsdklib.ui.UpdateView;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 10/1/16.
 */
public class DownloadBuildInteractorCallback implements InteractorCallback<DownloadResult> {

  private final UpdateView updateView;

  public DownloadBuildInteractorCallback(UpdateView updateView) {
    this.updateView = updateView;
  }

  @Override public void onSuccess(DownloadResult businessObject) {
    updateView.hideDownloadInProgress();
  }

  @Override public void onError(ErrorObject error) {
    ShowErrorAlert showErrorAlert = new ShowErrorAlert();
    showErrorAlert.showError(error);
  }
}
