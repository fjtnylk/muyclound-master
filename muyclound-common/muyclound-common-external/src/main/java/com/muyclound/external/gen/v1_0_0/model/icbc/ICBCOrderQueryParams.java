package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-订单查询接口参数.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCOrderQueryParams extends ICBCCryptParams implements APIParams {
  @JsonProperty(value = "merID")
  private String merId;       // 商户编号
  @JsonProperty(value = "out_trade_no")
  private String outTradeNo; // 商户订单号
  @JsonProperty(value = "orderID")
  private String orderId;    // 行内订单号
  @JsonProperty(value = "backup_1")
  private String backup1;   // 备用字段1
  @JsonProperty(value = "backup_2")
  private String backup2;   // 备用字段2
  @JsonProperty(value = "backup_3")
  private String backup3;   // 备用字段3
  @JsonProperty(value = "backup_4")
  private String backup4;   // 备用字段4

  public ICBCOrderQueryParams() {
  }

  public ICBCOrderQueryParams(String accessToken, String sessionKey) {
    super(accessToken, sessionKey);
    this.orderId = "";
    this.backup1 = "";
    this.backup2 = "";
    this.backup3 = "";
    this.backup4 = "";
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();

    parameters.put("merID", merId);
    parameters.put("out_trade_no", outTradeNo);
    parameters.put("orderID", orderId);
    parameters.put("backup_1", backup1);
    parameters.put("backup_2", backup2);
    parameters.put("backup_3", backup3);
    parameters.put("backup_4", backup4);

    return parameters;
  }
}
