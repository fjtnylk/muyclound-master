package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum OrderBizEnum {
  B2B("01", "10", "B2B"),
  S2B("02", "20", "B2B"),
  ;

  public String biz;
  public String pre;
  public String desc;

  OrderBizEnum(String biz, String pre, String desc) {
    this.biz = biz;
    this.pre = pre;
    this.desc = desc;
  }
}
