package com.muyclound.provider.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muyclound.provider.model.entity.GoodsImagesDO;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/29.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoadGoodsImagesVO extends GoodsImagesDO {
  @JsonIgnore
  private Long id;
  @JsonIgnore
  private Date createTime;
  @JsonIgnore
  private Date updateTime;
}
