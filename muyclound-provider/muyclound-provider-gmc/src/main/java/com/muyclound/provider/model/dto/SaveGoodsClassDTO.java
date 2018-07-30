package com.muyclound.provider.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muyclound.provider.model.bo.SaveGoodsClassBO;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/27.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SaveGoodsClassDTO extends SaveGoodsClassBO {
}
