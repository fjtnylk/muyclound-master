package com.muyclound.crypto.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by yanglikai on 2018/4/11.
 */
public class RSA {
  public RSA() {
  }

  public static boolean rsaGenkey(int var0) throws Exception {
    return rsaGenkey(var0, "", "");
  }

  public static boolean rsaGenkey(int var0, String var1, String var2) throws Exception {
    if (var0 % 512 != 0) {
      throw new Exception("密钥长度不对，必须为512的整数倍！");
    } else {
      KeyPairGenerator var3 = null;
      var3 = KeyPairGenerator.getInstance("RSA");
      System.out.println("正在初始化密钥长度为" + var0 + "的密钥生成器......");
      var3.initialize(var0);
      System.out.println("正在生成密钥对......");
      KeyPair var4 = null;
      RSAPublicKey var5 = null;
      RSAPrivateKey var6 = null;
      long var7 = System.currentTimeMillis();

      while (true) {
        var4 = var3.generateKeyPair();
        var5 = (RSAPublicKey) var4.getPublic();
        var6 = (RSAPrivateKey) var4.getPrivate();
        if (var5.getModulus().bitLength() == var0) {
          System.out.println("成功生成密钥！");
          String var9 = "Skey_RSA_pub.key";
          FileOutputStream var10 = null;
          if (var1 != null && var1.trim().length() != 0) {
            var9 = var1;
          }

          var10 = new FileOutputStream(var9);
          var10.write(var5.getEncoded());
          System.out.println("将公钥写入" + var9 + "文件成功！");

          try {
            var10.close();
          } catch (IOException var15) {
            ;
          }

          String var11 = "Skey_RSA_priv.key";
          FileOutputStream var12 = null;
          if (var2 != null && var2.trim().length() != 0) {
            var11 = var2;
          }

          var12 = new FileOutputStream(var11);
          var12.write(var6.getEncoded());
          System.out.println("将私钥写入" + var11 + "文件成功!");

          try {
            var12.close();
          } catch (IOException var14) {
            ;
          }

          return true;
        }

        if (System.currentTimeMillis() - var7 > 60000L) {
          throw new Exception("在一分钟内没有获取到符合要求的密钥，请重新生成密钥！");
        }

        System.out.println("已经生成了密钥，但是不符合工行的安全要求，继续生成下一个密钥！");
      }
    }
  }

  public static byte[] rsaPubEn(byte[] var0) throws Exception {
    return rsaPubEn(var0, "");
  }

  public static byte[] rsaPubEn(byte[] var0, String var1) throws Exception {
    String var2 = "Skey_RSA_pub.key";
    RSAPublicKey var3 = null;
    FileInputStream var4 = null;
    if (var1 != null && var1.trim().length() != 0) {
      var2 = var1;
    }

    var4 = new FileInputStream(var2);
    byte[] var5 = new byte[var4.available()];
    var4.read(var5);
    KeyFactory var6 = KeyFactory.getInstance("RSA");
    X509EncodedKeySpec var7 = new X509EncodedKeySpec(var5);
    var3 = (RSAPublicKey) var6.generatePublic(var7);

    try {
      var4.close();
    } catch (IOException var14) {
      ;
    }

    BigInteger var8 = var3.getPublicExponent();
    BigInteger var9 = var3.getModulus();
    int var10 = var0.length;
    if (var10 > (var9.bitLength() + 7) / 8) {
      throw new Exception("一次不能加密源长度超过" + (var9.bitLength() + 7) / 8 + "的数据");
    } else {
      byte[] var11 = new byte[(var9.bitLength() + 7) / 8];
      System.arraycopy(var0, 0, var11, 0, var10);
      Arrays.fill(var11, var10, var11.length, (byte) 0);
      BigInteger var12 = new BigInteger(var11);
      System.out.println("使用公钥加密明文......");
      byte[] var13 = var12.modPow(var8, var9).toByteArray();
      System.out.println("加密明文成功！");
      if (var13.length > var11.length && var13[0] == 0) {
        System.arraycopy(var13, 1, var11, 0, var11.length);
        return var11;
      } else {
        return var13;
      }
    }
  }

  public static byte[] rsaPriEn(byte[] var0) throws Exception {
    return rsaPriEn(var0, "");
  }

  public static byte[] rsaPriEn(byte[] var0, String var1) throws Exception {
    String var2 = "Skey_RSA_priv.key";
    RSAPrivateKey var3 = null;
    FileInputStream var4 = null;
    if (var1 != null && var1.trim().length() != 0) {
      var2 = var1;
    }

    var4 = new FileInputStream(var2);
    byte[] var5 = new byte[var4.available()];
    var4.read(var5);
    KeyFactory var6 = KeyFactory.getInstance("RSA");
    PKCS8EncodedKeySpec var7 = new PKCS8EncodedKeySpec(var5);
    var3 = (RSAPrivateKey) var6.generatePrivate(var7);

    try {
      var4.close();
    } catch (IOException var14) {
      ;
    }

    BigInteger var8 = var3.getPrivateExponent();
    BigInteger var9 = var3.getModulus();
    int var10 = var0.length;
    if (var10 > (var9.bitLength() + 7) / 8) {
      throw new Exception("一次不能加密源长度超过" + (var9.bitLength() + 7) / 8 + "的数据");
    } else {
      byte[] var11 = new byte[(var9.bitLength() + 7) / 8];
      System.arraycopy(var0, 0, var11, 0, var10);
      Arrays.fill(var11, var10, var11.length, (byte) 0);
      BigInteger var12 = new BigInteger(var11);
      System.out.println("使用私钥加密明文......");
      byte[] var13 = var12.modPow(var8, var9).toByteArray();
      System.out.println("加密明文成功！");
      if (var13.length > var11.length && var13[0] == 0) {
        System.arraycopy(var13, 1, var11, 0, var11.length);
        return var11;
      } else {
        return var13;
      }
    }
  }

  public static byte[] rsaPriDe(byte[] var0) throws Exception {
    return rsaPriDe(var0, "");
  }

  public static byte[] rsaPriDe(byte[] var0, String var1) throws Exception {
    Object var2 = null;
    BigInteger var3 = null;
    byte var4 = var0[0];
    if (var4 < 0) {
      byte[] var18 = new byte[var0.length + 1];
      var18[0] = 0;
      System.arraycopy(var0, 0, var18, 1, var0.length);
      var3 = new BigInteger(var18);
    } else {
      var3 = new BigInteger(var0);
    }

    String var5 = "Skey_RSA_priv.key";
    RSAPrivateKey var6 = null;
    FileInputStream var7 = null;
    if (var1 != null && var1.trim().length() != 0) {
      var5 = var1;
    }

    var7 = new FileInputStream(var5);
    byte[] var8 = new byte[var7.available()];
    var7.read(var8);
    KeyFactory var9 = KeyFactory.getInstance("RSA");
    PKCS8EncodedKeySpec var10 = new PKCS8EncodedKeySpec(var8);
    var6 = (RSAPrivateKey) var9.generatePrivate(var10);

    try {
      var7.close();
    } catch (IOException var17) {
      ;
    }

    BigInteger var11 = var6.getPrivateExponent();
    BigInteger var12 = var6.getModulus();
    System.out.println("使用私钥解密密文......");
    BigInteger var13 = var3.modPow(var11, var12);
    byte[] var14 = var13.toByteArray();
    int var15 = var14.length;

    for (int var16 = 0; var16 < var14.length; ++var16) {
      if (var14[var16] == 0) {
        var15 = var16;
        break;
      }
    }

    byte[] var19 = new byte[var15];
    System.arraycopy(var14, 0, var19, 0, var15);
    System.out.println("解密成功！");
    return var19;
  }

  public static byte[] rsaPubDe(byte[] var0) throws Exception {
    return rsaPubDe(var0, "");
  }

  public static byte[] rsaPubDe(byte[] var0, String var1) throws Exception {
    Object var2 = null;
    BigInteger var3 = null;
    byte var4 = var0[0];
    if (var4 < 0) {
      byte[] var18 = new byte[var0.length + 1];
      var18[0] = 0;
      System.arraycopy(var0, 0, var18, 1, var0.length);
      var3 = new BigInteger(var18);
    } else {
      var3 = new BigInteger(var0);
    }

    String var5 = "Skey_RSA_pub.key";
    RSAPublicKey var6 = null;
    FileInputStream var7 = null;
    if (var1 != null && var1.trim().length() != 0) {
      var5 = var1;
    }

    var7 = new FileInputStream(var5);
    byte[] var8 = new byte[var7.available()];
    var7.read(var8);
    KeyFactory var9 = KeyFactory.getInstance("RSA");
    X509EncodedKeySpec var10 = new X509EncodedKeySpec(var8);
    var6 = (RSAPublicKey) var9.generatePublic(var10);

    try {
      var7.close();
    } catch (IOException var17) {
      ;
    }

    BigInteger var11 = var6.getPublicExponent();
    BigInteger var12 = var6.getModulus();
    System.out.println("使用公钥解密密文......");
    BigInteger var13 = var3.modPow(var11, var12);
    byte[] var14 = var13.toByteArray();
    int var15 = var14.length;

    for (int var16 = 0; var16 < var14.length; ++var16) {
      if (var14[var16] == 0) {
        var15 = var16;
        break;
      }
    }

    byte[] var19 = new byte[var15];
    System.arraycopy(var14, 0, var19, 0, var15);
    System.out.println("解密成功！");
    return var19;
  }

  public static boolean convertX509PublicKeyToOpenSSL(String var0, String var1) throws Exception {
    System.out.println("将X509格式的公钥转换为OpenSSL格式的公钥开始！");
    RSAPublicKey var2 = null;
    FileInputStream var3 = null;
    if (var0 != null && var0.trim().length() != 0) {
      if (var1 != null && var1.trim().length() != 0) {
        var3 = new FileInputStream(var0);
        byte[] var4 = new byte[var3.available()];
        var3.read(var4);

        try {
          var3.close();
        } catch (IOException var12) {
          ;
        }

        System.out.println("正在从" + var0 + "中读取X509格式的公钥。。。");
        KeyFactory var5 = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec var6 = new X509EncodedKeySpec(var4);
        var2 = (RSAPublicKey) var5.generatePublic(var6);
        BigInteger var7 = var2.getPublicExponent();
        BigInteger var8 = var2.getModulus();
        System.out.println("从" + var0 + "文件中恢复公钥成功，正在进行转换。。。");
        FileOutputStream var9 = null;
        var9 = new FileOutputStream(var1);
        var9.write("N=".getBytes());
        var9.write(var8.toString(16).getBytes());
        var9.write("\r\nE=".getBytes());
        var9.write(var7.toString(16).getBytes());

        try {
          var9.close();
        } catch (Exception var11) {
          ;
        }

        System.out.println("转换成OpenSSL格式的公钥成功，公钥存放在" + var1 + "文件中!");
        return true;
      } else {
        throw new Exception("输入参数" + var1 + "不能为空！");
      }
    } else {
      throw new Exception("输入参数" + var0 + "不能为空！");
    }
  }

  public static boolean convertOpenSSLPublicKeyToX509(String var0, String var1) throws Exception {
    System.out.println("将OpenSSL格式的公钥转换为X509格式的公钥开始！");
    Properties var2 = new Properties();
    FileOutputStream var3 = null;
    FileInputStream var4 = null;
    if (var1 != null && var1.trim().length() != 0) {
      if (var0 != null && var0.trim().length() != 0) {
        System.out.println("正在从" + var0 + "中读取OpenSSL格式的公钥。。。");
        var4 = new FileInputStream(var0);
        var2.load(var4);
        String var5 = var2.getProperty("N");
        String var6 = var2.getProperty("E");
        System.out.println("从" + var0 + "文件中恢复公钥成功，正在进行转换。。。");
        RSAPublicKeySpec var7 = new RSAPublicKeySpec(new BigInteger(var5, 16), new BigInteger(var6, 16));
        KeyFactory var8 = KeyFactory.getInstance("RSA");
        PublicKey var9 = var8.generatePublic(var7);
        var3 = new FileOutputStream(var1);
        var3.write(var9.getEncoded());

        try {
          var3.close();
          var4.close();
        } catch (Exception var11) {
          ;
        }

        System.out.println("转换成X509格式的公钥成功，公钥存放在" + var1 + "文件中!");
        return true;
      } else {
        throw new Exception("输入参数" + var0 + "不能为空！");
      }
    } else {
      throw new Exception("输入参数" + var1 + "不能为空！");
    }
  }

  private static void _$1() {
    System.out.println("参数错误。");
    System.out.println("用法1：-create Keylen PubKeyFileName PriKeyFileName");
    System.out.println("用于产生x509的私钥与openssl的公钥");
    System.out.println("用法2：-toOpenSSL x509Filename opensslFilename");
    System.out.println("用于转换x509格式的公钥为openssl格式");
    System.out.println("用法3：-toX509 opensslFilenameX509Filename ");
    System.out.println("用于转换openssl格式的公钥为x509格式");
  }

  public static void main(String[] var0) throws Exception {
    if (var0.length == 4 && var0[0].equals("-create")) {
      boolean var1 = true;

      int var4;
      try {
        var4 = Integer.parseInt(var0[1]);
      } catch (Exception var3) {
        _$1();
        return;
      }

      rsaGenkey(var4, var0[2], var0[3]);
      System.out.println("产生密钥对成功");
    } else if (var0.length == 3) {
      if (var0[0].equals("-toOpenSSL")) {
        convertX509PublicKeyToOpenSSL(var0[1], var0[2]);
      } else if (var0[0].equals("-toX509")) {
        convertOpenSSLPublicKeyToX509(var0[1], var0[2]);
      } else {
        _$1();
      }
    } else {
      _$1();
    }

  }
}
