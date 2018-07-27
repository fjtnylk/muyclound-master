package com.muyclound.provider.model;

import com.muyclound.model.MUYObject;
import com.muyclound.provider.enums.GoodsTypeEnum;
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
  private Long userId;                   // 用户编号
  private OrderStatusEnum orderStatus;   // 订单状态
  private OrderChannelEnum orderChannel; // 订单渠道
  private OrderTypeEnum orderType;       // 订单类型
  private BigDecimal totalAmount;        // 总金额

  @Data
  public static class PlaceOrderGoodsModel extends MUYObject {
    private String goodsCode;        // 商品编码
    private Integer orderNbr;        // 下单数量
    private Integer discountAmount;  // 优惠金额
  }
}
