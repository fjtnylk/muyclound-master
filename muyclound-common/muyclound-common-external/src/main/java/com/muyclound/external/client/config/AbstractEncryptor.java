package com.muyclound.external.client.config;

/**
 * Created by yanglikai on 2018/3/22.
 */
public abstract class AbstractEncryptor implements Encryptor {
  protected String content;

  @Override
  public void setContent(String content) {
    this.content = content;
  }
}
