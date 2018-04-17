package com.muyclound.provider.web.rpc;

import com.muyclound.provider.service.OMCOrderFeignApi;
import com.muyclound.provider.service.SimpleService;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/17.
 */
@RestController
@Slf4j
public class OMCOrderFeignClient implements OMCOrderFeignApi {
  @Resource
  private SimpleService simpleService;

  @Override
  public Wrapper<String> loadOrderCode() {
    return WrapMapper.ok(simpleService.loadMessage(""));
  }
}
