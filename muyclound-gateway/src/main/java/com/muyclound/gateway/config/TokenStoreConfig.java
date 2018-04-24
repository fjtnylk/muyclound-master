package com.muyclound.gateway.config;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Configuration
public class TokenStoreConfig {

  @Configuration
  @ConditionalOnProperty(prefix = "muyclound.security.oauth2", name = "tokenStore", havingValue = "redis")
  public static class RedisConfig {
    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore redisTokenStore() {
      return new RedisTokenStore(redisConnectionFactory);
    }
  }

  @Configuration
  @ConditionalOnProperty(prefix = "muyclound.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
  public static class JwtConfig {

  }
}
