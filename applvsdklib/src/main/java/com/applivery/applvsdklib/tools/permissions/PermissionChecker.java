package com.applivery.applvsdklib.tools.permissions;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/1/16.
 */
public interface PermissionChecker {
  void askForPermission(Permission permission, UserPermissionRequestResponseListener userResponse);
  void continuePendingPermissionsRequestsIfPossible();
}
