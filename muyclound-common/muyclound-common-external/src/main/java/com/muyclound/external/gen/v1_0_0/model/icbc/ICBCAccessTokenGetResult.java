package com.muyclound.external.gen.v1_0_0.model.icbc;


import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-获取accesstoken、sessionkey接口返回结果.
 * <p>
 * Created by yanglikai on 2018/3/15.
 */
@Data
public class ICBCAccessTokenGetResult implements APIResult {
  private String signature;   // 数字签名，用于sha1校验
  private String expiredtime; // 凭证有效时间，单位：秒
  private String accesstoken; // 第三方凭证
  private String sessionkey;  // 会话秘钥
}
