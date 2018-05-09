package com.muyclound.external.gen.v1_0_0.api.unions;

import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionGetUserInfoParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionGetUserInfoResult;
import org.apache.http.entity.ContentType;

/**
 * 工会用户信息获取接口.
 * Created by yanglikai on 2018/5/7.
 */
public class UnionGetUserInfo extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getHttpUrl() {
    return "http://fzszgh.fznews.com.cn/menber/userInfo";
  }

  @Override
  public String getName() {
    return UnionGetUserInfo.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return UnionGetUserInfoResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return UnionGetUserInfoParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }
}
