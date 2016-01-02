package com.applivery.applvsdklib.api.requests;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.requests.mappers.ApiAuthResponseMapper;
import com.applivery.applvsdklib.api.responses.ApiAuthDataResponse;
import retrofit.Call;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class AuthRequest extends ServerRequest {

  private AppliveryApiService apiService;
  private ApiAuthData apiAuthData;
  private ApiAuthResponseMapper apiAuthResponseMapper;

  public AuthRequest(AppliveryApiService apiService, String apiId, String apiSecret,
      ApiAuthResponseMapper apiAuthResponseMapper) {
    this.apiService = apiService;
    this.apiAuthResponseMapper = apiAuthResponseMapper;
    this.apiAuthData = new ApiAuthData(apiId, apiSecret);
  }

  @Override protected BusinessObject performRequest() {
    Call<ApiAuthDataResponse> response = apiService.auth(apiAuthData);
    ApiAuthDataResponse apiAuthDataResponse = super.performRequest(response);
    BusinessObject businessObject = apiAuthResponseMapper.map(apiAuthDataResponse);
    return businessObject;
  }

}
