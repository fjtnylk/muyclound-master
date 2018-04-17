package com.muyclound.provider.exception;

import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.base.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Slf4j
public class OMCBizException extends BizException {

  public OMCBizException() {
  }

  public OMCBizException(int code, String msgFormat, Object... args) {
    super(code, msgFormat, args);
    log.error("<== OMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }

  public OMCBizException(int code, String msg) {
    super(code, msg);
    log.error("<== OMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }

  public OMCBizException(ErrorCodeEnum codeEnum) {
    super(codeEnum.code(), codeEnum.msg());
    log.error("<== OMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }

  public OMCBizException(ErrorCodeEnum codeEnum, Object... args) {
    super(codeEnum, args);
    log.error("<== OMCBizException, code:" + this.code + ", message:" + super.getMessage());
  }
}
