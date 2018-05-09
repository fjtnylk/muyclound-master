package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenGetResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-获取accesstoken、sessionkey接口.
 * <p>
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCAccessTokenGet extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "GET";
  }

  @Override
  public String getName() {
    return ICBCAccessTokenGet.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCAccessTokenGetResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCAccessTokenGetParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.DEFAULT_TEXT;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/token";
  }
}
