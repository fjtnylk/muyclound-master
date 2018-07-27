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
@TableName(value = "my_goods_inventory")
public class GoodsInventoryDO extends MUYObject {
  @TableId
  private Long id;            // 主键
  @TableField(value = "goods_code")
  private String goodsCode;   // 商品编码
  @TableField(value = "goods_name")
  private String goodsName;   // 商品名称
  @TableField(value = "current_qty")
  private Integer currentQty; // 现货库存
  @TableField(value = "order_qty")
  private Integer orderQty;   // 预占库存
  @TableField(value = "create_time")
  private Date createTime;    // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;    // 更新时间
}
