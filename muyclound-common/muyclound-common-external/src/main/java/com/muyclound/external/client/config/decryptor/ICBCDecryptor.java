package com.muyclound.external.client.config.decryptor;

import com.icbc.crypto.utils.Base64;
import com.muyclound.external.client.config.Decryptor;
import com.muyclound.external.exception.APIException;
import com.muyclound.external.util.misc.ICBCUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class ICBCDecryptor implements Decryptor {
  private String sessionKey;

  public ICBCDecryptor(String sessionKey) {
    if (StringUtils.isBlank(sessionKey)) {
      throw new IllegalArgumentException("session key must be not null");
    }

    this.sessionKey = sessionKey;
  }

  @Override
  public String decrypt(byte[] cipherText) {
    try {
      String dataString = new String(cipherText, ICBCUtils.UTF_8);
      if (dataString.contains("errcode")) {
        return dataString;
      }

      byte[] key = Base64.icbcbase64decode(sessionKey);
      byte[] decrypt = ICBCUtils.decrypt(cipherText, key);
      return new String(decrypt, ICBCUtils.UTF_8);
    } catch (Exception e) {
      throw new APIException(e.getMessage(), e);
    }
  }
}
