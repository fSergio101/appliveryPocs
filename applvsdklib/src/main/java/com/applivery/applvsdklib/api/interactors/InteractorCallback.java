package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.api.interactors.model.ErrorObject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/1/16.
 */
public interface InteractorCallback<Data> {
  void onSuccess(Data businessObject);
  void onError(ErrorObject error);
}
