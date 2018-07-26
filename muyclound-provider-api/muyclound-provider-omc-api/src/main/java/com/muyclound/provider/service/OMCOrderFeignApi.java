package com.muyclound.provider.service;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.provider.service.hystrix.OMCOrderApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by yanglikai on 2018/4/17.
 */
@FeignClient(value = GlobalConstant.OMC_PROVIDER, fallback = OMCOrderApiHystrix.class)
public interface OMCOrderFeignApi {
}
