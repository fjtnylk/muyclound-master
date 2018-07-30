package com.muyclound.provider.service;

import com.muyclound.provider.model.bo.SaveGoodsImagesBO;
import com.muyclound.provider.model.entity.GoodsImagesDO;

/**
 * Created by yanglikai on 2018/7/27.
 */
public interface GoodsImagesService {

  /**
   * 插入/更新商品图片.
   *
   * @param target
   * @return
   */
  boolean save(SaveGoodsImagesBO target);

  /**
   * 删除商品图片.
   *
   * @param goodsCode
   * @return
   */
  boolean delete(String goodsCode);

  /**
   * 加载商品图片信息.
   *
   * @param goodsCode
   * @return
   */
  GoodsImagesDO load(String goodsCode);
}
