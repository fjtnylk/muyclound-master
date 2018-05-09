package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenAuthParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenAuthResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-access_token鉴权接口.
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCAccessTokenAuth extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "GET";
  }

  @Override
  public String getName() {
    return ICBCAccessTokenAuth.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCAccessTokenAuthResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCAccessTokenAuthParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.DEFAULT_TEXT;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/oauth2/auth";
  }
}
