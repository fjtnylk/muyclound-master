package com.muyclound.model;

import com.muyclound.util.mapper.MapperUtil;
import java.io.Serializable;

/**
 * Created by yanglikai on 2018/7/26.
 */
public abstract class MUYResponse implements Serializable {
  public MUYResponse() {
  }

  public <T> T parse(Class<T> target) {
    return MapperUtil.map(this, target);
  }
}
