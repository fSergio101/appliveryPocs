package com.applivery.applvsdklib.api.resquests;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.api.responses.ServerResponse;
import java.util.logging.Handler;
import retrofit.Call;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 18/10/15.
 */
public class ObtainAppConfigRequest extends ServerRequest {

  private AppliveryApiService apiService;
  private String appId;

  public ObtainAppConfigRequest(Handler handler, AppliveryApiService apiService) {
    super(handler);
    this.apiService = apiService;
  }

  @Override protected ServerResponse performRequest() {
    Call<ApiAppConfigResponse> response = apiService.obtainAppConfig(appId);
    return response.execute().body();
  }

}
