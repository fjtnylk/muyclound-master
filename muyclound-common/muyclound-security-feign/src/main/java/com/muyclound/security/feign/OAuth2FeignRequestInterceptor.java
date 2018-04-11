package com.muyclound.security.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Slf4j
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {
  private static final String BEARER_TOKEN_TYPE = "bearer";

  private final OAuth2RestTemplate oAuth2RestTemplate;

  OAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
    Objects.requireNonNull(oAuth2RestTemplate, "Context can not be null");
    this.oAuth2RestTemplate = oAuth2RestTemplate;
  }

  @Override
  public void apply(RequestTemplate template) {
    log.debug("Constructing Header {} for Token {}", HttpHeaders.AUTHORIZATION, BEARER_TOKEN_TYPE);
    template.header(HttpHeaders.AUTHORIZATION, String.format("%s %s", BEARER_TOKEN_TYPE, oAuth2RestTemplate.getAccessToken().toString()));
  }
}
