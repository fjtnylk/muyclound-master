package com.muyclound.provider.service;

import com.muyclound.provider.model.dto.SaveGoodsPriceDTO;
import com.muyclound.provider.model.entity.GoodsPriceDO;

/**
 * Created by yanglikai on 2018/7/27.
 */
public interface GoodsPriceService {

  /**
   * 插入/更新商品价格.
   *
   * @param target
   * @return
   */
  boolean save(SaveGoodsPriceDTO target);

  /**
   * 删除商品价格.
   *
   * @param goodsCode
   * @return
   */
  boolean delete(String goodsCode);

  /**
   * 加载商品价格信息.
   *
   * @param goodsCode
   * @return
   */
  GoodsPriceDO load(String goodsCode);
}
