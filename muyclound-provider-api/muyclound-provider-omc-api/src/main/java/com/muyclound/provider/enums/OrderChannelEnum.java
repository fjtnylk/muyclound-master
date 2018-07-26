package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum OrderChannelEnum {
  B2B(10, "01", "10", "B2B"),
  S2B(20, "02", "10", "S2B"),
  ICBC(30, "03", "10", "ICBC"),
  ;

  public int code;
  public String biz;
  public String pre;
  public String desc;

  OrderChannelEnum(int code, String biz, String pre, String desc) {
    this.code = code;
    this.biz = biz;
    this.pre = pre;
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
