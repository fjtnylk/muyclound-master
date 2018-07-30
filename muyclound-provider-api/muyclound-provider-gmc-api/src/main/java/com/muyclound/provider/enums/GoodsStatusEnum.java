package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/30.
 */
public enum GoodsStatusEnum {
  OFFLINE(0, "下架"),
  ONLINE(1, "上架"),;

  public int code;
  public String desc;

  GoodsStatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static GoodsStatusEnum parse(int target) {
    for (GoodsStatusEnum item : GoodsStatusEnum.values()) {
      if (item.code == target) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
