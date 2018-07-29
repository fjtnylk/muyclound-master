package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.muyclound.provider.model.dto.SaveGoodsClassDTO;
import com.muyclound.provider.model.entity.GoodsClassDO;
import com.muyclound.provider.repository.GoodsClassRepository;
import com.muyclound.provider.service.GoodsClassService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Service
public class GoodsClassServiceImpl implements GoodsClassService {
  @Resource
  private GoodsClassRepository goodsClassRepository;

  /**
   * 插入/更新分类.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(SaveGoodsClassDTO target) {
    GoodsClassDO goodsClass = target.parse(GoodsClassDO.class);

    return goodsClassRepository.insertOrUpdate(goodsClass);
  }

  /**
   * 删除分类.
   *
   * @param classCode
   * @return
   */
  @Override
  public boolean delete(String classCode) {
    return
        goodsClassRepository.delete(
            new EntityWrapper<GoodsClassDO>()
                .where("g_class_code={0}", classCode));
  }

  /**
   * 加载分类信息.
   *
   * @param classCode
   * @return
   */
  @Override
  public GoodsClassDO load(String classCode) {
    return
        goodsClassRepository.selectOne(
            new EntityWrapper<GoodsClassDO>()
                .where("g_class_code={0}", classCode)
                .orderBy("create_time", false));
  }
}
