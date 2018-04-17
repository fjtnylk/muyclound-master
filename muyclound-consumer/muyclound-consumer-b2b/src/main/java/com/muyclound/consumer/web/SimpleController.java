package com.muyclound.consumer.web;

import com.muyclound.provider.service.OMCOrderFeignApi;
import com.muyclound.provider.service.UMCMqMessageFeignApi;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/16.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SimpleController {
  @Resource
  private UMCMqMessageFeignApi umcMqMessageFeignApi;
  @Resource
  private OMCOrderFeignApi omcOrderFeignApi;

  @GetMapping("/consumer")
  @ResponseBody
  String consumer() {
    Wrapper<String> umcResult = umcMqMessageFeignApi.loadMessageKey("");
    Wrapper<String> omcResult = omcOrderFeignApi.loadOrderCode();

    return "UMCResult:" + umcResult.getResult() + ", OMCResult:" + omcResult.getResult();
  }
}