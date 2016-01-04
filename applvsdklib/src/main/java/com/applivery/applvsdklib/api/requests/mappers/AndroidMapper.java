package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interactors.model.Android;
import com.applivery.applvsdklib.api.responses.model.ApiAndroid;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class AndroidMapper implements ResponseMapper<Android, ApiAndroid>{

  @Override public Android dataToModel(ApiAndroid apiAndroid) {
    Android android = new Android();
    android.setLastBuildId(apiAndroid.getLastBuildId());
    android.setLastBuildVersion(apiAndroid.getLastBuildVersion());
    android.setMinVersion(apiAndroid.getMinVersion());
    android.setStoreLink(apiAndroid.getStoreLink());
    return android;
  }
}
