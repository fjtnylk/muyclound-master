package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/22.
 */
@Data
public class ICBCCryptParams {
  @JsonIgnore
  private String accessToken; // 调用接口凭证
  @JsonIgnore
  private String sessionKey;  // 会话秘钥

  public ICBCCryptParams() {
  }

  public ICBCCryptParams (String accessToken, String sessionKey) {
    this.accessToken = accessToken;
    this.sessionKey = sessionKey;
  }
}
