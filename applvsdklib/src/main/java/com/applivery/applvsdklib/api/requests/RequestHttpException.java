package com.applivery.applvsdklib.api.requests;

import com.applivery.applvsdklib.api.responses.ServerResponse;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 26/12/15.
 */
public class RequestHttpException extends RuntimeException {
  private ServerResponse serverResponse;

  public RequestHttpException(ServerResponse serverResponse) {
    this.serverResponse = serverResponse;
  }

  public ServerResponse getServerResponse() {
    return serverResponse;
  }

}
