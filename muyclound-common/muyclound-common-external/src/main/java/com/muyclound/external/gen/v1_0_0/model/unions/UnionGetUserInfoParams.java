package com.muyclound.external.gen.v1_0_0.model.unions;

import com.muyclound.external.model.APIParams;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 工会用户信息获取接口参数.
 * Created by yanglikai on 2018/5/7.
 */
@Data
public class UnionGetUserInfoParams implements APIParams {
  private String userName;
  private String password;
  private String mobile;

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> parameters = new HashMap<>();
    if (userName != null) {
      parameters.put("username", userName);
    }

    if (password != null) {
      parameters.put("password", password);
    }

    if (mobile != null) {
      parameters.put("mobile", mobile);
    }

    return parameters;
  }
}
