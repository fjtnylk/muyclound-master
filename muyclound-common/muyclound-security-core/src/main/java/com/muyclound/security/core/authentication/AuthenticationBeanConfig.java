package com.muyclound.security.core.authentication;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Configurable
public class AuthenticationBeanConfig {

  @Bean
  @ConditionalOnMissingBean(UserDetailsService.class)
  public UserDetailsService userDetailsService() {
    return new DefaultUserDetailsService();
  }
}
