package com.applivery.applvsdklib.api.requests.mappers;

import com.applivery.applvsdklib.api.interactors.model.FeedbackWrapper;
import com.applivery.applvsdklib.api.requests.ApiFeedbackRequestData;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/1/16.
 */
public class ApiFeedbackRequestMapper implements RequestMapper<FeedbackWrapper, ApiFeedbackRequestData>{

  @Override public ApiFeedbackRequestData modelToData(FeedbackWrapper feedbackWrapper) {
    ApiFeedbackRequestData apiFeedbackData = new ApiFeedbackRequestData();
    //TODO implement mapping of fields
    return apiFeedbackData;
  }
}
