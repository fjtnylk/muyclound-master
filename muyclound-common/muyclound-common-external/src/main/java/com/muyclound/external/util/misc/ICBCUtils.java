package com.muyclound.external.util.misc;

import com.crypto.RSAUtils;
import com.crypto.TripleDesUtils;
import com.icbc.crypto.utils.Base64;
import com.icbc.crypto.utils.RSA;

/**
 * Created by yanglikai on 2018/3/15.
 */
public final class ICBCUtils {
  public static final String UTF_8 = "utf-8";

  private ICBCUtils() {
  }

  /**
   * 根据appid和时间戳获取签名.
   *
   * @param appid     接入成功后平台为公众号分配的appid
   * @param timestamp 时间戳
   * @param privKey   公众号私钥存放路径
   * @return
   */
  public static String getSignature(String appid, String timestamp, String privKey) {
    String signature = null;
    try {
      //签名明文：
      signature = appid + timestamp;
      //使用公众号的私钥生成签名密文，
      byte[] cipherText = RSAUtils.encryptByPrivateKey(signature.getBytes(), privKey);
      //将密文通过base64转化成字符串
      signature = Base64.icbcbase64encode(cipherText);
      //base64转成字符串时，由于过长会导致结果出现\r，\n，因此替换掉
      signature = signature.replaceAll("\r", "").replaceAll("\n", "");
    } catch (Exception e) {
      e.printStackTrace();
    }

    return signature;
  }

  /**
   * 私钥加密
   *
   * @param data 待加密数据
   * @param path 私钥密钥文件路径
   * @return byte[] 加密数据
   * @throws Exception
   */
  public static byte[] encryptByPrivateKey(byte[] data, String path) throws Exception {
    String base64Text = Base64.icbcbase64encode(data);
    return RSA.icbcRsaPriEn(base64Text.getBytes(), path);
  }

  /**
   * 公钥解密
   *
   * @param data 待解密数据
   * @param path 公钥存放路径
   * @return byte[] 解密数据
   * @throws Exception
   */
  public static byte[] decryptByPublicKey(byte[] data, String path) throws Exception {
    byte[] plainText = RSA.icbcRsaPubDe(data, path);
    return Base64.icbcbase64decode(new String(plainText));
  }

  /**
   * 秘钥解密.
   *
   * @param cipherText
   * @param cipherKey
   * @return
   * @throws Exception
   */
  public static byte[] decrypt(byte[] cipherText, byte[] cipherKey) throws Exception {
    return TripleDesUtils.decrypt(cipherText, cipherKey);
  }
}
