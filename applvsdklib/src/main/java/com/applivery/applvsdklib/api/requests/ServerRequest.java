package com.applivery.applvsdklib.api.requests;

import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.responses.ServerResponse;
import java.io.IOException;
import retrofit.Call;
import retrofit.Response;

public abstract class ServerRequest {

    public final BusinessObject execute() {
        return performRequest();
    }

    protected abstract BusinessObject performRequest();

    public <T extends ServerResponse> T performRequest(Class<T> classType, Call<T> call) {

        T response = null;

        try{

            Response<T> apiResponse = call.execute();

            if (apiResponse.isSuccess()) {
                apiResponse.body().setHttpErrorResponseCodeType(ServerResponse.HTTP_OK_RESPONSE_CODE);
            }else if (!apiResponse.isSuccess()){
                apiResponse.body().setHttpErrorResponseCodeType(ServerResponse.CLIENT_HTTP_ERROR_RESPONSE_CODE);
                //apiResponse.body().setHttpErrorResponseCodeType(ServerResponse.SERVER_HTTP_ERROR_RESPONSE_CODE);
            }

        }catch (IOException ioException){
            response = classType.cast(new ServerResponse<T>());
            response.setError(null);
        }

        return response;

    }
}
