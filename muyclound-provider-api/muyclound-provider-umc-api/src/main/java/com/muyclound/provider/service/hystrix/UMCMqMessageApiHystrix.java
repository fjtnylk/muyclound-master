package com.muyclound.provider.service.hystrix;

import com.muyclound.provider.service.UMCMqMessageFeignApi;
import com.muyclound.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/4/16.
 */
@Component
public class UMCMqMessageApiHystrix implements UMCMqMessageFeignApi {
  @Override
  public Wrapper<String> loadMessageKey(String messageKey) {
    return null;
  }
}
