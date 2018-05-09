package com.muyclound.external.gen.v1_0_0.model.unions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工会用户信息获取接口返回结果.
 * Created by yanglikai on 2018/5/7.
 */
@Data
public class UnionGetUserInfoResult implements APIResult {
  @JsonProperty(value = "errornum")
  private String errorNum;    // 错误编号
  @JsonProperty(value = "errormsg")
  private String errorMsg;    // 错误说明
  @JsonProperty(value = "realname")
  private String realName;    // 用户姓名
  private String mobile;      // 用户手机号
  private String integral;    // 用户积分数
  private String difficult;   // 困难户(0-否、1-是)
  private String exchange;    // 积分兑换比例
  @JsonProperty(value = "integral_fee")
  private String integralFee; // 用户积分对应金额(单位元-1积分=0.2元)
  @JsonProperty(value = "openid")
  private String openId;      // 用户微信openid
  @JsonProperty(value = "userid")
  private String userId;      // 用户编号
}
