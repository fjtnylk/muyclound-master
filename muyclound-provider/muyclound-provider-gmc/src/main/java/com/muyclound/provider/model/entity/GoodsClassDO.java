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
@TableName(value = "my_goods_class")
public class GoodsClassDO extends MUYObject {
  @TableId
  private Long id;               // 主键
  @TableField(value = "g_class_code")
  private String classCode;      // 分类编码
  @TableField(value = "g_class_name")
  private String className;      // 分类名称
  @TableField(value = "level")
  private Integer level;         // 分类级别
  @TableField(value = "p_code")
  private String parentCode;     // 父分类编码
  @TableField(value = "sort")
  private Integer sort;          // 顺序
  @TableField(value = "is_display_flg")
  private Boolean displayFlg;    // 是否显示(true-显示、false-不显示)
  @TableField(value = "create_time")
  private Date createTime;       // 创建时间
  @TableField(value = "update_time")
  private Date updateTime;       // 更新时间
}
