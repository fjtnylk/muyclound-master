package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-信使类消息发送接口text参数.
 * Created by yanglikai on 2018/3/23.
 */
@Data
public class ICBCSendMessengerTextParams extends ICBCSendMessengerParams implements APIParams {
  @JsonProperty(value = "content")
  private Content content;

  public ICBCSendMessengerTextParams() {
  }

  public ICBCSendMessengerTextParams(String accessToken, String sessionKey) {
    super(accessToken, sessionKey, "text");
  }

  @Data
  public static class Content {
    @JsonProperty(value = "msgcontent")
    private String msgContent;
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>(super.toParams());

    parameters.put("content", content);

    return parameters;
  }
}
