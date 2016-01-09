package com.applivery.applvsdklib.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.applivery.applvsdklib.api.interactors.AppInstaller;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 9/1/16.
 */
public class AndroidAppInstallerImpl implements AppInstaller {

  private final Context context;

  public AndroidAppInstallerImpl(Context context) {
    this.context = context;
  }

  @Override public void installApp(String path) {
    Intent promptInstall = new Intent(Intent.ACTION_VIEW)
        .setDataAndType(Uri.parse("file:///" + path), "application/vnd.android.package-archive");
    context.startActivity(promptInstall);
  }
}
