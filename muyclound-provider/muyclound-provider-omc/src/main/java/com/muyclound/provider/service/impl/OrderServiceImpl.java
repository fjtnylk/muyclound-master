package com.muyclound.provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.provider.enums.OrderStatusEnum;
import com.muyclound.provider.model.PageQueryOrderModel;
import com.muyclound.provider.model.PlaceOrderModel;
import com.muyclound.provider.model.entity.OrderDO;
import com.muyclound.provider.repository.OrderRepository;
import com.muyclound.provider.service.OrderService;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Resource;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Service
public class OrderServiceImpl implements OrderService {
  @Resource
  private OrderRepository orderRepository;

  /**
   * 创建订单.
   *
   * @param target
   * @return
   */
  @Override
  public OrderDO createOrder(PlaceOrderModel target) {
    String orderCode = OrderDO.buildOrderCode(target.getOrderChannel());

    OrderDO order =
        OrderDO.builder()
            .orderCode(orderCode)
            .userId(target.getUserId())
            .orderStatus(target.getOrderStatus().code)
            .orderChannel(target.getOrderChannel().code)
            .orderType(target.getOrderType().code)
            .totalAmount(target.getTotalAmount().multiply(new BigDecimal(100)).intValue())
            .expiredTime(new DateTime(new Date()).plusMinutes(15).toDate())
            .createTime(new Date())
            .updateTime(new Date())
            .build();

    return _createOrder(order);
  }

  /**
   * 分页加载.
   *
   * @param target
   * @return
   */
  @Override
  public Page<OrderDO> loadPage(PageQueryOrderModel target) {
    Page page =
        new Page(
            target.getPage(),
            target.getPageSize());

    Wrapper wrap =
        new EntityWrapper()
            .where("1=1")
            .orderBy("create_time", false);

    if (target.getUserId() != null) {
      wrap.and("user_id={0}", target.getUserId());
    }

    return
        orderRepository.selectPage(page, wrap);
  }

  /**
   * 加载订单.
   *
   * @param orderCode
   * @return
   */
  @Override
  public OrderDO loadOrder(String orderCode) {
    return
        orderRepository.selectOne(
            new EntityWrapper<OrderDO>()
                .where("order_code={0}", orderCode));
  }

  /**
   * 取消订单.
   *
   * @param orderCode
   * @return
   */
  @Override
  public boolean cannelOrder(String orderCode) {
    OrderDO entity =
        OrderDO.builder()
            .orderStatus(OrderStatusEnum.CREATE.code)
            .updateTime(new Date())
            .build();

    Wrapper where =
        new EntityWrapper()
            .where("order_code={0}", orderCode);

    return
        orderRepository.update(entity, where);
  }

  private OrderDO _createOrder(OrderDO target) {
    orderRepository.insertOrUpdate(target);
    return target;
  }
}
