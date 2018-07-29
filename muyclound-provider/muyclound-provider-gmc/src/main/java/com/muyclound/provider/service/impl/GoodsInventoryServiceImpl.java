package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.muyclound.provider.model.dto.SaveGoodsInventoryDTO;
import com.muyclound.provider.model.entity.GoodsInventoryDO;
import com.muyclound.provider.repository.GoodsInventoryRepository;
import com.muyclound.provider.service.GoodsInventoryService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Service
public class GoodsInventoryServiceImpl implements GoodsInventoryService {
  @Resource
  private GoodsInventoryRepository goodsInventoryRepository;

  /**
   * 插入/更新商品库存.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(SaveGoodsInventoryDTO target) {
    GoodsInventoryDO goodsInventory = target.parse(GoodsInventoryDO.class);

    return
        goodsInventoryRepository.insertOrUpdate(goodsInventory);
  }

  /**
   * 删除商品库存.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public boolean delete(String goodsCode) {
    return
        goodsInventoryRepository.delete(
            new EntityWrapper<GoodsInventoryDO>()
                .where("goods_code={0}", goodsCode));
  }

  /**
   * 加载商品信息.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public GoodsInventoryDO load(String goodsCode) {
    return
        goodsInventoryRepository.selectOne(
            new EntityWrapper<GoodsInventoryDO>()
                .where("goods_code={0}", goodsCode)
                .orderBy("create_time", false));
  }
}
