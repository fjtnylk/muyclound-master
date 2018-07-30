package com.muyclound.provider.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.muyclound.model.MUYObject;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Data
@TableName(value = "my_goods")
public class GoodsDO extends MUYObject {
  @TableId
  private Long id;           // 主键
  @NotBlank(message = "商品编码不允许为空")
  @Length(max = 12)
  @TableField(value = "goods_code")
  private String goodsCode;  // 商品编码
  @Length(max = 64)
  @TableField(value = "goods_name")
  private String goodsName;  // 商品名称
  @Min(value = 10)
  @Max(value = 20)
  @TableField(value = "goods_type")
  private Integer goodsType; // 商品类型(10-普通商品、20-促销商品)
  @Min(value = 0)
  @Max(value = 1)
  @TableField(value = "status")
  private Integer status;    // 商品状态(0-上架、1-下架)
  @Length(max = 12)
  @TableField(value = "spec")
  private String spec;       // 规格
  @Length(max = 6)
  @TableField(value = "unit")
  private String unit;       // 单位
  @Length(max = 12)
  @TableField(value = "origin")
  private String origin;     // 产地
  @TableField(value = "create_time")
  private Date createTime;   // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;   // 更新时间
}
