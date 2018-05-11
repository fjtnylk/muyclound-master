package com.muyclound.security.core.properties;

import lombok.Data;

/**
 * 短信验证码配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class SMSCodeProperties {
  /**
   * 验证码长度
   */
  private int length = 6;

  /**
   * 过期时间
   */
  private int expireIn = 60;

  /**
   * 要拦截的url，多个url用逗号隔开，ant pattern
   */
  private String url;

  /**
   * 每天每个手机号最大送送短信数量
   */
  private int mobileMaxSendCount;

  /**
   * 每天每个IP最大送送短信数量
   */
  private int ipMaxSendCount;

  /**
   * 每天最大送送短信数量
   */
  private int totalMaxSendCount;
}
