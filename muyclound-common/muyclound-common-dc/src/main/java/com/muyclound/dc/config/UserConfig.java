package com.muyclound.dc.config;

import javax.servlet.http.HttpServletRequest;
import lombok.Data;

/**
 * Created by yanglikai on 2018/4/23.
 */
@Data
public class UserConfig {
  private String userid;
  private String username;

  private HttpServletRequest request;

  public UserConfig(HttpServletRequest request) {
    this.request = request;
    init();
  }

  private void init() {
  }
}
