package com.muyclound.dc.enums;

/**
 * Created by yanglikai on 2018/4/23.
 */
public enum LogLevelEnum {
  INFO("INFO", "信息"),
  ERROR("ERROR", "错误"),
  warn("WARN", "警告");

  private String level;
  private String desc;

  LogLevelEnum(String level, String desc) {
    this.level = level;
    this.desc = desc;
  }

  public String level() {
    return level;
  }
}
