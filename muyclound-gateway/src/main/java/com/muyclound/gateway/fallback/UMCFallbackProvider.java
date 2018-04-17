package com.muyclound.gateway.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/4/17.
 */
@Component
@Slf4j
public class UMCFallbackProvider implements FallbackProvider {

  @Override
  public ClientHttpResponse fallbackResponse(Throwable cause) {
    if (cause instanceof HystrixTimeoutException) {
      return response(HttpStatus.GATEWAY_TIMEOUT);
    } else {
      return fallbackResponse();
    }
  }

  @Override
  public String getRoute() {
    return "*";
  }

  @Override
  public ClientHttpResponse fallbackResponse() {
    return response(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ClientHttpResponse response(final HttpStatus status) {
    return new ClientHttpResponse() {
      @Override
      public HttpStatus getStatusCode() {
        return status;
      }

      @Override
      public int getRawStatusCode() {
        return status.value();
      }

      @Override
      public String getStatusText() {
        return status.getReasonPhrase();
      }

      @Override
      public void close() {
        log.info("close");
      }

      @Override
      public InputStream getBody() {
        String message = "{\"code\": 500,\"message\": \"微服务故障, 请稍后再试\"}";
        return new ByteArrayInputStream(message.getBytes());
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
      }
    };
  }
}
