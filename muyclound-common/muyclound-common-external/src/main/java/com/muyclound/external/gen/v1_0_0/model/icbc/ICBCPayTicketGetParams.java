package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-获取支付凭证接口参数.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCPayTicketGetParams implements APIParams {
  private String sessionKey;
  private String accessToken;

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> paramters = new HashMap<>();

    if (accessToken != null) {
      paramters.put("access_token", accessToken);
    }

    return paramters;
  }
}
