package com.muyclound.provider.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.muyclound.model.MUYObject;
import com.muyclound.provider.enums.OrderChannelEnum;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;

/**
 * Created by yanglikai on 2018/7/25.
 */
@Data
@Builder
@TableName(value = "my_order")
public class OrderDO extends MUYObject {
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

  public static String buildOrderCode(OrderChannelEnum channel) {
    try {
      /* 并发情况保证序列号唯一 */
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    String date = new DateTime().toString("yyMMdd");
    String biz = channel.biz;
    String random = RandomStringUtils.randomNumeric(4);
    String serial = String.valueOf(new DateTime().getMillisOfDay());

    return date.concat(biz).concat(random).concat(serial);
  }

  public Integer getTotalAmount() {
    return totalAmount / 100;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount * 100;
  }
}
