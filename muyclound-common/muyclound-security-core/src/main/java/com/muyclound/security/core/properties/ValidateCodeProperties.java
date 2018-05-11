package com.muyclound.security.core.properties;

import lombok.Data;

/**
 * 验证码配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class ValidateCodeProperties {
  /**
   * 图片验证码配置
   */
  private ImageCodeProperties image = new ImageCodeProperties();

  /**
   * 短信验证码配置
   */
  private SMSCodeProperties sms = new SMSCodeProperties();

  /**
   * 邮箱验证码配置
   */
  private EmailCodeProperties email = new EmailCodeProperties();
}
