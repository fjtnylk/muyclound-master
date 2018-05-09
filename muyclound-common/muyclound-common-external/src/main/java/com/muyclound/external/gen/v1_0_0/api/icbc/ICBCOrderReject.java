package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRejectParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRejectResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-订单冲正接口.
 * Created by yanglikai on 2018/3/16.
 */
public class ICBCOrderReject extends AbstractApi {
  private String accessToken;

  public ICBCOrderReject(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getName() {
    return ICBCOrderReject.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCOrderRejectResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCOrderRejectParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/order/rejectoncegoods?access_token=" + accessToken;
  }
}
