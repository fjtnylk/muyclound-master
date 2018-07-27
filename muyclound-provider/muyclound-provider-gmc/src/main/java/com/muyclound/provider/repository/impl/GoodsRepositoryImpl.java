package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.GoodsMapper;
import com.muyclound.provider.model.entity.GoodsDO;
import com.muyclound.provider.repository.GoodsRepository;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Service
public class GoodsRepositoryImpl
    extends ServiceImpl<GoodsMapper, GoodsDO> implements GoodsRepository {
}
