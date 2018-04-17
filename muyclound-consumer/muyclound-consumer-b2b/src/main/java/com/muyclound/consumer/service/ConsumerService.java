package com.muyclound.consumer.service;

import com.muyclound.provider.service.UMCMqMessageFeignApi;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/4/16.
 */
@Service
@Slf4j
public class ConsumerService {
  @Resource
  private UMCMqMessageFeignApi umcMqMessageFeignApi;

  public String loadMessage(String key) {
    Wrapper<String> result = umcMqMessageFeignApi.loadMessageKey(key);
    return result.getResult();
  }
}
