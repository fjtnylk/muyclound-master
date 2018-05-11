package com.muyclound.security.core.authentication;

import com.muyclound.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 表单登录配置
 * Created by yanglikai on 2018/4/18.
 */
@Component
public class FormAuthenticationConfig {

  protected final AuthenticationSuccessHandler authenticationSuccessHandler;

  protected final AuthenticationFailureHandler authenticationFailureHandler;

  @Autowired
  public FormAuthenticationConfig(AuthenticationSuccessHandler authenticationSuccessHandler, AuthenticationFailureHandler authenticationFailureHandler) {
    this.authenticationSuccessHandler = authenticationSuccessHandler;
    this.authenticationFailureHandler = authenticationFailureHandler;
  }

  public void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
        .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
        .successHandler(authenticationSuccessHandler)
        .failureHandler(authenticationFailureHandler);
  }
}
