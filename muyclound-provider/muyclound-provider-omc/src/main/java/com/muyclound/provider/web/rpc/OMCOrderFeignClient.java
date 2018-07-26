package com.muyclound.provider.web.rpc;

import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.model.PageResponse;
import com.muyclound.provider.model.PageQueryOrderModel;
import com.muyclound.provider.model.PlaceOrderModel;
import com.muyclound.provider.model.entity.OrderDO;
import com.muyclound.provider.response.CannelOrderResponse;
import com.muyclound.provider.response.PageQueryOrderResponse;
import com.muyclound.provider.response.PlaceOrderResponse;
import com.muyclound.provider.response.QueryOrderResponse;
import com.muyclound.provider.service.OMCOrderFeignApi;
import com.muyclound.provider.service.OrderService;
import com.muyclound.wrapper.PageWrapper;
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
  private OrderService orderService;

  /**
   * 下单.
   *
   * @param model
   * @return
   */
  @Override
  public Wrapper<PlaceOrderResponse> placeOrder(PlaceOrderModel model) {
    OrderDO order = orderService.createOrder(model);

    PlaceOrderResponse response = order.parse(PlaceOrderResponse.class);

    return WrapMapper.ok(response);
  }

  /**
   * 查询订单.
   *
   * @param orderCode
   * @return
   */
  @Override
  public Wrapper<QueryOrderResponse> queryOrder(String orderCode) {
    OrderDO order = orderService.loadOrder(orderCode);

    QueryOrderResponse response = order.parse(QueryOrderResponse.class);

    return WrapMapper.ok(response);
  }

  /**
   * 查询订单-分页.
   *
   * @param model
   * @return
   */
  @Override
  public Wrapper<PageResponse> queryOrder(PageQueryOrderModel model) {
    Page<OrderDO> page = orderService.loadPage(model);

    PageResponse response = PageWrapper.wrap(page);

    return WrapMapper.ok(response);
  }

  /**
   * 取消订单.
   *
   * @param orderCode
   * @return
   */
  @Override
  public Wrapper<CannelOrderResponse> cannelOrder(String orderCode) {
    boolean result = orderService.cannelOrder(orderCode);

    CannelOrderResponse response = new CannelOrderResponse(result);

    return WrapMapper.ok(response);
  }
}
