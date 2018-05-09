package com.muyclound.external.invoke;


import com.muyclound.external.client.auth.Simple;
import com.muyclound.external.client.config.decryptor.ICBCDecryptor;
import com.muyclound.external.client.config.encryptor.ICBCEncryptor;
import com.muyclound.external.client.config.postprocessor.icbc.ICBCAccessTokenAuthPostProcessor;
import com.muyclound.external.client.config.postprocessor.icbc.ICBCAccessTokenGetContext;
import com.muyclound.external.client.config.postprocessor.icbc.ICBCAccessTokenGetPostProcessor;
import com.muyclound.external.client.config.postprocessor.icbc.ICBCNormalPostProcessor;
import com.muyclound.external.client.config.postprocessor.icbc.ICBCSendMessagePostProcessor;
import com.muyclound.external.client.core.Client;
import com.muyclound.external.client.core.DefaultClient;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCAccessTokenAuth;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCAccessTokenGet;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCOAuth2AccessTokenGet;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCOrderQuery;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCOrderRefund;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCOrderReject;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCPayTicketGet;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCSendMessage;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCSendMessageNews;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCSendMessageNotice;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCSendMessenger;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCTicketGet;
import com.muyclound.external.gen.v1_0_0.api.icbc.ICBCUserInfoGet;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenAuthParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenAuthResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCAccessTokenGetResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOAuth2AccessTokenGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOAuth2AccessTokenGetResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderQueryParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderQueryResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRefundParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRefundResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRejectParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCOrderRejectResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCPayTicketGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCPayTicketGetResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageNewsParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageNewsResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageNoticeParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageNoticeResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessageResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerTextParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerTitleParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCTicketGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCTicketGetResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCUserInfoGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCUserInfoGetResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/3/16.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ICBCAPI {

  /**
   * 获取accesstoken、sessionkey.
   *
   * @param params
   * @return
   */
  public static ICBCAccessTokenGetResult tokenGet(ICBCAccessTokenGetParams params) {
    ICBCAccessTokenGet api = new ICBCAccessTokenGet();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCAccessTokenGetPostProcessor(
                new ICBCAccessTokenGetContext(params.getKeyPath())));

    return client.invoke(api);
  }

  /**
   * 通过code换取网页授权access_token.
   *
   * @param params
   * @return
   */
  public static ICBCOAuth2AccessTokenGetResult oauth2AccessTokenGet(
      ICBCOAuth2AccessTokenGetParams params) {
    ICBCOAuth2AccessTokenGet api = new ICBCOAuth2AccessTokenGet();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor());

    return client.invoke(api);
  }

  /**
   * 获取用户信息.
   *
   * @param params
   * @return
   */
  public static ICBCUserInfoGetResult userInfoGet(ICBCUserInfoGetParams params) {
    ICBCUserInfoGet api = new ICBCUserInfoGet();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor());

    return client.invoke(api);
  }

  /**
   * 鉴权授权凭证.
   *
   * @param params
   * @return
   */
  public static ICBCAccessTokenAuthResult accessTokenAuth(ICBCAccessTokenAuthParams params) {
    ICBCAccessTokenAuth api = new ICBCAccessTokenAuth();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCAccessTokenAuthPostProcessor());

    return client.invoke(api);
  }

  /**
   * 消息群发.
   *
   * @param params
   * @return
   */
  public static ICBCSendMessageResult sendMessage(ICBCSendMessageParams params) {
    ICBCSendMessage api = new ICBCSendMessage(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }

  /**
   * 消息发送.
   *
   * @param params
   * @return
   */
  public static ICBCSendMessageNoticeResult sendMessageNotice(ICBCSendMessageNoticeParams params) {
    ICBCSendMessageNotice api = new ICBCSendMessageNotice(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCSendMessagePostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }

  /**
   * 图文消息发送.
   *
   * @param params
   * @return
   */
  public static ICBCSendMessageNewsResult sendMessageNews(ICBCSendMessageNewsParams params) {
    ICBCSendMessageNews api = new ICBCSendMessageNews(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCSendMessagePostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }


  /**
   * 信使类消息发送接口text.
   *
   * @param params
   * @return
   */
  public static ICBCSendMessengerResult sendTextMessage(ICBCSendMessengerTextParams params) {
    ICBCSendMessenger api = new ICBCSendMessenger(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCSendMessagePostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }

  /**
   * 信使类消息发送接口title.
   *
   * @param params
   * @return
   */
  public static ICBCSendMessengerResult sendTitleMessage(ICBCSendMessengerTitleParams params) {
    ICBCSendMessenger api = new ICBCSendMessenger(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCSendMessagePostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }

  /**
   * 获取jsapi凭证.
   *
   * @param params
   * @return
   */
  public static ICBCTicketGetResult ticketGet(ICBCTicketGetParams params) {
    ICBCTicketGet api = new ICBCTicketGet();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor(),
            new ICBCDecryptor(params.getSessionKey()));

    return client.invoke(api);
  }

  /**
   * 获取支付凭证.
   *
   * @param params
   * @return
   */
  public static ICBCPayTicketGetResult payTicketGet(ICBCPayTicketGetParams params) {
    ICBCPayTicketGet api = new ICBCPayTicketGet();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor(),
            new ICBCDecryptor(params.getSessionKey()));

    return client.invoke(api);
  }

  /**
   * 订单查询.
   *
   * @param params
   * @return
   */
  public static ICBCOrderQueryResult orderQuery(ICBCOrderQueryParams params) {
    ICBCOrderQuery api = new ICBCOrderQuery(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }

  /**
   * 订单退款.
   *
   * @param params
   * @return
   */
  public static ICBCOrderRefundResult orderRefund(ICBCOrderRefundParams params) {
    ICBCOrderRefund api = new ICBCOrderRefund(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }

  /**
   * 订单冲正.
   *
   * @param params
   * @return
   */
  public static ICBCOrderRejectResult orderReject(ICBCOrderRejectParams params) {
    ICBCOrderReject api = new ICBCOrderReject(params.getAccessToken());
    api.setAPIParams(params);

    String sessionKey = params.getSessionKey();
    Client client =
        new DefaultClient(
            new Simple(),
            new ICBCNormalPostProcessor(),
            new ICBCDecryptor(sessionKey),
            new ICBCEncryptor(sessionKey));

    return client.invoke(api);
  }
}
