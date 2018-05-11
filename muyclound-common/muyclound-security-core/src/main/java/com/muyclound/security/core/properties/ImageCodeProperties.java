package com.muyclound.security.core.properties;

import lombok.Data;

/**
 * 图片验证码配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class ImageCodeProperties {
  /**
   * 验证码长度
   */
  private int length = 4;
}
