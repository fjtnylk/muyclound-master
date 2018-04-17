package com.muyclound.provider.service;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.provider.service.hystrix.OMCOrderApiHystrix;
import com.muyclound.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by yanglikai on 2018/4/17.
 */
@FeignClient(value = GlobalConstant.OMC_PROVIDER, fallback = OMCOrderApiHystrix.class)
public interface OMCOrderFeignApi {

  @GetMapping(value = "/api/omc/order/code/load")
  Wrapper<String> loadOrderCode();
}
