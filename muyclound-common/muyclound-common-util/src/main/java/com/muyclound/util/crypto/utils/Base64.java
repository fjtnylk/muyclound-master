package com.muyclound.util.crypto.utils;

/**
 * Created by yanglikai on 2018/4/11.
 */
public class Base64 {
  public static final boolean _$9 = true;
  public static final boolean _$8 = false;
  private static final int _$7 = 76;
  private static final byte _$6 = 61;
  private static final byte _$5 = 10;
  private static final byte[] _$4 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
  private static final byte[] _$3 = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
  private static final byte _$2 = -5;
  private static final byte _$1 = -1;

  public Base64() {
  }

  public static String encode(byte[] var0) {
    return _$1(var0, true);
  }

  public static byte[] decode(String var0) {
    byte[] var1 = var0.getBytes();
    return _$1(var1, 0, var1.length);
  }

  private static byte[] _$1(byte[] var0, int var1, int var2, byte[] var3, int var4) {
    int var5 = (var2 > 0 ? var0[var1] << 24 >>> 8 : 0) | (var2 > 1 ? var0[var1 + 1] << 24 >>> 16 : 0) | (var2 > 2 ? var0[var1 + 2] << 24 >>> 24 : 0);
    switch (var2) {
      case 1:
        var3[var4] = _$4[var5 >>> 18];
        var3[var4 + 1] = _$4[var5 >>> 12 & 63];
        var3[var4 + 2] = 61;
        var3[var4 + 3] = 61;
        return var3;
      case 2:
        var3[var4] = _$4[var5 >>> 18];
        var3[var4 + 1] = _$4[var5 >>> 12 & 63];
        var3[var4 + 2] = _$4[var5 >>> 6 & 63];
        var3[var4 + 3] = 61;
        return var3;
      case 3:
        var3[var4] = _$4[var5 >>> 18];
        var3[var4 + 1] = _$4[var5 >>> 12 & 63];
        var3[var4 + 2] = _$4[var5 >>> 6 & 63];
        var3[var4 + 3] = _$4[var5 & 63];
        return var3;
      default:
        return var3;
    }
  }

  private static String _$1(byte[] var0, boolean var1) {
    return _$1(var0, 0, var0.length, var1);
  }

  private static String _$2(byte[] var0, int var1, int var2) {
    return _$1(var0, var1, var2, true);
  }

  private static String _$1(byte[] var0, int var1, int var2, boolean var3) {
    int var4 = var2 * 4 / 3;
    byte[] var5 = new byte[var4 + (var2 % 3 > 0 ? 4 : 0) + (var3 ? var4 / 76 : 0)];
    int var6 = 0;
    int var7 = 0;
    int var8 = var2 - 2;

    for (int var9 = 0; var6 < var8; var7 += 4) {
      _$1(var0, var6 + var1, 3, var5, var7);
      var9 += 4;
      if (var3 && var9 == 76) {
        var5[var7 + 4] = 10;
        ++var7;
        var9 = 0;
      }

      var6 += 3;
    }

    if (var6 < var2) {
      _$1(var0, var6 + var1, var2 - var6, var5, var7);
      var7 += 4;
    }

    return new String(var5, 0, var7);
  }

  private static int _$1(byte[] var0, int var1, byte[] var2, int var3) {
    int var4;
    if (var0[var1 + 2] == 61) {
      var4 = (_$3[var0[var1]] & 255) << 18 | (_$3[var0[var1 + 1]] & 255) << 12;
      var2[var3] = (byte) (var4 >>> 16);
      return 1;
    } else if (var0[var1 + 3] == 61) {
      var4 = (_$3[var0[var1]] & 255) << 18 | (_$3[var0[var1 + 1]] & 255) << 12 | (_$3[var0[var1 + 2]] & 255) << 6;
      var2[var3] = (byte) (var4 >>> 16);
      var2[var3 + 1] = (byte) (var4 >>> 8);
      return 2;
    } else {
      try {
        var4 = (_$3[var0[var1]] & 255) << 18 | (_$3[var0[var1 + 1]] & 255) << 12 | (_$3[var0[var1 + 2]] & 255) << 6 | _$3[var0[var1 + 3]] & 255;
        var2[var3] = (byte) (var4 >> 16);
        var2[var3 + 1] = (byte) (var4 >> 8);
        var2[var3 + 2] = (byte) var4;
        return 3;
      } catch (Exception var5) {
        System.out.println("" + var0[var1] + ": " + _$3[var0[var1]]);
        System.out.println("" + var0[var1 + 1] + ": " + _$3[var0[var1 + 1]]);
        System.out.println("" + var0[var1 + 2] + ": " + _$3[var0[var1 + 2]]);
        System.out.println("" + var0[var1 + 3] + ": " + _$3[var0[var1 + 3]]);
        return -1;
      }
    }
  }

  private static byte[] _$1(byte[] var0, int var1, int var2) {
    int var3 = var2 * 3 / 4;
    byte[] var4 = new byte[var3];
    int var5 = 0;
    byte[] var6 = new byte[4];
    int var7 = 0;
    boolean var8 = false;
    boolean var9 = false;
    boolean var10 = false;

    for (int var12 = var1; var12 < var1 + var2; ++var12) {
      byte var13 = (byte) (var0[var12] & 127);
      byte var14 = _$3[var13];
      if (var14 < -5) {
        System.err.println("Bad Base64 input character at " + var12 + ": " + var0[var12] + "(decimal)");
        return null;
      }

      if (var14 >= -1) {
        var6[var7++] = var13;
        if (var7 > 3) {
          var5 += _$1(var6, 0, var4, var5);
          var7 = 0;
          if (var13 == 61) {
            break;
          }
        }
      }
    }

    byte[] var11 = new byte[var5];
    System.arraycopy(var4, 0, var11, 0, var5);
    return var11;
  }
}
