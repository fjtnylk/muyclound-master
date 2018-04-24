package com.muyclound.security.core.authentication.sms;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 短息登录验证信息.
 *
 * Created by yanglikai on 2018/4/18.
 */
public class SMSAuthenticationToken extends AbstractAuthenticationToken {
  private final Object principal;

  public SMSAuthenticationToken(String mobile) {
    super(null);
    this.principal = mobile;
    super.setAuthenticated(false);
  }

  public SMSAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) {
    if (isAuthenticated) {
      throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    }

    super.setAuthenticated(false);
  }
}
