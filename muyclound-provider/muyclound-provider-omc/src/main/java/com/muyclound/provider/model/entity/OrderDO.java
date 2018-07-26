package com.muyclound.provider.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/25.
 */
@Data
@TableName(value = "my_order")
public class OrderDO implements Serializable {
  @TableId
  private Long id;              // 主键
  @TableField(value = "order_code")
  private String orderCode;     // 订单编号
  @TableField(value = "user_id")
  private Long userId;          // 用户编号
  @TableField(value = "order_status")
  private Integer orderStatus;  // 订单状态
  @TableField(value = "order_channel")
  private Integer orderChannel; // 订单渠道
  @TableField(value = "order_type")
  private Integer orderType;    // 订单类型
  @TableField(value = "total_amount")
  private Integer totalAmount;  // 总金额
  @TableField(value = "expired_time")
  private Date expiredTime;     // 过期时间
  @TableField(value = "create_time")
  private Date createTime;      // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;      // 更新时间
}
