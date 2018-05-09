package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOAuth2AccessTokenGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOAuth2AccessTokenGetResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-通过code换取网页授权access_token接口.
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCOAuth2AccessTokenGet extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "GET";
  }

  @Override
  public String getName() {
    return ICBCOAuth2AccessTokenGet.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCOAuth2AccessTokenGetResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCOAuth2AccessTokenGetParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.DEFAULT_TEXT;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/oauth2/access_token";
  }
}
