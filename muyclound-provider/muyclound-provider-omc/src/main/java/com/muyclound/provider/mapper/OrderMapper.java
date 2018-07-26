package com.muyclound.provider.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muyclound.provider.model.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
}
