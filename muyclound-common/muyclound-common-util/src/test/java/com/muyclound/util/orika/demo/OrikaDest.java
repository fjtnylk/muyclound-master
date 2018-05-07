package com.muyclound.util.orika.demo;

import com.muyclound.util.mapper.annotation.MapperProperty;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/7.
 */
@Data
//@MapperSource(value = OrikaSource.class)
public class OrikaDest {
  @MapperProperty(value = "userId")
  private String userid;
  @MapperProperty(value = "userName")
  private String username;
  private Integer age;
}
