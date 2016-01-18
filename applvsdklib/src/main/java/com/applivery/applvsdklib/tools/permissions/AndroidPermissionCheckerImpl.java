package com.applivery.applvsdklib.tools.permissions;

import android.content.Context;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.PermissionListener;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/1/16.
 */
public class AndroidPermissionCheckerImpl implements PermissionChecker {

  public AndroidPermissionCheckerImpl(Context context) {
    Dexter.initialize(context);
  }

  @Override public void askForPermission(Permission permission,
      UserPermissionRequestResponseListener userResponse) {
    if (Dexter.isRequestOngoing()) {
      return;
    }
    Dexter.checkPermission(getPermissionListenerImpl(permission, userResponse),
        permission.getAndroidPermissionStringType());
  }

  private PermissionListener getPermissionListenerImpl(final Permission permission,
      final UserPermissionRequestResponseListener userPermissionRequestResponseListener) {
    return new GenericPermissionListenerImpl(permission, userPermissionRequestResponseListener);
  }

  @Override public void continuePendingPermissionsRequestsIfPossible() {
    Dexter.continuePendingRequestIfPossible(new ContinueRequestPermissionListenerImpl());
  }
}
