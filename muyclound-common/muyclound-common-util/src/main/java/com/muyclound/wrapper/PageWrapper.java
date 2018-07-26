package com.muyclound.wrapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.muyclound.model.PageResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/7/27.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageWrapper {

  public static PageResponse wrap(Page page) {
    PageResponse response = new PageResponse();
    response.setList(page.getRecords());
    response.setTotal(page.getTotal());
    response.setCurrent(page.getCurrent());
    response.setPages(page.getPages());
    response.setSize(page.getSize());

    return response;
  }
}
