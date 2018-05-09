package com.muyclound.external.gen.v1_0_0.api.icbc;

import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-信使类消息发送接口.
 * Created by yanglikai on 2018/3/23.
 */
public class ICBCSendMessenger extends AbstractApi {
  private String accessToken;

  public ICBCSendMessenger(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/message/messenger?access_token=" + accessToken;
  }

  @Override
  public String getName() {
    return ICBCSendMessenger.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCSendMessengerResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCSendMessengerParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }
}
