package com.muyclound.provider.web.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.model.OperationResponse;
import com.muyclound.model.PageResponse;
import com.muyclound.provider.model.dto.PageGoodsDTO;
import com.muyclound.provider.model.dto.SaveGoodsDTO;
import com.muyclound.provider.model.entity.GoodsDO;
import com.muyclound.provider.model.vo.LoadGoodsVO;
import com.muyclound.provider.service.GoodsService;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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
public class GoodsController {
  @Resource
  private GoodsService goodsService;

  /**
   * 插入/更新商品.
   *
   * @param target
   * @return
   */
  @PostMapping(value = "/admin/goods/save")
  @ResponseBody
  public Wrapper<OperationResponse> saveGoods(@Validated @RequestBody SaveGoodsDTO target) {
    boolean result = goodsService.save(target);

    return WrapMapper.ok(result);
  }

  /**
   * 删除商品.
   *
   * @param goodsCode
   * @return
   */
  @PostMapping(value = "/admin/goods/delete")
  @ResponseBody
  public Wrapper<OperationResponse> deleteGoods(String goodsCode) {
    boolean result = goodsService.delete(goodsCode);

    return WrapMapper.ok(result);
  }

  /**
   * 加载商品信息.
   *
   * @param goodsCode
   * @return
   */
  @GetMapping(value = "/admin/goods/{goodsCode}")
  @ResponseBody
  public Wrapper<LoadGoodsVO> loadGoods(@PathVariable(value = "goodsCode") String goodsCode) {
    GoodsDO goods = goodsService.load(goodsCode);

    LoadGoodsVO rsp = goods.parse(LoadGoodsVO.class);

    return WrapMapper.ok(rsp);
  }

  /**
   * 商品分页加载.
   *
   * @param target
   * @return
   */
  @GetMapping(value = "/admin/goods.page/search")
  @ResponseBody
  public Wrapper<PageResponse> loadPageGoods(PageGoodsDTO target) {
    Page<GoodsDO> page = goodsService.loadPage(target);

    return WrapMapper.ok(page);
  }
}
