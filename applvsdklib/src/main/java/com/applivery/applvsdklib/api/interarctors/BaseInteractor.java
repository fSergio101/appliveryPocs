package com.applivery.applvsdklib.api.interarctors;

import android.os.Handler;
import android.os.Message;
import com.applivery.applvsdklib.api.interarctors.model.BusinessObject;
import com.applivery.applvsdklib.api.interarctors.model.ErrorObject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 7/11/15.
 */
public abstract class BaseInteractor<T> implements Runnable{

  Handler handler = new Handler() {
    public void handleMessage(Message msg) {
       receivedResponse((T)msg.obj);
    }
  };

  protected abstract void receivedResponse(T obj);

  protected void receivedResponse(T obj, Class<T> responseClass) {
    try {
      T response = responseClass.cast(obj);
      success(response);
    }catch (ClassCastException classCastException){
      ErrorObject errorObject = (ErrorObject) obj;
      error(errorObject);
    }
  }

  protected abstract void error(ErrorObject serverResponse);

  protected abstract void success(T response);

  @Override public void run() {
    Message message = new Message();
    message.obj = performRequest();
    handler.sendMessage(message);
  }

  protected abstract BusinessObject performRequest();
}
