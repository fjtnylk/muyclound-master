package com.muyclound.external.client.config.encryptor;

import com.crypto.TripleDesUtils;
import com.icbc.crypto.utils.Base64;
import com.muyclound.external.client.config.AbstractEncryptor;
import com.muyclound.external.exception.APIException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;

/**
 * Created by yanglikai on 2018/3/22.
 */
public class ICBCEncryptor extends AbstractEncryptor {
  private String sessionKey;

  public ICBCEncryptor(String sessionKey) {
    if (StringUtils.isBlank(sessionKey)) {
      throw new IllegalArgumentException("session key must be not null");
    }

    this.sessionKey = sessionKey;
  }

  @Override
  public HttpEntity toEntity() {
    try {
      byte[] key = Base64.icbcbase64decode(sessionKey);
      // formparams为post请求的参数
      // body为参数内容
      List<NameValuePair> formparams = new ArrayList<>();
      formparams.add(new BasicNameValuePair("body", content));
      HttpEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
      // 获取post请求实体的二进制数组
      byte[] p = IOUtils.toByteArray(entity.getContent());
      // 使用会话密钥加密后获取流的密文
      byte[] c = TripleDesUtils.encrypt(p, key);
      // 根据密文重新生成一个请求实体
      return new ByteArrayEntity(c);
    } catch (UnsupportedEncodingException e) {
      throw new APIException(e.getMessage(), e);
    } catch (IOException e) {
      throw new APIException(e.getMessage(), e);
    }
  }
}
