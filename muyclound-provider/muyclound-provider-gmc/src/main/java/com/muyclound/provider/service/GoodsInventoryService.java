package com.muyclound.provider.service;

import com.muyclound.provider.model.dto.SaveGoodsInventoryDTO;
import com.muyclound.provider.model.entity.GoodsInventoryDO;

/**
 * Created by yanglikai on 2018/7/27.
 */
public interface GoodsInventoryService {

  /**
   * 插入/更新商品库存.
   *
   * @param target
   * @return
   */
  boolean save(SaveGoodsInventoryDTO target);

  /**
   * 删除商品库存.
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
  GoodsInventoryDO load(String goodsCode);
}
