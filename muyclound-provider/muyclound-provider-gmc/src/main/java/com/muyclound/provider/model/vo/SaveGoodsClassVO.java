package com.muyclound.provider.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muyclound.model.MUYObject;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SaveGoodsClassVO extends MUYObject {
  private Long id;
}
