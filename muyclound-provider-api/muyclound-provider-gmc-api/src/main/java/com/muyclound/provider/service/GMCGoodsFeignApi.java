package com.muyclound.provider.service;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.provider.service.hystrix.GMCGoodsApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by yanglikai on 2018/7/30.
 */
@FeignClient(value = GlobalConstant.GMC_PROVIDER, fallback = GMCGoodsApiHystrix.class)
public interface GMCGoodsFeignApi {
}
