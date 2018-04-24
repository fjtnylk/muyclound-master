package com.muyclound.provider.security;

import com.google.common.collect.Lists;
import com.muyclound.security.core.SecurityUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Component
public class UMCUserDetailsService implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    SecurityUser user = new SecurityUser();
    user.setUserId(10000L);
    user.setUserName("yanglikai");
    user.setMobile("13671803404");
    user.setAuthorities(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")));
    return user;
  }
}
