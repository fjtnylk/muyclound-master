package com.muyclound.security.core.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Slf4j
public class DefaultUserDetailsService implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.warn("请配置 UserDetailsService 接口的实现.");
    throw new UsernameNotFoundException(username);
  }
}
