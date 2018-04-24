package com.muyclound.provider.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Data
public class AuthUserDto implements Serializable {
  private Long userId;
  private String userName;
  private String mobile;
  private List<String> role;

  public AuthUserDto() {
    this.userId = 0L;
  }

  public static AuthUserDto create() {
    return new AuthUserDto();
  }

  public AuthUserDto withUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public AuthUserDto withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public AuthUserDto withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public AuthUserDto withRole(List<String> role) {
    this.role = role;
    return this;
  }
}
