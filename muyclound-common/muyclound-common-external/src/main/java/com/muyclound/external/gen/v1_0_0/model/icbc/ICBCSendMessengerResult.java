package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-信使类消息发送接口返回结果.
 * Created by yanglikai on 2018/3/23.
 */
@Data
public class ICBCSendMessengerResult implements APIResult {
  @JsonProperty(value = "success")
  private boolean success;
}
