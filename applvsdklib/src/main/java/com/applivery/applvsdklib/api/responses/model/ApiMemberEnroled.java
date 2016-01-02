package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 1/1/16.
 */
public class ApiMemberEnroled {

  @SerializedName("role")
  @Expose
  private String role;

  @SerializedName("member")
  @Expose
  private ApiMember member;

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ApiMember getMember() {
    return member;
  }

  public void setMember(ApiMember member) {
    this.member = member;
  }
}
