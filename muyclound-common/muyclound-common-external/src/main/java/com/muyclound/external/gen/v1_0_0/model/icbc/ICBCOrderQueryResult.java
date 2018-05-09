package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-订单查询接口返回结果.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCOrderQueryResult implements APIResult {
  @JsonProperty(value = "return_code")
  private String returnCode;  // 返回状态码（0：支付中，1：支付成功，2：支付失败）
  @JsonProperty(value = "error_code")
  private String errorCode;   // 错误代码
  @JsonProperty(value = "error_msg")
  private String errorMsg;    // 错误信息
  @JsonProperty(value = "userID")
  private String userId;      // 用户标识
  @JsonProperty(value = "cardNo")
  private String cardNo;      // 付款卡号
  @JsonProperty(value = "total_amt")
  private String totalAmt;    // 订单总金额
  @JsonProperty(value = "point_amt")
  private String pointAmt;    // 积分抵扣金额
  @JsonProperty(value = "ecoupon_amt")
  private String ecouponAmt;  // 电子券折扣金额
  @JsonProperty(value = "mer_disc_amt")
  private String merDiscAmt;  // 优惠立减金额
  @JsonProperty(value = "bank_disc_amt")
  private String bankDiscAmt; // 银行补贴金额
  @JsonProperty(value = "payment_amt")
  private String paymentAmt;  // 实际支付金额
  @JsonProperty(value = "out_trade_no")
  private String outTradeNo;  // 商户订单号
  @JsonProperty(value = "orderID")
  private String orderId;     // 行内订单号
  @JsonProperty(value = "pay_time")
  private String payTime;     // 支付完成时间
  @JsonProperty(value = "backup_1")
  private String backup1;     // 启用备用字段1为总优惠金额，其值=优惠立减金额（商户部分）+银行补贴金额
  @JsonProperty(value = "backup_2")
  private String backup2;     // 备用字段2
  @JsonProperty(value = "backup_3")
  private String backup3;     // 备用字段3
  @JsonProperty(value = "backup_4")
  private String backup4;     // 备用字段4
}
