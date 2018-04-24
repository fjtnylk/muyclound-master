package com.muyclound.dc.config;

import lombok.Data;

/**
 * Created by yanglikai on 2018/4/23.
 */
@Data
public class SessionConfig {
  private String sessionId;
  private String entryTime;
  private String leaveTime;
}
