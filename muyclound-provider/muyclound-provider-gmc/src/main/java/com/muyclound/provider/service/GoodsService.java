package com.muyclound.provider.service;

import com.muyclound.provider.model.dto.SaveGoodsDTO;
import com.muyclound.provider.model.entity.GoodsDO;

/**
 * Created by yanglikai on 2018/7/27.
 */
public interface GoodsService {

  /**
   * 插入/更新商品.
   *
   * @param target
   * @return
   */
  boolean save(SaveGoodsDTO target);

  /**
   * 删除商品.
   *
   * @param goodsCode
   * @return
   */
  boolean delete(String goodsCode);

  /**
   * 加载商品信息.
   *
   * @param goodsCode
   * @return
   */
  GoodsDO load(String goodsCode);
}
