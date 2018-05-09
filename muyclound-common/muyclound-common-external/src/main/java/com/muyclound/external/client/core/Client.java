package com.muyclound.external.client.core;


import com.muyclound.external.api.Api;

/**
 * Created by yanglikai on 2018/3/16.
 */
public interface Client {
  <T> T invoke(Api api);

  String execute(Api api);
}
