package com.muyclound.model;

import lombok.Data;

/**
 * Created by yanglikai on 2018/7/30.
 */
@Data
public class PageObject extends MUYObject {
  private Integer page;
  private Integer size;
}
