package com.applivery.applvsdklib.api.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class ApiAuthData {

  @Expose @SerializedName("")
  private String apiId;

  @Expose @SerializedName("")
  private String apiSecret;

  public ApiAuthData(String apiId, String apiSecret) {
    this.apiId = apiId;
    this.apiSecret = apiSecret;
  }

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public String getApiSecret() {
    return apiSecret;
  }

  public void setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
  }
}
