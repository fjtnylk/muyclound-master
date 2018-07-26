package com.muyclound.provider.response;

import com.muyclound.model.MUYResponse;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Data
public class CannelOrderResponse extends MUYResponse {
  private boolean result;
  
  public CannelOrderResponse(boolean result) {
    this.result = result;
  }
}
