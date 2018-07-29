package com.muyclound.provider.web.admin;

import com.muyclound.model.OperationResponse;
import com.muyclound.provider.model.dto.SaveGoodsPriceDTO;
import com.muyclound.provider.model.entity.GoodsPriceDO;
import com.muyclound.provider.model.vo.LoadGoodsPriceVO;
import com.muyclound.provider.service.GoodsPriceService;
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
public class GoodsPriceController {
  @Resource
  private GoodsPriceService goodsPriceService;

  /**
   * 插入/更新商品价格.
   *
   * @param target
   * @return
   */
  @PostMapping(value = "/admin/goods.price/save")
  @ResponseBody
  public Wrapper<OperationResponse> saveGoodsPrice(@RequestBody SaveGoodsPriceDTO target) {
    boolean result = goodsPriceService.save(target);

    return WrapMapper.ok(result);
  }

  /**
   * 删除商品价格.
   *
   * @param goodsCode
   * @return
   */
  @PostMapping(value = "/admin/goods.price/delete")
  @ResponseBody
  public Wrapper<OperationResponse> deleteGoodsPrice(String goodsCode) {
    boolean result = goodsPriceService.delete(goodsCode);

    return WrapMapper.ok(result);
  }

  /**
   * 加载商品价格信息.
   *
   * @param goodsCode
   * @return
   */
  @GetMapping(value = "/admin/goods/price/{goodsCode}")
  @ResponseBody
  public Wrapper<LoadGoodsPriceVO> loadGoods(@PathVariable(value = "goodsCode") String goodsCode) {
    GoodsPriceDO goodsPrice = goodsPriceService.load(goodsCode);

    LoadGoodsPriceVO rsp = goodsPrice.parse(LoadGoodsPriceVO.class);

    return WrapMapper.ok(rsp);
  }
}
