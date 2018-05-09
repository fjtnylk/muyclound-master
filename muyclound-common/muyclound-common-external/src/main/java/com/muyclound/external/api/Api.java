package com.muyclound.external.api;

import com.muyclound.external.model.APIParams;
import java.util.Map;
import org.apache.http.entity.ContentType;

/**
 * Created by yanglikai on 2018/3/16.
 */
public interface Api {
  String getHttpMethod();

  String getHttpUrl();

  String getVersion();

  String getName();

  APIParams getAPIParams();

  Map<String, String> getHeaders();

  void setAPIParams(APIParams params);

  Class getResultModelClass();

  Class getParamModelClass();

  ContentType getContentType();
}
