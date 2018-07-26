package com.muyclound.model;

import java.util.List;
import lombok.Data;

/**
 * Created by yanglikai on 2018/7/26.
 */
@Data
public class PageResponse extends MUYResponse {
  private long total;  // 总记录数
  private int size;    // 每页显示条数
  private long pages;  // 总页数
  private int current; // 当前页
  private List list;   // 分页数据
}
