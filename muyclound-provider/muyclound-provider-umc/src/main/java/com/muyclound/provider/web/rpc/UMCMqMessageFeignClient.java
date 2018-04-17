package com.muyclound.provider.web.rpc;

import com.muyclound.provider.service.MqMessageService;
import com.muyclound.provider.service.UMCMqMessageFeignApi;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/16.
 */
@RestController
public class UMCMqMessageFeignClient implements UMCMqMessageFeignApi {
  @Resource
  private MqMessageService mqMessageService;

  @Override
  public Wrapper<String> loadMessageKey(String messageKey) {
    String message = mqMessageService.loadMessage(messageKey);
    return WrapMapper.ok(message);
  }
}
