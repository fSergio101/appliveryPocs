package com.applivery.applvsdklib.io;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 11/1/16.
 */
public interface LastConfigReader {
  long readLastConfigCheckTimeStamp();
  boolean existLastConfig();
}
