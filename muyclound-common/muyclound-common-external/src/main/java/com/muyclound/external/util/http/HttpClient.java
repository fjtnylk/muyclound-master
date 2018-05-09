package com.muyclound.external.util.http;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.muyclound.external.client.config.Decryptor;
import com.muyclound.external.client.config.Encryptor;
import com.muyclound.external.util.json.JSONUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.Charsets;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

/**
 * Created by yanglikai on 2018/3/16.
 */
public interface HttpClient {
  String get(String var1);

  String get(String var1, HttpClient.Params var2);

  String post(String var1, HttpClient.Params var2);

  public static class Params {
    private List<Header> headers;
    private Map<String, Object> data;
    private ContentType contentType;
    private Decryptor decryptor;
    private Encryptor encryptor;

    private Params() {
      this.headers = Lists.newArrayList();
      this.contentType = ContentType.DEFAULT_TEXT;
    }

    public static HttpClient.Params.Builder custom() {
      return new HttpClient.Params.Builder();
    }

    public List<Header> getHeaders() {
      return this.headers;
    }

    public void setHeaders(List<Header> headers) {
      this.headers = headers;
    }

    public ContentType getContentType() {
      return this.contentType;
    }

    public void setContentType(ContentType contentType) {
      this.contentType = contentType;
    }

    public Decryptor getDecryptor() {
      return decryptor;
    }

    public Encryptor getEncryptor() {
      return encryptor;
    }

    @Override
    public String toString() {
      if (this.contentType == ContentType.APPLICATION_JSON) {
        return JSONUtils.toJson(this.data);
      } else {
        List<NameValuePair> tmp = Lists.newArrayList();
        Iterator var2 = this.data.entrySet().iterator();

        while (var2.hasNext()) {
          Map.Entry<String, Object> entry = (Map.Entry) var2.next();
          tmp.add(new BasicNameValuePair((String) entry.getKey(), entry.getValue().toString()));
        }

        return URLEncodedUtils.format(tmp, Charsets.UTF_8);
      }
    }

    public HttpEntity toEntity() {
      if (!this.contentType.equals(ContentType.MULTIPART_FORM_DATA)) {
        return EntityBuilder.create().setContentType(this.contentType).setContentEncoding("utf-8").setText(this.toString()).build();
      }

      throw new IllegalArgumentException("content type multipart/form-data is not support!");
    }

    public static class Builder {
      private Map<String, Object> data = Maps.newHashMap();
      private List<Header> headers = Lists.newArrayList();
      private ContentType contentType;
      private Decryptor decryptor;
      private Encryptor encryptor;

      public Builder() {
      }

      public HttpClient.Params.Builder header(String k, String v) {
        this.headers.add(new BasicHeader(k, v));
        return this;
      }

      public HttpClient.Params.Builder add(Map<String, Object> params) {
        this.data.putAll(params);
        return this;
      }

      public HttpClient.Params.Builder add(String k, Object v) {
        if (k != null && v != null) {
          this.data.put(k, v);
          return this;
        }

        throw new IllegalArgumentException("The specified k or v cannot be null");
      }

      public HttpClient.Params.Builder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
      }

      public HttpClient.Params.Builder setDecryptor(Decryptor decryptor) {
        this.decryptor = decryptor;
        return this;
      }

      public HttpClient.Params.Builder setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
        return this;
      }

      public HttpClient.Params build() {
        HttpClient.Params params = new HttpClient.Params();
        params.headers = this.headers;
        params.contentType = this.contentType;
        params.data = this.data;
        params.decryptor = this.decryptor;
        params.encryptor = this.encryptor;

        return params;
      }
    }
  }
}
