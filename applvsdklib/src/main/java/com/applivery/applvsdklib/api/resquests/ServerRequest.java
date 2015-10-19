package com.applivery.applvsdklib.api.resquests;

import com.applivery.applvsdklib.api.responses.ServerResponse;
import java.util.logging.Handler;

public abstract class ServerRequest {
    private Handler handler;

    public ServerRequest(Handler handler) {
        this.handler = handler;
    }

    public final ServerResponse execute() {
        ServerResponse response;
        response = performRequest();

        //TODO Add error management

        return response;
    }

    protected abstract ServerResponse performRequest();
}
