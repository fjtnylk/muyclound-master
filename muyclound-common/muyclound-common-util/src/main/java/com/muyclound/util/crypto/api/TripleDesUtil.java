package com.muyclound.util.crypto.api;

import com.muyclound.util.crypto.utils.TripleDesCryptVarKey2;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/4/11.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TripleDesUtil {
  public static final String ENCODING = "utf-8";

  public static byte[] encrypt(byte[] plainText, byte[] cipherKey) throws UnsupportedEncodingException {
    byte[] cipherText = new byte[plainText.length];
    byte[] asciiCipherKey = TripleDesCryptVarKey2.Ascii2Text(cipherKey).getBytes("utf-8");
    TripleDesCryptVarKey2.TripleDesCFB0(plainText, plainText.length, cipherText, 0, asciiCipherKey);
    return cipherText;
  }

  public static byte[] decrypt(byte[] cipherText, byte[] cipherKey) throws UnsupportedEncodingException {
    byte[] out = new byte[cipherText.length];
    byte[] asciiCipherKey = TripleDesCryptVarKey2.Ascii2Text(cipherKey).getBytes("utf-8");
    TripleDesCryptVarKey2.TripleDesCFB0(cipherText, cipherText.length, out, 1, asciiCipherKey);
    return out;
  }

  public static byte[] createCipher(int size) throws NoSuchAlgorithmException {
    KeyGenerator kg = KeyGenerator.getInstance("3DES");
    kg.init(size);
    return kg.generateKey().getEncoded();
  }
}
