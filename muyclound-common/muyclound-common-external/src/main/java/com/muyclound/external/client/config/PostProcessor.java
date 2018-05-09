package com.muyclound.external.client.config;

/**
 * 后置处理器
 * Created by yanglikai on 2018/3/16.
 */
public interface PostProcessor {
  String process(String response);
}
