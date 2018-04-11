package com.muyclound.security.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Data
@ConfigurationProperties(prefix = "muyclound.oauth2.client")
public class Oauth2ClientProperties {
  private String id;
  private String accessTokenUrl;
  private String clientId;
  private String clientSecret;
  private String clientAuthenticationScheme;
}
