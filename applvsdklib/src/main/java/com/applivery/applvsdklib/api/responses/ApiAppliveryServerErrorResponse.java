package com.applivery.applvsdklib.api.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public class ApiAppliveryServerErrorResponse {

  @Expose @SerializedName("code")
  private int code;

  @Expose @SerializedName("msg")
  private String msg;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
