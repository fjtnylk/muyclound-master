package com.muyclound.provider.service;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.model.PageResponse;
import com.muyclound.provider.model.PageQueryOrderModel;
import com.muyclound.provider.model.PlaceOrderModel;
import com.muyclound.provider.response.CannelOrderResponse;
import com.muyclound.provider.response.PageQueryOrderResponse;
import com.muyclound.provider.response.PlaceOrderResponse;
import com.muyclound.provider.response.QueryOrderResponse;
import com.muyclound.provider.service.hystrix.OMCOrderApiHystrix;
import com.muyclound.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by yanglikai on 2018/4/17.
 */
@FeignClient(value = GlobalConstant.OMC_PROVIDER, fallback = OMCOrderApiHystrix.class)
public interface OMCOrderFeignApi {

  /**
   * 下单.
   *
   * @param model
   * @return
   */
  Wrapper<PlaceOrderResponse> placeOrder(PlaceOrderModel model);

  /**
   * 查询订单.
   *
   * @param orderCode
   * @return
   */
  Wrapper<QueryOrderResponse> queryOrder(String orderCode);

  /**
   * 查询订单-分页.
   *
   * @param model
   * @return
   */
  Wrapper<PageResponse> queryOrder(PageQueryOrderModel model);

  /**
   * 取消订单.
   *
   * @param orderCode
   * @return
   */
  Wrapper<CannelOrderResponse> cannelOrder(String orderCode);
}
