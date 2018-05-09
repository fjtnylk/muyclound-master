package com.muyclound.external.client.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.muyclound.external.api.Api;
import com.muyclound.external.client.auth.Auth;
import com.muyclound.external.client.auth.Basic;
import com.muyclound.external.client.auth.Sign;
import com.muyclound.external.client.auth.Simple;
import com.muyclound.external.client.auth.Token;
import com.muyclound.external.client.config.Decryptor;
import com.muyclound.external.client.config.Encryptor;
import com.muyclound.external.client.config.PostProcessor;
import com.muyclound.external.client.executor.BasicExecutor;
import com.muyclound.external.client.executor.ExecutionContext;
import com.muyclound.external.client.executor.Executor;
import com.muyclound.external.client.executor.SignExecutor;
import com.muyclound.external.client.executor.SimpleExecutor;
import com.muyclound.external.client.executor.TokenExecutor;
import com.muyclound.external.exception.APIException;
import com.muyclound.external.model.ErrorResponse;
import com.muyclound.external.model.Response;
import com.muyclound.external.util.http.DefaultHttpClient;
import com.muyclound.external.util.http.HttpClient;
import com.muyclound.external.util.json.JSONUtils;

/**
 * Created by yanglikai on 2018/3/16.
 */
public class DefaultClient implements Client {
  private HttpClient httpClient = new DefaultHttpClient();
  private Auth auth;
  private PostProcessor postProcessor;
  private Decryptor decryptor;
  private Encryptor encryptor;

  public DefaultClient(Auth auth) {
    this.auth = auth;
  }

  public DefaultClient(Auth auth, PostProcessor postProcessor) {
    this.auth = auth;
    this.postProcessor = postProcessor;
  }

  public DefaultClient(Auth auth, PostProcessor postProcessor, Encryptor encryptor) {
    this.auth = auth;
    this.postProcessor = postProcessor;
    this.encryptor = encryptor;
  }

  public DefaultClient(Auth auth, PostProcessor postProcessor, Decryptor decryptor) {
    this.auth = auth;
    this.postProcessor = postProcessor;
    this.decryptor = decryptor;
  }

  public DefaultClient(Auth auth, PostProcessor postProcessor, Decryptor decryptor, Encryptor encryptor) {
    this.auth = auth;
    this.postProcessor = postProcessor;
    this.decryptor = decryptor;
    this.encryptor = encryptor;
  }

  @Override
  public <T> T invoke(Api api) {
    Preconditions.checkArgument(api != null, "api must not be null!");
    Preconditions.checkArgument(api.getAPIParams() != null, "api parameters must not be null!");

    String result = this._execute(this.auth, api);
    this.handleError(result);
    Response<T> response = JSONUtils.toClassBean(result, api.getResultModelClass());
    return response.getResponse();
  }

  @Override
  public String execute(Api api) {
    Preconditions.checkArgument(this.auth != null, "auth must not be null!");
    Preconditions.checkArgument(api != null, "api must not be null!");

    return this._execute(this.auth, api);
  }

  private String _execute(Auth auth, Api api) {
    Preconditions.checkArgument(this.auth != null, "auth must not be null!");
    Preconditions.checkArgument(api != null, "api must not be null!");

    Executor executor = null;
    switch (auth.getType().ordinal()) {
      case 0:
        if ((auth instanceof Sign) == false) {
          throw new APIException("Auth type not match, expected sign");
        }

        executor = new SignExecutor(this.httpClient, (Sign) auth);
        break;
      case 1:
        if ((auth instanceof Token) == false) {
          throw new APIException("Auth type not match, expected token");
        }
        executor = new TokenExecutor(this.httpClient, (Token) auth);
        break;
      case 2:
        if ((auth instanceof Simple) == false) {
          throw new APIException("Auth type not match, expected simple");
        }
        executor = new SimpleExecutor(this.httpClient, (Simple) auth);
        break;
      case 3:
        if ((auth instanceof Basic) == false) {
          throw new APIException("Auth type not match, expected basic");
        }
        executor = new BasicExecutor(this.httpClient, (Basic) auth);
        break;
      default:
        throw new APIException("Unknown auth type");
    }

    executor.registerPostProcessor(postProcessor);
    executor.registerDecryptor(decryptor);
    executor.registerEncryptor(encryptor);

    ExecutionContext context = new ExecutionContext();
    context.setApi(api);
    context.setUrl(api.getHttpUrl());
    return executor.execute(context);
  }

  private void handleError(String result) {
    Response response = JSONUtils.toBean(result, new TypeReference<Response<ErrorResponse>>() {
    });

    if (response != null && response.getErrorResponse() != null) {
      ErrorResponse errorResponse = (ErrorResponse) response.getErrorResponse();
      throw new APIException(errorResponse.toString());
    }
  }
}
