package com.muyclound.provider.web.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.model.PageResponse;
import com.muyclound.provider.model.PageQueryOrderModel;
import com.muyclound.provider.model.entity.OrderDO;
import com.muyclound.provider.response.QueryOrderResponse;
import com.muyclound.provider.service.OrderService;
import com.muyclound.wrapper.PageWrapper;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/17.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class OrderController {
  @Resource
  private OrderService orderService;

  /**
   * 订单分页.
   *
   * @param model
   * @return
   */
  @GetMapping(value = "/admin/order.page/load")
  @ResponseBody
  public Wrapper<PageResponse> loadPage(PageQueryOrderModel model) {
    Page<OrderDO> page = orderService.loadPage(model);

    PageResponse response = PageWrapper.wrap(page);

    return WrapMapper.ok(response);
  }

  /**
   * 订单详情.
   *
   * @param orderCode
   * @return
   */
  @GetMapping(value = "/admin/order.dtl/load")
  @ResponseBody
  public Wrapper<QueryOrderResponse> loadOrderDtl(String orderCode) {
    OrderDO order = orderService.loadOrder(orderCode);

    QueryOrderResponse response = order.parse(QueryOrderResponse.class);

    return WrapMapper.ok(response);
  }
}
