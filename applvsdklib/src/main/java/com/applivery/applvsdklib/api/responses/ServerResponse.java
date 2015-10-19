package com.applivery.applvsdklib.api.responses;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("UnusedDeclaration")
public class ServerResponse<JsonObject> {

    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private JsonObject data;

    @SerializedName("error")
    private ApiAppliveryServerErrorResponse error;

    public ApiAppliveryServerErrorResponse getError() {
        return error;
    }

    public void setError(ApiAppliveryServerErrorResponse error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public boolean isSuccess() {
//        return status == null || !status.toUpperCase().equals("KO");
        return status != null && !status.toUpperCase().equals("KO");
    }

    public static ServerResponse cancel() {
        ServerResponse response = new ServerResponse();
        response.setStatus("KO");
        return response;
    }
}
