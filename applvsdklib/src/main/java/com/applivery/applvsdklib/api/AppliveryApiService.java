package com.applivery.applvsdklib.api;

import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public interface AppliveryApiService {

  @GET("/api/apps/{app_id}") Call<ApiAppConfigResponse> obtainAppConfig(@Path("app_id") String appId);

  @GET("/api/builds/{build_id}/token")
  Call<ApiAppTokenResponse> obtainAppToken(@Path("build_id") String buildId);

  @GET("/download/{build_id}/{download_token}")
  Call<THIS_IS_BINARY_FILE_response> downloadBuild(@Path("build_id") String buildId, @Path("download_token") String download_token);

  @POST("/api/bugs")
  Call<ApiBugResponse> sendBug(ApiBugRequest bugRequest);

  @POST("/api/crashes/")
  Call<ApiCrashResponse> reportCrash(ApiCrashRequest crashRequest);

}

