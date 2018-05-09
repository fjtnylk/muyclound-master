package com.muyclound.external.client.auth;

import com.muyclound.external.model.AuthType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class Sign implements Auth {
  private String appId;
  private String appSecret;

  public Sign(String appId, String appSecret) {
    if (StringUtils.isBlank(appId)) {
      throw new IllegalArgumentException("App id must be not null");
    } else if (StringUtils.isBlank(appSecret)) {
      throw new IllegalArgumentException("App secret must be not null");
    }

    this.appId = appId;
    this.appSecret = appSecret;
  }

  public String getAppId() {
    return appId;
  }

  public String getAppSecret() {
    return appSecret;
  }

  @Override
  public AuthType getType() {
    return AuthType.SIGN;
  }
}
