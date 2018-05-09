package com.muyclound.external.exception;

/**
 * Created by yanglikai on 2018/3/16.
 */
public class APIException extends RuntimeException {
  public APIException() {
  }

  public APIException(String msg) {
    super(msg);
  }

  public APIException(String msg, Throwable throwable) {
    super(msg, throwable);
  }
}
