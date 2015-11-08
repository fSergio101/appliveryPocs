package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interarctors.model.Android;
import com.applivery.applvsdklib.api.interarctors.model.AppConfig;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.interarctors.model.Downloads;
import com.applivery.applvsdklib.api.interarctors.model.Ios;
import com.applivery.applvsdklib.api.interarctors.model.Sdk;
import com.applivery.applvsdklib.api.responses.ApiAppConfigResponse;
import com.applivery.applvsdklib.api.responses.ServerResponse;
import com.applivery.applvsdklib.api.responses.model.ApiAndroid;
import com.applivery.applvsdklib.api.responses.model.ApiAppConfigData;
import com.applivery.applvsdklib.api.responses.model.ApiDownloads;
import com.applivery.applvsdklib.api.responses.model.ApiIos;
import com.applivery.applvsdklib.api.responses.model.ApiSdK;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ApiAppConfigResponseMapper extends BaseMapper{

  public BusinessObject map(ApiAppConfigResponse apiAppConfigResponse) {
    return super.map(apiAppConfigResponse);
  }

  @Override protected BusinessObject mapBusinessObject(ServerResponse serverResponse) {

    ApiAppConfigResponse appConfigResponse = (ApiAppConfigResponse) serverResponse;
    ApiAppConfigData apiAppConfigData = appConfigResponse.getData();

    AppConfig appConfig = new AppConfig();

    appConfig.setBuildsCount(apiAppConfigData.getBuildsCount());
    appConfig.setCreated(apiAppConfigData.getCreated());
    appConfig.setCreator(apiAppConfigData.getCreator());
    appConfig.setDescription(apiAppConfigData.getDescription());
    appConfig.setId(apiAppConfigData.getId());
    appConfig.setInvited(apiAppConfigData.getInvited());
    appConfig.setMembers(apiAppConfigData.getMembers());
    appConfig.setModified(apiAppConfigData.getModified());
    appConfig.setName(apiAppConfigData.getName());
    appConfig.setOwner(apiAppConfigData.getOwner());
    appConfig.setTotalDownloads(apiAppConfigData.getTotalDownloads());
    appConfig.setSo(apiAppConfigData.getSo());
    appConfig.setTeams(apiAppConfigData.getTeams());
    appConfig.setSdk(getSdkFrom(apiAppConfigData.getSkd()));
    appConfig.setDownloads(getDownloadsFrom(apiAppConfigData.getDownloads()));

    return new AppConfig();
  }

  private Downloads getDownloadsFrom(ApiDownloads apiDownloads) {
    Downloads downloads = new Downloads();
    //TODO set properties
    return downloads;
  }

  private Sdk getSdkFrom(ApiSdK apiSdk) {
    Sdk sdk = new Sdk();
    sdk.setForceUpdate(apiSdk.getForceUpdate());
    sdk.setMustUpdateMsg(apiSdk.getMustUpdateMsg());
    sdk.setOta(apiSdk.getOta());
    sdk.setStoreRelease(apiSdk.getStoreRelease());
    sdk.setUpdateMsg(apiSdk.getUpdateMsg());
    sdk.setAndroid(getAndroidFrom(apiSdk.getAndroid()));
    sdk.setIos(getIosFrom(apiSdk.getIos()));
    return sdk;
  }

  private Ios getIosFrom(ApiIos apiIos) {
    Ios ios = new Ios();
    ios.setLastBuildId(apiIos.getLastBuildId());
    ios.setLastBuildVersion(apiIos.getLastBuildVersion());
    ios.setMinVersion(apiIos.getMinVersion());
    ios.setStoreLink(apiIos.getStoreLink());
    return ios;
  }

  private Android getAndroidFrom(ApiAndroid apiAndroid) {
    Android android = new Android();
    android.setLastBuildId(apiAndroid.getLastBuildId());
    android.setLastBuildVersion(apiAndroid.getLastBuildVersion());
    android.setMinVersion(apiAndroid.getMinVersion());
    android.setStoreLink(apiAndroid.getStoreLink());
    return android;
  }
}
