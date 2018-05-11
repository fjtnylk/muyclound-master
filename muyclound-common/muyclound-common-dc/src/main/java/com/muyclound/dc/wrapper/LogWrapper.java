package com.muyclound.dc.wrapper;

import com.muyclound.dc.CollectionData;
import com.muyclound.dc.DataCollectionLog;
import com.muyclound.dc.config.CollectionConfig;
import com.muyclound.dc.config.ProjectConfig;
import com.muyclound.dc.config.RequestConfig;
import com.muyclound.dc.config.SessionConfig;
import com.muyclound.dc.config.UserConfig;
import com.muyclound.dc.enums.EventEnum;
import javax.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 数据采集包装类.
 * Created by yanglikai on 2018/4/24.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogWrapper {

  public static void collection(EventEnum event, CollectionConfig config) {
    CollectionDataWrapper wrapper = new CollectionDataWrapper(new CollectionData());
    wrapper.config(event);
    wrapper.config(config);

    collection(wrapper);
  }

  public static void collection(EventEnum event, HttpServletRequest request) {
    CollectionDataWrapper wrapper = new CollectionDataWrapper(new CollectionData());
    wrapper.config(event);
    wrapper.config(new ProjectConfig());
    wrapper.config(new UserConfig(request));
    wrapper.config(new SessionConfig());
    wrapper.config(new RequestConfig(request));

    collection(wrapper);
  }

  private static void collection(CollectionDataWrapper wrapper) {
    DataCollectionLog.log(wrapper.data());
  }
}
