package com.muyclound.util.crypto.utils;

/**
 * Created by yanglikai on 2018/4/11.
 */
public class SHA1 {
  private final int[] _$3 = new int[]{1732584193, -271733879, -1732584194, 271733878, -1009589776};
  private int[] _$2 = new int[5];
  private int[] _$1 = new int[80];

  public SHA1() {
  }

  private int _$3(byte[] var1) {
    System.arraycopy(this._$3, 0, this._$2, 0, this._$3.length);
    byte[] var2 = this._$2(var1);
    int var3 = var2.length / 64;

    for (int var4 = 0; var4 < var3; ++var4) {
      for (int var5 = 0; var5 < 16; ++var5) {
        this._$1[var5] = this._$1(var2, var4 * 64 + var5 * 4);
      }

      this._$1();
    }

    return 20;
  }

  private byte[] _$2(byte[] var1) {
    boolean var2 = false;
    boolean var3 = false;
    int var4 = var1.length;
    int var5 = var4 % 64;
    int var18;
    int var19;
    if (var5 < 56) {
      var18 = 55 - var5;
      var19 = var4 - var5 + 64;
    } else if (var5 == 56) {
      var18 = 63;
      var19 = var4 + 8 + 64;
    } else {
      var18 = 63 - var5 + 56;
      var19 = var4 + 64 - var5 + 64;
    }

    byte[] var6 = new byte[var19];
    System.arraycopy(var1, 0, var6, 0, var4);
    int var7 = var4 + 1;
    var6[var4] = -128;

    for (int var8 = 0; var8 < var18; ++var8) {
      var6[var7++] = 0;
    }

    long var20 = (long) var4 * 8L;
    byte var10 = (byte) ((int) (var20 & 255L));
    byte var11 = (byte) ((int) (var20 >> 8 & 255L));
    byte var12 = (byte) ((int) (var20 >> 16 & 255L));
    byte var13 = (byte) ((int) (var20 >> 24 & 255L));
    byte var14 = (byte) ((int) (var20 >> 32 & 255L));
    byte var15 = (byte) ((int) (var20 >> 40 & 255L));
    byte var16 = (byte) ((int) (var20 >> 48 & 255L));
    byte var17 = (byte) ((int) (var20 >> 56));
    var6[var7++] = var17;
    var6[var7++] = var16;
    var6[var7++] = var15;
    var6[var7++] = var14;
    var6[var7++] = var13;
    var6[var7++] = var12;
    var6[var7++] = var11;
    var6[var7++] = var10;
    return var6;
  }

  private int _$3(int var1, int var2, int var3) {
    return var1 & var2 | ~var1 & var3;
  }

  private int _$2(int var1, int var2, int var3) {
    return var1 ^ var2 ^ var3;
  }

  private int _$1(int var1, int var2, int var3) {
    return var1 & var2 | var1 & var3 | var2 & var3;
  }

  private int _$1(int var1, int var2) {
    return var1 << var2 | var1 >>> 32 - var2;
  }

  private void _$1() {
    for (int var1 = 16; var1 <= 79; ++var1) {
      this._$1[var1] = this._$1(this._$1[var1 - 3] ^ this._$1[var1 - 8] ^ this._$1[var1 - 14] ^ this._$1[var1 - 16], 1);
    }

    int[] var4 = new int[5];

    int var2;
    for (var2 = 0; var2 < var4.length; ++var2) {
      var4[var2] = this._$2[var2];
    }

    int var3;
    for (var2 = 0; var2 <= 19; ++var2) {
      var3 = this._$1(var4[0], 5) + this._$3(var4[1], var4[2], var4[3]) + var4[4] + this._$1[var2] + 1518500249;
      var4[4] = var4[3];
      var4[3] = var4[2];
      var4[2] = this._$1(var4[1], 30);
      var4[1] = var4[0];
      var4[0] = var3;
    }

    for (var2 = 20; var2 <= 39; ++var2) {
      var3 = this._$1(var4[0], 5) + this._$2(var4[1], var4[2], var4[3]) + var4[4] + this._$1[var2] + 1859775393;
      var4[4] = var4[3];
      var4[3] = var4[2];
      var4[2] = this._$1(var4[1], 30);
      var4[1] = var4[0];
      var4[0] = var3;
    }

    for (var2 = 40; var2 <= 59; ++var2) {
      var3 = this._$1(var4[0], 5) + this._$1(var4[1], var4[2], var4[3]) + var4[4] + this._$1[var2] + -1894007588;
      var4[4] = var4[3];
      var4[3] = var4[2];
      var4[2] = this._$1(var4[1], 30);
      var4[1] = var4[0];
      var4[0] = var3;
    }

    for (var2 = 60; var2 <= 79; ++var2) {
      var3 = this._$1(var4[0], 5) + this._$2(var4[1], var4[2], var4[3]) + var4[4] + this._$1[var2] + -899497514;
      var4[4] = var4[3];
      var4[3] = var4[2];
      var4[2] = this._$1(var4[1], 30);
      var4[1] = var4[0];
      var4[0] = var3;
    }

    for (var2 = 0; var2 < var4.length; ++var2) {
      this._$2[var2] += var4[var2];
    }

    for (var2 = 0; var2 < this._$1.length; ++var2) {
      this._$1[var2] = 0;
    }

  }

  private int _$1(byte[] var1, int var2) {
    return (var1[var2] & 255) << 24 | (var1[var2 + 1] & 255) << 16 | (var1[var2 + 2] & 255) << 8 | var1[var2 + 3] & 255;
  }

  private void _$1(int var1, byte[] var2, int var3) {
    var2[var3] = (byte) (var1 >>> 24);
    var2[var3 + 1] = (byte) (var1 >>> 16);
    var2[var3 + 2] = (byte) (var1 >>> 8);
    var2[var3 + 3] = (byte) var1;
  }

  private static String _$1(byte var0) {
    char[] var1 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    char[] var2 = new char[]{var1[var0 >>> 4 & 15], var1[var0 & 15]};
    String var3 = new String(var2);
    return var3;
  }

  private static String _$1(byte[] var0) {
    String var1 = "";

    for (int var2 = 0; var2 < var0.length; ++var2) {
      var1 = var1 + _$1(var0[var2]);
    }

    return var1;
  }

  public byte[] getDigestOfBytes(byte[] var1) {
    this._$3(var1);
    byte[] var2 = new byte[20];

    for (int var3 = 0; var3 < this._$2.length; ++var3) {
      this._$1(this._$2[var3], var2, var3 * 4);
    }

    return var2;
  }

  public String getDigestOfString(byte[] var1) {
    return _$1(this.getDigestOfBytes(var1));
  }
}
