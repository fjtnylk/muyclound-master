package com.muyclound.dc.config;

import com.muyclound.dc.CollectionData;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import lombok.Data;
import org.apache.http.HttpHeaders;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;

/**
 * Created by yanglikai on 2018/4/23.
 */
@Data
public class RequestConfig {
  private static final String HEADERS_OS_VERSION = "X-OS-Version";
  private static final String HEADERS_DEVICE = "X-Device";
  private static final String HEADERS_APP_NAME = "X-App-Name";
  private static final String HEADERS_APP_VERSION = "X-App-Version";

  private HttpServletRequest request;
  private Device device;

  public RequestConfig(HttpServletRequest request) {
    this.request = request;
    this.device = DeviceUtils.getCurrentDevice(request);
  }

  public String method() {
    return this.request.getMethod();
  }

  public String protocol() {
    return this.request.getProtocol();
  }

  public String host() {
    return this.request.getHeader(HttpHeaders.HOST);
  }

  public String url() {
    return this.request.getRequestURI();
  }

  public Integer port() {
    return this.request.getServerPort();
  }

  public CollectionData.Request.Headers headers() {
    CollectionData.Request.Headers headers = new CollectionData.Request.Headers();
    headers.setContentType(this.request.getHeader(HttpHeaders.CONTENT_TYPE));
    headers.setRemoveAddr(this.request.getRemoteAddr());
    headers.setUserAgent(this.request.getHeader(HttpHeaders.USER_AGENT));
    headers.setRefer(this.request.getHeader(HttpHeaders.REFERER));

    return headers;
  }

  public String parameter() {
    StringBuffer sb = new StringBuffer();

    Enumeration<String> parameters = this.request.getParameterNames();
    while (parameters.hasMoreElements()) {
      String key = parameters.nextElement();
      String value = this.request.getParameter(key);

      if (sb.length() > 0) {
        sb.append("&");
      }

      sb.append(key).append("=").append(value);
    }

    return sb.toString();
  }

  public String platform() {
    return device.getDevicePlatform().name();
  }

  public String version() {
    return this.request.getHeader(HEADERS_OS_VERSION);
  }

  public String device() {
    return this.request.getHeader(HEADERS_DEVICE);
  }

  public String appname() {
    return this.request.getHeader(HEADERS_APP_NAME);
  }

  public String appversion() {
    return this.request.getHeader(HEADERS_APP_VERSION);
  }

  public CollectionData.Request.Location location() {
    CollectionData.Request.Location location = new CollectionData.Request.Location();
    location.setLat("");
    location.setLon("");
    location.setProvince("");
    location.setCity("");

    return location;
  }
}
