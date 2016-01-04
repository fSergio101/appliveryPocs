package com.applivery.applvsdklib.api.interactors;

import com.applivery.applvsdklib.api.AppliveryApiService;
import com.applivery.applvsdklib.api.interactors.model.BusinessObject;
import com.applivery.applvsdklib.api.interactors.model.ErrorObject;
import com.applivery.applvsdklib.api.interactors.model.Feedback;
import com.applivery.applvsdklib.api.interactors.model.FeedbackResult;
import com.applivery.applvsdklib.api.interactors.model.FeedbackWrapper;
import com.applivery.applvsdklib.api.requests.FeedbackRequest;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/1/16.
 */
public class FeedbackInteractor extends BaseInteractor<FeedbackResult> {

  private final FeedbackRequest feedbackRequest;
  private final InteractorCallback feedbackCallback;
  private final FeedbackWrapper feedbackWrapper;

  public FeedbackInteractor(FeedbackRequest feedbackRequest, InteractorCallback feedbackCallback,
      Feedback feedback, AppliveryApiService appliveryApiService) {
    this.feedbackWrapper = FeedbackWrapper.createWrapper(feedback);
    this.feedbackRequest = new FeedbackRequest(appliveryApiService, feedbackWrapper);
    this.feedbackCallback = feedbackCallback;
  }

  @Override protected void receivedResponse(FeedbackResult result) {
    super.receivedResponse(result, FeedbackResult.class);
  }

  @Override protected void error(ErrorObject error) {
    feedbackCallback.onError(error);
  }

  @Override protected void success(FeedbackResult response) {
    feedbackCallback.onSuccess(response);
  }

  @Override protected BusinessObject performRequest() {
    //TODO transform fee
    return feedbackRequest.execute();
  }
}
