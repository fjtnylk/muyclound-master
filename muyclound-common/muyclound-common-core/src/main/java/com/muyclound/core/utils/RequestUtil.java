package com.muyclound.core.utils;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.base.exception.BizException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by yanglikai on 2018/4/17.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestUtil {

  public static HttpServletRequest getRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }

  public static String getRemoteAddr(HttpServletRequest request) {
    String ipAddress = request.getHeader(GlobalConstant.X_REAL_IP);
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.X_FORWARDED_FOR);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.PROXY_CLIENT_IP);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.WL_PROXY_CLIENT_IP);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.HTTP_CLIENT_IP);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.HTTP_X_FORWARDED_FOR);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
      if (GlobalConstant.LOCALHOST_IP.equals(ipAddress) || GlobalConstant.LOCALHOST_IP_16.equals(ipAddress)) {
        //根据网卡取本机配置的IP
        InetAddress inet = null;
        try {
          inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
          log.error("获取IP地址, 出现异常={}", e.getMessage(), e);
        }
        assert inet != null;
        ipAddress = inet.getHostAddress();
      }
      log.info("获取IP地址 ipAddress={}", ipAddress);
    }
    // 对于通过多个代理的情况, 第一个IP为客户端真实IP,多个IP按照','分割 //"***.***.***.***".length() = 15
    if (ipAddress != null && ipAddress.length() > GlobalConstant.MAX_IP_LENGTH) {
      if (ipAddress.indexOf(GlobalConstant.Symbol.COMMA) > 0) {
        ipAddress = ipAddress.substring(0, ipAddress.indexOf(GlobalConstant.Symbol.COMMA));
      }
    }
    return ipAddress;
  }

  public static String getAuthHeader(HttpServletRequest request) {

    String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (StringUtils.isEmpty(authHeader)) {
      throw new BizException(ErrorCodeEnum.UMC10011040);
    }

    return authHeader;
  }
}
