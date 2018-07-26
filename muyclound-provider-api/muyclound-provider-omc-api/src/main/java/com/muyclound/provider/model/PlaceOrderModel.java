package com.muyclound.provider.model;

import com.muyclound.model.MUYObject;
import com.muyclound.provider.enums.OrderChannelEnum;
import com.muyclound.provider.enums.OrderStatusEnum;
import com.muyclound.provider.enums.OrderTypeEnum;
import java.math.BigDecimal;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Data
public class PlaceOrderModel extends MUYObject {
  private Long userId;                    // 用户编号
  private OrderStatusEnum orderStatus;   // 订单状态
  private OrderChannelEnum orderChannel; // 订单渠道
  private OrderTypeEnum orderType;       // 订单类型
  private Integer totalAmount;           // 总金额
}
