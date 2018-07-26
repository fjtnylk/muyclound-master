package com.muyclound.provider.service.impl;

import com.muyclound.provider.repository.OrderRepository;
import com.muyclound.provider.service.OrderService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Service
public class OrderServiceImpl implements OrderService {
  @Resource
  private OrderRepository orderRepository;
}
