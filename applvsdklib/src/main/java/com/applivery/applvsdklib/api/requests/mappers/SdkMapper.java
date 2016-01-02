package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interarctors.model.Sdk;
import com.applivery.applvsdklib.api.responses.model.ApiSdK;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class SdkMapper implements ResponseMapper<Sdk, ApiSdK>{

  private AndroidMapper androidMapper;

  public SdkMapper(AndroidMapper androidMapper) {
    this.androidMapper = androidMapper;
  }

  @Override public Sdk dataToModel(ApiSdK apiSdK) {
    Sdk sdk = new Sdk();
    sdk.setAndroid(androidMapper.dataToModel(apiSdK.getAndroid()));
    sdk.setForceUpdate(apiSdK.isForceUpdate());
    sdk.setMustUpdateMsg(apiSdK.getMustUpdateMsg());
    sdk.setOta(apiSdK.isOta());
    sdk.setStoreRelease(apiSdK.isStoreRelease());
    sdk.setUpdateMsg(apiSdK.getUpdateMsg());
    return sdk;
  }
}
