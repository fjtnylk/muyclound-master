package com.muyclound;

import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.provider.model.dto.SaveGoodsDTO;
import com.muyclound.util.json.JSONUtil;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by yanglikai on 2018/7/29.
 */
public class GoodsTest extends MUYApplicationTests {

  @Test
  public void test001() throws Exception {
    SaveGoodsDTO target = new SaveGoodsDTO();
    target.setGoodsCode("");
    target.setGoodsName("优质活塞10#");
    target.setGoodsType(10);
    target.setStatus(1);
    target.setSpec("KG/袋");
    target.setUnit("斤");
    target.setOrigin("福建福州");

    String url = "/api/admin/goods/save";

    ResultActions result = post(url, JSONUtil.toJSON(target));

    result
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ErrorCodeEnum.GL99990400.code()));
  }

  @Test
  public void test002() throws Exception {
    SaveGoodsDTO target = new SaveGoodsDTO();
    target.setGoodsCode("3606531111110");
    target.setGoodsName("优质活塞10#");
    target.setGoodsType(10);
    target.setStatus(1);
    target.setSpec("KG/袋");
    target.setUnit("斤");
    target.setOrigin("福建福州");

    String url = "/api/admin/goods/save";

    ResultActions result = post(url, JSONUtil.toJSON(target));

    result
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ErrorCodeEnum.GL99990400.code()));
  }

  @Test
  public void test003() throws Exception {
    SaveGoodsDTO target = new SaveGoodsDTO();
    target.setGoodsCode("360653");
    target.setGoodsName("优质活塞10#");
    target.setGoodsType(10);
    target.setStatus(1);
    target.setSpec("KG/袋");
    target.setUnit("斤");
    target.setOrigin("福建福州");

    String url = "/api/admin/goods/save";

    ResultActions result = post(url, JSONUtil.toJSON(target));

    result
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("ok"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.response.is_success").value(true));
  }
}
