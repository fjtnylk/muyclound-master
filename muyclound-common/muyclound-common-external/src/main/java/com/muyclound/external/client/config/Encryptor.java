package com.muyclound.external.client.config;

import org.apache.http.HttpEntity;

/**
 * Created by yanglikai on 2018/3/22.
 */
public interface Encryptor {

  void setContent(String content);

  HttpEntity toEntity();
}
