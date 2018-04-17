package com.muyclound.provider.service;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.provider.service.hystrix.UMCMqMessageApiHystrix;
import com.muyclound.security.feign.OAuth2FeignAutoConfiguration;
import com.muyclound.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yanglikai on 2018/4/16.
 */
@FeignClient(value = GlobalConstant.UMC_PROVIDER, fallback = UMCMqMessageApiHystrix.class)
public interface UMCMqMessageFeignApi {

  @GetMapping(value = "/api/umc/message/key/load")
  Wrapper<String> loadMessageKey(@RequestParam("messageKey") String messageKey);
}
