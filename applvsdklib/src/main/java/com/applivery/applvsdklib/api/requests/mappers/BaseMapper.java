package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.interarctors.model.ErrorObject;
import com.applivery.applvsdklib.api.responses.ServerResponse;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public abstract class BaseMapper {

  public BusinessObject map(ServerResponse serverResponse) {
    if (serverResponse.getHttpErrorResponseCodeType() == ServerResponse.HTTP_OK_RESPONSE_CODE){
      return mapBusinessObject(serverResponse);
    }else{
      return new ErrorObject();
    }
  }

  protected abstract BusinessObject mapBusinessObject(ServerResponse serverResponse);
}
