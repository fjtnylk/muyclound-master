package com.muyclound.security.core.authorize;

import com.muyclound.security.core.properties.SecurityConstants;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Component
@Order(Integer.MIN_VALUE)
public class PCAuthorizeConfigProvider implements AuthorizeConfigProvider {

  @Override
  public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
    config.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
        SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
        SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID,
        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*", "/pay/alipayCallback",
        "/auth/**").permitAll();
    return false;
  }
}
