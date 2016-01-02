package com.applivery.applvsdklib.api.interarctors.model;

import java.util.Date;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class AuthData implements BusinessObject {

  private String accessToken;
  private Date expirationDate;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }
}
