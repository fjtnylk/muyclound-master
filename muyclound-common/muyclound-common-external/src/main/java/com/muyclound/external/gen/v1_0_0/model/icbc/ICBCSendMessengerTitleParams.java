package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-信使类消息发送接口title参数.
 * Created by yanglikai on 2018/3/23.
 */
@Data
public class ICBCSendMessengerTitleParams extends ICBCSendMessengerParams implements APIParams {
  @JsonProperty(value = "content")
  private ICBCSendMessengerTitleParams.Content content;

  public ICBCSendMessengerTitleParams() {
  }

  public ICBCSendMessengerTitleParams(String accessToken, String sessionKey) {
    super(accessToken, sessionKey, "title");
  }

  @Data
  public static class Content {
    @JsonProperty(value = "msgcontent")
    private String msgContent;
    @JsonProperty(value = "title")
    private String title;
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>(super.toParams());

    parameters.put("content", content);

    return parameters;
  }
}
