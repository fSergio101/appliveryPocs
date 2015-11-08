package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ApiSdK {

  @SerializedName("ota")
  @Expose
  private Boolean ota;
  @SerializedName("forceUpdate")
  @Expose
  private Boolean forceUpdate;
  @SerializedName("ios")
  @Expose
  private ApiIos ios;
  @SerializedName("android")
  @Expose
  private ApiAndroid android;
  @SerializedName("storeRelease")
  @Expose
  private Boolean storeRelease;
  @SerializedName("updateMsg")
  @Expose
  private String updateMsg;
  @SerializedName("mustUpdateMsg")
  @Expose
  private String mustUpdateMsg;

  public Boolean getOta() {
    return ota;
  }

  public void setOta(Boolean ota) {
    this.ota = ota;
  }

  public Boolean getForceUpdate() {
    return forceUpdate;
  }

  public void setForceUpdate(Boolean forceUpdate) {
    this.forceUpdate = forceUpdate;
  }

  public ApiIos getIos() {
    return ios;
  }

  public void setIos(ApiIos ios) {
    this.ios = ios;
  }

  public ApiAndroid getAndroid() {
    return android;
  }

  public void setAndroid(ApiAndroid android) {
    this.android = android;
  }

  public Boolean getStoreRelease() {
    return storeRelease;
  }

  public void setStoreRelease(Boolean storeRelease) {
    this.storeRelease = storeRelease;
  }

  public String getUpdateMsg() {
    return updateMsg;
  }

  public void setUpdateMsg(String updateMsg) {
    this.updateMsg = updateMsg;
  }

  public String getMustUpdateMsg() {
    return mustUpdateMsg;
  }

  public void setMustUpdateMsg(String mustUpdateMsg) {
    this.mustUpdateMsg = mustUpdateMsg;
  }
}
