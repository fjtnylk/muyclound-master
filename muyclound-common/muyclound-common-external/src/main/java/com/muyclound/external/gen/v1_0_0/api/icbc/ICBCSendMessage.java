package com.muyclound.external.gen.v1_0_0.api.icbc;


import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-消息群发接口.
 * Created by yanglikai on 2018/3/16.
 */
public class ICBCSendMessage extends AbstractApi {
  private String accessToken;

  public ICBCSendMessage(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getName() {
    return ICBCSendMessage.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCSendMessageResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCSendMessageParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/message/sendallbyopenid?access_token=" + accessToken;
  }
}
