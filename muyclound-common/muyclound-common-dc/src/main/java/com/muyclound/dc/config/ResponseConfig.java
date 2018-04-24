package com.muyclound.dc.config;

import lombok.Data;

/**
 * Created by yanglikai on 2018/4/23.
 */
@Data
public class ResponseConfig {
  private Integer status;
  private String responseTime;
  private String content;
}
