package com.muyclound.external.client.config;


import com.muyclound.external.exception.APIException;

/**
 * Created by yanglikai on 2018/3/19.
 */
public abstract class AbstractPostProcessor implements PostProcessor {
  protected PostProcessorContext context;

  public AbstractPostProcessor() {
  }

  public AbstractPostProcessor(PostProcessorContext context) {
    this.context = context;
  }

  @Override
  public String process(String response) {
    if (response == null || response.length() == 0) {
      throw new APIException("response is empty");
    }

    if (isOK(response)) {
      return success(response);
    }

    return failed(response);
  }

  public abstract boolean isOK(String target);

  public abstract String success(String target);

  public abstract String failed(String target);
}
