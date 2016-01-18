package com.applivery.applvsdklib.utils;

import com.applivery.applvsdklib.network.api.responses.ApiAppConfigResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 25/12/15.
 */
public interface AppliveryTestApi {

  @GET("/api/apps/{app_id}") Call<ApiAppConfigResponse> obtainAppConfig(@Path("app_id") String appId);

  @GET("/api/apps/error") Call<ApiAppConfigResponse> obtainAppConfigError();

  @GET("/api/apps/bad") Call<ApiAppConfigResponse> obtainAppConfigBad();
}
