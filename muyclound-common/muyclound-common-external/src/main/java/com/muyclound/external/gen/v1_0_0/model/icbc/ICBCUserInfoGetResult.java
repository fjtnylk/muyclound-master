package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-获取用户信息接口返回结果.
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCUserInfoGetResult implements APIResult {
  @JsonProperty(value = "subscribe")
  private String subscribe;  // 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
  @JsonProperty(value = "openid")
  private String openid;     // 用户的标识，对当前公众号唯一
  @JsonProperty(value = "nickname")
  private String nickName;   // 用户的昵称
  @JsonProperty(value = "sex")
  private String sex;        // 用户的性别，值为1时是男性，值为0时是女性
  @JsonProperty(value = "city")
  private String city;       // 用户所在城市
  @JsonProperty(value = "province")
  private String province;   // 用户所在省份
  @JsonProperty(value = "portrait")
  private String portrait;   // 用户头像
  @JsonProperty(value = "cisno")
  private String cisno;      // 客户信息号，行内公众号返回，不存在则返回空
  @JsonProperty(value = "unino")
  private String unino;      // 统一认证号，行内公众号返回，不存在则返回空
  @JsonProperty(value = "ICBCUserid")
  private String icbcUserId; // 统一通行证号，行内公众号返回，不存在则返回空
}
