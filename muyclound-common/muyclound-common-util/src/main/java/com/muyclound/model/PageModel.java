package com.muyclound.model;

import lombok.Data;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Data
public class PageModel extends MUYObject {
  private Integer page;
  private Integer pageSize;
}
