package com.applivery.applvsdklib.tools.permissions;

import android.app.Activity;
import android.content.Context;
import com.applivery.applvsdklib.AppliverySdk;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 17/1/16.
 */
public abstract class AbstractPermissionListener implements PermissionListener {

  private UserPermissionRequestResponseListener userPermissionRequestResponseListener;

  public AbstractPermissionListener() {}

  public AbstractPermissionListener(UserPermissionRequestResponseListener
      userPermissionRequestResponseListener) {
    this.userPermissionRequestResponseListener = userPermissionRequestResponseListener;
  }

  @Override public void onPermissionGranted(PermissionGrantedResponse response) {
    PermissionsUIViews.showPermissionToast(AppliverySdk.getApplicationContext(),
        getPermissionAllowedFeedBack());

    if (userPermissionRequestResponseListener!=null){
      userPermissionRequestResponseListener.onPermissionAllowed(true);
    }
  }

  @Override public void onPermissionDenied(PermissionDeniedResponse response) {
    if (AppliverySdk.isContextAvailable()){
      Activity activity = AppliverySdk.getCurrentActivity();
      PermissionsUIViews.showSnackBarPermissionMessage(activity,
          getPermissionRationaleMessage(),
          getPermissionSettingsDeniedFeedback());
    }else{
      PermissionsUIViews.showPermissionToast(AppliverySdk.getApplicationContext(),
          getPermissionDeniedFeedback());
    }

    if (userPermissionRequestResponseListener!=null){
      userPermissionRequestResponseListener.onPermissionAllowed(false);
    }

  }

  @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest,
      PermissionToken token) {

    if (AppliverySdk.isContextAvailable()){
      Context context = AppliverySdk.getCurrentActivity();
      PermissionsUIViews.showRationaleView(createRationaleResponseInstance(token), context,
          getPermissionRationaleTitle(), getPermissionRationaleMessage());
    }
  }

  private RationaleResponse createRationaleResponseInstance(final PermissionToken token) {
      return new RationaleResponse() {
        @Override public void cancelPermissionRequest() {
          token.cancelPermissionRequest();
        }

        @Override public void continuePermissionRequest() {
          token.continuePermissionRequest();
        }
      };
    }

  public abstract int getPermissionAllowedFeedBack();
  protected abstract int getPermissionSettingsDeniedFeedback();
  protected abstract int getPermissionDeniedFeedback();
  protected abstract int getPermissionRationaleMessage();
  protected abstract int getPermissionRationaleTitle();

  }
