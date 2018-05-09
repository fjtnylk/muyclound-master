package com.muyclound.external.client.executor;

import com.google.common.collect.Maps;
import com.muyclound.external.api.Api;
import com.muyclound.external.client.auth.Simple;
import com.muyclound.external.util.http.HttpClient;
import java.util.Map;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class SimpleExecutor extends AbstractExecutor implements Executor {
  private Simple simple;

  public SimpleExecutor(HttpClient httpClient, Simple simple) {
    this.simple = simple;
    this.httpClient = httpClient;
  }

  @Override
  protected void prepare(ExecutionContext context) {
    Api api = context.getApi();
    Map<String, Object> params = api.getAPIParams().toParams();
    Map<String, Object> newParams = Maps.newHashMap();
    for (Map.Entry<String, Object> entry : params.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();

      newParams.put(key, value);
    }

    context.setParams(newParams);
    context.setUrl(api.getHttpUrl());
    context.setContentType(api.getContentType());
  }
}
