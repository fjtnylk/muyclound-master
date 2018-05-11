package com.muyclound.config.properties;

import lombok.Data;

/**
 * 异步任务配置
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class AsyncTaskProperties {

  private int corePoolSize = 50;

  private int maxPoolSize = 100;

  private int queueCapacity = 10000;

  private int keepAliveSeconds = 3000;

  private String threadNamePrefix = "muyclound-task-executor-";
}
