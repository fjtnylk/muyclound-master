package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.OrderPayMapper;
import com.muyclound.provider.model.entity.OrderPayDO;
import com.muyclound.provider.repository.OrderPayRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Repository
public class OrderPayRepositoryImpl
    extends ServiceImpl<OrderPayMapper, OrderPayDO> implements OrderPayRepository {
}
