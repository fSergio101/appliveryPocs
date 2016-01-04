package com.applivery.applvsdklib.ui;

import com.applivery.applvsdklib.api.interactors.AppConfigInteractorCallback;
import com.applivery.applvsdklib.api.interactors.model.ErrorObject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/1/16.
 */
public class UpdateViewPresenter {

  private final AppConfigInteractorCallback appConfigInteractorCallback;
  private final UpdateView updateView;

  public UpdateViewPresenter() {

    this.updateView = new UpdateViewImpl();

    this.appConfigInteractorCallback = new AppConfigInteractorCallback() {
      @Override public void showForceUpdateDialog() {
        updateView.showForceUpdateDialog();
      }

      @Override public void onSuccess(Object businessObject) {
        //not necessary to implement
      }

      @Override public void onError(ErrorObject error) {
        ShowErrorAlert showErrorAlert = new ShowErrorAlert();
        showErrorAlert.showError(error);
      }
    };
  }

  public AppConfigInteractorCallback getAppConfigInteractorCallback() {
    return appConfigInteractorCallback;
  }
}
