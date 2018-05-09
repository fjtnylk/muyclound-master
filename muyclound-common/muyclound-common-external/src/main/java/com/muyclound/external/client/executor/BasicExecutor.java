package com.muyclound.external.client.executor;

import com.google.common.collect.Maps;
import com.muyclound.external.api.Api;
import com.muyclound.external.client.auth.Basic;
import com.muyclound.external.util.http.HttpClient;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class BasicExecutor extends AbstractExecutor {
  private Basic basic;

  public BasicExecutor(HttpClient httpClient, Basic basic) {
    this.basic = basic;
    this.httpClient = httpClient;
  }

  @Override
  protected void prepare(ExecutionContext context) {
    Api api = context.getApi();
    Map<String, String> headers = api.getHeaders();
    String basicAuth = basic.getUserName().concat(":").concat(basic.getPassword());
    Base64 base64 = new Base64();
    String encodeVal = new String(base64.encode(basicAuth.getBytes()));
    headers.put("Authorization", "Basic ".concat(encodeVal));

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
