package com.muyclound.external.client.config.postprocessor.icbc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crypto.RSAUtils;
import com.crypto.Sha1Utils;
import com.icbc.crypto.utils.Base64;
import com.muyclound.external.client.config.AbstractPostProcessor;
import com.muyclound.external.client.config.PostProcessorContext;
import com.muyclound.external.exception.APIException;

/**
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCAccessTokenGetPostProcessor extends AbstractPostProcessor {
  private String keypath;

  public ICBCAccessTokenGetPostProcessor(PostProcessorContext<String> context) {
    super(context);
    this.keypath = context.getTarget();
  }

  @Override
  public boolean isOK(String target) {
    if (target.contains("errcode")) {
      return false;
    }

    return true;
  }

  @Override
  public String success(String target) {
    /* 验证响应来源及数据完整性 */
    tokenValidate(target);

    /* 响应报文解密获取accesstoken和sessionkey */
    JSONObject rspJson = JSON.parseObject(target);
    String signature = rspJson.getString("signature");

    JSONObject token = rspJson.getJSONObject("token");
    String expiredtime = token.getString("expiredtime");
    String accessToken = token.getString("accesstoken");
    // 获取sessionkey密文
    String key = token.getString("sessionkey");
    // 使用公众号私钥解密，获取sessionkey明文
    String sessionkey = decryptKey(key, keypath + "/caisx_priv.key");

    JSONObject rsp = new JSONObject();
    rsp.put("signature", signature);
    rsp.put("expiredtime", expiredtime);
    rsp.put("accesstoken", accessToken);
    rsp.put("sessionkey", sessionkey);

    JSONObject result = new JSONObject();
    result.put("response", rsp);
    return result.toJSONString();
  }

  /**
   * 解密sessionkey.
   *
   * @param key
   * @param path
   * @return
   */
  private String decryptKey(String key, String path) {
    try {
      return new String(RSAUtils.decryptByPrivateKey(Base64.icbcbase64decode(key), path));
    } catch (Exception e) {
      throw new APIException(e.getMessage(), e);
    }
  }

  /**
   * token数据完整性效验.
   *
   * @param target
   */
  private void tokenValidate(String target) {
    JSONObject json = JSON.parseObject(target);
    String signature = json.getString("signature");
    String token = json.getString("token");

    try {
      boolean ret = Sha1Utils.tokenValidate(token.getBytes(), signature, keypath + "/icbc_pub.key");
      if (ret == false) {
        throw new APIException("SHA1解密验签失败!");
      }
    } catch (Exception e) {
      throw new APIException(e.getMessage(), e);
    }
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
