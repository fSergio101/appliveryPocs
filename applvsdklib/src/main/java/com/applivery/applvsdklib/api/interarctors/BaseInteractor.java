package com.applivery.applvsdklib.api.interarctors;

import android.os.Handler;
import android.os.Message;
import com.applivery.applvsdklib.api.interarctors.model.ErrorObject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 7/11/15.
 */
public abstract class BaseInteractor<T> implements Runnable{

  Handler handler = new Handler() {
    public void handleMessage(Message msg) {
       receivedResponse(msg.obj);
    }
  };

  protected abstract void receivedResponse(Object obj);

  protected void receivedResponse(Object obj, Class<T> responseClass) {
    try {
      T response = responseClass.cast(obj);
      digestServerResponse(response);
    }catch (ClassCastException classCastException){
      ErrorObject errorObject = (ErrorObject) obj;
      logError(errorObject);
    }
  }

  protected abstract void logError(ErrorObject serverResponse);

  protected abstract void digestServerResponse(T response);

  @Override public void run() {
    Message message = new Message();
    message.obj = performRequest();
    handler.sendMessage(message);
  }

  protected abstract Object performRequest();
}
