package com.muyclound.dc.wrapper;

import com.muyclound.dc.CollectionData;
import com.muyclound.dc.config.CollectionConfig;
import com.muyclound.dc.config.CustomerConfig;
import com.muyclound.dc.config.ProjectConfig;
import com.muyclound.dc.config.RequestConfig;
import com.muyclound.dc.config.ResponseConfig;
import com.muyclound.dc.config.SessionConfig;
import com.muyclound.dc.config.UserConfig;
import com.muyclound.dc.enums.EventEnum;
import com.muyclound.dc.enums.LogLevelEnum;
import com.muyclound.json.JSONUtil;
import java.util.Objects;

/**
 * 数据采集参数包装.
 * Created by yanglikai on 2018/4/23.
 */
public class CollectionDataWrapper {
  private CollectionData collection;

  public CollectionDataWrapper(CollectionData value) {
    this.collection = value;
  }

  public CollectionData config(CollectionConfig collectionConfig) {
    /* 配置-项目信息 */
    config(collectionConfig.getProjectConfig());

    /* 配置-用户信息 */
    config(collectionConfig.getUserConfig());

    /* 配置-会话信息 */
    config(collectionConfig.getSessionConfig());

    /* 配置-请求信息 */
    config(collectionConfig.getRequestConfig());

    /* 配置-响应信息 */
    config(collectionConfig.getResponseConfig());

    /* 配置-自定义信息 */
    config(collectionConfig.getCustomerConfig());

    return collection;
  }

  public CollectionData config(EventEnum eventEnum) {
    collection.setEvent(eventEnum.value());
    return collection;
  }

  public CollectionData config(LogLevelEnum logLevelEnum) {
    collection.setLevel(logLevelEnum.level());
    return collection;
  }

  public CollectionData config(ProjectConfig config) {
    Objects.requireNonNull(config, "project config must not be null");

    collection.setProjectCode(config.getProjectCode());
    collection.setProjectName(config.getProjectName());
    return collection;
  }

  public CollectionData config(UserConfig config) {
    Objects.requireNonNull(config, "user config must not be null");

    CollectionData.User user = new CollectionData.User();
    user.setId(config.getUserid());
    user.setName(config.getUsername());

    collection.setUser(user);
    return collection;
  }

  public CollectionData config(SessionConfig config) {
    Objects.requireNonNull(config, "session config must not be null");

    collection.setSessionId(config.getSessionId());
    collection.setEntryTime(config.getEntryTime());
    collection.setLeaveTime(config.getLeaveTime());
    return collection;
  }

  public CollectionData config(RequestConfig config) {
    Objects.requireNonNull(config, "request config must not be null");

    CollectionData.Request request = collection.getRequest();

    request.setMethod(config.method());
    request.setScheme(config.protocol());
    request.setHost(config.host());
    request.setPath(config.url());
    request.setPort(config.port());
    request.setHeaders(config.headers());
    request.setParamters(config.parameter());

    request.setPlatform(config.platform());
    request.setPlatformVersion(config.version());
    request.setDevice(config.device());
    request.setAppName(config.appname());
    request.setAppVersion(config.appversion());
    request.setLocation(config.location());

    return collection;
  }

  public CollectionData config(ResponseConfig config) {
    if (config == null) {
      collection.setResponse(CollectionData.defaultResponse());
      return collection;
    }

    CollectionData.Response response = new CollectionData.Response();
    response.setStatus(config.getStatus());
    response.setResponseTime(config.getResponseTime());

    CollectionData.Response.Content content =
        JSONUtil.toBean(config.getContent(), CollectionData.Response.Content.class);
    response.setContent(content);

    collection.setResponse(response);
    return collection;
  }

  public CollectionData config(CustomerConfig config) {
    return collection;
  }

  public CollectionData data() {
    return collection;
  }
}
