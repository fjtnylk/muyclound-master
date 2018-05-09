package com.muyclound.external.client.config.postprocessor.icbc;

import com.muyclound.external.client.config.PostProcessorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2018/3/20.
 */
public class ICBCAccessTokenGetContext implements PostProcessorContext<String> {
  private String keypath;

  public ICBCAccessTokenGetContext(String keypath) {
    if (StringUtils.isBlank(keypath)) {
      throw new IllegalArgumentException("keypath must be not null");
    }

    this.keypath = keypath;
  }

  @Override
  public String getTarget() {
    return keypath;
  }
}
