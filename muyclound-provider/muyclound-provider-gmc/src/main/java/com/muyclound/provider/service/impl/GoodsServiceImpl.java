package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.muyclound.provider.model.dto.SaveGoodsDTO;
import com.muyclound.provider.model.entity.GoodsDO;
import com.muyclound.provider.repository.GoodsRepository;
import com.muyclound.provider.service.GoodsService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
  @Resource
  private GoodsRepository goodsRepository;

  /**
   * 插入/更新商品.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(SaveGoodsDTO target) {
    GoodsDO goods = target.parse(GoodsDO.class);

    return goodsRepository.insertOrUpdate(goods);
  }

  /**
   * 删除商品.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public boolean delete(String goodsCode) {
    return
        goodsRepository.delete(
            new EntityWrapper<GoodsDO>().where("goods_code={0}", goodsCode));
  }

  /**
   * 加载商品信息.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public GoodsDO load(String goodsCode) {
    return
        goodsRepository.selectOne(
            new EntityWrapper<GoodsDO>()
                .where("goods_code={0}", goodsCode)
                .orderBy("create_time", false));
  }
}
