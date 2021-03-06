package com.muyclound.core.handler;


import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.base.exception.BizException;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import java.nio.file.AccessDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 参数非法异常.
   *
   * @param e the e
   * @return the wrapper
   */
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseBody
  public Wrapper illegalArgumentException(IllegalArgumentException e) {
    log.error("参数非法异常={}", e.getMessage(), e);
    return WrapMapper.wrap(ErrorCodeEnum.GL99990400.code(), ErrorCodeEnum.GL99990400.msg());
  }

  /**
   * 参数效验异常.
   *
   * @param e the e
   * @return the wrapper
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Wrapper methodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.info("参数效验异常 ex={}", e.getMessage(), e);
    return WrapMapper.wrap(ErrorCodeEnum.GL99990400.code(), ErrorCodeEnum.GL99990400.msg());
  }

  /**
   * 业务异常.
   *
   * @param e the e
   * @return the wrapper
   */
  @ExceptionHandler(BizException.class)
  @ResponseBody
  public Wrapper businessException(BizException e) {
    log.error("业务异常={}", e.getMessage(), e);
    return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
  }

  /**
   * 无权限访问.
   *
   * @param e the e
   * @return the wrapper
   */
  @ExceptionHandler(AccessDeniedException.class)
  @ResponseBody
  public Wrapper unAuthorizedException(AccessDeniedException e) {
    return WrapMapper.wrap(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg());
  }

  /**
   * 无访问资源.
   *
   * @param e
   * @return
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseBody
  public Wrapper noHandlerFoundException(NoHandlerFoundException e) {
    return WrapMapper.wrap(ErrorCodeEnum.GL99990404.code(), ErrorCodeEnum.GL99990404.msg());
  }

  /**
   * 全局异常.
   *
   * @param e the e
   * @return the wrapper
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public Wrapper exception(Exception e) {
    log.info("保存全局异常信息 ex={}", e.getMessage(), e);
    return WrapMapper.error();
  }
}
