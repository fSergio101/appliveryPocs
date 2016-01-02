package com.applivery.applvsdklib.api.interarctors.model;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class Sdk {

  private boolean ota;
  private boolean forceUpdate;
  private Android android;
  private boolean storeRelease;
  private String updateMsg;
  private String mustUpdateMsg;

  public boolean isOta() {
    return ota;
  }

  public void setOta(boolean ota) {
    this.ota = ota;
  }

  public boolean isForceUpdate() {
    return forceUpdate;
  }

  public void setForceUpdate(boolean forceUpdate) {
    this.forceUpdate = forceUpdate;
  }

  public Android getAndroid() {
    return android;
  }

  public void setAndroid(Android android) {
    this.android = android;
  }

  public boolean isStoreRelease() {
    return storeRelease;
  }

  public void setStoreRelease(boolean storeRelease) {
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
