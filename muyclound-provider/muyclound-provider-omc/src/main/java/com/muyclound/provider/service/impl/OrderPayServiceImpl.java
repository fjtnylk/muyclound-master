package com.muyclound.provider.service.impl;

import com.muyclound.provider.repository.OrderPayRepository;
import com.muyclound.provider.service.OrderPayService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Service
public class OrderPayServiceImpl implements OrderPayService {
  @Resource
  private OrderPayRepository orderPayRepository;
}
