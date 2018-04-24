package com.muyclound.provider.security.password;

import java.util.Collection;
import lombok.Data;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Data
public class PasswordAuthenticationToken extends AbstractAuthenticationToken {
  private String userName;
  private String password;
  private PasswordUserDetails principal;

  public PasswordAuthenticationToken(String userName, String password) {
    super(null);
    this.userName = userName;
    this.password = password;
    super.setAuthenticated(false);
  }

  public PasswordAuthenticationToken(PasswordUserDetails principal, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return password;
  }

  @Override
  public PasswordUserDetails getPrincipal() {
    return principal;
  }
}
