package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-access_token鉴权接口返回结果.
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCAccessTokenAuthResult implements APIResult {
  @JsonProperty(value = "is_valid")
  private boolean isValid;
}
