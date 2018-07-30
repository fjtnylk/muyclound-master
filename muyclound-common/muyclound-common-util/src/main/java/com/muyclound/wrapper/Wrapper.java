package com.muyclound.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/4/10.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wrapper<T> implements Serializable {
  public static final int SUCCESS_CODE = 200;

  public static final String SUCCESS_MESSAGE = "ok";

  public static final int ERROR_CODE = 500;

  public static final String ERROR_MESSAGE = "内部异常";

  public static final int ILLEGAL_ARGUMENT_CODE = 100;

  public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";


  private int code;
  private String message;
  private T response;

  public Wrapper() {
    this(SUCCESS_CODE, SUCCESS_MESSAGE);
  }

  public Wrapper(int code, String message) {
    this(code, message, null);
  }

  public Wrapper(int code, String message, T result) {
    super();
    this.code(code).message(message).response(result);
  }

  private Wrapper<T> code(int code) {
    this.setCode(code);
    return this;
  }

  private Wrapper<T> message(String message) {
    this.setMessage(message);
    return this;
  }

  public Wrapper<T> response(T result) {
    this.setResponse(result);
    return this;
  }

  @JsonIgnore
  public boolean success() {
    return Wrapper.SUCCESS_CODE == this.code;
  }

  @JsonIgnore
  public boolean error() {
    return !success();
  }
}
