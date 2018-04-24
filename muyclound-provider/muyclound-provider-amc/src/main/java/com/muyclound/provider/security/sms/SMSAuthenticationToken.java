package com.muyclound.provider.security.sms;

import java.util.Collection;
import lombok.Data;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Data
public class SMSAuthenticationToken extends AbstractAuthenticationToken {
  private String mobile;
  private String verifyCode;
  private SMSUserDetails principal;

  public SMSAuthenticationToken(String mobile, String verifyCode) {
    super(null);
    this.mobile = mobile;
    this.verifyCode = verifyCode;
    super.setAuthenticated(false);
  }

  public SMSAuthenticationToken(SMSUserDetails principal, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return verifyCode;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }
}
