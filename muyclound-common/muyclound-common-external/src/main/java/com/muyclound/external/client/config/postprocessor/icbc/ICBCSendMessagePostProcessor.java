package com.muyclound.external.client.config.postprocessor.icbc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muyclound.external.client.config.AbstractPostProcessor;

/**
 * Created by yanglikai on 2018/3/22.
 */
public class ICBCSendMessagePostProcessor extends AbstractPostProcessor {
  @Override
  public boolean isOK(String target) {
    JSONObject rspJson = JSON.parseObject(target);
    String code = rspJson.getString("errcode");
    if ("0".equals(code)) {
      return true;
    }

    return false;
  }

  @Override
  public String success(String target) {
    JSONObject rsp = new JSONObject();

    JSONObject success = new JSONObject();
    success.put("success", true);

    rsp.put("response", success);
    return rsp.toJSONString();
  }

  @Override
  public String failed(String target) {
    JSONObject rspJson = JSON.parseObject(target);
    String code = rspJson.getString("errcode");
    String message = rspJson.getString("errmsg");

    JSONObject error = new JSONObject();
    error.put("code", code);
    error.put("msg", message);

    JSONObject result = new JSONObject();
    result.put("error_response", error);
    return result.toJSONString();
  }
}
