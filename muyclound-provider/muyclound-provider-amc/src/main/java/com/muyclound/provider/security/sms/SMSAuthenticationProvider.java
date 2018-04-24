package com.muyclound.provider.security.sms;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * 短信认证提供者.
 * Created by yanglikai on 2018/4/18.
 */
public class SMSAuthenticationProvider implements AuthenticationProvider {
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    SMSAuthenticationToken target = (SMSAuthenticationToken) authentication;
    String mobile = target.getMobile();
    String verifyCode = target.getVerifyCode();

    SMSUserDetails userDetails = new SMSUserDetails();
    userDetails.setUserId(10000L);
    userDetails.setUserName("KK");
    userDetails.setMobile("13671803404");
    userDetails.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));

    return new SMSAuthenticationToken(userDetails, userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return SMSAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
