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
@TableName(value = "my_goods")
public class GoodsDO extends MUYObject {
  @TableId
  private Long id;           // 主键
  @TableField(value = "goods_code")
  private String goodsCode;  // 商品编码
  @TableField(value = "goods_name")
  private String goodsName;  // 商品名称
  @TableField(value = "goods_type")
  private Integer goodsType; // 商品类型(10-普通商品、20-促销商品)
  @TableField(value = "status")
  private Integer status;    // 商品状态(0-上架、1-下架)
  @TableField(value = "spec")
  private String spec;       // 规格
  @TableField(value = "unit")
  private String unit;       // 单位
  @TableField(value = "origin")
  private String origin;     // 产地
  @TableField(value = "create_time")
  private Date createTime;   // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;   // 更新时间
}
