package com.muyclound.provider.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.muyclound.model.MUYObject;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Data
@TableName(value = "my_order_item")
public class OrderItemDO extends MUYObject {
  @TableId
  private Long id;                // 主键
  @TableField(value = "order_code")
  private String orderCode;       // 订单号
  @TableField(value = "item_code")
  private String itemCode;        // 订单项编码
  @TableField(value = "goods_code")
  private String goodsCode;       // 商品编码
  @TableField(value = "goods_name")
  private String goodsName;       // 商品名称
  @TableField(value = "goods_type")
  private Integer goodsType;      // 商品类型
  @TableField(value = "order_nbr")
  private Integer orderNrb;       // 下单数量
  @TableField(value = "unit_price")
  private Integer unitPrice;      // 单价
  @TableField(value = "discount_amount")
  private Integer discountAmount; // 优惠金额
  @TableField(value = "create_time")
  private Date createTime;        // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;        // 更新时间
}
