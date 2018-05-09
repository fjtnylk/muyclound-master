package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCTicketGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCTicketGetResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-获取jsapi凭证接口.
 * Created by yanglikai on 2018/3/16.
 */
public class ICBCTicketGet extends AbstractApi {
  @Override
  public String getHttpMethod() {
    return "GET";
  }

  @Override
  public String getName() {
    return ICBCTicketGet.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCTicketGetResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCTicketGetParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.DEFAULT_TEXT;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/ticket/getticket";
  }
}
