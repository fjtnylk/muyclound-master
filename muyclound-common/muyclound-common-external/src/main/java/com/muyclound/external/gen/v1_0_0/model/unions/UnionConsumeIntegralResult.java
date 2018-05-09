package com.muyclound.external.gen.v1_0_0.model.unions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 积分消费接口返回结果.
 * Created by yanglikai on 2018/5/7.
 */
@Data
public class UnionConsumeIntegralResult implements APIResult {
  /**
   * 错误编号,成功为空
   * <p>
   * 2001：手机号不正确
   * 2002：无此会员信息
   * 2003：抵扣金额不正确
   * 2004：抵扣金额超出用户积分
   * 2005：订单编号参数未知
   * 2006：用户信息不完整
   */
  @JsonProperty(value = "errornum")
  private String errorNum;
  @JsonProperty(value = "errormsg")
  private String errorMsg;
}
