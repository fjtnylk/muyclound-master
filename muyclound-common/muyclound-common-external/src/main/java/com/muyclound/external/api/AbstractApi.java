package com.muyclound.external.api;

import com.google.common.collect.Maps;
import com.muyclound.external.model.APIParams;
import java.util.Map;
import org.apache.http.entity.ContentType;

/**
 * Created by yanglikai on 2017/10/30.
 */
public abstract class AbstractApi implements Api {
  protected APIParams params;
  protected Map<String, String> headers;

  public AbstractApi() {
    headers = Maps.newHashMap();
  }

  @Override
  public APIParams getAPIParams() {
    return params;
  }

  @Override
  public void setAPIParams(APIParams params) {
    this.params = params;
  }

  @Override
  public String getVersion() {
    return "1.0.0";
  }

  @Override
  public Map<String, String> getHeaders() {
    if (getContentType() == ContentType.APPLICATION_JSON) {
      headers.put("Content-Type", "application/json");
    }

    return headers;
  }
}
