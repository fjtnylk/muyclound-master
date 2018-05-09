package com.muyclound.external.gen.v1_0_0.api.unions;

import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionConsumeIntegralParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionConsumeIntegralResult;
import org.apache.http.entity.ContentType;

/**
 * 积分消费接口.
 * Created by yanglikai on 2018/5/7.
 */
public class UnionConsumeIntegral extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getHttpUrl() {
    return "https://fzszgh.fznews.com.cn/menber/integralUse";
  }

  @Override
  public String getName() {
    return UnionConsumeIntegral.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return UnionConsumeIntegralResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return UnionConsumeIntegralParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }
}
