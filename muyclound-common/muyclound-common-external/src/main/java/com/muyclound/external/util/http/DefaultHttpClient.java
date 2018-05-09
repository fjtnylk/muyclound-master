package com.muyclound.external.util.http;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.muyclound.external.client.config.Decryptor;
import com.muyclound.external.client.config.Encryptor;
import com.muyclound.external.exception.APIException;
import java.io.IOException;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Created by yanglikai on 2018/3/19.
 */
public class DefaultHttpClient implements HttpClient {
  private Integer maxRouteCount = Integer.valueOf(10);
  private Integer maxConnectionCount = Integer.valueOf(1000);
  private Integer socketTimeout = Integer.valueOf(10000);
  private Integer connectionTimeout = Integer.valueOf(2000);
  private CloseableHttpClient client = null;

  public DefaultHttpClient() {
    this.init();
  }

  public void init() {
    SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
    SSLContext sslContext = null;

    try {
      sslContextBuilder.loadTrustMaterial((KeyStore) null, new TrustStrategy() {
        @Override
        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
          return true;
        }
      });
      sslContext = sslContextBuilder.build();
    } catch (Exception var6) {
      throw new RuntimeException(var6);
    }

    SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, (String[]) null, NoopHostnameVerifier.INSTANCE);
    Registry registry =
        RegistryBuilder
            .create()
            .register("http", new PlainConnectionSocketFactory())
            .register("https", sslConnectionSocketFactory)
            .build();
    PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
    this.client = HttpClients.custom().setMaxConnPerRoute(this.maxRouteCount.intValue()).setMaxConnTotal(this.maxConnectionCount.intValue()).setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(this.connectionTimeout.intValue()).setSocketTimeout(this.socketTimeout.intValue()).build()).build();
  }

  @Override
  public String get(String var1) {
    Preconditions.checkArgument(var1 != null, "uri must be not null");
    HttpGet httpGet = new HttpGet(var1);

    try {
      CloseableHttpResponse response = this.client.execute(httpGet);
      return EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String get(String var1, Params var2) {
    Preconditions.checkArgument(var1 != null, "uri must be not null");
    Preconditions.checkArgument(var2 != null, "parameters must be not null");
    HttpGet httpGet = this.getGet(var1, var2);

    CloseableHttpResponse response = null;
    try {
      response = this.client.execute(httpGet);
      HttpEntity entity = response.getEntity();

      Decryptor decryptor = var2.getDecryptor();
      if (decryptor != null) {
        byte[] cipherText = IOUtils.toByteArray(entity.getContent());
        return decryptor.decrypt(cipherText);
      }

      return EntityUtils.toString(entity, "utf-8");
    } catch (IOException e) {
      throw new APIException(e.getMessage(), e);
    } catch (Exception e) {
      throw new APIException(e.getMessage(), e);
    } finally {
      close(response);
    }
  }

  @Override
  public String post(String var1, Params var2) {
    Preconditions.checkArgument(var1 != null, "uri must be not null");
    Preconditions.checkArgument(var2 != null, "parameters must be not null");
    HttpPost httpPost = getPost(var1, var2);

    CloseableHttpResponse response = null;
    try {
      response = this.client.execute(httpPost);
      HttpEntity entity = response.getEntity();

      Decryptor decryptor = var2.getDecryptor();
      if (decryptor != null) {
        byte[] cipherText = IOUtils.toByteArray(entity.getContent());
        return decryptor.decrypt(cipherText);
      }

      return EntityUtils.toString(entity, "utf-8");
    } catch (IOException e) {
      throw new APIException(e.getMessage());
    } finally {
      close(response);
    }
  }

  private HttpGet getGet(String uri, Params params) {
    HttpGet httpGet = new HttpGet(uri);
    Iterator headers = params.getHeaders().iterator();

    while (headers.hasNext()) {
      Header header = (Header) headers.next();
      httpGet.setHeader(header);
    }

    String query = URI.create(uri).getQuery();
    List<NameValuePair> pairs = Lists.newArrayList();
    if (query != null) {
      pairs = URLEncodedUtils.parse(query, Charsets.UTF_8);
    }

    if (((List) pairs).size() == 0) {
      uri = uri + "?";
    } else {
      uri = uri + "&";
    }

    String data = params.toString();
    if (data.length() > 0) {
      uri = uri + data;
    }

    httpGet.setURI(URI.create(uri));
    return httpGet;
  }

  private HttpPost getPost(String uri, Params params) {
    HttpPost httpPost = new HttpPost(uri);
    Iterator headers = params.getHeaders().iterator();

    while (headers.hasNext()) {
      Header header = (Header) headers.next();
      httpPost.setHeader(header);
    }

    if (params.getEncryptor() != null) {
      Encryptor encryptor = params.getEncryptor();
      encryptor.setContent(params.toString());

      httpPost.setEntity(encryptor.toEntity());
      return httpPost;
    }

    if (params.getContentType() == null
        || params.getContentType() != null && params.getContentType().equals(ContentType.DEFAULT_TEXT)) {
      params.setContentType(ContentType.create("application/x-www-form-urlencoded", Charsets.UTF_8));
    }

    httpPost.setEntity(params.toEntity());
    return httpPost;
  }

  private void close(CloseableHttpResponse response) {
    try {
      if (response != null) {
        response.close();
      }
    } catch (IOException e) {
      throw new APIException(e.getMessage(), e);
    }
  }
}
