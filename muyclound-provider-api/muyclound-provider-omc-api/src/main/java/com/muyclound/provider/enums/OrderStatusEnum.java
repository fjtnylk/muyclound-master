package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum OrderStatusEnum {
  CREATE(10, "创建"),
  CANCEL(90, "取消"),
  ;

  public int code;
  public String desc;

  OrderStatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static OrderStatusEnum parse(int target) {
    for (OrderStatusEnum item : OrderStatusEnum.values()) {
      if (item.code == target) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
