package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 1/1/16.
 */
public class ApiTeam {

  @SerializedName("_id")
  @Expose
  private String Id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("members")
  @Expose
  private List<ApiMemberEnroled> members;

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ApiMemberEnroled> getMembers() {
    return members;
  }

  public void setMembers(List<ApiMemberEnroled> members) {
    this.members = members;
  }
}
