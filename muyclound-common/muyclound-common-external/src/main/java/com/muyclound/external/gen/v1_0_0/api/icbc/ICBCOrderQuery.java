package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderQueryParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderQueryResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-订单查询接口.
 * Created by yanglikai on 2018/3/16.
 */
public class ICBCOrderQuery extends AbstractApi {
  private String accessToken;

  public ICBCOrderQuery(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getName() {
    return ICBCOrderQuery.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCOrderQueryResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCOrderQueryParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/order/queryorder?access_token=" + accessToken;
  }
}
