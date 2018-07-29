package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.muyclound.provider.model.dto.SaveGoodsPriceDTO;
import com.muyclound.provider.model.entity.GoodsPriceDO;
import com.muyclound.provider.repository.GoodsPriceRepository;
import com.muyclound.provider.service.GoodsPriceService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Service
public class GoodsPriceServiceImpl implements GoodsPriceService {
  @Resource
  private GoodsPriceRepository goodsPriceRepository;

  /**
   * 插入/更新商品价格.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(SaveGoodsPriceDTO target) {
    GoodsPriceDO goodsPrice = target.parse(GoodsPriceDO.class);

    return
        goodsPriceRepository.insertOrUpdate(goodsPrice);
  }

  /**
   * 删除商品价格.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public boolean delete(String goodsCode) {
    return
        goodsPriceRepository.delete(
            new EntityWrapper<GoodsPriceDO>()
                .where("goods_code={0}", goodsCode));
  }

  /**
   * 加载商品价格信息.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public GoodsPriceDO load(String goodsCode) {
    return
        goodsPriceRepository.selectOne(
            new EntityWrapper<GoodsPriceDO>()
                .where("goods_code={0}", goodsCode)
                .orderBy("create_time", false));
  }
}
