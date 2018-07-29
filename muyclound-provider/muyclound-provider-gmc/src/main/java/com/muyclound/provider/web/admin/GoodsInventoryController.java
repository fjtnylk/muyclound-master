package com.muyclound.provider.web.admin;

import com.muyclound.model.OperationResponse;
import com.muyclound.provider.model.dto.SaveGoodsInventoryDTO;
import com.muyclound.provider.model.entity.GoodsInventoryDO;
import com.muyclound.provider.model.vo.LoadGoodsInventoryVO;
import com.muyclound.provider.service.GoodsInventoryService;
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
public class GoodsInventoryController {
  @Resource
  private GoodsInventoryService goodsInventoryService;

  /**
   * 插入/更新库存.
   *
   * @param target
   * @return
   */
  @PostMapping(value = "/admin/goods.inventory/save")
  @ResponseBody
  public Wrapper<OperationResponse> saveGoodsInventory(@RequestBody SaveGoodsInventoryDTO target) {
    boolean result = goodsInventoryService.save(target);

    return WrapMapper.ok(result);
  }

  /**
   * 删除库存.
   *
   * @param goodsCode
   * @return
   */
  @PostMapping(value = "/admin/goods.inventory/delete")
  @ResponseBody
  public Wrapper<OperationResponse> deleteGoodsInventory(String goodsCode) {
    boolean result = goodsInventoryService.delete(goodsCode);

    return WrapMapper.ok(result);
  }

  /**
   * 加载商品库存信息.
   *
   * @param goodsCode
   * @return
   */
  @GetMapping(value = "/admin/goods/inventory/{goodsCode}")
  @ResponseBody
  public Wrapper<LoadGoodsInventoryVO> loadGoodsInventory(@PathVariable(value = "goodsCode") String goodsCode) {
    GoodsInventoryDO goodsInventory = goodsInventoryService.load(goodsCode);

    LoadGoodsInventoryVO rsp = goodsInventory.parse(LoadGoodsInventoryVO.class);

    return WrapMapper.ok(rsp);
  }
}
