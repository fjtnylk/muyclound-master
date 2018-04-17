package com.muyclound.provider.service.impl;

import com.muyclound.provider.service.MqMessageService;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/4/16.
 */
@Service
public class MqMessageServiceImpl implements MqMessageService {

  @Override
  public String loadMessage(String messageKey) {
    return "this is umc provider service.";
  }
}
