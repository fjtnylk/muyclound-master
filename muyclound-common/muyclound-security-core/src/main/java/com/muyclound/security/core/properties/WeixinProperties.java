package com.muyclound.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 微信登录配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class WeixinProperties extends SocialProperties {

  /**
   * 第三方id，用来决定发起第三方登录的url，默认是 weixin
   */
  private String providerId = "weixin";
}
