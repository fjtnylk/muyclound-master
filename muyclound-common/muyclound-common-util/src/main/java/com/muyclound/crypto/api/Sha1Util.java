package com.muyclound.crypto.api;

import com.muyclound.crypto.utils.Base64;
import com.muyclound.crypto.utils.SHA1;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/4/11.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sha1Util {

  public static String shaHex(byte[] data) {
    SHA1 sha = new SHA1();
    return sha.getDigestOfString(data);
  }

  public static boolean validata(byte[] data, String messageDigest) {
    SHA1 sha = new SHA1();
    return messageDigest.equals(sha.getDigestOfString(data));
  }

  public static boolean tokenValidate(byte[] data, String messageDigest, String keyPath) throws Exception {
    String messageDigest_p = new String(RSAUtil.decryptByPublicKey(Base64.decode(messageDigest), keyPath));
    return validata(data, messageDigest_p);
  }
}
