package com.muyclound.external.gen.v1_0_0.model.icbc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import com.muyclound.external.model.APIParams;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * 工行-图文消息发送接口参数
 * Created by yanglikai on 2018/3/22.
 */
@Data
public class ICBCSendMessageNewsParams extends ICBCCryptParams implements APIParams {
  @JsonProperty(value = "touser")
  private String toUser;
  @JsonProperty(value = "msgtype")
  private String msgType;
  @JsonProperty(value = "news")
  private ICBCSendMessageNewsParams.News news;
  @JsonProperty(value = "isAllowSend")
  private String isAllowSend;

  public ICBCSendMessageNewsParams(String accessToken, String sessionKey) {
    super(accessToken, sessionKey);
    this.isAllowSend = "0";
    this.msgType = "news";
  }

  @Data
  public static class News {
    @JsonProperty(value = "articles")
    private List<Articles> articles;

    public News() {
      this.articles = new ArrayList<>();
    }

    public static News create() {
      return new News();
    }

    public News add(Articles articles) {
      this.articles.add(articles);
      return this;
    }
  }

  @Data
  public static class Articles {
    private String title;
    private String description;
    private String url;
    private String picurl;

    public Articles() {
    }

    private Articles(String title, String desc, String url, String picurl) {
      this.title = title;
      this.description = desc;
      this.url = url;
      this.picurl = picurl;
    }

    public static Articles create(String title, String desc, String url, String picurl) {
      return new Articles(title, desc, url, picurl);
    }
  }

  @Override
  public Map<String, Object> toParams() {
    Map<String, Object> params = Maps.newHashMap();
    params.put("touser", toUser);
    params.put("msgtype", msgType);
    params.put("news", news);
    params.put("isAllowSend", isAllowSend);

    return params;
  }
}
