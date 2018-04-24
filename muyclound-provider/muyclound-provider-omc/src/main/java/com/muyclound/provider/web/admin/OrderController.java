package com.muyclound.provider.web.admin;

import com.muyclound.dc.enums.EventEnum;
import com.muyclound.dc.wrapper.DCWrapper;
import com.muyclound.provider.service.SimpleService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/17.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class OrderController {

  @Resource
  private SimpleService simpleService;

  @GetMapping(value = "/order/message")
  public String loadMessage() {
    return simpleService.loadMessage("");
  }

  @GetMapping(value = "/order/log")
  public String log(HttpServletRequest request) {
    DCWrapper.log(EventEnum.SHOW, request);
    return "ok";
  }
}
