package com.muyclound.security.server;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * Created by yanglikai on 2018/5/11.
 */
public class TokenJwtEnhancer implements TokenEnhancer {

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oAuth2Authentication) {
    Map<String, Object> info = new HashMap<>(8);
    info.put("timestamp", System.currentTimeMillis());
    Authentication authentication = oAuth2Authentication.getUserAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
      Object principal = authentication.getPrincipal();
      info.put("loginName", ((UserDetails) principal).getUsername());
    }

    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

    return accessToken;
  }
}
