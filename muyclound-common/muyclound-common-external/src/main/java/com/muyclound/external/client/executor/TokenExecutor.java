package com.muyclound.external.client.executor;

import com.google.common.collect.Maps;
import com.muyclound.external.api.Api;
import com.muyclound.external.client.auth.Token;
import com.muyclound.external.model.APIParams;
import com.muyclound.external.util.http.HttpClient;
import com.muyclound.external.util.misc.TimeUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class TokenExecutor extends AbstractExecutor implements Executor {
  private Token token;

  public TokenExecutor(HttpClient httpClient, Token token) {
    this.token = token;
    this.httpClient = httpClient;
  }

  @Override
  protected void prepare(ExecutionContext context) {
    Api api = context.getApi();
    APIParams apiParams = api.getAPIParams();
    Map<String, Object> params = apiParams.toParams();
    Map<String, Object> finalParams = Maps.newHashMap();

    String key;
    String newValue;
    for (Iterator var6 = params.keySet().iterator(); var6.hasNext(); finalParams.put(key, newValue)) {
      key = (String) var6.next();
      Object value = params.get(key);
      newValue = value.toString();
      if (value instanceof Date) {
        Date tmp = (Date) value;
        newValue = TimeUtils.formatTime(tmp);
      }
    }

    finalParams.put("access_token", this.token.getAccessToken());
    context.setParams(finalParams);
    context.setUrl(api.getHttpUrl() + "/oauthentry");
  }
}
