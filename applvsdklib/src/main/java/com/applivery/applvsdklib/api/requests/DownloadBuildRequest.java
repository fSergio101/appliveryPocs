package com.applivery.applvsdklib.api.requests;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.BuildTokenInfo;
import com.applivery.applvsdklib.api.interactors.model.BusinessObject;
import com.applivery.applvsdklib.api.interactors.model.DownloadResult;
import com.applivery.applvsdklib.tools.AndroidExternalStorageWriterImpl;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.io.InputStream;
import retrofit.Call;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 9/1/16.
 */
public class DownloadBuildRequest extends ServerRequest {

  private final AppliveryApiService apiService;
  private final BuildTokenInfo token;
  private final DownloadStatusListener downloadStatusListener;
  private final ExternalStorageWriter externalStorageWriter;
  private final String appName;

  public DownloadBuildRequest(AppliveryApiService apiService, BuildTokenInfo token, String appName,
      DownloadStatusListener downloadStatusListener) {

    this.externalStorageWriter = new AndroidExternalStorageWriterImpl();

    this.downloadStatusListener = downloadStatusListener;
    this.apiService = apiService;
    this.token = token;
    this.appName = appName;
  }

  @Override protected BusinessObject performRequest() {
    DownloadResult downloadResult;

    Call<Response> response = apiService.downloadBuild(token.getBuild(), token.getToken());

    try {
      retrofit.Response<Response> apiResponse = response.execute();

      //becareful because body and headers can be from retrofit.Response that is the wrapper of
      //okHttpResponse of the oposite
      int lenght = Integer.parseInt(apiResponse.headers().get("Content-Lenght"));
      InputStream in = apiResponse.body().body().byteStream();
      String fileName = appName + "_" + token.getBuild();

      String path = externalStorageWriter.writeToFile(in, lenght, downloadStatusListener, fileName);

      downloadResult = new DownloadResult(true, path);
    } catch (IOException e) {
      downloadResult = new DownloadResult(false);
      e.printStackTrace();
    }

    return downloadResult;
  }

}
