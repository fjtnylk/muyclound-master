package com.muyclound.provider.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.muyclound.model.MUYObject;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Data
@TableName(value = "my_goods_price")
public class GoodsPriceDO extends MUYObject {
  @TableId
  private Long id;             // 主键
  @TableField(value = "goods_code")
  private String goodsCode;    // 商品编码
  @TableField(value = "normal_price")
  private Integer normalPrice; // 正常售价
  @TableField(value = "cost_price")
  private Integer costPrice;   // 成本价
  @TableField(value = "create_time")
  private Date createTime;     // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;     // 更新时间
}
