package com.muyclound.external.client.auth;


import com.muyclound.external.model.AuthType;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class Simple implements Auth {
  @Override
  public AuthType getType() {
    return AuthType.SIMPLE;
  }
}
