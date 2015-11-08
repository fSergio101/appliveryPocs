package com.applivery.applvsdklib.api.interarctors.model;

import com.applivery.applvsdklib.api.responses.ServerResponse;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ErrorObject implements BusinessObject{

  private static final String NETWORK_ERROR_STATUS = "NO_CONNECTION";

  private String status = null;
  private String message = null;
  private int businessCode = 0;

  public ErrorObject(ServerResponse serverResponse, boolean network) {
    if (!network){
      this.status = serverResponse.getStatus();
      this.message = serverResponse.getError().getMsg();
      this.businessCode = serverResponse.getError().getCode();
    }else{
      this.status = NETWORK_ERROR_STATUS;
    }

  }
}
