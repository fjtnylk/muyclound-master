package com.muyclound.external.client.auth;


import com.muyclound.external.model.AuthType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class Basic implements Auth {
  private String userName;
  private String password;

  public Basic(String userName, String password) {
    if (StringUtils.isBlank(userName)) {
      throw new IllegalArgumentException("username must be not null");
    } else if (StringUtils.isBlank(password)) {
      throw new IllegalArgumentException("password must be not null");
    }

    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public AuthType getType() {
    return AuthType.BASIC;
  }
}
