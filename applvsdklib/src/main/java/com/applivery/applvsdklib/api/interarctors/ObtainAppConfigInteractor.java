package com.applivery.applvsdklib.api.interarctors;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interarctors.model.AppConfig;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.interarctors.model.ErrorObject;
import com.applivery.applvsdklib.api.requests.ObtainAppConfigRequest;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 7/11/15.
 */
public class ObtainAppConfigInteractor extends BaseInteractor<AppConfig> {

  private final ObtainAppConfigRequest obtainAppConfigRequest;

  public ObtainAppConfigInteractor(AppliveryApiService apiService, String appId) {
    obtainAppConfigRequest = new ObtainAppConfigRequest(apiService, appId);
  }

  @Override protected void receivedResponse(AppConfig obj) {
    super.receivedResponse(obj, AppConfig.class);
  }

  @Override protected void error(ErrorObject errorObject) {

  }

  @Override protected void success(AppConfig appConfig) {

  }

  @Override protected BusinessObject performRequest() {
    return obtainAppConfigRequest.execute();
  }
}
