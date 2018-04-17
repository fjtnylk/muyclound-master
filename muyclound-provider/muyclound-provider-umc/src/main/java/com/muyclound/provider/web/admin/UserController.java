package com.muyclound.provider.web.admin;

import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/16.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

  @GetMapping(value = "/umc/message/key/load")
  public Wrapper message(String messageKey) {
    return WrapMapper.ok("yanglikai");
  }
}
