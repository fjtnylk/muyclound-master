package com.muyclound.external.client.config.postprocessor.unions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muyclound.external.client.config.AbstractPostProcessor;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2018/5/7.
 */
public class UnionPostProcessor extends AbstractPostProcessor {
  @Override
  public boolean isOK(String target) {
    JSONObject json = JSON.parseObject(target);

    String errorNum = json.getString("errornum");
    if (StringUtils.isEmpty(errorNum)) {
      return true;
    }

    return false;
  }

  @Override
  public String success(String target) {
    JSONObject rsp = new JSONObject();
    rsp.put("response", JSONObject.parseObject(target));
    return rsp.toJSONString();
  }

  @Override
  public String failed(String target) {
    JSONObject rspJson = JSON.parseObject(target);
    String code = rspJson.getString("errornum");
    String message = rspJson.getString("errormsg");

    JSONObject error = new JSONObject();
    error.put("code", code);
    error.put("msg", message);

    JSONObject result = new JSONObject();
    result.put("error_response", error);
    return result.toJSONString();
  }
}
