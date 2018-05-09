package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-订单退款接口返回结果.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCOrderRefundResult implements APIResult {
  @JsonProperty(value = "return_code")
  private String returnCode;  // 返回状态码（1：退货成功，2：退货失败）
  @JsonProperty(value = "error_code")
  private String errorCode;   // 错误代码
  @JsonProperty(value = "error_msg")
  private String errorMsg;    // 错误信息
  @JsonProperty(value = "out_trade_no")
  private String outTradeNo;  // 商户订单号
  @JsonProperty(value = "orderID")
  private String orderId;     // 行内订单号
  @JsonProperty(value = "rejectNo")
  private String rejectNo;      // 退款编号
  @JsonProperty(value = "real_reject_amt")
  private String realRejectAmt; // 实退金额
  @JsonProperty(value = "reject_amt")
  private String rejectAmt;     // 本次退货金额
  @JsonProperty(value = "reject_point")
  private String rejectPoint;   // 积分退货金额
  @JsonProperty(value = "reject_ecoupon")
  private String rejectEcoupon; // 电子券退货金额
  @JsonProperty(value = "cardNo")
  private String cardNo;      // 交易卡号
  @JsonProperty(value = "backup_1")
  private String backup1;     // 启用备用字段1为本次所退优惠立减金额（商户部分）
  @JsonProperty(value = "backup_2")
  private String backup2;     // 启用备用字段2为本次所退银行补贴金额
  @JsonProperty(value = "backup_3")
  private String backup3;     // 启用备用字段3为本次所退总优惠金额，其值=本次所退优惠立减金额（商户部分）+本次所退银行补贴金额
  @JsonProperty(value = "backup_4")
  private String backup4;     // 备用字段4
}
