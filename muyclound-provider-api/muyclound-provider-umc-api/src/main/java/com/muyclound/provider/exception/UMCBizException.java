package com.muyclound.provider.exception;

import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.base.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Slf4j
public class UMCBizException extends BizException {

  public UMCBizException() {
  }

  public UMCBizException(int code, String msgFormat, Object... args) {
    super(code, msgFormat, args);
    log.error("<== UMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }

  public UMCBizException(int code, String msg) {
    super(code, msg);
    log.error("<== UMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }

  public UMCBizException(ErrorCodeEnum codeEnum) {
    super(codeEnum.code(), codeEnum.msg());
    log.error("<== UMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }

  public UMCBizException(ErrorCodeEnum codeEnum, Object... args) {
    super(codeEnum, args);
    log.error("<== UMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }
}
