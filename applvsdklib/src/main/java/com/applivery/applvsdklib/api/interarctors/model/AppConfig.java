package com.applivery.applvsdklib.api.interarctors.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 7/11/15.
 */
public class AppConfig implements BusinessObject{

  private String Id;
  private String name;
  private Skd skd;
  private String owner;
  private String creator;
  private Downloads downloads;
  private Integer totalDownloads;
  private Integer buildsCount;
  private List<Object> invited = new ArrayList<Object>();
  private List<Object> teams = new ArrayList<Object>();
  private List<Object> members = new ArrayList<Object>();
  private String modified;
  private String created;
  private List<String> so = new ArrayList<String>();
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

  public Skd getSkd() {
    return skd;
  }

  public void setSkd(Skd skd) {
    this.skd = skd;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Downloads getDownloads() {
    return downloads;
  }

  public void setDownloads(Downloads downloads) {
    this.downloads = downloads;
  }

  public Integer getTotalDownloads() {
    return totalDownloads;
  }

  public void setTotalDownloads(Integer totalDownloads) {
    this.totalDownloads = totalDownloads;
  }

  public Integer getBuildsCount() {
    return buildsCount;
  }

  public void setBuildsCount(Integer buildsCount) {
    this.buildsCount = buildsCount;
  }

  public List<Object> getInvited() {
    return invited;
  }

  public void setInvited(List<Object> invited) {
    this.invited = invited;
  }

  public List<Object> getTeams() {
    return teams;
  }

  public void setTeams(List<Object> teams) {
    this.teams = teams;
  }

  public List<Object> getMembers() {
    return members;
  }

  public void setMembers(List<Object> members) {
    this.members = members;
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
