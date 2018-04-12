package com.muyclound.base.log;

import com.muyclound.base.enums.ErrorCodeEnum;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Slf4j
public class MuycloundLogger {

  public static void logBizError(ErrorCodeEnum error) {
    String errorMsg = "code:" + error.code() + ", message:" + error.msg();
    log.error(String.format("<== BizError:{%s}, time:{%s}", errorMsg, getTime()));
  }

  public static void logBizError(String error) {
    log.error(String.format("<== BizError:{%s}, time:{%s}", error, getTime()));
  }

  public static void logBizDebug(String debug) {
    log.debug(String.format("<== BizDebug:{%s}, time:{%s}", debug, new Date()));
  }

  public static void logBizInfo(String info) {
    log.info(String.format("<== BizInfo:{%s}, time:{%s}", info, new Date()));
  }

  private static String getTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(new Date());
  }
}
