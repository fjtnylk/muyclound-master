package com.muyclound.security.core.properties;

/**
 * 邮箱验证配置
 * Created by yanglikai on 2018/5/11.
 */
public class EmailCodeProperties {
  /**
   * 过期时间
   */
  private int expireIn = 60 * 60 * 24;

  /**
   * 要拦截的url，多个url用逗号隔开，ant pattern
   */
  private String url;
}
