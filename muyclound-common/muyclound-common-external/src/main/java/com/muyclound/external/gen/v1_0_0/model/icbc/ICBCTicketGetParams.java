package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-获取jsapi凭证接口.参数.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCTicketGetParams implements APIParams {
  private String sessionKey;
  private String accessToken;
  private String type;

  public ICBCTicketGetParams() {
    this.type = "jsapi";
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();

    if (accessToken != null) {
      parameters.put("access_token", accessToken);
    }

    if (type != null) {
      parameters.put("type", type);
    }

    return parameters;
  }
}
