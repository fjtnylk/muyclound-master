package com.muyclound.external.model;

/**
 * Created by yanglikai on 2018/3/19.
 */
public enum AuthType {
  SIGN("sign"),
  TOKEN("token"),
  SIMPLE("simple"),
  BASIC("basic");

  private String value;

  private AuthType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
