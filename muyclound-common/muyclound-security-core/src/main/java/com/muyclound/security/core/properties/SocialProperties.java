package com.muyclound.security.core.properties;

import lombok.Data;

/**
 * 社交登录配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class SocialProperties {

  /**
   * 社交登录功能拦截的url
   */
  private String filterProcessesUrl = "/auth";

  /**
   * QQ登录配置
   */
  private QQProperties qq = new QQProperties();

  /**
   * 微信登录配置
   */
  private WeixinProperties weixin = new WeixinProperties();
}
