package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-订单退款接口参数.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCOrderRefundParams extends ICBCOrderQueryParams implements APIParams {
  @JsonProperty(value = "rejectNo")
  private String rejectNo;  // 退款编号
  @JsonProperty(value = "reject_amt")
  private String rejectAmt; // 退款金额
  @JsonProperty(value = "operID")
  private String operId;    // 操作人编号

  public ICBCOrderRefundParams() {
  }

  public ICBCOrderRefundParams(String accessToken, String sessionKey) {
    super(accessToken, sessionKey);
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>(super.toParams());

    parameters.put("rejectNo", rejectNo);
    parameters.put("reject_amt", rejectAmt);
    parameters.put("operID", operId);

    return parameters;
  }
}
