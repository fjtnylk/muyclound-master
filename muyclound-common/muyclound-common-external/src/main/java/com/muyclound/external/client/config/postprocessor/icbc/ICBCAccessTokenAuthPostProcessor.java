package com.muyclound.external.client.config.postprocessor.icbc;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muyclound.external.client.config.AbstractPostProcessor;

/**
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCAccessTokenAuthPostProcessor extends AbstractPostProcessor {
  @Override
  public boolean isOK(String target) {
    JSONObject rspJson = JSON.parseObject(target);
    int errcode = rspJson.getInteger("errcode");

    if (errcode > 0) {
      return false;
    }

    return true;
  }

  @Override
  public String success(String target) {
    JSONObject rsp = new JSONObject();
    rsp.put("is_valid", true);

    JSONObject result = new JSONObject();
    result.put("response", rsp);
    return result.toJSONString();
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
