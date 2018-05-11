package com.muyclound.security.core.properties;

import lombok.Data;

/**
 * 浏览器环境配置.
 * Created by yanglikai on 2018/5/11.
 */
@Data
public class BrowserProperties {
  /**
   * 社交登录，如果需要用户注册，跳转的页面
   */
  private String signUpUrl = "/pc-signUp.html";

  /**
   * 登录响应的方式，默认是json
   */
  private LoginResponseType signInResponseType = LoginResponseType.JSON;

  /**
   * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
   * 只在signInResponseType为REDIRECT时生效
   */
  private String singInSuccessUrl;
}
