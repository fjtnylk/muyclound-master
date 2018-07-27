package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.GoodsClassMapper;
import com.muyclound.provider.model.entity.GoodsClassDO;
import com.muyclound.provider.repository.GoodsClassRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Repository
public class GoodsClassRepositoryImpl
    extends ServiceImpl<GoodsClassMapper, GoodsClassDO> implements GoodsClassRepository {
}
