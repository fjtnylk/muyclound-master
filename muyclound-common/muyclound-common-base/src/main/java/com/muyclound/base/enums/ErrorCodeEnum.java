package com.muyclound.base.enums;

/**
 * Created by yanglikai on 2018/4/11.
 */
public enum ErrorCodeEnum {
  // ============================================9999.全局错误==============================================
  GL99990400(99990400, "参数异常"),

  GL99990401(99990401, "无访问权限"),

  GL99990500(99990500, "未知异常"),

  GL99990403(99990403, "无权访问"),

  GL99990404(99990404, "找不到指定资源"),

  GL99990001(99990001, "注解使用错误"),

  GL99990002(99990002, "微服务不在线,或者网络超时"),
  // ============================================999999.全局错误==============================================

  // ============================================1001.用户中心==============================================
  UMC10010001(10010001, "会话超时,请刷新页面重试"),

  UMC10010002(10010002, "TOKEN解析失败"),

  UMC10011001(10011001, "用户Id不能为空"),

  UMC10011002(10011002, "找不到用户,loginName=%s"),

  UMC10011040(10011040, "解析header失败"),

  UMC10011041(10011041, "页面已过期,请重新登录"),

  UMC10012001(10012001, "用户名密码错误"),

  UMC10012002(10012002, "验证码错误"),
  // ============================================1001.用户中心==============================================

  // ============================================1002.订单中心==============================================
  // ============================================1002.订单中心==============================================

  // ============================================1003.支付中心==============================================
  // ============================================1003.支付中心==============================================

  // ============================================1004.商品中心==============================================
  // ============================================1004.商品中心==============================================

  // ============================================1005.库存中心==============================================
  // ============================================1005.库存中心==============================================

  GL99999999(99999999, "系统无法使用");

  private int code;
  private String msg;

  public String msg() {
    return msg;
  }

  public int code() {
    return code;
  }

  ErrorCodeEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static ErrorCodeEnum getEnum(int code) {
    for (ErrorCodeEnum el : ErrorCodeEnum.values()) {
      if (el.code() == code) {
        return el;
      }
    }

    return null;
  }
}
