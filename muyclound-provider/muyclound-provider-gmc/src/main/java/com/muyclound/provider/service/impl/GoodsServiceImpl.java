package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.provider.model.bo.PageGoodsBO;
import com.muyclound.provider.model.bo.SaveGoodsBO;
import com.muyclound.provider.model.dto.PageGoodsDTO;
import com.muyclound.provider.model.dto.SaveGoodsDTO;
import com.muyclound.provider.model.entity.GoodsDO;
import com.muyclound.provider.repository.GoodsRepository;
import com.muyclound.provider.service.GoodsService;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
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
  public boolean save(SaveGoodsBO target) {
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

  /**
   * 分页加载.
   *
   * @param target
   * @return
   */
  @Override
  public Page<GoodsDO> loadPage(PageGoodsBO target) {
    int page =
        target.getPage() == null ? 0 : target.getPage();

    int size =
        target.getSize() == null ? GlobalConstant.DEFAULT_PAGE_SIZE : target.getSize();

    Page p =
        new Page(page, size);

    Wrapper wrapper =
        new EntityWrapper()
            .where("1=1")
            .orderBy("create_time", false);

    /* 商品名称 */
    String goodsName = target.getGoodsName();
    if (StringUtils.isNotBlank(goodsName)) {
      wrapper.like("goods_name", goodsName);
    }

    return
        goodsRepository.selectPage(p, wrapper);
  }
}
