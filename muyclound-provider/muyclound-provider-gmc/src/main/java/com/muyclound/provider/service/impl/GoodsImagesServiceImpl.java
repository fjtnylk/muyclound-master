package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.muyclound.provider.model.dto.SaveGoodsImagesDTO;
import com.muyclound.provider.model.entity.GoodsImagesDO;
import com.muyclound.provider.repository.GoodsImagesRepository;
import com.muyclound.provider.service.GoodsImagesService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Service
public class GoodsImagesServiceImpl implements GoodsImagesService {
  @Resource
  private GoodsImagesRepository goodsImagesRepository;

  /**
   * 插入/更新商品图片.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(SaveGoodsImagesDTO target) {
    GoodsImagesDO goodsImages = target.parse(GoodsImagesDO.class);

    return goodsImagesRepository.insertOrUpdate(goodsImages);
  }

  /**
   * 删除商品图片.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public boolean delete(String goodsCode) {
    return
        goodsImagesRepository.delete(
            new EntityWrapper<GoodsImagesDO>()
                .where("goods_code={0}", goodsCode));
  }

  /**
   * 加载商品图片信息.
   *
   * @param goodsCode
   * @return
   */
  @Override
  public GoodsImagesDO load(String goodsCode) {
    return
        goodsImagesRepository.selectOne
            (new EntityWrapper<GoodsImagesDO>()
                .where("goods_code={0}", goodsCode)
                .orderBy("create_time", false));
  }
}
