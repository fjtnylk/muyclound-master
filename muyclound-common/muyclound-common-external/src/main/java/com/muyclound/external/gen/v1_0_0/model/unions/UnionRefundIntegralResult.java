package com.muyclound.external.gen.v1_0_0.model.unions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 积分返还接口返回结果.
 * Created by yanglikai on 2018/5/7.
 */
@Data
public class UnionRefundIntegralResult implements APIResult {
  /**
   * 错误编号,成功为空
   * <p>
   * 3001：手机号不正确
   * 3002：用户信息不完整(没有userid参数)
   * 3003：返还金额参数未知(没有refund_fee参数或为0)
   * 3004：订单编号参数未知
   * 3005：无此会员信息
   */
  @JsonProperty(value = "errornum")
  private String errorNum;
  @JsonProperty(value = "errormsg")
  private String errorMsg;
}
