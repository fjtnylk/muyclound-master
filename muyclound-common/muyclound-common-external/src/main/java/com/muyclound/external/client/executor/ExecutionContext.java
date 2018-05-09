package com.muyclound.external.client.executor;

import com.muyclound.external.api.Api;
import java.util.Map;
import org.apache.http.entity.ContentType;

/**
 * Created by yanglikai on 2018/3/16.
 */
public class ExecutionContext {
  private Api api;
  private String url;
  private Map<String, Object> params;
  private ContentType contentType;

  public Api getApi() {
    return api;
  }

  public void setApi(Api api) {
    this.api = api;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }

  public ContentType getContentType() {
    return contentType;
  }

  public void setContentType(ContentType contentType) {
    this.contentType = contentType;
  }
}
