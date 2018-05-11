package com.muyclound.security.core.properties;

import lombok.Data;

/**
 * OAuth环境配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class OAuth2Properties {
  /**
   * 使用jwt时为token签名的秘钥
   */
  private String jwtSigningKey = "www.muyclound.com";

  /**
   * 客户端配置
   */
  private OAuth2ClientProperties[] clients = {};
}
