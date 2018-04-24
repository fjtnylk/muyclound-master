package com.muyclound.provider.query;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Data
public class AuthSMSQuery implements Serializable {
  private String mobile;
  private String verifyCode;
}
