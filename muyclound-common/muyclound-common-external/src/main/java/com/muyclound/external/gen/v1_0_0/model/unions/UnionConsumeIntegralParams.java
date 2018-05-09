package com.muyclound.external.gen.v1_0_0.model.unions;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 积分消费接口参数模型.
 * Created by yanglikai on 2018/5/7.
 */
@Data
public class UnionConsumeIntegralParams implements APIParams {
  private String userName;    // 接口调用用户名
  private String password;    // 接口调用密码
  private String mobile;      // 手机号
  private String exchangeFee; // 积分抵扣金额(单位元)
  private String payFee;      // 支付总金额(单位元)
  private String orderId;     // 订单编号
  private String goods;       // 商品名称
  private String openId;      // 微信openid
  private String userId;      // 用户编号

  public UnionConsumeIntegralParams() {
    this.goods = "";
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("username", userName);
    parameters.put("password", password);
    parameters.put("mobile", mobile);
    parameters.put("exchange_fee", exchangeFee);
    parameters.put("pay_fee", payFee);
    parameters.put("orderid", orderId);
    parameters.put("goods", goods);
    parameters.put("openid", openId);
    parameters.put("userid", userId);

    return parameters;
  }
}
