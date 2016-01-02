package com.applivery.applvsdklib.api;

import com.applivery.applvsdklib.api.requests.ApiAuthData;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.api.responses.ApiAuthDataResponse;
import com.applivery.applvsdklib.api.responses.ApiFeedbackResponse;
import com.applivery.applvsdklib.api.responses.model.ApiFeedbackResponseData;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public interface AppliveryApiService {

  @GET("/api/apps/{app_id}") Call<ApiAppConfigResponse> obtainAppConfig(@Path("app_id") String appId);

  @POST("/api/auth")
  Call<ApiAuthDataResponse> auth(@Body ApiAuthData apiAuthData);

  @POST("/api/bugs")
  Call<ApiFeedbackResponse> sendFeedback(@Body ApiFeedbackResponseData bugRequest);

  //@GET("/api/builds/{build_id}/token")
  //Call<ApiAppTokenResponse> obtainAppToken(@Path("build_id") String buildId);
  //
  //@GET("/download/{build_id}/{download_token}")
  //Call<THIS_IS_BINARY_FILE_response> downloadBuild(@Path("build_id") String buildId, @Path("download_token") String download_token);
  //
  //@POST("/api/crashes/")
  //Call<ApiCrashResponse> reportCrash(ApiCrashRequest crashRequest);

}

