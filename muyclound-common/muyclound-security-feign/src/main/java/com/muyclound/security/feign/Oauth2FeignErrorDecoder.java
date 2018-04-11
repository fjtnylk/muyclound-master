package com.muyclound.security.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.base.exception.BizException;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Slf4j
public class Oauth2FeignErrorDecoder implements ErrorDecoder {
  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {
    if (response.status() >= HttpStatus.BAD_REQUEST.value() && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
      return new HystrixBadRequestException("request exception wrapper");
    }

    ObjectMapper mapper = new ObjectMapper();

    try {
      HashMap map = mapper.readValue(response.body().asInputStream(), HashMap.class);
      Integer code = (Integer) map.get("code");
      String message = (String) map.get("message");
      if (code != null) {
        ErrorCodeEnum error = ErrorCodeEnum.getEnum(code);
        if (error != null) {
          if (error == ErrorCodeEnum.GL99990400) {
            throw new IllegalArgumentException(message);
          } else {
            throw new BizException(error);
          }
        } else {
          throw new BizException(ErrorCodeEnum.GL99990500, message);
        }
      }
    } catch (IOException ex) {
      log.error("Failed to process response body");
    }

    return defaultErrorDecoder.decode(methodKey, response);
  }
}
