package com.muyclound.config;

import com.muyclound.config.properties.MuycloundProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Configuration
@EnableConfigurationProperties(MuycloundProperties.class)
public class MuycloundCoreConfig {
}
