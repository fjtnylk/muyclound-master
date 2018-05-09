package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCUserInfoGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCUserInfoGetResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-获取用户信息接口.
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCUserInfoGet extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "GET";
  }

  @Override
  public String getName() {
    return ICBCUserInfoGet.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCUserInfoGetResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCUserInfoGetParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.DEFAULT_TEXT;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/oauth2/userinfo";
  }
}
