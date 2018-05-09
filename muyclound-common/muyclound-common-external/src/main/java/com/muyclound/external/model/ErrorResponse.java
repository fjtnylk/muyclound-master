package com.muyclound.external.model;

/**
 * Created by yanglikai on 2018/3/16.
 */
public class ErrorResponse {
  private String code;
  private String msg;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ErrorResponse{");
    sb.append("code='").append(code).append('\'');
    sb.append(", msg='").append(msg).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
