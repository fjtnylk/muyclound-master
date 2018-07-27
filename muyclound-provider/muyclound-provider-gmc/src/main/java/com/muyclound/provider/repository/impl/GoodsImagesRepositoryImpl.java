package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.GoodsImagesMapper;
import com.muyclound.provider.model.entity.GoodsImagesDO;
import com.muyclound.provider.repository.GoodsImagesRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Repository
public class GoodsImagesRepositoryImpl
    extends ServiceImpl<GoodsImagesMapper, GoodsImagesDO> implements GoodsImagesRepository {
}
