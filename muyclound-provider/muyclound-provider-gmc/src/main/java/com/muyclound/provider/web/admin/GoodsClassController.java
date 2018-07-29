package com.muyclound.provider.web.admin;

import com.muyclound.model.OperationResponse;
import com.muyclound.provider.model.dto.SaveGoodsClassDTO;
import com.muyclound.provider.model.entity.GoodsClassDO;
import com.muyclound.provider.model.vo.LoadGoodsClassVO;
import com.muyclound.provider.service.GoodsClassService;
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
 * Created by yanglikai on 2018/7/27.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class GoodsClassController {
  @Resource
  private GoodsClassService goodsClassService;

  /**
   * 插入/更新分类.
   *
   * @param target
   * @return
   */
  @PostMapping(value = "/admin/goods.class/save")
  @ResponseBody
  public Wrapper<OperationResponse> saveGoodsClass(@RequestBody SaveGoodsClassDTO target) {
    boolean result = goodsClassService.save(target);

    return WrapMapper.ok(result);
  }

  /**
   * 删除分类.
   *
   * @param classCode
   * @return
   */
  @PostMapping(value = "/admin/goods.class/delete")
  @ResponseBody
  public Wrapper<OperationResponse> deleteGoodsClass(String classCode) {
    boolean result = goodsClassService.delete(classCode);

    return WrapMapper.ok(result);
  }

  /**
   * 加载分类信息.
   *
   * @param classCode
   * @return
   */
  @GetMapping(value = "/admin/goods/class/{classCode}")
  @ResponseBody
  public Wrapper<LoadGoodsClassVO> loadGoodsClass(@PathVariable(value = "classCode") String classCode) {
    GoodsClassDO goodsClass = goodsClassService.load(classCode);

    LoadGoodsClassVO rsp = goodsClass.parse(LoadGoodsClassVO.class);

    return WrapMapper.ok(rsp);
  }
}
