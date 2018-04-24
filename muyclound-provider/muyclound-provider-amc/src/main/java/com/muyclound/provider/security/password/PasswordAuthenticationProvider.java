package com.muyclound.provider.security.password;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * 用户名密码提供者.
 * Created by yanglikai on 2018/4/18.
 */
public class PasswordAuthenticationProvider implements AuthenticationProvider {
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    PasswordAuthenticationToken target = (PasswordAuthenticationToken) authentication;
    String username = target.getUserName();
    String password = target.getPassword();

    PasswordUserDetails userDetails = new PasswordUserDetails();
    userDetails.setUserId(10000L);
    userDetails.setUserName("KK");
    userDetails.setMobile("13671803404");
    userDetails.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));

    return new PasswordAuthenticationToken(userDetails, userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return PasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
