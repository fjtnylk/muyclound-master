package com.muyclound.security.core.authentication.sms;

import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

/**
 * 短信登录配置.
 * <p>
 * Created by yanglikai on 2018/4/18.
 */
@Component
public class SMSAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  @Resource
  private AuthenticationSuccessHandler authenticationSuccessHandler;
  @Resource
  private AuthenticationFailureHandler authenticationFailureHandler;
  @Resource
  private UserDetailsService userDetailsService;
  @Resource
  private PersistentTokenRepository persistentTokenRepository;

  @Override
  public void configure(HttpSecurity http) {

    SMSAuthenticationFilter smsAuthenticationFilter = new SMSAuthenticationFilter();
    smsAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    smsAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    smsAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
    String key = UUID.randomUUID().toString();
    smsAuthenticationFilter.setRememberMeServices(new PersistentTokenBasedRememberMeServices(key, userDetailsService, persistentTokenRepository));

    SMSAuthenticationProvider smsAuthenticationProvider = new SMSAuthenticationProvider();
    smsAuthenticationProvider.setUserDetailsService(userDetailsService);

    http.authenticationProvider(smsAuthenticationProvider)
        .addFilterAfter(smsAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
