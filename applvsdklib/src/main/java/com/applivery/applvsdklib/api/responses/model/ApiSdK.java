package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ApiSdK {

  @SerializedName("android")
  @Expose
  private ApiAndroid android;

  @SerializedName("updateMsg")
  @Expose
  private String updateMsg;
  @SerializedName("mustUpdateMsg")
  @Expose
  private String mustUpdateMsg;

  @SerializedName("forceUpdate")
  @Expose
  private boolean forceUpdate;
  @SerializedName("storeRelease")
  @Expose
  private boolean storeRelease;
  @SerializedName("ota")
  @Expose
  private boolean ota;
  @SerializedName("active")
  @Expose
  private boolean active;

  public ApiAndroid getAndroid() {
    return android;
  }

  public void setAndroid(ApiAndroid android) {
    this.android = android;
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

  public boolean isForceUpdate() {
    return forceUpdate;
  }

  public void setForceUpdate(boolean forceUpdate) {
    this.forceUpdate = forceUpdate;
  }

  public boolean isStoreRelease() {
    return storeRelease;
  }

  public void setStoreRelease(boolean storeRelease) {
    this.storeRelease = storeRelease;
  }

  public boolean isOta() {
    return ota;
  }

  public void setOta(boolean ota) {
    this.ota = ota;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
