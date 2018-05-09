package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRefundParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRefundResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-订单退款接口.
 * Created by yanglikai on 2018/3/16.
 */
public class ICBCOrderRefund extends AbstractApi {
  private String accessToken;

  public ICBCOrderRefund(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getName() {
    return ICBCOrderRefund.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCOrderRefundResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCOrderRefundParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/order/rejectgoods?access_token=" + accessToken;
  }
}
