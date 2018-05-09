package com.muyclound.external.client.executor;


import com.muyclound.external.client.config.Decryptor;
import com.muyclound.external.client.config.Encryptor;
import com.muyclound.external.client.config.PostProcessor;

/**
 * Created by yanglikai on 2018/3/16.
 */
public interface Executor {
  String execute(ExecutionContext context);

  void registerPostProcessor(PostProcessor postProcessor);

  void registerDecryptor(Decryptor decryptor);

  void registerEncryptor(Encryptor encryptor);
}
