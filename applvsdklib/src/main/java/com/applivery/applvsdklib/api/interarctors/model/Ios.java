package com.applivery.applvsdklib.api.interarctors.model;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class Ios {

  private String minVersion;
  private String lastBuildId;
  private String lastBuildVersion;
  private String storeLink;

  public String getMinVersion() {
    return minVersion;
  }

  public void setMinVersion(String minVersion) {
    this.minVersion = minVersion;
  }

  public String getLastBuildId() {
    return lastBuildId;
  }

  public void setLastBuildId(String lastBuildId) {
    this.lastBuildId = lastBuildId;
  }

  public String getLastBuildVersion() {
    return lastBuildVersion;
  }

  public void setLastBuildVersion(String lastBuildVersion) {
    this.lastBuildVersion = lastBuildVersion;
  }

  public String getStoreLink() {
    return storeLink;
  }

  public void setStoreLink(String storeLink) {
    this.storeLink = storeLink;
  }
}
