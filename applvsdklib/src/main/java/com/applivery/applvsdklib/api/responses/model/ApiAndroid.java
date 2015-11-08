package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ApiAndroid {

  @SerializedName("minVersion")
  @Expose
  private String minVersion;
  @SerializedName("lastBuildId")
  @Expose
  private String lastBuildId;
  @SerializedName("lastBuildVersion")
  @Expose
  private String lastBuildVersion;
  @SerializedName("storeLink")
  @Expose
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
