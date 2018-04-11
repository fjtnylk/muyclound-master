package com.muyclound.crypto.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 * Created by yanglikai on 2018/4/11.
 */
public class TripleDesCryptFileInputKey implements Serializable {
  private char[] _$7 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
  private byte[] _$6;
  private byte[] _$5;
  private static final int[] _$4 = new int[]{58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
  private static final int[] _$3 = new int[]{32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
  private static final int[][] _$2 = new int[][]{{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}, {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}, {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}, {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}, {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}, {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}, {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}, {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
  private static final int[] _$1 = new int[]{16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};

  public TripleDesCryptFileInputKey() {
    this._$6 = (new String(this._$7)).getBytes();
    this._$5 = null;
  }

  public TripleDesCryptFileInputKey(String var1) {
    this._$6 = (new String(this._$7)).getBytes();
    this._$5 = null;
    int[] var2 = new int[1];
    int var3 = _$1(var1, this._$6, var2);
    if (var3 != 0) {
      System.out.println("TripleDesCryptFileInputKey构造函数中，ExtractKey(keyFile,KEY方法获取密钥错误，错误码为：" + var3);
    }

    int var4 = var2[0];
    this._$5 = new byte[var4];
    System.arraycopy(this._$6, 0, this._$5, 0, var4);
  }

  private static void _$3(byte[] var0) {
    byte[] var2 = new byte[8];

    int var1;
    for (var1 = 0; var1 < 8; ++var1) {
      var2[var1] = var0[var1];
      var0[var1] = 0;
    }

    for (var1 = 0; var1 < 64; ++var1) {
      short var3;
      if ((var2[(_$4[var1] - 1) / 8] & 255 & 128 >>> (_$4[var1] - 1) % 8 & 255) != 0) {
        var3 = 128;
      } else {
        var3 = 0;
      }

      var0[var1 / 8] = (byte) ((var0[var1 / 8] & 255 | var3 >>> var1 % 8 & 255) & 255);
    }

  }

  private static void _$1(byte[] var0, byte[] var1, byte[] var2) {
    byte[] var4 = new byte[6];
    byte[] var5 = new byte[4];
    byte[] var6 = new byte[4];
    int var7 = 0;

    int var3;
    for (var3 = 0; var3 < 6; ++var3) {
      var4[var3] = 0;
    }

    for (var3 = 0; var3 < 4; ++var3) {
      var5[var3] = 0;
      var6[var3] = 0;
    }

    for (var3 = 0; var3 < 48; ++var3) {
      if ((byte) (var1[(_$3[var3] - 1) / 8] & 255 & 128 >>> (_$3[var3] - 1) % 8 & 255 & 255) != 0) {
        var7 = 128;
      } else {
        var7 = 0;
      }

      var4[var3 / 8] = (byte) ((var4[var3 / 8] | var7 >>> var3 % 8) & 255);
    }

    for (var3 = 0; var3 < 6; ++var3) {
      var4[var3] = (byte) ((var4[var3] ^ var2[var3]) & 255);
    }

    for (var3 = 0; var3 < 48; ++var3) {
      if (var3 % 6 == 0) {
        var7 = 0;
      }

      if ((byte) (var4[var3 / 8] & 255 & 128 >>> var3 % 8 & 255 & 255) != 0) {
        var7 |= 1;
      } else {
        var7 |= 0;
      }

      if ((var3 + 1) % 6 == 0) {
        var5[var3 / 12] = (byte) ((var5[var3 / 12] & 255) << 4 & 255);
        var5[var3 / 12] = (byte) (var5[var3 / 12] & 255 | _$2[var3 / 6][(var7 & 32) + ((var7 & 1) << 4) + ((var7 & 30) >>> 1)]);
      }

      var7 <<= 1;
    }

    for (var3 = 0; var3 < 32; ++var3) {
      short var9;
      if ((byte) (var5[(_$1[var3] - 1) / 8] & 255 & 128 >>> (_$1[var3] - 1) % 8 & 255) != 0) {
        var9 = 128;
      } else {
        var9 = 0;
      }

      var6[var3 / 8] = (byte) ((var6[var3 / 8] | var9 >>> var3 % 8) & 255);
    }

    for (var3 = 0; var3 < 4; ++var3) {
      byte var8 = var1[var3];
      var1[var3] = (byte) ((var6[var3] ^ var0[var3]) & 255);
      var0[var3] = var8;
    }

  }

  private static void _$2(byte[] var0) {
    byte[] var2 = new byte[8];
    int[] var4 = new int[]{40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};

    int var1;
    for (var1 = 0; var1 < 8; ++var1) {
      var2[var1] = var0[var1];
      var0[var1] = 0;
    }

    for (var1 = 0; var1 < 64; ++var1) {
      short var3;
      if ((byte) (var2[(var4[var1] - 1) / 8] & 255 & 128 >>> (var4[var1] - 1) % 8 & 255 & 255) != 0) {
        var3 = 128;
      } else {
        var3 = 0;
      }

      var0[var1 / 8] = (byte) (var0[var1 / 8] & 255 & 255 | var3 >>> var1 % 8 & 255);
    }

  }

  private static void _$5(byte[] var0, byte[] var1) {
    byte[] var3 = new byte[8];
    byte[] var4 = new byte[7];
    byte[] var6 = new byte[]{57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};

    int var2;
    for (var2 = 0; var2 < 7; ++var2) {
      var0[var2] = 0;
    }

    for (var2 = 0; var2 < 8; ++var2) {
      var3[var2] = var1[var2];
    }

    int var5 = 128;

    for (var2 = 0; var2 < 7; ++var2) {
      var3[var2] = (byte) (var3[var2] & 254);
      var4[var2] = (byte) ((var3[var2] << var2 | (var3[var2 + 1] & var5) >>> 7 - var2) & 255);
      var5 = var5 >>> 1 | 128;
    }

    for (var2 = 0; var2 < 56; ++var2) {
      var6[var2] = (byte) (var6[var2] - var6[var2] / 8 - 1 & 255);
      short var7;
      if ((var4[var6[var2] / 8] & 128 >>> var6[var2] % 8 & 255) != 0) {
        var7 = 128;
      } else {
        var7 = 0;
      }

      var0[var2 / 8] = (byte) ((var0[var2 / 8] | var7 >>> var2 % 8) & 255);
    }

  }

  private static void _$1(byte[] var0) {
    int var2 = var0[0] & 128;

    for (int var1 = 0; var1 < 6; ++var1) {
      var0[var1] = (byte) ((var0[var1] << 1 | (var0[var1 + 1] & 128) >>> 7) & 255);
    }

    var0[6] = (byte) (var0[6] << 1 & 255);
    if ((var0[3] & 16) != 0) {
      var0[6] = (byte) ((var0[6] | 1) & 255);
    }

    var0[3] = (byte) ((var0[3] & 239 | var2 >>> 3) & 255);
  }

  private static void _$4(byte[] var0, byte[] var1) {
    byte[] var4 = new byte[]{14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};

    int var2;
    for (var2 = 0; var2 < 6; ++var2) {
      var1[var2] = 0;
    }

    for (var2 = 0; var2 < 48; ++var2) {
      short var3;
      if ((var0[(var4[var2] - 1) / 8] & 128 >>> (var4[var2] - 1) % 8 & 255) != 0) {
        var3 = 128;
      } else {
        var3 = 0;
      }

      var1[var2 / 8] = (byte) ((var1[var2 / 8] | var3 >>> var2 % 8) & 255);
    }

  }

  private static void _$1(byte[][] var0, byte[] var1) {
    byte[] var3 = new byte[7];
    byte[] var4 = new byte[]{1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    _$5(var3, var1);

    for (int var2 = 0; var2 < 16; ++var2) {
      _$1(var3);
      if ((var4[var2] & 255) == 2) {
        _$1(var3);
      }

      _$4(var3, var0[var2]);
    }

  }

  private static void _$3(byte[] var0, byte[] var1) {
    byte[] var3 = new byte[4];
    byte[] var4 = new byte[4];
    byte[][] var5 = new byte[16][6];
    _$1(var5, var1);
    _$3(var0);
    var3[0] = var0[0];
    var4[0] = var0[4];
    var3[1] = var0[1];
    var4[1] = var0[5];
    var3[2] = var0[2];
    var4[2] = var0[6];
    var3[3] = var0[3];
    var4[3] = var0[7];

    for (int var2 = 0; var2 < 16; ++var2) {
      _$1(var3, var4, var5[var2]);
    }

    var0[0] = var4[0];
    var0[4] = var3[0];
    var0[1] = var4[1];
    var0[5] = var3[1];
    var0[2] = var4[2];
    var0[6] = var3[2];
    var0[3] = var4[3];
    var0[7] = var3[3];
    _$2(var0);
  }

  private static void _$2(byte[] var0, byte[] var1) {
    byte[] var3 = new byte[4];
    byte[] var4 = new byte[4];
    byte[][] var5 = new byte[16][6];
    _$1(var5, var1);
    _$3(var0);
    var3[0] = var0[0];
    var4[0] = var0[4];
    var3[1] = var0[1];
    var4[1] = var0[5];
    var3[2] = var0[2];
    var4[2] = var0[6];
    var3[3] = var0[3];
    var4[3] = var0[7];

    for (int var2 = 0; var2 < 16; ++var2) {
      _$1(var3, var4, var5[15 - var2]);
    }

    var0[0] = var4[0];
    var0[4] = var3[0];
    var0[1] = var4[1];
    var0[5] = var3[1];
    var0[2] = var4[2];
    var0[6] = var3[2];
    var0[3] = var4[3];
    var0[7] = var3[3];
    _$2(var0);
  }

  private static int _$2(byte[] var0, int var1, byte[] var2, byte[] var3, byte[] var4) {
    if (var1 == 0) {
      _$3(var0, var2);
      _$3(var0, var3);
      _$3(var0, var4);
    } else {
      _$2(var0, var4);
      _$2(var0, var3);
      _$2(var0, var2);
    }

    return 0;
  }

  private static int _$1(byte[] var0, int var1, byte[] var2, byte[] var3, byte[] var4) {
    if (var1 == 0) {
      _$3(var0, var2);
      _$2(var0, var3);
      _$3(var0, var4);
    } else {
      _$2(var0, var4);
      _$3(var0, var3);
      _$2(var0, var2);
    }

    return 0;
  }

  public static int TripleDes0(byte[] var0, byte[] var1, int var2, String var3) {
    char[] var4 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var5 = (new String(var4)).getBytes();
    int[] var6 = new int[1];
    int var7 = _$1(var3, var5, var6);
    if (var7 != 0) {
      return var7;
    } else {
      int var8 = var6[0];
      byte[] var9 = new byte[var8];
      System.arraycopy(var5, 0, var9, 0, var8);
      byte[] var11 = new byte[24];
      byte[] var12 = new byte[8];
      byte[] var13 = new byte[8];
      byte[] var14 = new byte[8];
      if (var0 != null && var1 != null) {
        if (var0.length == 8 && var1.length == 8) {
          if (var9 != null && (var9.length == 32 || var9.length == 48)) {
            if (var2 != 0 && var2 != 1) {
              return -3;
            } else {
              int var15 = Text2Ascii(var9, var11);
              if (var15 < 0) {
                return -4;
              } else {
                if (var9.length == 32) {
                  System.arraycopy(var11, 0, var12, 0, 8);
                  System.arraycopy(var11, 0, var14, 0, 8);
                  System.arraycopy(var11, 8, var13, 0, 8);
                } else {
                  System.arraycopy(var11, 0, var12, 0, 8);
                  System.arraycopy(var11, 8, var13, 0, 8);
                  System.arraycopy(var11, 16, var14, 0, 8);
                }

                System.arraycopy(var0, 0, var1, 0, 8);
                return _$2(var1, var2, var12, var13, var14);
              }
            }
          } else {
            return -2;
          }
        } else {
          return -26;
        }
      } else {
        return -1;
      }
    }
  }

  public static int TripleDes1(byte[] var0, byte[] var1, int var2, String var3) {
    char[] var4 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var5 = (new String(var4)).getBytes();
    int[] var6 = new int[1];
    int var7 = _$1(var3, var5, var6);
    if (var7 != 0) {
      return var7;
    } else {
      int var8 = var6[0];
      byte[] var9 = new byte[var8];
      System.arraycopy(var5, 0, var9, 0, var8);
      byte[] var11 = new byte[24];
      byte[] var12 = new byte[8];
      byte[] var13 = new byte[8];
      byte[] var14 = new byte[8];
      if (var0 != null && var1 != null) {
        if (var0.length == 8 && var1.length == 8) {
          if (var9 != null && (var9.length == 32 || var9.length == 48)) {
            if (var2 != 0 && var2 != 1) {
              return -3;
            } else {
              int var15 = Text2Ascii(var9, var11);
              if (var15 < 0) {
                return -4;
              } else {
                if (var9.length == 32) {
                  System.arraycopy(var11, 0, var12, 0, 8);
                  System.arraycopy(var11, 0, var14, 0, 8);
                  System.arraycopy(var11, 8, var13, 0, 8);
                } else {
                  System.arraycopy(var11, 0, var12, 0, 8);
                  System.arraycopy(var11, 8, var13, 0, 8);
                  System.arraycopy(var11, 16, var14, 0, 8);
                }

                System.arraycopy(var0, 0, var1, 0, 8);
                return _$1(var1, var2, var12, var13, var14);
              }
            }
          } else {
            return -2;
          }
        } else {
          return -26;
        }
      } else {
        return -1;
      }
    }
  }

  public static int TripleDes(byte[] var0, int var1, byte[] var2, int var3, int var4, int var5, String var6) {
    return var0 != null && var2 != null && var0.length >= var1 && var1 >= 1 ? (var3 != 0 && var3 != 1 ? -3 : (var5 != 0 && var5 != 1 ? -25 : (var4 != 1 && var4 != 2 && var4 != 3 && var4 != 4 ? -11 : (var4 == 1 ? (var3 == 1 && var1 % 8 != 0 ? -6 : (var5 == 0 ? TripleDesECB0(var0, var1, var2, var3, var6) : TripleDesECB1(var0, var1, var2, var3, var6))) : (var4 == 2 ? (var3 == 1 && var1 % 8 != 0 ? -6 : (var5 == 0 ? TripleDesCBC0(var0, var1, var2, var3, var6) : TripleDesCBC1(var0, var1, var2, var3, var6))) : (var4 == 3 ? (var5 == 0 ? TripleDesCFB0(var0, var1, var2, var3, var6) : TripleDesCFB1(var0, var1, var2, var3, var6)) : (var5 == 0 ? TripleDesOFB0(var0, var1, var2, var3, var6) : TripleDesOFB1(var0, var1, var2, var3, var6)))))))) : -1;
  }

  public static int TripleDesFile(String var0, String var1, int var2, int var3, int var4, String var5) {
    byte[] var6 = new byte[24];
    byte[] var11 = new byte[4104];
    byte[] var12 = new byte[4104];
    if (var2 != 0 && var2 != 1) {
      return -3;
    } else if (var3 != 1 && var3 != 2 && var3 != 3 && var3 != 4) {
      return -11;
    } else if (var4 != 0 && var4 != 1) {
      return -25;
    } else if (var0 == null) {
      return -12;
    } else if (var1 == null) {
      return -13;
    } else {
      BufferedInputStream var13 = null;
      BufferedOutputStream var14 = null;
      File var15 = new File(var0);
      if (!var15.canRead()) {
        return -14;
      } else {
        File var16 = new File(var1);
        if (!var16.canWrite()) {
          return -15;
        } else {
          try {
            var13 = new BufferedInputStream(new FileInputStream(var15));
          } catch (FileNotFoundException var27) {
            var27.printStackTrace();
            return -16;
          }

          try {
            var14 = new BufferedOutputStream(new FileOutputStream(var1));
          } catch (FileNotFoundException var26) {
            var26.printStackTrace();

            try {
              var13.close();
            } catch (IOException var21) {
              ;
            }

            return -17;
          }

          short var8;
          if (var2 == 0) {
            var8 = 4096;
          } else if (var3 != 1 && var3 != 2) {
            var8 = 4096;
          } else {
            var8 = 4104;
          }

          int var7;
          do {
            int var10 = 0;

            do {
              try {
                var7 = var13.read(var11, var10, var8 - var10);
              } catch (IOException var24) {
                try {
                  var13.close();
                  var14.close();
                } catch (IOException var20) {
                  ;
                }

                return -18;
              }

              if (var7 == -1) {
                break;
              }

              var10 += var7;
            } while (var10 < var8);

            int var9 = TripleDes(var11, var10, var12, var2, var3, var4, var5);
            if (var9 <= 0) {
              try {
                var13.close();
                var14.close();
              } catch (IOException var22) {
                ;
              }

              return var9;
            }

            try {
              var14.write(var12, 0, var9);
            } catch (IOException var25) {
              try {
                var13.close();
                var14.close();
              } catch (IOException var19) {
                ;
              }

              return -19;
            }
          } while (var7 != -1);

          try {
            var13.close();
            var14.close();
          } catch (IOException var23) {
            ;
          }

          return 0;
        }
      }
    }
  }

  public static int TripleDesECB0(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var8 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var9 = (new String(var8)).getBytes();
    int[] var10 = new int[1];
    int var11 = _$1(var4, var9, var10);
    if (var11 != 0) {
      return var11;
    } else {
      int var12 = var10[0];
      byte[] var13 = new byte[var12];
      System.arraycopy(var9, 0, var13, 0, var12);
      byte[] var14 = new byte[8];
      byte[] var15 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
      byte[] var18 = new byte[24];
      byte[] var19 = new byte[8];
      byte[] var20 = new byte[8];
      byte[] var21 = new byte[8];
      if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
        if (var13 == null || var13.length != 32 && var13.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var22 = Text2Ascii(var13, var18);
          if (var22 < 0) {
            return -4;
          } else {
            if (var13.length == 32) {
              System.arraycopy(var18, 0, var19, 0, 8);
              System.arraycopy(var18, 0, var21, 0, 8);
              System.arraycopy(var18, 8, var20, 0, 8);
            } else {
              System.arraycopy(var18, 0, var19, 0, 8);
              System.arraycopy(var18, 8, var20, 0, 8);
              System.arraycopy(var18, 16, var21, 0, 8);
            }

            int var5 = var1 % 8;
            int var6 = var1 / 8;
            if (var2.length < (var6 + 1) * 8 & var3 == 0) {
              return -5;
            } else {
              if (var3 == 1) {
                if (var5 != 0) {
                  return -6;
                }

                if (var2.length < 8 * (var6 - 1)) {
                  return -7;
                }
              }

              int var7;
              int var23;
              if (var3 == 0) {
                for (var7 = 0; var7 < var6; ++var7) {
                  System.arraycopy(var0, 8 * var7, var14, 0, 8);
                  _$2(var14, 0, var19, var20, var21);
                  System.arraycopy(var14, 0, var2, 8 * var7, 8);
                }

                if (var5 == 0) {
                  for (var23 = 0; var23 < 8; ++var23) {
                    var14[var23] = 8;
                  }
                } else {
                  System.arraycopy(var0, 8 * var6, var14, 0, var5);

                  for (var23 = 0; var23 < 8 - var5; ++var23) {
                    var14[var5 + var23] = var15[8 - var5];
                  }
                }

                _$2(var14, 0, var19, var20, var21);
                System.arraycopy(var14, 0, var2, 8 * var6, 8);
                return (var6 + 1) * 8;
              } else {
                for (var7 = 0; var7 < var6 - 1; ++var7) {
                  System.arraycopy(var0, 8 * var7, var14, 0, 8);
                  _$2(var14, 1, var19, var20, var21);
                  System.arraycopy(var14, 0, var2, 8 * var7, 8);
                }

                System.arraycopy(var0, 8 * (var6 - 1), var14, 0, 8);
                _$2(var14, 1, var19, var20, var21);
                byte var16 = var14[7];
                if (var6 == 1 && var16 == 8) {
                  return -8;
                } else if (var16 >= 1 && var16 <= 8) {
                  if (var16 == 8) {
                    return (var6 - 1) * 8;
                  } else {
                    var23 = var16 - 0;
                    int var24 = 8 - var23;
                    if (var2.length < 8 * (var6 - 1) + var24) {
                      return -7;
                    } else {
                      System.arraycopy(var14, 0, var2, 8 * (var6 - 1), var24);
                      return (var6 - 1) * 8 + (8 - var16);
                    }
                  }
                } else {
                  return -8;
                }
              }
            }
          }
        }
      } else {
        return -1;
      }
    }
  }

  public static int TripleDesECB1(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
    char[] var11 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var12 = (new String(var11)).getBytes();
    int[] var13 = new int[1];
    int var14 = _$1(var4, var12, var13);
    if (var14 != 0) {
      return var14;
    } else {
      int var15 = var13[0];
      byte[] var16 = new byte[var15];
      System.arraycopy(var12, 0, var16, 0, var15);
      byte[] var18 = new byte[24];
      byte[] var19 = new byte[8];
      byte[] var20 = new byte[8];
      byte[] var21 = new byte[8];
      if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
        if (var16 == null || var16.length != 32 && var16.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var22 = Text2Ascii(var16, var18);
          if (var22 < 0) {
            return -4;
          } else {
            if (var16.length == 32) {
              System.arraycopy(var18, 0, var19, 0, 8);
              System.arraycopy(var18, 0, var21, 0, 8);
              System.arraycopy(var18, 8, var20, 0, 8);
            } else {
              System.arraycopy(var18, 0, var19, 0, 8);
              System.arraycopy(var18, 8, var20, 0, 8);
              System.arraycopy(var18, 16, var21, 0, 8);
            }

            int var5 = var1 % 8;
            int var6 = var1 / 8;
            if (var2.length < (var6 + 1) * 8 & var3 == 0) {
              return -5;
            } else {
              if (var3 == 1) {
                if (var5 != 0) {
                  return -6;
                }

                if (var2.length < 8 * (var6 - 1)) {
                  return -7;
                }
              }

              int var7;
              int var23;
              if (var3 == 0) {
                for (var7 = 0; var7 < var6; ++var7) {
                  System.arraycopy(var0, 8 * var7, var8, 0, 8);
                  _$1(var8, 0, var19, var20, var21);
                  System.arraycopy(var8, 0, var2, 8 * var7, 8);
                }

                if (var5 == 0) {
                  for (var23 = 0; var23 < 8; ++var23) {
                    var8[var23] = 8;
                  }
                } else {
                  System.arraycopy(var0, 8 * var6, var8, 0, var5);

                  for (var23 = 0; var23 < 8 - var5; ++var23) {
                    var8[var5 + var23] = var9[8 - var5];
                  }
                }

                _$1(var8, 0, var19, var20, var21);
                System.arraycopy(var8, 0, var2, 8 * var6, 8);
                return (var6 + 1) * 8;
              } else {
                for (var7 = 0; var7 < var6 - 1; ++var7) {
                  System.arraycopy(var0, 8 * var7, var8, 0, 8);
                  _$1(var8, 1, var19, var20, var21);
                  System.arraycopy(var8, 0, var2, 8 * var7, 8);
                }

                System.arraycopy(var0, 8 * (var6 - 1), var8, 0, 8);
                _$1(var8, 1, var19, var20, var21);
                byte var10 = var8[7];
                if (var6 == 1 && var10 == 8) {
                  return -8;
                } else if (var10 >= 1 && var10 <= 8) {
                  if (var10 == 8) {
                    return (var6 - 1) * 8;
                  } else {
                    var23 = var10 - 0;
                    int var24 = 8 - var23;
                    if (var2.length < 8 * (var6 - 1) + var24) {
                      return -7;
                    } else {
                      System.arraycopy(var8, 0, var2, 8 * (var6 - 1), var24);
                      return (var6 - 1) * 8 + (8 - var10);
                    }
                  }
                } else {
                  return -8;
                }
              }
            }
          }
        }
      } else {
        return -1;
      }
    }
  }

  public static int TripleDesCBC0(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var5 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var6 = (new String(var5)).getBytes();
    int[] var7 = new int[1];
    int var8 = _$1(var4, var6, var7);
    if (var8 != 0) {
      return var8;
    } else {
      int var9 = var7[0];
      byte[] var10 = new byte[var9];
      System.arraycopy(var6, 0, var10, 0, var9);
      byte[] var11 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
      return _$6(var0, var1, var2, var3, var11, var10);
    }
  }

  private static int _$6(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var7 = new byte[8];
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
    byte[] var16 = new byte[24];
    byte[] var17 = new byte[8];
    byte[] var18 = new byte[8];
    byte[] var19 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 != null && var4.length == 8) {
        if (var5 == null || var5.length != 32 && var5.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var20 = Text2Ascii(var5, var16);
          if (var20 < 0) {
            return -4;
          } else {
            if (var5.length == 32) {
              System.arraycopy(var16, 0, var17, 0, 8);
              System.arraycopy(var16, 0, var19, 0, 8);
              System.arraycopy(var16, 8, var18, 0, 8);
            } else {
              System.arraycopy(var16, 0, var17, 0, 8);
              System.arraycopy(var16, 8, var18, 0, 8);
              System.arraycopy(var16, 16, var19, 0, 8);
            }

            int var13 = var1 % 8;
            int var14 = var1 / 8;
            if (var2.length < (var14 + 1) * 8 & var3 == 0) {
              return -5;
            } else {
              if (var3 == 1) {
                if (var13 != 0) {
                  return -6;
                }

                if (var2.length < 8 * (var14 - 1)) {
                  return -7;
                }
              }

              int var11;
              int var12;
              int var21;
              if (var3 == 0) {
                System.arraycopy(var4, 0, var6, 0, 8);

                for (var11 = 0; var11 < var14; ++var11) {
                  System.arraycopy(var0, 8 * var11, var7, 0, 8);

                  for (var12 = 0; var12 < 8; ++var12) {
                    var8[var12] = (byte) ((var6[var12] ^ var7[var12]) & 255);
                  }

                  _$2(var8, 0, var17, var18, var19);
                  System.arraycopy(var8, 0, var6, 0, 8);
                  System.arraycopy(var8, 0, var2, 8 * var11, 8);
                }

                if (var13 == 0) {
                  for (var21 = 0; var21 < 8; ++var21) {
                    var7[var21] = 8;
                  }
                } else {
                  System.arraycopy(var0, 8 * var14, var7, 0, var13);

                  for (var21 = 0; var21 < 8 - var13; ++var21) {
                    var7[var13 + var21] = var9[8 - var13];
                  }
                }

                for (var12 = 0; var12 < 8; ++var12) {
                  var8[var12] = (byte) ((var6[var12] ^ var7[var12]) & 255);
                }

                _$2(var8, 0, var17, var18, var19);
                System.arraycopy(var8, 0, var2, 8 * var14, 8);
                return (var14 + 1) * 8;
              } else {
                System.arraycopy(var4, 0, var6, 0, 8);

                for (var11 = 0; var11 < var14 - 1; ++var11) {
                  System.arraycopy(var0, 8 * var11, var8, 0, 8);
                  _$2(var8, 1, var17, var18, var19);

                  for (var12 = 0; var12 < 8; ++var12) {
                    var7[var12] = (byte) ((var6[var12] ^ var8[var12]) & 255);
                  }

                  System.arraycopy(var7, 0, var2, 8 * var11, 8);
                  System.arraycopy(var0, 8 * var11, var6, 0, 8);
                }

                System.arraycopy(var0, 8 * (var14 - 1), var8, 0, 8);
                _$2(var8, 1, var17, var18, var19);

                for (var12 = 0; var12 < 8; ++var12) {
                  var7[var12] = (byte) ((var6[var12] ^ var8[var12]) & 255);
                }

                byte var10 = var7[7];
                if (var14 == 1 && var10 == 8) {
                  return -8;
                } else if (var10 >= 1 && var10 <= 8) {
                  if (var10 == 8) {
                    return (var14 - 1) * 8;
                  } else {
                    var21 = var10 - 0;
                    int var22 = 8 - var21;
                    if (var2.length < 8 * (var14 - 1) + var22) {
                      return -7;
                    } else {
                      System.arraycopy(var7, 0, var2, 8 * (var14 - 1), var22);
                      return (var14 - 1) * 8 + (8 - var10);
                    }
                  }
                } else {
                  return -8;
                }
              }
            }
          }
        }
      } else {
        return -9;
      }
    } else {
      return -1;
    }
  }

  public static int TripleDesCBC1(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var5 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var6 = (new String(var5)).getBytes();
    int[] var7 = new int[1];
    int var8 = _$1(var4, var6, var7);
    if (var8 != 0) {
      return var8;
    } else {
      int var9 = var7[0];
      byte[] var10 = new byte[var9];
      System.arraycopy(var6, 0, var10, 0, var9);
      byte[] var11 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
      return _$5(var0, var1, var2, var3, var11, var10);
    }
  }

  private static int _$5(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var7 = new byte[8];
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
    byte[] var16 = new byte[24];
    byte[] var17 = new byte[8];
    byte[] var18 = new byte[8];
    byte[] var19 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 != null && var4.length == 8) {
        if (var5 == null || var5.length != 32 && var5.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var20 = Text2Ascii(var5, var16);
          if (var20 < 0) {
            return -4;
          } else {
            if (var5.length == 32) {
              System.arraycopy(var16, 0, var17, 0, 8);
              System.arraycopy(var16, 0, var19, 0, 8);
              System.arraycopy(var16, 8, var18, 0, 8);
            } else {
              System.arraycopy(var16, 0, var17, 0, 8);
              System.arraycopy(var16, 8, var18, 0, 8);
              System.arraycopy(var16, 16, var19, 0, 8);
            }

            int var13 = var1 % 8;
            int var14 = var1 / 8;
            if (var2.length < (var14 + 1) * 8 & var3 == 0) {
              return -5;
            } else {
              if (var3 == 1) {
                if (var13 != 0) {
                  return -6;
                }

                if (var2.length < 8 * (var14 - 1)) {
                  return -7;
                }
              }

              int var11;
              int var12;
              int var21;
              if (var3 == 0) {
                System.arraycopy(var4, 0, var6, 0, 8);

                for (var11 = 0; var11 < var14; ++var11) {
                  System.arraycopy(var0, 8 * var11, var7, 0, 8);

                  for (var12 = 0; var12 < 8; ++var12) {
                    var8[var12] = (byte) ((var6[var12] ^ var7[var12]) & 255);
                  }

                  _$1(var8, 0, var17, var18, var19);
                  System.arraycopy(var8, 0, var6, 0, 8);
                  System.arraycopy(var8, 0, var2, 8 * var11, 8);
                }

                if (var13 == 0) {
                  for (var21 = 0; var21 < 8; ++var21) {
                    var7[var21] = 8;
                  }
                } else {
                  System.arraycopy(var0, 8 * var14, var7, 0, var13);

                  for (var21 = 0; var21 < 8 - var13; ++var21) {
                    var7[var13 + var21] = var9[8 - var13];
                  }
                }

                for (var12 = 0; var12 < 8; ++var12) {
                  var8[var12] = (byte) ((var6[var12] ^ var7[var12]) & 255);
                }

                _$1(var8, 0, var17, var18, var19);
                System.arraycopy(var8, 0, var2, 8 * var14, 8);
                return (var14 + 1) * 8;
              } else {
                System.arraycopy(var4, 0, var6, 0, 8);

                for (var11 = 0; var11 < var14 - 1; ++var11) {
                  System.arraycopy(var0, 8 * var11, var8, 0, 8);
                  _$1(var8, 1, var17, var18, var19);

                  for (var12 = 0; var12 < 8; ++var12) {
                    var7[var12] = (byte) ((var6[var12] ^ var8[var12]) & 255);
                  }

                  System.arraycopy(var7, 0, var2, 8 * var11, 8);
                  System.arraycopy(var0, 8 * var11, var6, 0, 8);
                }

                System.arraycopy(var0, 8 * (var14 - 1), var8, 0, 8);
                _$1(var8, 1, var17, var18, var19);

                for (var12 = 0; var12 < 8; ++var12) {
                  var7[var12] = (byte) ((var6[var12] ^ var8[var12]) & 255);
                }

                byte var10 = var7[7];
                if (var14 == 1 && var10 == 8) {
                  return -8;
                } else if (var10 >= 1 && var10 <= 8) {
                  if (var10 == 8) {
                    return (var14 - 1) * 8;
                  } else {
                    var21 = var10 - 0;
                    int var22 = 8 - var21;
                    if (var2.length < 8 * (var14 - 1) + var22) {
                      return -7;
                    } else {
                      System.arraycopy(var7, 0, var2, 8 * (var14 - 1), var22);
                      return (var14 - 1) * 8 + (8 - var10);
                    }
                  }
                } else {
                  return -8;
                }
              }
            }
          }
        }
      } else {
        return -9;
      }
    } else {
      return -1;
    }
  }

  public static int TripleDesCFB0(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var5 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var6 = (new String(var5)).getBytes();
    int[] var7 = new int[1];
    int var8 = _$1(var4, var6, var7);
    if (var8 != 0) {
      return var8;
    } else {
      int var9 = var7[0];
      byte[] var10 = new byte[var9];
      System.arraycopy(var6, 0, var10, 0, var9);
      byte[] var11 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
      return _$4(var0, var1, var2, var3, var11, var10);
    }
  }

  private static int _$4(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var10 = new byte[24];
    byte[] var11 = new byte[8];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 != null && var4.length == 8) {
        if (var5 == null || var5.length != 32 && var5.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var14 = Text2Ascii(var5, var10);
          if (var14 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var5.length == 32) {
              System.arraycopy(var10, 0, var11, 0, 8);
              System.arraycopy(var10, 0, var13, 0, 8);
              System.arraycopy(var10, 8, var12, 0, 8);
            } else {
              System.arraycopy(var10, 0, var11, 0, 8);
              System.arraycopy(var10, 8, var12, 0, 8);
              System.arraycopy(var10, 16, var13, 0, 8);
            }

            int var7;
            int var8;
            if (var3 == 0) {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var7 = 0; var7 < var1; ++var7) {
                _$2(var6, 0, var11, var12, var13);
                var2[var7] = (byte) ((var0[var7] ^ var6[0]) & 255);

                for (var8 = 0; var8 < 7; ++var8) {
                  var6[var8] = var6[var8 + 1];
                }

                var6[7] = var2[var7];
              }
            } else {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var7 = 0; var7 < var1; ++var7) {
                _$2(var6, 0, var11, var12, var13);
                var2[var7] = (byte) ((var0[var7] ^ var6[0]) & 255);

                for (var8 = 0; var8 < 7; ++var8) {
                  var6[var8] = var6[var8 + 1];
                }

                var6[7] = var0[var7];
              }
            }

            return var1;
          }
        }
      } else {
        return -9;
      }
    } else {
      return -1;
    }
  }

  public static int TripleDesCFB1(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var5 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var6 = (new String(var5)).getBytes();
    int[] var7 = new int[1];
    int var8 = _$1(var4, var6, var7);
    if (var8 != 0) {
      return var8;
    } else {
      int var9 = var7[0];
      byte[] var10 = new byte[var9];
      System.arraycopy(var6, 0, var10, 0, var9);
      byte[] var11 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
      return _$3(var0, var1, var2, var3, var11, var10);
    }
  }

  private static int _$3(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var10 = new byte[24];
    byte[] var11 = new byte[8];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 != null && var4.length == 8) {
        if (var5 == null || var5.length != 32 && var5.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var14 = Text2Ascii(var5, var10);
          if (var14 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var5.length == 32) {
              System.arraycopy(var10, 0, var11, 0, 8);
              System.arraycopy(var10, 0, var13, 0, 8);
              System.arraycopy(var10, 8, var12, 0, 8);
            } else {
              System.arraycopy(var10, 0, var11, 0, 8);
              System.arraycopy(var10, 8, var12, 0, 8);
              System.arraycopy(var10, 16, var13, 0, 8);
            }

            int var7;
            int var8;
            if (var3 == 0) {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var7 = 0; var7 < var1; ++var7) {
                _$1(var6, 0, var11, var12, var13);
                var2[var7] = (byte) ((var0[var7] ^ var6[0]) & 255);

                for (var8 = 0; var8 < 7; ++var8) {
                  var6[var8] = var6[var8 + 1];
                }

                var6[7] = var2[var7];
              }
            } else {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var7 = 0; var7 < var1; ++var7) {
                _$1(var6, 0, var11, var12, var13);
                var2[var7] = (byte) ((var0[var7] ^ var6[0]) & 255);

                for (var8 = 0; var8 < 7; ++var8) {
                  var6[var8] = var6[var8 + 1];
                }

                var6[7] = var0[var7];
              }
            }

            return var1;
          }
        }
      } else {
        return -9;
      }
    } else {
      return -1;
    }
  }

  public static int TripleDesOFB0(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var5 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var6 = (new String(var5)).getBytes();
    int[] var7 = new int[1];
    int var8 = _$1(var4, var6, var7);
    if (var8 != 0) {
      return var8;
    } else {
      int var9 = var7[0];
      byte[] var10 = new byte[var9];
      System.arraycopy(var6, 0, var10, 0, var9);
      byte[] var11 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
      return _$2(var0, var1, var2, var3, var11, var10);
    }
  }

  private static int _$2(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var11 = new byte[24];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    byte[] var14 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 != null && var4.length == 8) {
        if (var5 == null || var5.length != 32 && var5.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var15 = Text2Ascii(var5, var11);
          if (var15 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var5.length == 32) {
              System.arraycopy(var11, 0, var12, 0, 8);
              System.arraycopy(var11, 0, var14, 0, 8);
              System.arraycopy(var11, 8, var13, 0, 8);
            } else {
              System.arraycopy(var11, 0, var12, 0, 8);
              System.arraycopy(var11, 8, var13, 0, 8);
              System.arraycopy(var11, 16, var14, 0, 8);
            }

            byte var7;
            int var8;
            int var9;
            if (var3 == 0) {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var8 = 0; var8 < var1; ++var8) {
                _$2(var6, 0, var12, var13, var14);
                var2[var8] = (byte) ((var0[var8] ^ var6[0]) & 255);
                var7 = var6[0];

                for (var9 = 0; var9 < 7; ++var9) {
                  var6[var9] = var6[var9 + 1];
                }

                var6[7] = var7;
              }
            } else {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var8 = 0; var8 < var1; ++var8) {
                _$2(var6, 0, var12, var13, var14);
                var2[var8] = (byte) ((var0[var8] ^ var6[0]) & 255);
                var7 = var6[0];

                for (var9 = 0; var9 < 7; ++var9) {
                  var6[var9] = var6[var9 + 1];
                }

                var6[7] = var7;
              }
            }

            return var1;
          }
        }
      } else {
        return -9;
      }
    } else {
      return -1;
    }
  }

  public static int TripleDesOFB1(byte[] var0, int var1, byte[] var2, int var3, String var4) {
    char[] var5 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var6 = (new String(var5)).getBytes();
    int[] var7 = new int[1];
    int var8 = _$1(var4, var6, var7);
    if (var8 != 0) {
      return var8;
    } else {
      int var9 = var7[0];
      byte[] var10 = new byte[var9];
      System.arraycopy(var6, 0, var10, 0, var9);
      byte[] var11 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
      return _$1(var0, var1, var2, var3, var11, var10);
    }
  }

  private static int _$1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var11 = new byte[24];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    byte[] var14 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 != null && var4.length == 8) {
        if (var5 == null || var5.length != 32 && var5.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var15 = Text2Ascii(var5, var11);
          if (var15 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var5.length == 32) {
              System.arraycopy(var11, 0, var12, 0, 8);
              System.arraycopy(var11, 0, var14, 0, 8);
              System.arraycopy(var11, 8, var13, 0, 8);
            } else {
              System.arraycopy(var11, 0, var12, 0, 8);
              System.arraycopy(var11, 8, var13, 0, 8);
              System.arraycopy(var11, 16, var14, 0, 8);
            }

            byte var7;
            int var8;
            int var9;
            if (var3 == 0) {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var8 = 0; var8 < var1; ++var8) {
                _$1(var6, 0, var12, var13, var14);
                var2[var8] = (byte) ((var0[var8] ^ var6[0]) & 255);
                var7 = var6[0];

                for (var9 = 0; var9 < 7; ++var9) {
                  var6[var9] = var6[var9 + 1];
                }

                var6[7] = var7;
              }
            } else {
              System.arraycopy(var4, 0, var6, 0, 8);

              for (var8 = 0; var8 < var1; ++var8) {
                _$1(var6, 0, var12, var13, var14);
                var2[var8] = (byte) ((var0[var8] ^ var6[0]) & 255);
                var7 = var6[0];

                for (var9 = 0; var9 < 7; ++var9) {
                  var6[var9] = var6[var9 + 1];
                }

                var6[7] = var7;
              }
            }

            return var1;
          }
        }
      } else {
        return -9;
      }
    } else {
      return -1;
    }
  }

  private static int _$1(byte var0) {
    return var0 >= 48 && var0 <= 57 ? var0 - 48 : (var0 >= 65 && var0 <= 70 ? var0 - 65 + 10 : (var0 >= 97 && var0 <= 102 ? var0 - 97 + 10 : -1));
  }

  public static String Ascii2Text(byte[] var0) {
    Vector var1 = new Vector();
    var1.add(0, "0");
    var1.add(1, "1");
    var1.add(2, "2");
    var1.add(3, "3");
    var1.add(4, "4");
    var1.add(5, "5");
    var1.add(6, "6");
    var1.add(7, "7");
    var1.add(8, "8");
    var1.add(9, "9");
    var1.add(10, "A");
    var1.add(11, "B");
    var1.add(12, "C");
    var1.add(13, "D");
    var1.add(14, "E");
    var1.add(15, "F");
    StringBuffer var2 = new StringBuffer();

    for (int var3 = 0; var3 < var0.length; ++var3) {
      int var4 = var0[var3];
      if (var4 < 0) {
        var4 += 256;
      }

      int var5 = var4 >> 4;
      int var6 = var4 & 15;
      var2.append((String) var1.get(var5)).append((String) var1.get(var6));
    }

    return var2.toString();
  }

  public static int Text2Ascii(byte[] var0, byte[] var1) {
    byte[] var8 = var0;
    byte[] var9 = var1;
    if (var0 != null && var1 != null) {
      int var4 = var0.length;
      if (var4 < 2) {
        return -21;
      } else if (var4 % 2 != 0) {
        return -22;
      } else if (var1.length < var4 / 2) {
        return -23;
      } else {
        int var2 = 0;

        int var3;
        for (var3 = 0; var2 < var4; ++var3) {
          int var6;
          if ((var6 = _$1(var8[var2++])) < 0) {
            return -24;
          }

          int var7;
          if ((var7 = _$1(var8[var2++])) < 0) {
            return -24;
          }

          int var5 = (var6 << 4 | var7) & 255;
          var9[var3] = (byte) var5;
        }

        return var3;
      }
    } else {
      return -20;
    }
  }

  public static void PrintHex(byte[] var0, int var1) {
    if (var0.length < var1) {
      System.out.println("Array.length:" + var0.length + " 小于len:" + var1 + "的长度!");
    } else {
      int var2 = var1 % 8;

      int var3;
      int var4;
      byte var5;
      byte var6;
      char var7;
      for (var3 = 0; var3 < var1 / 8; ++var3) {
        for (var4 = 0; var4 < 8; ++var4) {
          var5 = (byte) ((var0[var3 * 8 + var4] & 240) >>> 4);
          var6 = (byte) (var0[var3 * 8 + var4] & 15);
          System.out.print("0x");
          if (var5 < 10) {
            var7 = (char) (48 + var5);
          } else {
            var7 = (char) (65 + var5 - 10);
          }

          System.out.print(var7);
          if (var6 < 10) {
            var7 = (char) (48 + var6);
          } else {
            var7 = (char) (65 + var6 - 10);
          }

          System.out.print(var7);
          System.out.print(" ");
        }

        System.out.println();
      }

      for (var4 = 0; var4 < var2; ++var4) {
        var5 = (byte) ((var0[var3 * 8 + var4] & 240) >>> 4);
        var6 = (byte) (var0[var3 * 8 + var4] & 15);
        System.out.print("0x");
        if (var5 < 10) {
          var7 = (char) (48 + var5);
        } else {
          var7 = (char) (65 + var5 - 10);
        }

        System.out.print(var7);
        if (var6 < 10) {
          var7 = (char) (48 + var6);
        } else {
          var7 = (char) (65 + var6 - 10);
        }

        System.out.print(var7);
        System.out.print(" ");
      }

      System.out.println();
    }
  }

  public static boolean ArrayByteCmp(byte[] var0, byte[] var1, int var2) {
    if (var0 == null && var1 == null) {
      return true;
    } else if ((var0 != null || var1 == null) && (var0 == null || var1 != null)) {
      if (var0.length != var1.length) {
        return false;
      } else {
        if (var0.length < var2) {
          var2 = var0.length;
        }

        for (int var3 = 0; var3 < var2; ++var3) {
          if (var1[var3] != var0[var3]) {
            return false;
          }
        }

        return true;
      }
    } else {
      return false;
    }
  }

  public static int des3Mac(byte[] var0, int var1, byte[] var2, String var3) {
    byte[] var4 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    byte[] var6 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    byte[] var7 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    byte[] var8 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    byte[] var9 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    char[] var10 = new char[]{'0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'};
    byte[] var11 = (new String(var10)).getBytes();
    int[] var12 = new int[1];
    int var13 = _$1(var3, var11, var12);
    if (var13 != 0) {
      return var13;
    } else {
      int var14 = var12[0];
      byte[] var15 = new byte[var14];
      System.arraycopy(var11, 0, var15, 0, var14);
      byte[] var17 = new byte[16];
      byte[] var18 = new byte[16];
      if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
        if (var15 != null && var15.length == 32) {
          int var19 = Text2Ascii(var15, var17);
          if (var19 < 0) {
            return -4;
          } else {
            System.arraycopy(var17, 0, var18, 0, 8);
            System.arraycopy(var17, 0, var18, 8, 8);
            int var20 = var1 % 8;
            int var21 = var1 / 8;
            boolean var22 = false;
            int var25;
            if (var20 == 0) {
              var25 = var21 - 1;
            } else {
              var25 = var21;
            }

            System.arraycopy(var4, 0, var5, 0, 8);

            int var23;
            for (var23 = 0; var23 < var25; ++var23) {
              System.arraycopy(var0, 8 * var23, var6, 0, 8);

              int var24;
              for (var24 = 0; var24 < 8; ++var24) {
                var7[var24] = (byte) (var5[var24] ^ var6[var24]);
              }

              var24 = TripleDes1(var7, var8, 0, (byte[]) Ascii2Text(var18).getBytes());
              if (var24 < 0) {
                return var24;
              }

              System.arraycopy(var8, 0, var5, 0, 8);
            }

            if (var20 == 0) {
              System.arraycopy(var0, var25 * 8, var6, 0, 8);
            } else {
              System.arraycopy(var0, 8 * var25, var6, 0, var20);
              System.arraycopy(var9, 0, var6, var20, 8 - var20);
            }

            for (var23 = 0; var23 < 8; ++var23) {
              var7[var23] = (byte) (var5[var23] ^ var6[var23]);
            }

            var23 = TripleDes1(var7, var8, 0, (String) var3);
            if (var23 < 0) {
              return var23;
            } else {
              System.arraycopy(var8, 0, var2, 0, 8);
              return 8;
            }
          }
        } else {
          return -2;
        }
      } else {
        return -1;
      }
    }
  }

  private static int TripleDes1(byte[] var0, byte[] var1, int var2, byte[] var3) {
    byte[] var4 = new byte[24];
    byte[] var5 = new byte[8];
    byte[] var6 = new byte[8];
    byte[] var7 = new byte[8];
    if (var0 != null && var1 != null) {
      if (var0.length == 8 && var1.length == 8) {
        if (var3 != null && (var3.length == 32 || var3.length == 48)) {
          if (var2 != 0 && var2 != 1) {
            return -3;
          } else {
            int var8 = Text2Ascii(var3, var4);
            if (var8 < 0) {
              return -4;
            } else {
              if (var3.length == 32) {
                System.arraycopy(var4, 0, var5, 0, 8);
                System.arraycopy(var4, 0, var7, 0, 8);
                System.arraycopy(var4, 8, var6, 0, 8);
              } else {
                System.arraycopy(var4, 0, var5, 0, 8);
                System.arraycopy(var4, 8, var6, 0, 8);
                System.arraycopy(var4, 16, var7, 0, 8);
              }

              System.arraycopy(var0, 0, var1, 0, 8);
              return _$1(var1, var2, var5, var6, var7);
            }
          }
        } else {
          return -2;
        }
      } else {
        return -26;
      }
    } else {
      return -1;
    }
  }

  public static int pinBlockEnc(String var0, String var1, int var2, String var3, String[] var4) {
    String var5 = "";
    String var6 = "FFFFFFFFFFFFFFFF";
    byte[] var7 = new byte[8];
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[8];
    if (var0.length() >= 4 && var0.length() <= 12) {
      switch (var0.length()) {
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
          var5 = "0" + var0.length() + var0 + var6.substring(0, 16 - var0.length() - 2);
          break;
        case 10:
          var5 = "0A" + var0 + var6.substring(0, 16 - var0.length() - 2);
          break;
        case 11:
          var5 = "0B" + var0 + var6.substring(0, 16 - var0.length() - 2);
          break;
        case 12:
          var5 = "0C" + var0 + var6.substring(0, 16 - var0.length() - 2);
      }

      byte[] var14 = var5.getBytes();
      byte[] var12;
      if (var2 == 0) {
        if (var1.length() < 13) {
          return -30;
        }

        int var10 = var1.length() - 1 - 12;
        int var11 = var1.length() - 1;
        var12 = ("0000" + var1.substring(var10, var11)).getBytes();
      } else {
        if (var1.length() < 25) {
          return -31;
        }

        var12 = ("0000" + var1.substring(13)).getBytes();
      }

      int var13 = Text2Ascii(var14, var7);
      if (var13 < 0) {
        return var13;
      } else {
        var13 = Text2Ascii(var12, var8);
        if (var13 < 0) {
          return var13;
        } else {
          byte[] var15 = _$1(var7, var8);
          int var16 = TripleDes1(var15, var9, 0, (String) var3);
          if (var16 < 0) {
            return var16;
          } else {
            String var17 = Ascii2Text(var9);
            var4[0] = var17;
            return 0;
          }
        }
      }
    } else {
      return -29;
    }
  }

  public static int pinBlockDec(String var0, String var1, int var2, String var3, String[] var4) {
    String var5 = "";
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[8];
    byte[] var10 = new byte[8];
    byte[] var14 = var0.getBytes();
    int var6 = Text2Ascii(var14, var10);
    if (var6 < 0) {
      return var6;
    } else {
      int var7 = TripleDes1(var10, var8, 1, (String) var3);
      if (var7 < 0) {
        return var7;
      } else if (var8[0] >= 4 && var8[0] <= 12) {
        byte[] var13;
        if (var2 == 0) {
          if (var1.length() < 13) {
            return -30;
          }

          int var11 = var1.length() - 1 - 12;
          int var12 = var1.length() - 1;
          var13 = ("0000" + var1.substring(var11, var12)).getBytes();
        } else {
          if (var1.length() < 25) {
            return -31;
          }

          var13 = ("0000" + var1.substring(13)).getBytes();
        }

        var6 = Text2Ascii(var13, var9);
        if (var6 < 0) {
          return var6;
        } else {
          byte[] var15 = _$1(var8, var9);
          var5 = Ascii2Text(var15);
          byte[] var16 = var5.getBytes();
          int var17 = 0;

          int var18;
          for (var18 = 2; var17 < var15[0]; ++var18) {
            if (var16[var18] < 48 || var16[var18] > 57) {
              return -33;
            }

            ++var17;
          }

          var17 = 0;

          for (var18 = 15; var17 < 14 - var15[0]; --var18) {
            if (var16[var18] != 70) {
              return -34;
            }

            ++var17;
          }

          var4[0] = var5.substring(2, var15[0] + 2);
          return 0;
        }
      } else {
        return -32;
      }
    }
  }

  public static int pinBlockDecEnc(String var0, String var1, int var2, String var3, String var4, String[] var5) {
    int var6 = pinBlockDec(var0, var1, var2, var3, var5);
    if (var6 < 0) {
      return var6;
    } else {
      var6 = pinBlockEnc(var5[0], var1, var2, var4, var5);
      return var6;
    }
  }

  private static int _$1(String var0, byte[] var1, int[] var2) {
    if (var0 != null && !"".equals(var0)) {
      FileInputStream var5 = null;
      File var6 = new File(var0);
      if (!var6.canRead()) {
        return -28;
      } else {
        long var7 = var6.length();

        byte[] var9;
        try {
          byte var11;
          try {
            var5 = new FileInputStream(var6);
            var9 = new byte[(int) var7];
            int var10 = var5.read(var9);
            if ((long) var10 != var7) {
              var11 = -28;
              return var11;
            }
          } catch (FileNotFoundException var42) {
            var42.printStackTrace();
            var11 = -28;
            return var11;
          } catch (IOException var43) {
            var43.printStackTrace();
            var11 = -28;
            return var11;
          }
        } finally {
          try {
            if (var5 != null) {
              var5.close();
            }
          } catch (IOException var41) {
            var41.printStackTrace();
            return -28;
          }

        }

        Object var45 = null;

        byte[] var46;
        try {
          String var47 = new String(var9, "GBK");
          var46 = Base64.decode(var47);
        } catch (UnsupportedEncodingException var40) {
          var40.printStackTrace();
          return -28;
        }

        int var48 = var46.length - 9;
        int var12 = var48 / 8;
        if (var48 % 8 != 0) {
          return -27;
        } else {
          int var13 = var46[0] & 255;
          if (var48 % var13 != 0 || var48 / var13 != 16 && var48 / var13 != 24) {
            return -27;
          } else {
            byte[] var14 = new byte[8];
            byte[] var15 = new byte[8 * var12];
            System.arraycopy(var46, var46.length - 8, var14, 0, 8);
            System.arraycopy(var46, 1, var15, 0, 8 * var12);
            int var16 = var15[0] & 255;

            while (_$1(var16, var12)) {
              ++var16;
              if (var16 == 256) {
                var16 = 0;
              }
            }

            byte[] var17 = new byte[24];

            int var18;
            for (var18 = 0; var18 < 8; ++var18) {
              var17[var18] = (byte) (var14[var18] ^ var15[var12 * var18 + var16 * (var18 + 1) % var12]);
            }

            var18 = 0;
            boolean var19 = false;

            int var20;
            byte var21;
            int var22;
            int var23;
            int var49;
            for (var20 = 8; var20 < 16; ++var20) {
              var21 = 0;
              var22 = var17[var18] & 255;
              var49 = var22 % 5 + 1;

              for (var23 = var18; var23 < var49 + 1 + var18; ++var23) {
                var21 ^= var17[var23 % 8];
              }

              var17[var20] = var21;
              var18 = (var49 + var18) % 8;
            }

            var18 = 8;
            var19 = true;

            for (var20 = 16; var20 < 24; ++var20) {
              var21 = 0;
              var22 = var17[var18] & 255;
              var49 = var22 % 5 + 1;

              for (var23 = var18; var23 < var49 + 1 + var18; ++var23) {
                var21 ^= var17[var23 % 8 + 8];
              }

              var17[var20] = var21;
              var18 = (var49 + var18) % 8 + 8;
            }

            byte[] var50 = new byte[var15.length];
            byte[] var51 = new byte[8];
            byte[] var52 = new byte[8];

            for (var23 = 0; var23 < var15.length / 8; ++var23) {
              System.arraycopy(var15, var23 * 8, var51, 0, 8);
              TemplateTripleDesCryptVarKey.TripleDes1(var51, var52, 1, Ascii2Text(var17).getBytes());
              System.arraycopy(var52, 0, var50, var23 * 8, 8);
            }

            var23 = var50.length;
            if (var23 % 8 != 0) {
              return -28;
            } else {
              byte[] var24 = new byte[8];
              int var25 = var23 / 8;

              int var26;
              for (var26 = 0; var26 < 8; ++var26) {
                byte var27 = 0;

                for (int var28 = 0; var28 < var25; ++var28) {
                  var27 ^= var50[var26 * var25 + var28];
                }

                var24[var26] = var27;
              }

              for (var26 = 0; var26 < 8; ++var26) {
                if (var24[var26] != var17[var26]) {
                  return -28;
                }
              }

              var26 = var50.length / var13;
              byte[] var53 = new byte[var26];
              byte[] var54 = new byte[var26];

              int var29;
              for (var29 = 0; var29 < var26; ++var29) {
                var53[var29] = 0;
              }

              for (var29 = 0; var29 < var13; ++var29) {
                System.arraycopy(var50, var29 * var26, var54, 0, var26);
                var53 = _$1(var53, var54);
              }

              String var55 = Ascii2Text(var53);
              byte[] var30 = var55.getBytes();
              System.arraycopy(var30, 0, var1, 0, var30.length);
              var2[0] = var30.length;
              return 0;
            }
          }
        }
      }
    } else {
      return -28;
    }
  }

  private static byte[] _$1(byte[] var0, byte[] var1) {
    int var2 = var0.length;
    byte[] var3 = new byte[var2];

    for (int var4 = 0; var4 < var2; ++var4) {
      var3[var4] = (byte) (var0[var4] ^ var1[var4]);
    }

    return var3;
  }

  private static boolean _$1(int var0, int var1) {
    if (var0 != 0 && var1 != 0) {
      if (var0 != 1 && var1 != 1) {
        int var2 = var1;
        if (var0 < var1) {
          var1 = var0;
          var0 = var2;
        }

        for (int var3 = 2; var3 < var1 + 1; ++var3) {
          if (var1 % var3 == 0 && var0 % var3 == 0) {
            return true;
          }
        }

        return false;
      } else {
        return false;
      }
    } else {
      return true;
    }
  }

  public int TripleDes(byte[] var1, int var2, byte[] var3, int var4, int var5, int var6) {
    byte[] var7 = this._$5;
    return var1 != null && var3 != null && var1.length >= var2 && var2 >= 1 ? (var7 != null && (var7.length == 32 || var7.length == 48) ? (var4 != 0 && var4 != 1 ? -3 : (var6 != 0 && var6 != 1 ? -25 : (var5 != 1 && var5 != 2 && var5 != 3 && var5 != 4 ? -11 : (var5 == 1 ? (var4 == 1 && var2 % 8 != 0 ? -6 : (var6 == 0 ? TripleDesECB0(var1, var2, var3, var4, this._$5) : TripleDesECB1(var1, var2, var3, var4, this._$5))) : (var5 == 2 ? (var4 == 1 && var2 % 8 != 0 ? -6 : (var6 == 0 ? TripleDesCBC0(var1, var2, var3, var4, this._$5) : TripleDesCBC1(var1, var2, var3, var4, this._$5))) : (var5 == 3 ? (var6 == 0 ? TripleDesCFB0(var1, var2, var3, var4, this._$5) : TripleDesCFB1(var1, var2, var3, var4, this._$5)) : (var6 == 0 ? TripleDesOFB0(var1, var2, var3, var4, this._$5) : TripleDesOFB1(var1, var2, var3, var4, this._$5)))))))) : -2) : -1;
  }

  public int TripleDesFile(String var1, String var2, int var3, int var4, int var5) {
    byte[] var6 = this._$5;
    byte[] var7 = new byte[24];
    byte[] var12 = new byte[4104];
    byte[] var13 = new byte[4104];
    if (var6 != null && (var6.length == 32 || var6.length == 48)) {
      if (var3 != 0 && var3 != 1) {
        return -3;
      } else {
        int var8 = Text2Ascii(var6, var7);
        if (var8 < 0) {
          return -4;
        } else if (var4 != 1 && var4 != 2 && var4 != 3 && var4 != 4) {
          return -11;
        } else if (var5 != 0 && var5 != 1) {
          return -25;
        } else if (var1 == null) {
          return -12;
        } else if (var2 == null) {
          return -13;
        } else {
          BufferedInputStream var14 = null;
          BufferedOutputStream var15 = null;
          File var16 = new File(var1);
          if (!var16.canRead()) {
            return -14;
          } else {
            File var17 = new File(var2);
            if (!var17.canWrite()) {
              return -15;
            } else {
              try {
                var14 = new BufferedInputStream(new FileInputStream(var16));
              } catch (FileNotFoundException var28) {
                var28.printStackTrace();
                return -16;
              }

              try {
                var15 = new BufferedOutputStream(new FileOutputStream(var2));
              } catch (FileNotFoundException var27) {
                var27.printStackTrace();

                try {
                  var14.close();
                } catch (IOException var21) {
                  ;
                }

                return -17;
              }

              short var9;
              if (var3 == 0) {
                var9 = 4096;
              } else if (var4 != 1 && var4 != 2) {
                var9 = 4096;
              } else {
                var9 = 4104;
              }

              do {
                int var11 = 0;

                do {
                  try {
                    var8 = var14.read(var12, var11, var9 - var11);
                  } catch (IOException var25) {
                    try {
                      var14.close();
                      var15.close();
                    } catch (IOException var20) {
                      ;
                    }

                    return -18;
                  }

                  if (var8 == -1) {
                    break;
                  }

                  var11 += var8;
                } while (var11 < var9);

                int var10 = this.TripleDes(var12, var11, var13, var3, var4, var5);
                if (var10 <= 0) {
                  try {
                    var14.close();
                    var15.close();
                  } catch (IOException var23) {
                    ;
                  }

                  return var10;
                }

                try {
                  var15.write(var13, 0, var10);
                } catch (IOException var26) {
                  try {
                    var14.close();
                    var15.close();
                  } catch (IOException var22) {
                    ;
                  }

                  return -19;
                }
              } while (var8 != -1);

              try {
                var14.close();
                var15.close();
              } catch (IOException var24) {
                ;
              }

              return 0;
            }
          }
        }
      }
    } else {
      return -2;
    }
  }

  private static int TripleDesECB0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
    byte[] var12 = new byte[24];
    byte[] var13 = new byte[8];
    byte[] var14 = new byte[8];
    byte[] var15 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 == null || var4.length != 32 && var4.length != 48) {
        return -2;
      } else if (var3 != 0 && var3 != 1) {
        return -3;
      } else {
        int var16 = Text2Ascii(var4, var12);
        if (var16 < 0) {
          return -4;
        } else {
          if (var4.length == 32) {
            System.arraycopy(var12, 0, var13, 0, 8);
            System.arraycopy(var12, 0, var15, 0, 8);
            System.arraycopy(var12, 8, var14, 0, 8);
          } else {
            System.arraycopy(var12, 0, var13, 0, 8);
            System.arraycopy(var12, 8, var14, 0, 8);
            System.arraycopy(var12, 16, var15, 0, 8);
          }

          int var5 = var1 % 8;
          int var6 = var1 / 8;
          if (var2.length < (var6 + 1) * 8 & var3 == 0) {
            return -5;
          } else {
            if (var3 == 1) {
              if (var5 != 0) {
                return -6;
              }

              if (var2.length < 8 * (var6 - 1)) {
                return -7;
              }
            }

            int var7;
            int var17;
            if (var3 == 0) {
              for (var7 = 0; var7 < var6; ++var7) {
                System.arraycopy(var0, 8 * var7, var8, 0, 8);
                _$2(var8, 0, var13, var14, var15);
                System.arraycopy(var8, 0, var2, 8 * var7, 8);
              }

              if (var5 == 0) {
                for (var17 = 0; var17 < 8; ++var17) {
                  var8[var17] = 8;
                }
              } else {
                System.arraycopy(var0, 8 * var6, var8, 0, var5);

                for (var17 = 0; var17 < 8 - var5; ++var17) {
                  var8[var5 + var17] = var9[8 - var5];
                }
              }

              _$2(var8, 0, var13, var14, var15);
              System.arraycopy(var8, 0, var2, 8 * var6, 8);
              return (var6 + 1) * 8;
            } else {
              for (var7 = 0; var7 < var6 - 1; ++var7) {
                System.arraycopy(var0, 8 * var7, var8, 0, 8);
                _$2(var8, 1, var13, var14, var15);
                System.arraycopy(var8, 0, var2, 8 * var7, 8);
              }

              System.arraycopy(var0, 8 * (var6 - 1), var8, 0, 8);
              _$2(var8, 1, var13, var14, var15);
              byte var10 = var8[7];
              if (var6 == 1 && var10 == 8) {
                return -8;
              } else if (var10 >= 1 && var10 <= 8) {
                if (var10 == 8) {
                  return (var6 - 1) * 8;
                } else {
                  var17 = var10 - 0;
                  int var18 = 8 - var17;
                  if (var2.length < 8 * (var6 - 1) + var18) {
                    return -7;
                  } else {
                    System.arraycopy(var8, 0, var2, 8 * (var6 - 1), var18);
                    return (var6 - 1) * 8 + (8 - var10);
                  }
                }
              } else {
                return -8;
              }
            }
          }
        }
      }
    } else {
      return -1;
    }
  }

  private static int TripleDesECB1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var8 = new byte[8];
    byte[] var9 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
    byte[] var12 = new byte[24];
    byte[] var13 = new byte[8];
    byte[] var14 = new byte[8];
    byte[] var15 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var4 == null || var4.length != 32 && var4.length != 48) {
        return -2;
      } else if (var3 != 0 && var3 != 1) {
        return -3;
      } else {
        int var16 = Text2Ascii(var4, var12);
        if (var16 < 0) {
          return -4;
        } else {
          if (var4.length == 32) {
            System.arraycopy(var12, 0, var13, 0, 8);
            System.arraycopy(var12, 0, var15, 0, 8);
            System.arraycopy(var12, 8, var14, 0, 8);
          } else {
            System.arraycopy(var12, 0, var13, 0, 8);
            System.arraycopy(var12, 8, var14, 0, 8);
            System.arraycopy(var12, 16, var15, 0, 8);
          }

          int var5 = var1 % 8;
          int var6 = var1 / 8;
          if (var2.length < (var6 + 1) * 8 & var3 == 0) {
            return -5;
          } else {
            if (var3 == 1) {
              if (var5 != 0) {
                return -6;
              }

              if (var2.length < 8 * (var6 - 1)) {
                return -7;
              }
            }

            int var7;
            int var17;
            if (var3 == 0) {
              for (var7 = 0; var7 < var6; ++var7) {
                System.arraycopy(var0, 8 * var7, var8, 0, 8);
                _$1(var8, 0, var13, var14, var15);
                System.arraycopy(var8, 0, var2, 8 * var7, 8);
              }

              if (var5 == 0) {
                for (var17 = 0; var17 < 8; ++var17) {
                  var8[var17] = 8;
                }
              } else {
                System.arraycopy(var0, 8 * var6, var8, 0, var5);

                for (var17 = 0; var17 < 8 - var5; ++var17) {
                  var8[var5 + var17] = var9[8 - var5];
                }
              }

              _$1(var8, 0, var13, var14, var15);
              System.arraycopy(var8, 0, var2, 8 * var6, 8);
              return (var6 + 1) * 8;
            } else {
              for (var7 = 0; var7 < var6 - 1; ++var7) {
                System.arraycopy(var0, 8 * var7, var8, 0, 8);
                _$1(var8, 1, var13, var14, var15);
                System.arraycopy(var8, 0, var2, 8 * var7, 8);
              }

              System.arraycopy(var0, 8 * (var6 - 1), var8, 0, 8);
              _$1(var8, 1, var13, var14, var15);
              byte var10 = var8[7];
              if (var6 == 1 && var10 == 8) {
                return -8;
              } else if (var10 >= 1 && var10 <= 8) {
                if (var10 == 8) {
                  return (var6 - 1) * 8;
                } else {
                  var17 = var10 - 0;
                  int var18 = 8 - var17;
                  if (var2.length < 8 * (var6 - 1) + var18) {
                    return -7;
                  } else {
                    System.arraycopy(var8, 0, var2, 8 * (var6 - 1), var18);
                    return (var6 - 1) * 8 + (8 - var10);
                  }
                }
              } else {
                return -8;
              }
            }
          }
        }
      }
    } else {
      return -1;
    }
  }

  private static int TripleDesCBC0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$6(var0, var1, var2, var3, var4, var5);
  }

  private static int TripleDesCBC1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$5(var0, var1, var2, var3, var4, var5);
  }

  private static int TripleDesCFB0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$4(var0, var1, var2, var3, var4, var5);
  }

  private static int TripleDesCFB1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$3(var0, var1, var2, var3, var4, var5);
  }

  private static int TripleDesOFB0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$2(var0, var1, var2, var3, var4, var5);
  }

  private static int TripleDesOFB1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$1(var0, var1, var2, var3, var4, var5);
  }

  public static void main(String[] var0) {
    String[] var1 = new String[16];
    new TripleDesCryptFileInputKey();
    int var2 = pinBlockEnc("8888812", "1234567890123456789", 0, "F:\\hsm_test\\abc", var1);
    System.out.println("rec is" + var2 + "password" + var1[0]);
    new TripleDesCryptFileInputKey();
    var2 = pinBlockDecEnc(var1[0], "1234567890123456789", 0, "F:\\hsm_test\\abc", "F:\\hsm_test\\abc", var1);
    System.out.println("rec is" + var2 + "password" + var1[0]);
  }
}
