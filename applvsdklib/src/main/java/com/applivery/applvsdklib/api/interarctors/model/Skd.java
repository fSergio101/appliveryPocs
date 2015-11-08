package com.applivery.applvsdklib.api.interarctors.model;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class Skd {

  private Boolean ota;
  private Boolean forceUpdate;
  private Ios ios;
  private Android android;
  private Boolean storeRelease;
  private String updateMsg;
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

  public Ios getIos() {
    return ios;
  }

  public void setIos(Ios ios) {
    this.ios = ios;
  }

  public Android getAndroid() {
    return android;
  }

  public void setAndroid(Android android) {
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
