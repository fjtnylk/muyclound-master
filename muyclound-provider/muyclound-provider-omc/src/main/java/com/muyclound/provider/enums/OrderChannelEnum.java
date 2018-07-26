package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum OrderChannelEnum {
  B2B(10, "B2B"),
  S2B(20, "S2B"),
  ICBC(30, "ICBC"),
  ;

  public int code;
  public String desc;

  OrderChannelEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static OrderChannelEnum parse(int target) {
    for (OrderChannelEnum item : OrderChannelEnum.values()) {
      if (item.code == target) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
