package com.muyclound.provider.service.hystrix;

import com.muyclound.model.PageResponse;
import com.muyclound.provider.model.PageQueryOrderModel;
import com.muyclound.provider.model.PlaceOrderModel;
import com.muyclound.provider.response.CannelOrderResponse;
import com.muyclound.provider.response.PageQueryOrderResponse;
import com.muyclound.provider.response.PlaceOrderResponse;
import com.muyclound.provider.response.QueryOrderResponse;
import com.muyclound.provider.service.OMCOrderFeignApi;
import com.muyclound.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/4/17.
 */
@Component
public class OMCOrderApiHystrix implements OMCOrderFeignApi {
  /**
   * 下单.
   *
   * @param model
   * @return
   */
  @Override
  public Wrapper<PlaceOrderResponse> placeOrder(PlaceOrderModel model) {
    return null;
  }

  /**
   * 查询订单.
   *
   * @param orderCode
   * @return
   */
  @Override
  public Wrapper<QueryOrderResponse> queryOrder(String orderCode) {
    return null;
  }

  /**
   * 查询订单-分页.
   *
   * @param model
   * @return
   */
  @Override
  public Wrapper<PageResponse> queryOrder(PageQueryOrderModel model) {
    return null;
  }

  /**
   * 取消订单.
   *
   * @param orderCode
   * @return
   */
  @Override
  public Wrapper<CannelOrderResponse> cannelOrder(String orderCode) {
    return null;
  }
}
