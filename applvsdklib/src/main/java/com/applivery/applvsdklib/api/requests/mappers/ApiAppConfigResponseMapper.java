package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interarctors.model.AppConfig;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.api.responses.ServerResponse;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ApiAppConfigResponseMapper extends BaseMapper{

  public BusinessObject map(ApiAppConfigResponse apiAppConfigResponse) {
    return super.map(apiAppConfigResponse);
  }

  @Override protected BusinessObject mapBusinessObject(ServerResponse serverResponse) {
    return new AppConfig();
  }
}
