package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-订单冲正接口返回结果.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCOrderRejectResult implements APIResult {
  @JsonProperty(value = "return_code")
  private String returnCode;  // 返回状态码（1：冲正成功，2：冲正失败）
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
  private String backup1;     // 备用字段1
  @JsonProperty(value = "backup_2")
  private String backup2;     // 备用字段2
  @JsonProperty(value = "backup_3")
  private String backup3;     // 备用字段3
  @JsonProperty(value = "backup_4")
  private String backup4;     // 备用字段4
}
