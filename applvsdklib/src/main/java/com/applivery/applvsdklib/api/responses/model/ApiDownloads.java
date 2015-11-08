package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 8/11/15.
 */
public class ApiDownloads {

  //TODO change this on Server, name of parameter cant be the value

  @SerializedName("2015oct")
  @Expose
  private Integer _2015oct;
  @SerializedName("2015aug")
  @Expose
  private Integer _2015aug;
}
