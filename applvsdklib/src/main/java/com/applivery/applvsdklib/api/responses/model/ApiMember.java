package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 1/1/16.
 */
public class ApiMember {

  @SerializedName("_id")
  @Expose
  private String Id;

  @SerializedName("fullname")
  @Expose
  private String fullname;

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("email")
  @Expose
  private String email;

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
