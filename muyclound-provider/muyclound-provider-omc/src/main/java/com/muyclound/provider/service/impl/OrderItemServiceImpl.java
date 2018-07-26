package com.muyclound.provider.service.impl;

import com.muyclound.provider.repository.OrderItemRepository;
import com.muyclound.provider.service.OrderItemService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
  @Resource
  private OrderItemRepository orderItemRepository;
}
