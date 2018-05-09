package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-消息群发接口返回结果.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCSendMessageResult implements APIResult {
  @JsonProperty(value = "msgId")
  private String msgId;         // 消息发送任务的ID
  @JsonProperty(value = "msg_num")
  private String msgNbr;        // 剩余的群发次数 （按组发送时返回）
  @JsonProperty(value = "noRelaOpenids")
  private String noRelaOpenids; // 没有发送成功的openid，在touser超过100时，100以后的openid也会在此返回 (在根据openid群发消息时返回)
  @JsonProperty(value = "sendErrorMsgId")
  private String sendErrorMsgId; // 没有发送成功的msgid，根据OpenID多消息(openid、消息内容一对一)群发时返回
}
