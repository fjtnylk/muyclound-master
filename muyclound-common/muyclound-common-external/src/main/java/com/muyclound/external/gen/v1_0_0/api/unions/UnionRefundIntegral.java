package com.muyclound.external.gen.v1_0_0.api.unions;

import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionRefundIntegralParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionRefundIntegralResult;
import org.apache.http.entity.ContentType;

/**
 * 积分返还接口.
 * Created by yanglikai on 2018/5/7.
 */
public class UnionRefundIntegral extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getHttpUrl() {
    return "https://fzszgh.fznews.com.cn/menber/refund";
  }

  @Override
  public String getName() {
    return UnionRefundIntegral.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return UnionRefundIntegralResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return UnionRefundIntegralParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }
}
