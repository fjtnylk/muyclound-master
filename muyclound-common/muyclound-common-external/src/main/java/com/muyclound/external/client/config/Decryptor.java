package com.muyclound.external.client.config;

/**
 * 解密器
 * Created by yanglikai on 2018/3/19.
 */
public interface Decryptor {

  String decrypt(byte[] cipherText);
}
