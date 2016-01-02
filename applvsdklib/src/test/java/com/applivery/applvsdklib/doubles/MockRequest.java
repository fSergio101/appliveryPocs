package com.applivery.applvsdklib.doubles;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.requests.ServerRequest;
import com.applivery.applvsdklib.api.requests.mappers.ApiAppConfigResponseMapper;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.api.responses.ServerResponse;
import com.applivery.applvsdklib.utils.AppliveryTestApi;
import retrofit.Call;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 25/12/15.
 */
public class MockRequest extends ServerRequest {

    private AppliveryTestApi apiService;

    @Override protected BusinessObject performRequest() {
      // empty. This class is created just with testing purposes
      return null;
    }

  public <T extends ServerResponse> T performSuperRequest(Call<T> call){
    return super.performRequest(call);
  }


}
