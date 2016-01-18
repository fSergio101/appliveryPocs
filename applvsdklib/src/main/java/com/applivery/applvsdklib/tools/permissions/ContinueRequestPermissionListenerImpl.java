package com.applivery.applvsdklib.tools.permissions;

import com.applivery.applvsdklib.R;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 17/1/16.
 */
public class ContinueRequestPermissionListenerImpl extends AbstractPermissionListener{

  @Override public int getPermissionAllowedFeedBack() {
    return R.string.continueRequestPermissionAllowedFeedback;
  }

  @Override protected int getPermissionSettingsDeniedFeedback() {
    return R.string.continueRequestPermissionSettingsDeniedFeedback;
  }

  @Override protected int getPermissionDeniedFeedback() {
    return R.string.continueRequestPermissionDeniedFeedback;
  }

  @Override protected int getPermissionRationaleMessage() {
    return R.string.continueRequestPermissionRationaleMessage;
  }

  @Override protected int getPermissionRationaleTitle() {
    return R.string.continueRequestPermissionRationaleTitle;
  }
}
