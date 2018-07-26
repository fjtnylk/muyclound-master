package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum GoodsTypeEnum {
  NORMAL(10, "普通"),
  PROMOTE(20, "促销"),
  ;

  public int code;
  public String desc;

  GoodsTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static GoodsTypeEnum parse(int target) {
    for (GoodsTypeEnum item : GoodsTypeEnum.values()) {
      if (item.code == target) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
