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
@TableName(value = "my_goods_images")
public class GoodsImagesDO extends MUYObject {
  @TableId
  private Long id;          // 主键
  @TableField(value = "goods_code")
  private String goodsCode; // 商品编码
  @TableField(value = "img_url")
  private String imgUrl;   // 图片链接
  @TableField(value = "width")
  private Integer width;   // 宽度
  @TableField(value = "height")
  private Integer height;  // 高度
  @TableField(value = "type")
  private String type;     // 图片类型(MAIN-主图、SMALL-分类小图、MIDDLE-首页中图、DETAIL-商品详情图)
  @TableField(value = "sort")
  private Integer sort;    // 顺序
  @TableField(value = "create_time")
  private Date createTime; // 创建时间
  @TableField(value = "update_time")
  private Date updateTime; // 更新时间
}
