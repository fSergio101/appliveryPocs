package com.applivery.applvsdklib.api.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 7/11/15.
 */
public class ApiAppConfigData {

  @SerializedName("_id")
  @Expose
  private String Id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("owner")
  @Expose
  private ApiOwner owner;
  @SerializedName("creator")
  @Expose
  private ApiCreator creator;
  @SerializedName("sdk")
  @Expose
  private ApiSdK sdk;
  @SerializedName("crashesCount")
  @Expose
  private int crashesCount;
  @SerializedName("feedbackCount")
  @Expose
  private int feedbackCount;
  @SerializedName("sitesCount")
  @Expose
  private int sitesCount;
  @SerializedName("totalDownloads")
  @Expose
  private int totalDownloads;
  @SerializedName("buildsCount")
  @Expose
  private int buildsCount;
  @SerializedName("invited")
  @Expose
  private List<ApiMember> invited;
  @SerializedName("teams")
  @Expose
  private List<ApiTeam> teams;
  @SerializedName("members")
  @Expose
  private List<ApiMember> members;
  @SerializedName("active")
  @Expose
  private boolean active;
  @SerializedName("modified")
  @Expose
  private String modified;
  @SerializedName("created")
  @Expose
  private String created;
  @SerializedName("so")
  @Expose
  private List<String> so;
  @SerializedName("description")
  @Expose
  private String description;

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

  public ApiOwner getOwner() {
    return owner;
  }

  public void setOwner(ApiOwner owner) {
    this.owner = owner;
  }

  public ApiCreator getCreator() {
    return creator;
  }

  public void setCreator(ApiCreator creator) {
    this.creator = creator;
  }

  public ApiSdK getSdk() {
    return sdk;
  }

  public void setSdk(ApiSdK sdk) {
    this.sdk = sdk;
  }

  public int getCrashesCount() {
    return crashesCount;
  }

  public void setCrashesCount(int crashesCount) {
    this.crashesCount = crashesCount;
  }

  public int getFeedbackCount() {
    return feedbackCount;
  }

  public void setFeedbackCount(int feedbackCount) {
    this.feedbackCount = feedbackCount;
  }

  public int getSitesCount() {
    return sitesCount;
  }

  public void setSitesCount(int sitesCount) {
    this.sitesCount = sitesCount;
  }

  public int getTotalDownloads() {
    return totalDownloads;
  }

  public void setTotalDownloads(int totalDownloads) {
    this.totalDownloads = totalDownloads;
  }

  public int getBuildsCount() {
    return buildsCount;
  }

  public void setBuildsCount(int buildsCount) {
    this.buildsCount = buildsCount;
  }

  public List<ApiMember> getInvited() {
    return invited;
  }

  public void setInvited(List<ApiMember> invited) {
    this.invited = invited;
  }

  public List<ApiTeam> getTeams() {
    return teams;
  }

  public void setTeams(List<ApiTeam> teams) {
    this.teams = teams;
  }

  public List<ApiMember> getMembers() {
    return members;
  }

  public void setMembers(List<ApiMember> members) {
    this.members = members;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public List<String> getSo() {
    return so;
  }

  public void setSo(List<String> so) {
    this.so = so;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
