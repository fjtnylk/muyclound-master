package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.GoodsPriceMapper;
import com.muyclound.provider.model.entity.GoodsPriceDO;
import com.muyclound.provider.repository.GoodsPriceRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Repository
public class GoodsPriceRepositoryImpl
    extends ServiceImpl<GoodsPriceMapper, GoodsPriceDO> implements GoodsPriceRepository {
}
