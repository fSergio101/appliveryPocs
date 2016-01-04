package com.applivery.applvsdklib.api.requests;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.BusinessObject;
import com.applivery.applvsdklib.api.interactors.model.FeedbackResult;
import com.applivery.applvsdklib.api.interactors.model.FeedbackWrapper;
import com.applivery.applvsdklib.api.requests.mappers.ApiFeedbackRequestMapper;
import com.applivery.applvsdklib.api.responses.ApiFeedbackResponse;
import retrofit.Call;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/1/16.
 */
public class FeedbackRequest extends ServerRequest {

  private final AppliveryApiService apiService;
  private final FeedbackWrapper feedbackWrapper;
  private final ApiFeedbackRequestMapper apiFeedbackRequestMapper;

  public FeedbackRequest(AppliveryApiService apiService, FeedbackWrapper feedbackWrapper) {
    this.apiService = apiService;
    this.feedbackWrapper = feedbackWrapper;
    this.apiFeedbackRequestMapper = new ApiFeedbackRequestMapper();
  }

  @Override protected BusinessObject performRequest() {
    ApiFeedbackRequestData apiFeedbackData = apiFeedbackRequestMapper.modelToData(feedbackWrapper);
    Call<ApiFeedbackResponse> response = apiService.sendFeedback(apiFeedbackData);
    ApiFeedbackResponse apiFeedbackResponse = super.performRequest(response);
    return new FeedbackResult(apiFeedbackResponse.getStatus());
  }

}
