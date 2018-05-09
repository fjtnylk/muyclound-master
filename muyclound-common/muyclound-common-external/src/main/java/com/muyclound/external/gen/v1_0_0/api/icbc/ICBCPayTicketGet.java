package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCPayTicketGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCPayTicketGetResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-获取支付凭证接口.
 * Created by yanglikai on 2018/3/16.
 */
public class ICBCPayTicketGet extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "GET";
  }

  @Override
  public String getName() {
    return ICBCPayTicketGet.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCPayTicketGetResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCPayTicketGetParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.DEFAULT_TEXT;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/pay/getPayTicket";
  }
}
