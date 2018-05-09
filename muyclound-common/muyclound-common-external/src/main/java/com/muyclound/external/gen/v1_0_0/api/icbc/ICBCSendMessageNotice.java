package com.muyclound.external.gen.v1_0_0.api.icbc;

import com.muyclound.external.api.AbstractApi;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageNoticeParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageNoticeResult;
import org.apache.http.entity.ContentType;

/**
 * 工行-通知消息发送接口
 * Created by yanglikai on 2018/3/22.
 */
public class ICBCSendMessageNotice extends AbstractApi {
  private String accessToken;

  public ICBCSendMessageNotice(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String getHttpMethod() {
    return "POST";
  }

  @Override
  public String getHttpUrl() {
    return "https://imapi.icbc.com.cn/open/message/send?access_token=" + accessToken;
  }

  @Override
  public String getName() {
    return ICBCSendMessageNotice.class.getCanonicalName();
  }

  @Override
  public Class getResultModelClass() {
    return ICBCSendMessageNoticeResult.class;
  }

  @Override
  public Class getParamModelClass() {
    return ICBCSendMessageNoticeParams.class;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.APPLICATION_JSON;
  }
}
