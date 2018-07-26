package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum PayAspectEnum {
  F(10, "正向"),
  R(20, "逆向"),
  ;

  public int code;
  public String desc;

  PayAspectEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static PayAspectEnum parse(int target) {
    for (PayAspectEnum item : PayAspectEnum.values()) {
      if (item.code == (target)) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
