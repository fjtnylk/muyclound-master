package com.muyclound.config.properties;

import com.muyclound.base.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class MuycloundProperties {
  private AliyunProperties aliyun = new AliyunProperties();

  private AsyncTaskProperties task = new AsyncTaskProperties();

  private QiniuProperties qiniu = new QiniuProperties();

  private JobProperties job = new JobProperties();
}
