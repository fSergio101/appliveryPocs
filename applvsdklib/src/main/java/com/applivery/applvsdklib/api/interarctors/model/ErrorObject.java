package com.applivery.applvsdklib.api.interarctors.model;

import com.applivery.applvsdklib.api.responses.ApiAppliveryServerErrorResponse;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ErrorObject implements BusinessObject{

  private boolean isBusinessError;
  private String message;
  private int businessCode;

  public ErrorObject(ApiAppliveryServerErrorResponse serverResponse) {
    businessCode = serverResponse.getCode();
    message = serverResponse.getMsg();
    isBusinessError = serverResponse.isBusinessError();
  }
}
