package com.muyclound.util.crypto.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by yanglikai on 2018/4/11.
 */
public class TripleDesCryptVarKey2 implements Serializable {
  static final int[] _$4 = new int[]{58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
  static final int[] _$3 = new int[]{32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
  static final int[][] _$2 = new int[][]{{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}, {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}, {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}, {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}, {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}, {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}, {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}, {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
  static final int[] _$1 = new int[]{16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};

  public TripleDesCryptVarKey2() {
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

  private static void _$4(byte[] var0, byte[] var1) {
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

  private static void _$3(byte[] var0, byte[] var1) {
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
    _$4(var3, var1);

    for (int var2 = 0; var2 < 16; ++var2) {
      _$1(var3);
      if ((var4[var2] & 255) == 2) {
        _$1(var3);
      }

      _$3(var3, var0[var2]);
    }

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

  private static void _$1(byte[] var0, byte[] var1) {
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
      _$2(var0, var2);
      _$2(var0, var3);
      _$2(var0, var4);
    } else {
      _$1(var0, var4);
      _$1(var0, var3);
      _$1(var0, var2);
    }

    return 0;
  }

  private static int _$1(byte[] var0, int var1, byte[] var2, byte[] var3, byte[] var4) {
    if (var1 == 0) {
      _$2(var0, var2);
      _$1(var0, var3);
      _$2(var0, var4);
    } else {
      _$1(var0, var4);
      _$2(var0, var3);
      _$1(var0, var2);
    }

    return 0;
  }

  public static int TripleDes0(byte[] var0, byte[] var1, int var2, byte[] var3) {
    byte[] var5 = new byte[24];
    byte[] var6 = new byte[8];
    byte[] var7 = new byte[8];
    byte[] var8 = new byte[8];
    if (var0 != null && var1 != null) {
      if (var0.length == 8 && var1.length == 8) {
        if (var3 != null && (var3.length == 32 || var3.length == 48)) {
          if (var2 != 0 && var2 != 1) {
            return -3;
          } else {
            int var9 = Text2Ascii(var3, var5);
            if (var9 < 0) {
              return -4;
            } else {
              if (var3.length == 32) {
                System.arraycopy(var5, 0, var6, 0, 8);
                System.arraycopy(var5, 0, var8, 0, 8);
                System.arraycopy(var5, 8, var7, 0, 8);
              } else {
                System.arraycopy(var5, 0, var6, 0, 8);
                System.arraycopy(var5, 8, var7, 0, 8);
                System.arraycopy(var5, 16, var8, 0, 8);
              }

              System.arraycopy(var0, 0, var1, 0, 8);
              return _$2(var1, var2, var6, var7, var8);
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

  public static int TripleDes1(byte[] var0, byte[] var1, int var2, byte[] var3) {
    byte[] var5 = new byte[24];
    byte[] var6 = new byte[8];
    byte[] var7 = new byte[8];
    byte[] var8 = new byte[8];
    if (var0 != null && var1 != null) {
      if (var0.length == 8 && var1.length == 8) {
        if (var3 != null && (var3.length == 32 || var3.length == 48)) {
          if (var2 != 0 && var2 != 1) {
            return -3;
          } else {
            int var9 = Text2Ascii(var3, var5);
            if (var9 < 0) {
              return -4;
            } else {
              if (var3.length == 32) {
                System.arraycopy(var5, 0, var6, 0, 8);
                System.arraycopy(var5, 0, var8, 0, 8);
                System.arraycopy(var5, 8, var7, 0, 8);
              } else {
                System.arraycopy(var5, 0, var6, 0, 8);
                System.arraycopy(var5, 8, var7, 0, 8);
                System.arraycopy(var5, 16, var8, 0, 8);
              }

              System.arraycopy(var0, 0, var1, 0, 8);
              return _$1(var1, var2, var6, var7, var8);
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

  public static int TripleDes(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, int var5, int var6) {
    return var0 != null && var2 != null && var0.length >= var1 && var1 >= 1 ? (var4 != null && (var4.length == 32 || var4.length == 48) ? (var3 != 0 && var3 != 1 ? -3 : (var6 != 0 && var6 != 1 ? -25 : (var5 != 1 && var5 != 2 && var5 != 3 && var5 != 4 ? -11 : (var5 == 1 ? (var3 == 1 && var1 % 8 != 0 ? -6 : (var6 == 0 ? TripleDesECB0(var0, var1, var2, var3, var4) : TripleDesECB1(var0, var1, var2, var3, var4))) : (var5 == 2 ? (var3 == 1 && var1 % 8 != 0 ? -6 : (var6 == 0 ? TripleDesCBC0(var0, var1, var2, var3, var4) : TripleDesCBC1(var0, var1, var2, var3, var4))) : (var5 == 3 ? (var6 == 0 ? TripleDesCFB0(var0, var1, var2, var3, var4) : TripleDesCFB1(var0, var1, var2, var3, var4)) : (var6 == 0 ? TripleDesOFB0(var0, var1, var2, var3, var4) : TripleDesOFB1(var0, var1, var2, var3, var4)))))))) : -2) : -1;
  }

  public static int TripleDesFile(String var0, String var1, int var2, byte[] var3, int var4, int var5) {
    byte[] var7 = new byte[24];
    byte[] var12 = new byte[4104];
    byte[] var13 = new byte[4104];
    if (var3 != null && (var3.length == 32 || var3.length == 48)) {
      if (var2 != 0 && var2 != 1) {
        return -3;
      } else {
        int var8 = Text2Ascii(var3, var7);
        if (var8 < 0) {
          return -4;
        } else if (var4 != 1 && var4 != 2 && var4 != 3 && var4 != 4) {
          return -11;
        } else if (var5 != 0 && var5 != 1) {
          return -25;
        } else if (var0 == null) {
          return -12;
        } else if (var1 == null) {
          return -13;
        } else {
          BufferedInputStream var14 = null;
          BufferedOutputStream var15 = null;
          File var16 = new File(var0);
          if (!var16.canRead()) {
            return -14;
          } else {
            File var17 = new File(var1);
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
                var15 = new BufferedOutputStream(new FileOutputStream(var1));
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
              if (var2 == 0) {
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

                int var10 = TripleDes(var12, var11, var13, var2, var3, var4, var5);
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

  public static int TripleDesECB0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
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
                if (!_$1(var10, var8)) {
                  return -8;
                } else if (var10 == 8) {
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

  public static int TripleDesECB1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
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
                if (!_$1(var10, var8)) {
                  return -8;
                } else if (var10 == 8) {
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

  public static int TripleDesCBC0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$6(var0, var1, var2, var3, var4, var5);
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
      if (var5 != null && var5.length == 8) {
        if (var4 == null || var4.length != 32 && var4.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var20 = Text2Ascii(var4, var16);
          if (var20 < 0) {
            return -4;
          } else {
            if (var4.length == 32) {
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
                System.arraycopy(var5, 0, var6, 0, 8);

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
                System.arraycopy(var5, 0, var6, 0, 8);

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
                  if (!_$1(var10, var7)) {
                    return -8;
                  } else if (var10 == 8) {
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

  public static int TripleDesCBC1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$5(var0, var1, var2, var3, var4, var5);
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
      if (var5 != null && var5.length == 8) {
        if (var4 == null || var4.length != 32 && var4.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var20 = Text2Ascii(var4, var16);
          if (var20 < 0) {
            return -4;
          } else {
            if (var4.length == 32) {
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
                System.arraycopy(var5, 0, var6, 0, 8);

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
                System.arraycopy(var5, 0, var6, 0, 8);

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
                  if (!_$1(var10, var7)) {
                    return -8;
                  } else if (var10 == 8) {
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

  public static int TripleDesCFB0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$4(var0, var1, var2, var3, var4, var5);
  }

  private static int _$4(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var10 = new byte[24];
    byte[] var11 = new byte[8];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var5 != null && var5.length == 8) {
        if (var4 == null || var4.length != 32 && var4.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var14 = Text2Ascii(var4, var10);
          if (var14 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var4.length == 32) {
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
              System.arraycopy(var5, 0, var6, 0, 8);

              for (var7 = 0; var7 < var1; ++var7) {
                _$2(var6, 0, var11, var12, var13);
                var2[var7] = (byte) ((var0[var7] ^ var6[0]) & 255);

                for (var8 = 0; var8 < 7; ++var8) {
                  var6[var8] = var6[var8 + 1];
                }

                var6[7] = var2[var7];
              }
            } else {
              System.arraycopy(var5, 0, var6, 0, 8);

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

  public static int TripleDesCFB1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$3(var0, var1, var2, var3, var4, var5);
  }

  private static int _$3(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var10 = new byte[24];
    byte[] var11 = new byte[8];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var5 != null && var5.length == 8) {
        if (var4 == null || var4.length != 32 && var4.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var14 = Text2Ascii(var4, var10);
          if (var14 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var4.length == 32) {
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
              System.arraycopy(var5, 0, var6, 0, 8);

              for (var7 = 0; var7 < var1; ++var7) {
                _$1(var6, 0, var11, var12, var13);
                var2[var7] = (byte) ((var0[var7] ^ var6[0]) & 255);

                for (var8 = 0; var8 < 7; ++var8) {
                  var6[var8] = var6[var8 + 1];
                }

                var6[7] = var2[var7];
              }
            } else {
              System.arraycopy(var5, 0, var6, 0, 8);

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

  public static int TripleDesOFB0(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$2(var0, var1, var2, var3, var4, var5);
  }

  private static int _$2(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var11 = new byte[24];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    byte[] var14 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var5 != null && var5.length == 8) {
        if (var4 == null || var4.length != 32 && var4.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var15 = Text2Ascii(var4, var11);
          if (var15 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var4.length == 32) {
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
              System.arraycopy(var5, 0, var6, 0, 8);

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
              System.arraycopy(var5, 0, var6, 0, 8);

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

  public static int TripleDesOFB1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
    byte[] var5 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    return _$1(var0, var1, var2, var3, var4, var5);
  }

  private static int _$1(byte[] var0, int var1, byte[] var2, int var3, byte[] var4, byte[] var5) {
    byte[] var6 = new byte[8];
    byte[] var11 = new byte[24];
    byte[] var12 = new byte[8];
    byte[] var13 = new byte[8];
    byte[] var14 = new byte[8];
    if (var0 != null && var2 != null && var0.length >= var1 && var1 >= 1) {
      if (var5 != null && var5.length == 8) {
        if (var4 == null || var4.length != 32 && var4.length != 48) {
          return -2;
        } else if (var3 != 0 && var3 != 1) {
          return -3;
        } else {
          int var15 = Text2Ascii(var4, var11);
          if (var15 < 0) {
            return -4;
          } else if (var2.length < var1) {
            return -10;
          } else {
            if (var4.length == 32) {
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
              System.arraycopy(var5, 0, var6, 0, 8);

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
              System.arraycopy(var5, 0, var6, 0, 8);

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

  private static boolean _$1(byte var0, byte[] var1) {
    int var2 = var0 - 0;

    for (int var3 = 0; var3 < var2; ++var3) {
      if (var1[8 - var2 + var3] != var0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] var0) {
    byte[] var1 = "005BC5D2E990F14C6ED6740D5DF3991B".getBytes();
    boolean var2 = false;
    String var3 = "2030E109553A15652E2D7F967C868FA7";
    byte[] var4 = new byte[var3.getBytes().length / 2];
    Text2Ascii(var3.getBytes(), var4);
    byte[] var6 = new byte[var4.length];
    System.out.println("\n\n-------------变化密码TripleDesECB测试(加加加)--------------");
    System.out.println("加密后字符串:");
    PrintHex(var4, var4.length);
    int var7 = TripleDesECB0(var4, var4.length, var6, 1, var1);
    System.out.println("解密后字符串:" + var7);
    PrintHex(var6, var6.length);
    System.out.println("\n\n---------变化密码TripleDesECB测试(加解加)--------------");
    var7 = TripleDesECB1(var4, var4.length, var6, 1, var1);
    System.out.println("解密后字符串:" + var7);
    PrintHex(var6, var6.length);
    System.out.println("\n\n-------变化密码TripleDesCBC测试(加加加)---------");
    var7 = TripleDesCBC0(var4, var4.length, var6, 1, var1);
    System.out.println("解密后字符串:" + var7);
    PrintHex(var6, var6.length);
    System.out.println("\n\n----------------");
    var7 = TripleDesCBC1(var4, var4.length, var6, 1, var1);
    System.out.println("解密后字符串:" + var7);
    PrintHex(var6, var6.length);
  }
}
