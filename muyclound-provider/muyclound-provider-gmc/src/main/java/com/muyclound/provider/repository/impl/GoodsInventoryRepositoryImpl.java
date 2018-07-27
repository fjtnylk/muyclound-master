package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.GoodsInventoryMapper;
import com.muyclound.provider.model.entity.GoodsInventoryDO;
import com.muyclound.provider.repository.GoodsInventoryRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Repository
public class GoodsInventoryRepositoryImpl
    extends ServiceImpl<GoodsInventoryMapper, GoodsInventoryDO> implements GoodsInventoryRepository {
}
