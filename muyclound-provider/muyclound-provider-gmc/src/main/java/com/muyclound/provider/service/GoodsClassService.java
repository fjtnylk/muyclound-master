package com.muyclound.provider.service;

import com.muyclound.provider.model.bo.SaveGoodsClassBO;
import com.muyclound.provider.model.entity.GoodsClassDO;

/**
 * Created by yanglikai on 2018/7/27.
 */
public interface GoodsClassService {

  /**
   * 插入/更新分类.
   *
   * @param target
   * @return
   */
  boolean save(SaveGoodsClassBO target);

  /**
   * 删除分类.
   *
   * @param classCode
   * @return
   */
  boolean delete(String classCode);

  /**
   * 加载分类信息.
   *
   * @param classCode
   * @return
   */
  GoodsClassDO load(String classCode);
}
