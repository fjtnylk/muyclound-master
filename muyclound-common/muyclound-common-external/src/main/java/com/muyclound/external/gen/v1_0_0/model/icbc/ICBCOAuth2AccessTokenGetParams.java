package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-通过code换取网页授权access_token接口参数.
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCOAuth2AccessTokenGetParams implements APIParams {
  private String appid;
  private String code;

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();
    if (appid != null) {
      parameters.put("appid", appid);
    }

    if (code != null) {
      parameters.put("code", code);
    }

    return parameters;
  }
}
