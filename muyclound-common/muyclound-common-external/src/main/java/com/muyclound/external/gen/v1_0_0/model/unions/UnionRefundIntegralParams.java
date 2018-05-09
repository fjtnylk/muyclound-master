package com.muyclound.external.gen.v1_0_0.model.unions;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 积分返还接口参数模型.
 * Created by yanglikai on 2018/5/7.
 */
@Data
public class UnionRefundIntegralParams implements APIParams {
  private String userName;  // 接口调用用户名
  private String password;  // 接口调用密码
  private String mobile;    // 手机号
  private String refundFee; // 返还金额
  private String remark;    // 备注
  private String orderId;   // 订单号
  private String userId;    // 用户编号

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("username", userName);
    parameters.put("password", password);
    parameters.put("mobile", mobile);
    parameters.put("refund_fee", refundFee);
    parameters.put("remark", remark);
    parameters.put("orderid", orderId);
    parameters.put("userid", userId);

    return parameters;
  }
}
