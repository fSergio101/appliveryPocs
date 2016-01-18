package com.applivery.applvsdklib.tools.permissions;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 17/1/16.
 */
public class GenericPermissionListenerImpl extends AbstractPermissionListener{

  private final Permission permission;

  public GenericPermissionListenerImpl(Permission permission,
      UserPermissionRequestResponseListener userPermissionRequestResponseListener) {
    super(userPermissionRequestResponseListener);
    this.permission = permission;
  }

  @Override public int getPermissionAllowedFeedBack() {
    return permission.getPermissionAllowedFeedback();
  }

  @Override protected int getPermissionSettingsDeniedFeedback() {
    return permission.getPermissionSettingsDeniedFeedback();
  }

  @Override protected int getPermissionDeniedFeedback() {
    return permission.getPermissionDeniedFeedback();
  }

  @Override protected int getPermissionRationaleMessage() {
    return permission.getPermissionRationaleMessage();
  }

  @Override protected int getPermissionRationaleTitle() {
    return permission.getPermissionRationaleTitle();
  }
}
