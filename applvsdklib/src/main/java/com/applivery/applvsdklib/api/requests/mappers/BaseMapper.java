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
    }else if (serverResponse.getHttpErrorResponseCodeType() ==
        ServerResponse.CLIENT_HTTP_ERROR_RESPONSE_CODE ||
        serverResponse.getHttpErrorResponseCodeType() ==
            ServerResponse.SERVER_HTTP_ERROR_RESPONSE_CODE ){
      return new ErrorObject(serverResponse, false);
    }else{
      return new ErrorObject(serverResponse, true);
    }
  }

  protected abstract BusinessObject mapBusinessObject(ServerResponse serverResponse);
}
