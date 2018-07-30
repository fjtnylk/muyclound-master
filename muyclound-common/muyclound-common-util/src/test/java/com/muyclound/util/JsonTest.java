package com.muyclound.util;

import com.muyclound.util.json.JSONUtil;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/7/30.
 */
public class JsonTest {

  @Test
  public void test01() {
    Wrapper result = WrapMapper.ok();

    System.out.println(JSONUtil.toJSON(result));
  }
}
