package com.muyclound.crypto.encryptor;


import com.muyclound.crypto.hash.Md5DigestUtil;
import com.muyclound.crypto.hash.Sha256DigestUtil;
import com.muyclound.crypto.hash.Sha512DigestUtil;
import com.muyclound.crypto.hash.SlowEqualsUtil;
import com.muyclound.crypto.keygen.KeyGeneratorUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/4/11.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EncryptorsUtil {

  public static String md5(String target) {
    return Md5DigestUtil.md5Hex(target);
  }

  public static String sha256(String target) {
    return Sha256DigestUtil.shaHex(target);
  }

  public static String sha512(String target) {
    return Sha512DigestUtil.shaHex(target);
  }

  public static boolean slowEquals(String arg1, String arg2) {
    return SlowEqualsUtil.slowEquals(arg1.getBytes(), arg2.getBytes());
  }

  public static String generateKey() {
    return KeyGeneratorUtil.generateKey();
  }
}
