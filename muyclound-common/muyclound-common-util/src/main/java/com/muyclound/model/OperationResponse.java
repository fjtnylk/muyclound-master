package com.muyclound.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/29.
 */
@Data
public class OperationResponse extends MUYObject {
  @JsonProperty(value = "is_success")
  private Boolean successFlg;

  public OperationResponse(boolean successFlg) {
    this.successFlg = successFlg;
  }
}
