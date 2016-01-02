package com.applivery.applvsdklib.api.requests;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.requests.mappers.AndroidMapper;
import com.applivery.applvsdklib.api.requests.mappers.ApiAppConfigResponseMapper;
import com.applivery.applvsdklib.api.requests.mappers.SdkMapper;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import retrofit.Call;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public class ObtainAppConfigRequest extends ServerRequest {

  private AppliveryApiService apiService;
  private String appId;
  private ApiAppConfigResponseMapper apiAppConfigResponseMapper;

  public ObtainAppConfigRequest(AppliveryApiService apiService, String appId) {
    this.apiService = apiService;
    this.appId = appId;
    SdkMapper sdkMapper = new SdkMapper(new AndroidMapper());
    this.apiAppConfigResponseMapper = new ApiAppConfigResponseMapper(sdkMapper);
  }

  @Override protected BusinessObject performRequest() {
    Call<ApiAppConfigResponse> response = apiService.obtainAppConfig(appId);
    ApiAppConfigResponse apiAppConfigResponse = super.performRequest(response);
    BusinessObject businessObject = apiAppConfigResponseMapper.map(apiAppConfigResponse);
    return businessObject;
  }

}
