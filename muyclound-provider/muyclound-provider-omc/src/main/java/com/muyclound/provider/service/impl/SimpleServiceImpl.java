package com.muyclound.provider.service.impl;

import com.muyclound.provider.service.SimpleService;
import com.muyclound.provider.service.UMCMqMessageFeignApi;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/4/17.
 */
@Service
@Slf4j
public class SimpleServiceImpl implements SimpleService {
  @Resource
  private UMCMqMessageFeignApi umcMqMessageFeignApi;

  @Override
  public String loadMessage(String key) {
    Wrapper<String> result = umcMqMessageFeignApi.loadMessageKey(key);
    return result.getResult();
  }
}
