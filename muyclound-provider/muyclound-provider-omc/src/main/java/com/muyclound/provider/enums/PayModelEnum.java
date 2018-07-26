package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum PayModelEnum {
  ONLINE(10, "在线支付"),
  INTEGRAL(20, "积分支付"),
  CREDIT(30, "授信支付"),
  ;

  public int code;
  public String desc;

  PayModelEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static PayModelEnum parse(int target) {
    for (PayModelEnum item : PayModelEnum.values()) {
      if (item.code == target) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
