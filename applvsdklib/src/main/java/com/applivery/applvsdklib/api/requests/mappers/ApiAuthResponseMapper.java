package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interarctors.model.AuthData;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.requests.ApiAuthData;
import com.applivery.applvsdklib.api.responses.ApiAuthDataResponse;
import com.applivery.applvsdklib.api.responses.model.DateFormatConstants;
import com.applivery.applvsdklib.tools.DateUtils;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class ApiAuthResponseMapper extends BaseMapper<AuthData, ApiAuthData>{

  public BusinessObject map(ApiAuthDataResponse apiAuthDataResponse) {
    return super.map(apiAuthDataResponse);
  }

  @Override protected AuthData mapBusinessObject(ApiAuthData apiAuthData) {
    AuthData authData = new AuthData();
    authData.setAccessToken(apiAuthData.getApiId());
    authData.setExpirationDate(DateUtils.stringToDateWithFormat(apiAuthData.getApiId(),
        DateFormatConstants.DATE_FORMAT));
    return authData;
  }

}
