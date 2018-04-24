package com.muyclound.dc.config;

import lombok.Data;

/**
 * Created by yanglikai on 2018/4/23.
 */
@Data
public class CollectionConfig {
  private ProjectConfig projectConfig;

  private UserConfig userConfig;

  private SessionConfig sessionConfig;

  private RequestConfig requestConfig;

  private CustomerConfig customerConfig;

  private ResponseConfig responseConfig;
}
