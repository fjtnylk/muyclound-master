package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工行-获取accesstoken、sessionkey接口参数.
 * <p>
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCAccessTokenGetParams implements APIParams {
  private String keyPath;
  private String signature;
  private String appid;
  private String timestamp;

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> paramters = new HashMap<>();
    if (signature != null) {
      paramters.put("signature", signature);
    }

    if (appid != null) {
      paramters.put("appid", appid);
    }

    if (timestamp != null) {
      paramters.put("timestamp", timestamp);
    }

    return paramters;
  }
}
