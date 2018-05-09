package com.muyclound.external.client.executor;

import com.muyclound.external.api.Api;
import com.muyclound.external.client.config.Decryptor;
import com.muyclound.external.client.config.Encryptor;
import com.muyclound.external.client.config.PostProcessor;
import com.muyclound.external.exception.APIException;
import com.muyclound.external.util.http.HttpClient;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yanglikai on 2018/3/16.
 */
public abstract class AbstractExecutor implements Executor {
  protected HttpClient httpClient;
  protected PostProcessor postProcessor;
  protected Decryptor decryptor;
  protected Encryptor encryptor;

  public AbstractExecutor() {
  }

  protected abstract void prepare(ExecutionContext context);

  @Override
  public void registerPostProcessor(PostProcessor postProcessor) {
    this.postProcessor = postProcessor;
  }

  @Override
  public void registerDecryptor(Decryptor decryptor) {
    this.decryptor = decryptor;
  }

  @Override
  public void registerEncryptor(Encryptor encryptor) {
    this.encryptor = encryptor;
  }

  @Override
  public String execute(ExecutionContext context) {
    this.prepare(context);
    String response = _execute(context);
    if (postProcessor == null) {
      return response;
    }

    return postProcessor.process(response);
  }

  protected String _execute(ExecutionContext context) {
    Api api = context.getApi();
    String method = api.getHttpMethod();
    HttpClient.Params.Builder builder = new HttpClient.Params.Builder();
    Map<String, Object> plainParams = context.getParams();
    Iterator var1 = plainParams.keySet().iterator();

    while (var1.hasNext()) {
      String key = (String) var1.next();
      Object value = plainParams.get(key);
      builder.add(key, value);
    }

    Iterator var2;
    String key;
    Map headers;

    if (api.getHeaders() != null && api.getHeaders().size() > 0) {
      headers = api.getHeaders();
      var2 = headers.keySet().iterator();

      while (var2.hasNext()) {
        key = (String) var2.next();
        builder.header(key, (String) headers.get(key));
      }
    }

    String url = context.getUrl();

    builder.setContentType(context.getContentType());
    builder.setDecryptor(decryptor);
    builder.setEncryptor(encryptor);

    HttpClient.Params params = builder.build();

    if ("GET".equalsIgnoreCase(method)) {
      return this.httpClient.get(url, params);
    } else if ("POST".equalsIgnoreCase(method)) {
      return this.httpClient.post(url, params);
    } else if ("PUT".equalsIgnoreCase(method)) {
      throw new APIException("Unknown http method, known(PUT)");
    } else if ("DELETE".equalsIgnoreCase(method)) {
      throw new APIException("Unknown http method, known(DELETE)");
    } else {
      throw new APIException("Unknown http method, known(GET, POST, PUT, DELETE)");
    }
  }
}
