package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.OrderMapper;
import com.muyclound.provider.model.entity.OrderDO;
import com.muyclound.provider.repository.OrderRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Repository
public class OrderRepositoryImpl
    extends ServiceImpl<OrderMapper, OrderDO> implements OrderRepository {
}
