package com.muyclound.provider.enums;

/**
 * Created by yanglikai on 2018/7/26.
 */
public enum PayChannelEnum {
  WEIXIN("Weixin", "微信"),
  ALIPAY("Alipay", "支付宝"),
  ;

  public String code;
  public String desc;

  PayChannelEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static PayChannelEnum parse(String target) {
    for (PayChannelEnum item : PayChannelEnum.values()) {
      if (item.code.equals(target)) {
        return item;
      }
    }

    throw new IllegalArgumentException(String.format("no match is found for %s", target));
  }
}
