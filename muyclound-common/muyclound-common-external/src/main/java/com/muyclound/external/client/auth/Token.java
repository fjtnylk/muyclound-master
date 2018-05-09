package com.muyclound.external.client.auth;

import com.muyclound.external.model.AuthType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class Token implements Auth {
  private String accessToken;

  public Token(String accessToken) {
    if (StringUtils.isBlank(accessToken)) {
      throw new IllegalArgumentException("Access token must be not null");
    } else {
      this.accessToken = accessToken;
    }
  }

  public String getAccessToken() {
    return accessToken;
  }

  @Override
  public AuthType getType() {
    return AuthType.TOKEN;
  }
}
