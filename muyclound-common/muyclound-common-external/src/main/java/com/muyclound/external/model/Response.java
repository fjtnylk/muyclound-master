package com.muyclound.external.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yanglikai on 2018/3/16.
 */
public class Response<T> {
  private T response;
  @JsonProperty("error_response")
  private T errorResponse;

  @JsonCreator
  public Response(@JsonProperty("response") T response) {
    this.response = response;
  }

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }

  public T getErrorResponse() {
    return errorResponse;
  }

  public void setErrorResponse(T errorResponse) {
    this.errorResponse = errorResponse;
  }
}
