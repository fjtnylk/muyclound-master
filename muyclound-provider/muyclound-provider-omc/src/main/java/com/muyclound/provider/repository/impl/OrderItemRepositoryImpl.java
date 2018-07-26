package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.OrderItemMapper;
import com.muyclound.provider.model.entity.OrderItemDO;
import com.muyclound.provider.repository.OrderItemRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Repository
public class OrderItemRepositoryImpl
    extends ServiceImpl<OrderItemMapper, OrderItemDO> implements OrderItemRepository {
}
