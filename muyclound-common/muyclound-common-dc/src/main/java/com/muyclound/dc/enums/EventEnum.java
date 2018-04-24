package com.muyclound.dc.enums;

/**
 * Created by yanglikai on 2018/4/23.
 */
public enum EventEnum {
  LOGIN("LOGIN", "登录"),
  LOGOUT("LOGOUT", "退出"),
  PAY("PAY", "支付"),
  REFUND("REFUND", "退款"),
  PLACE_ORDER("PLACE_ORDER", "下单"),
  ADD_CART("ADD_CART", "加入购物车"),
  CLICK("CLICK", "点击"),
  CANCEL("CANCEL", "取消"),
  SHOW("SHOW", "展示");

  private String code;
  private String desc;

  EventEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String value() {
    return code;
  }
}
