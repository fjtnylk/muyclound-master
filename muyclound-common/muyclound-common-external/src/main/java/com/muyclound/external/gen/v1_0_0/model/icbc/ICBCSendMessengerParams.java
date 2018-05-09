package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * 工行-信使类消息发送接口参数.
 * Created by yanglikai on 2018/3/23.
 */
@Data
public class ICBCSendMessengerParams extends ICBCCryptParams implements APIParams {
  @JsonProperty(value = "msgtype")
  private String msgType;        // 信使消息类型，只支持通用（generalinfo）消息类型
  @JsonProperty(value = "touser")
  private String touser;         // 普通用户openid
  @JsonProperty(value = "busstype")
  private String busstype;       // 信使消息大类：目前大类支持公积金(accumulationFund)、社保(socialSecurity)
  @JsonProperty(value = "busssubtype")
  private String busssubtype;    // 信使消息小类：目前支持小类为入账提醒(inAccountNotice,支持公积金和社保),出账提醒(outAccountNotice,支持公积金和社保),月结单(monthAccountStatement,支持公积金和社保)
  @JsonProperty(value = "title")
  private String title;          // 信使消息标题
  @JsonProperty(value = "subtitle")
  private String subtitle;       // 信使消息副标题
  @JsonProperty(value = "icon")
  private String icon;           // 信使图标地址，支持JPG、PNG、JPEG格式，建议图60*60
  @JsonProperty(value = "displaytype")
  private String displayType;    // 显示模板：text：文本，account：金额，title：标题
  @JsonProperty(value = "isAllowSend")
  private String isAllowSend;    // 图文允许分享转发标志：0为不允许转发，1为不控制。如果不上送，则默认值为1
  @JsonProperty(value = "remark")
  private String remark;         // 备注字段
  @JsonProperty(value = "buttons")
  private List<Buttons> buttons; // 引导按数组，最多配置4个

  public ICBCSendMessengerParams() {
  }

  public ICBCSendMessengerParams(String accessToken, String sessionKey, String displayType) {
    super(accessToken, sessionKey);

    this.msgType = "generalinfo";
    this.busstype = "accumulationFund";
    this.busssubtype = "inAccountNotice";
    this.isAllowSend = "1";
    this.displayType = displayType;
  }

  @Data
  public static class Buttons {
    @JsonProperty(value = "desc")
    private String desc;   // 引导描述,不能超过30个字符
    @JsonProperty(value = "href")
    private String href;   // 引导功能链接或FuncNo，普通链接不能超过100个字符
    @JsonProperty(value = "isFunc")
    private String isFunc; // 1：原子功能，0：普通链接
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("msgtype", msgType);
    parameters.put("touser", touser);
    parameters.put("busstype", busstype);
    parameters.put("busssubtype", busssubtype);
    parameters.put("title", title);
    parameters.put("subtitle", subtitle);
    parameters.put("icon", icon);
    parameters.put("displaytype", displayType);
    parameters.put("isAllowSend", isAllowSend);
    parameters.put("remark", remark);
    parameters.put("buttons", buttons);

    return parameters;
  }
}
