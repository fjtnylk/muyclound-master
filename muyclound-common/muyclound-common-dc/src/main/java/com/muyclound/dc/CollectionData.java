package com.muyclound.dc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
 * 数据采集参数.
 * <p>
 * {
 * "id":"95975e06-e7ac-4b7d-991f-80ac24859bf7",
 * "project_name":"生鲜",
 * "project_code":"SX",
 * "user":{
 * "id":"2",
 * "name":"YangLikai"
 * },
 * "session_id":"pchNWq3oMYmX8QXczYDQAg",
 * "level":"info",
 * "entry_time":"2018-01-04 14:30:29",
 * "leave_time":"2018-01-04 14:30:29",
 * "event":"login",
 * "request":{
 * "method":"GET",
 * "scheme":"https",
 * "host":"b2b-masterdata01-prd",
 * "path":"/login",
 * "port":443,
 * "headers":{
 * "content_type":"application/json",
 * "remove_addr":"192.321.22.21",
 * "user_agent":"Mozilla/3.0 ",
 * "refer":"http://b2b-masterdata01-prd/shop/productcode=1"
 * },
 * "paramters":"shopcode=4&productcode=11",
 * "request_time":"2018-01-04 14:30:29",
 * "platform":"ios",
 * "platform_version":"ios 11.3",
 * "device":"iphone6",
 * "app_name":"生鲜",
 * "app_version":"1.0.1",
 * "location":{
 * "lat":"31.2240453",
 * "lon":"121.1965691",
 * "province":"上海市",
 * "city":"上海市"
 * },
 * "ext":{
 * <p>
 * }
 * },
 * "reponse":{
 * "status":200,
 * "content":{
 * "response":true,
 * "desc":"请求成功",
 * "code":"0"
 * },
 * "reponse_time":"2018-01-04 14:30:29",
 * "time_ms":117
 * },
 * "customer_attribute":{
 * <p>
 * },
 * "ts":"2018-01-04 14:30:29"
 * }
 * Created by yanglikai on 2018/4/23.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CollectionData {
  private String id;
  private String projectName;
  private String projectCode;
  private User user;
  private String sessionId;
  private String level;
  private String entryTime;
  private String leaveTime;
  private String event;
  private Request request;
  private Response response;
  @JsonProperty(value = "customer_attribute")
  private Customer customer;
  @JsonProperty(value = "ts")
  private String timestamp;

  public CollectionData() {
    this.id = UUID.randomUUID().toString();
    this.level = "INFO";
    this.user = new User();
    this.request = new Request();
    this.response = new Response();
    this.customer = new Customer();
    this.timestamp = formatDate(new Date());
  }

  public static Response defaultResponse() {
    return new Response();
  }


  /**
   * 用户信息.
   */
  @Data
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class User {
    private String id;
    private String name;
  }

  /**
   * 请求信息.
   */
  @Data
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class Request {
    private String method;
    private String scheme;
    private String host;
    private String path;
    private Integer port;
    private Headers headers;
    private String paramters;
    private String requestTime;
    private String platform;
    private String platformVersion;
    private String device;
    private String appName;
    private String appVersion;
    private Location location;
    private Ext ext;

    public Request() {
      this.requestTime = formatDate(new Date());
      this.headers = new Headers();
      this.location = new Location();
      this.ext = new Ext();
    }

    /**
     * 请求头信息.
     */
    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Headers {
      private String contentType;
      private String removeAddr;
      private String userAgent;
      private String refer;
    }

    /**
     * 地理位置信息.
     */
    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Location {
      private String lat;
      private String lon;
      private String province;
      private String city;
    }

    /**
     * 扩展信息.
     */
    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Ext {
    }
  }

  /**
   * 响应信息.
   */
  @Data
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class Response {
    private Integer status;
    private Content content;
    private String responseTime;
    @JsonProperty(value = "time_ms")
    private Long millisecond;

    public Response() {
      this.status = 200;
      this.content = new Content();
      this.responseTime = formatDate(new Date());
      this.millisecond = 117L;
    }

    /**
     * 响应内容.
     */
    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Content {
      private Boolean response;
      private String desc;
      private String code;

      public Content() {
        this.response = true;
        this.desc = "请求成功";
        this.code = "200";
      }
    }
  }

  /**
   * 自定义信息.
   */
  @Data
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class Customer {
  }

  private static String formatDate(Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return simpleDateFormat.format(date);
  }
}
