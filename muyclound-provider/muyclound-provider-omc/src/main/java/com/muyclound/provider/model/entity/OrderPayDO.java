package com.muyclound.provider.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.muyclound.model.MUYObject;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Data
@TableName(value = "my_order_pay")
public class OrderPayDO extends MUYObject {
  @TableId
  private Long id;            // 主键
  @TableField(value = "order_code")
  private String orderCode;   // 订单号
  @TableField(value = "pay_model")
  private Integer payModel;   // 支付方式(10-在线支付、20-积分支付、30-授信支付)
  @TableField(value = "pay_amount")
  private Integer payAmount;  // 支付金额
  @TableField(value = "pay_channel")
  private String payChannel;  // 支付渠道(Weixin-微信,Alipay-阿里)
  @TableField(value = "pay_flow_code")
  private String payFlowCode; // 支付流水号
  @TableField(value = "pay_time")
  private Date payTime;       // 支付时间
  @TableField(value = "pay_aspect")
  private Integer payAspect;  // 支付方向(10-正向、20-逆向)
  @TableField(value = "create_time")
  private Date createTime;    // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;    // 更新时间
}
