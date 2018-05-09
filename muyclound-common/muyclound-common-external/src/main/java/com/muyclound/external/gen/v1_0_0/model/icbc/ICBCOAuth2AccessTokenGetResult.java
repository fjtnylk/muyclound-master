package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-通过code换取网页授权access_token接口返回结果.
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCOAuth2AccessTokenGetResult implements APIResult {
  @JsonProperty(value = "access_token")
  private String accessToken; // 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
  @JsonProperty(value = "expires_in")
  private String expiresIn;   // access_token接口调用凭证超时时间，单位（秒）
  @JsonProperty(value = "openid")
  private String openid;      // 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
  @JsonProperty(value = "scope")
  private String scope;       // 	base（静默授权方式，目前仅支持行内公众号）；userinfo（普通授权方式，需要用户授权）
}
