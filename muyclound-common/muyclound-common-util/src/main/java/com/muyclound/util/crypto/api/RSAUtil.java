package com.muyclound.util.crypto.api;

import com.muyclound.util.crypto.utils.Base64;
import com.muyclound.util.crypto.utils.RSA;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/4/11.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RSAUtil {
  public static byte[] encryptByPrivateKey(byte[] data, String path) throws Exception {
    String base64Text = Base64.encode(data);
    return RSA.rsaPriEn(base64Text.getBytes(), path);
  }

  public static byte[] encryptByPublicKey(byte[] data, String path) throws Exception {
    String base64Text = Base64.encode(data);
    return RSA.rsaPubEn(base64Text.getBytes(), path);
  }

  public static byte[] decryptByPrivateKey(byte[] data, String path) throws Exception {
    byte[] plainText = RSA.rsaPriDe(data, path);
    return Base64.decode(new String(plainText));
  }

  public static byte[] decryptByPublicKey(byte[] data, String path) throws Exception {
    byte[] plainText = RSA.rsaPubDe(data, path);
    return Base64.decode(new String(plainText));
  }
}
