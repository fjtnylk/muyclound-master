package com.muyclound.dc.constant;

/**
 * Created by yanglikai on 2018/4/24.
 */
public final class DCConstant {

  public static final String DC_NAME = "datacollection";

  public static final String FILE = "/var/log/%s/DC/datacollect.log";

  public static final String FILE_DIRECTORY = "/var/log/%s/DC";

  public static final String FILE_NAME_PATTERN = "/datacollect.%d{yyyyMMdd}.log";

  public static final Integer MAX_HISTORY = 30;

  public static final String PATTERN = "%msg%n";
}
