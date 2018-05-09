package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import com.muyclound.external.model.APIParams;
import java.util.Map;
import lombok.Data;

/**
 * 工行-消息群发接口参数.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCSendMessageParams extends ICBCCryptParams implements APIParams {
  @JsonProperty(value = "touser")
  private String[] toUsers;
  @JsonProperty(value = "msgtype")
  private String msgType;
  @JsonProperty(value = "notice")
  private Notice notice;

  public ICBCSendMessageParams(String accessToken, String sessionKey) {
    super(accessToken, sessionKey);
  }

  @Data
  public static class Notice {
    private String title;
    private String source;
    private String remark;
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> params = Maps.newHashMap();
    params.put("touser", toUsers);
    params.put("msgtype", msgType);
    params.put("notice", notice);

    return params;
  }
}
