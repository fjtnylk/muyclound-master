package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-access_token鉴权接口参数.
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCAccessTokenAuthParams implements APIParams {
  private String accessToken;
  private String openid;

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();
    if (accessToken != null) {
      parameters.put("access_token", accessToken);
    }

    if (openid != null) {
      parameters.put("openid", openid);
    }

    return parameters;
  }
}
