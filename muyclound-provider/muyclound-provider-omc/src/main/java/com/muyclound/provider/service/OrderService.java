package com.muyclound.provider.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.provider.model.PageQueryOrderModel;
import com.muyclound.provider.model.PlaceOrderModel;
import com.muyclound.provider.model.entity.OrderDO;

/**
 * Created by yanglikai on 2018/7/26.
 */
public interface OrderService {

  /**
   * 创建订单.
   *
   * @param target
   * @return
   */
  OrderDO createOrder(PlaceOrderModel target);

  /**
   * 分页加载.
   *
   * @param target
   * @return
   */
  Page<OrderDO> loadPage(PageQueryOrderModel target);

  /**
   * 加载订单.
   *
   * @param orderCode
   * @return
   */
  OrderDO loadOrder(String orderCode);

  /**
   * 取消订单.
   *
   * @param orderCode
   * @return
   */
  boolean cannelOrder(String orderCode);
}
