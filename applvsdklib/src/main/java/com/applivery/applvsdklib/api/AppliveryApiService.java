package com.applivery.applvsdklib.api;

import com.applivery.applvsdklib.api.requests.ApiAuthData;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.api.responses.ApiAppTokenResponse;
import com.applivery.applvsdklib.api.responses.ApiAuthDataResponse;
import com.applivery.applvsdklib.api.responses.ApiFeedbackResponse;
import com.applivery.applvsdklib.api.responses.model.ApiFeedbackResponseData;
import com.squareup.okhttp.Response;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Streaming;

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

  @GET("/api/builds/{build_id}/token")
  Call<ApiAppTokenResponse> obtainAppToken(@Path("build_id") String buildId);

  @GET("/download/{build_id}/{download_token}")
  @Streaming
  //use this and use reporter for progress in the request for keep UI informed about qtty of
  // bytes read from inputStream
  // look at http://stackoverflow.com/questions/6160432/java-inputstream-reading-problem
  // http://stackoverflow.com/questions/32878478/how-to-download-file-in-android-using-retrofit-library
  // http://stackoverflow.com/questions/4604239/install-application-programmatically-on-android
  Call<Response> downloadBuild(@Path("build_id") String buildId, @Path("download_token") String download_token);

  //TODO
  //@POST("/api/crashes/")
  //Call<ApiCrashResponse> reportCrash(ApiCrashRequest crashRequest);

}

