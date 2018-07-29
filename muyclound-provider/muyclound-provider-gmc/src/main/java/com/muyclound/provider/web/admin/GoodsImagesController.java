package com.muyclound.provider.web.admin;

import com.muyclound.model.OperationResponse;
import com.muyclound.provider.model.dto.SaveGoodsImagesDTO;
import com.muyclound.provider.model.entity.GoodsImagesDO;
import com.muyclound.provider.model.vo.LoadGoodsImagesVO;
import com.muyclound.provider.service.GoodsImagesService;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/7/29.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class GoodsImagesController {
  @Resource
  private GoodsImagesService goodsImagesService;

  /**
   * 插入/更新商品图片.
   *
   * @param target
   * @return
   */
  @PostMapping(value = "/admin/goods.images/save")
  @ResponseBody
  public Wrapper<OperationResponse> saveGoodsImages(@RequestBody SaveGoodsImagesDTO target) {
    boolean result = goodsImagesService.save(target);

    return WrapMapper.ok(result);
  }

  /**
   * 删除商品图片.
   *
   * @param goodsCode
   * @return
   */
  @PostMapping(value = "/admin/goods.images/delete")
  @ResponseBody
  public Wrapper<OperationResponse> deleteGoods(String goodsCode) {
    boolean result = goodsImagesService.delete(goodsCode);

    return WrapMapper.ok(result);
  }

  /**
   * 加载商品信息.
   *
   * @param goodsCode
   * @return
   */
  @GetMapping(value = "/admin/goods/images/{goodsCode}")
  @ResponseBody
  public Wrapper<LoadGoodsImagesVO> loadGoods(@PathVariable(value = "goodsCode") String goodsCode) {
    GoodsImagesDO goodsImages = goodsImagesService.load(goodsCode);

    LoadGoodsImagesVO rsp = goodsImages.parse(LoadGoodsImagesVO.class);

    return WrapMapper.ok(rsp);
  }
}
