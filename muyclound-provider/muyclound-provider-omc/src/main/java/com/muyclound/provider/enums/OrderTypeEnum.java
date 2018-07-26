package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum OrderTypeEnum {
  NORMAL(10, "普通订单"),
  PRESELL(20, "预售订单"),
  GROUP(30, "拼团订单"),

  RETURN(90, "退换货订单"),
  ;

  public int code;
  public String desc;

  OrderTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static OrderTypeEnum parse(int target) {
    for (OrderTypeEnum item : OrderTypeEnum.values()) {
      if (item.code == target) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
