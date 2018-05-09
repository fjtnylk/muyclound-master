package com.muyclound.external;

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
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerTextParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCSendMessengerTitleParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCTicketGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCTicketGetResult;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCUserInfoGetParams;
import com.muyclound.external.gen.v1_0_0.model.icbc.ICBCUserInfoGetResult;
import com.muyclound.external.invoke.ICBCAPI;
import com.muyclound.external.util.misc.ICBCUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/3/15.
 */
public class ICBCAPITests {

  /**
   * 获取第一次access_token.
   */
  @Test
  public void testTokenGet() {
    ICBCAccessTokenGetResult result = accessTokenGet();

    System.out.println(result.toString());
  }

  /**
   * 获取公众号access_token.
   */
  @Test
  public void testOAuthTokenGet() {
    ICBCOAuth2AccessTokenGetResult result = oauthAccessTokenGet();

    System.out.println(result.toString());
  }

  private ICBCOAuth2AccessTokenGetResult oauthAccessTokenGet() {
    String appid = "6MKsdlXlMIcLNWWKUqXa2Q==";
    String code = "oH0O/TfuFzLpyJfRQRXLiJhqgSKKuxU=";

    ICBCOAuth2AccessTokenGetParams params = new ICBCOAuth2AccessTokenGetParams();
    params.setAppid(appid);
    params.setCode(code);

    return ICBCAPI.oauth2AccessTokenGet(params);
  }

  private ICBCAccessTokenGetResult accessTokenGet() {
    long sysTime = System.currentTimeMillis();
    String timestamp = String.valueOf(sysTime);

    String appid = "6MKsdlXlMIcLNWWKUqXa2Q==";

    String signature = ICBCUtils.getSignature(appid, timestamp, "C:/opt/encrypt/icbc/caisx_priv.key");

    ICBCAccessTokenGetParams params = new ICBCAccessTokenGetParams();
    params.setAppid(appid);
    params.setTimestamp(timestamp);
    params.setSignature(signature);
    params.setKeyPath("C:/opt/encrypt/icbc");

    return ICBCAPI.tokenGet(params);
  }

  /**
   * 获取用户信息.
   */
  @Test
  public void testUserInfoGet() {
    String accessToken = "6qm81kG7308iVR27Jj5VX250I629OWg0fCg1p8p9QeGiJFcJj5j5qrijXPge0JobHe11GS5371k43i1PMsy6LCerIc4CQK13OHvnsYDadpNXvJRQx1ercn9uIIKja/U=";
    String openid = "seU4cjApA6rElGZwL9sizktcL2XCnECm";

    ICBCUserInfoGetParams params = new ICBCUserInfoGetParams();
    params.setAccessToken(accessToken);
    params.setOpenid(openid);

    ICBCUserInfoGetResult result = ICBCAPI.userInfoGet(params);

    System.out.println(result.toString());
  }

  /**
   * 检验授权凭证（access_token）是否有效.
   */
  @Test
  public void testTokenAuth() {
    String accessToken = "6qm81kG7308iVR27Jj5VX2501I629OWg0fCg1p8p9QeGiJFcJj5j5qrijXPge0JobHe11GS5371k43i1PMsy6LCerIc4CQK13OHvnsYDadpNXvJRQx1ercn9uIIKja/U=";
    String openid = "seU4cjApA6rElGZwL9sizktcL2XCnECm";

    ICBCAccessTokenAuthParams params = new ICBCAccessTokenAuthParams();
    params.setAccessToken(accessToken);
    params.setOpenid(openid);

    ICBCAccessTokenAuthResult result = ICBCAPI.accessTokenAuth(params);

    System.out.println(result.toString());
  }

  /**
   * 消息群发.
   */
  @Test
  public void testSendMessage() {
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    String[] toUsers = new String[]{"seU4cjApA6rElGZwL9sizktcL2XCnECm"};
    String msgType = "notice";
    ICBCSendMessageParams.Notice notice = new ICBCSendMessageParams.Notice();
    notice.setTitle("this is notice");
    notice.setSource("from icbc");
    notice.setRemark("something do you want to do");

    ICBCSendMessageParams params = new ICBCSendMessageParams(accessToken, sessionKey);
    params.setToUsers(toUsers);
    params.setMsgType(msgType);
    params.setNotice(notice);

    ICBCSendMessageResult result = ICBCAPI.sendMessage(params);

    System.out.println(result);
  }

  /**
   * 通知消息发送.
   */
  @Test
  public void testSendMessageNotice() {
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    String toUser = "seU4cjApA6rElGZwL9sizktcL2XCnECm";
    String msgType = "notice";
    ICBCSendMessageNoticeParams.Notice notice = new ICBCSendMessageNoticeParams.Notice();
    notice.setTitle("测试");
    notice.setSource("彩食鲜");
    notice.setRemark("彩食鲜测试");

    ICBCSendMessageNoticeParams params = new ICBCSendMessageNoticeParams(accessToken, sessionKey);
    params.setToUser(toUser);
    params.setMsgType(msgType);
    params.setNotice(notice);

    ICBCSendMessageNoticeResult result = ICBCAPI.sendMessageNotice(params);

    System.out.println(result);
  }

  /**
   * 图片消息发送接口.
   */
  @Test
  public void testSendMessageNews() {
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    String toUser = "seU4cjApA6rElGZwL9sizktcL2XCnECm";
    String msgType = "news";
    ICBCSendMessageNewsParams.News news = new ICBCSendMessageNewsParams.News();
    List<ICBCSendMessageNewsParams.Articles> articles = new ArrayList<>();
    ICBCSendMessageNewsParams.Articles articles1 = new ICBCSendMessageNewsParams.Articles();
    articles1.setDescription("Is Really A Happy Day");
    articles1.setTitle("Happy Day");
    articles1.setUrl("https://www.baidu.com");
    articles1.setPicurl("http://pic.58pic.com/58pic/13/68/03/86S58PIC26b_1024.jpg");
    articles.add(articles1);

    news.setArticles(articles);

    ICBCSendMessageNewsParams params = new ICBCSendMessageNewsParams(accessToken, sessionKey);
    params.setToUser(toUser);
    params.setMsgType(msgType);
    params.setNews(news);
    params.setIsAllowSend("0");

    ICBCSendMessageNewsResult result = ICBCAPI.sendMessageNews(params);

    System.out.println(result);
  }


  /**
   * 信使类消息发送接口text.
   */
  @Test
  public void testSendMessageText() {
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    String toUser = "seU4cjApA6rElGZwL9sizktcL2XCnECm";
    String title = "xxxxx公积金";
    String subtitle = "xxxx公积金详情";
    String icon = "https://www.icbc.com.cn/test/1.jpg";
    String remark = "";

    ICBCSendMessengerTextParams.Content content = new ICBCSendMessengerTextParams.Content();
    content.setMsgContent("我是模板文本内容");

    List<ICBCSendMessengerParams.Buttons> buttons = new ArrayList<>();
    ICBCSendMessengerParams.Buttons btn1 = new ICBCSendMessengerParams.Buttons();
    btn1.setDesc("desc0");
    btn1.setHref("28");
    btn1.setIsFunc("1");
    ICBCSendMessengerParams.Buttons btn2 = new ICBCSendMessengerParams.Buttons();
    btn2.setDesc("desc1");
    btn2.setHref("href\":\"https://www.icbc.com.cn");
    btn2.setIsFunc("0");
    ICBCSendMessengerParams.Buttons btn3 = new ICBCSendMessengerParams.Buttons();
    btn3.setDesc("desc2");
    btn3.setHref("26");
    btn3.setIsFunc("1");
    ICBCSendMessengerParams.Buttons btn4 = new ICBCSendMessengerParams.Buttons();
    btn4.setDesc("desc3");
    btn4.setHref("https://www.icbc.com.cn");
    btn4.setIsFunc("0");

    buttons.add(btn1);
    buttons.add(btn2);
    buttons.add(btn3);
    buttons.add(btn4);

    ICBCSendMessengerTextParams params = new ICBCSendMessengerTextParams(accessToken, sessionKey);
    params.setTouser(toUser);
    params.setTitle(title);
    params.setSubtitle(subtitle);
    params.setIcon(icon);
    params.setRemark(remark);
    params.setContent(content);
    params.setButtons(buttons);

    ICBCSendMessengerResult result = ICBCAPI.sendTextMessage(params);

    System.out.println(result);
  }

  /**
   * 信使类消息发送接口title.
   */
  @Test
  public void testSendMessageTitle() {
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    String toUser = "seU4cjApA6rElGZwL9sizktcL2XCnECm";
    String title = "xxxxx公积金";
    String subtitle = "xxxx公积金详情";
    String icon = "https://www.icbc.com.cn/test/1.jpg";
    String remark = "";

    ICBCSendMessengerTitleParams.Content content = new ICBCSendMessengerTitleParams.Content();
    content.setMsgContent("我是模板标题内容正文:您尾号xxxxxx卡xx月xx日xx:xxATM支出(ATM转帐)xx元，手续费x元，余额xxxx元，可用余额xxxx元。");
    content.setTitle("我是模板标题内容标题:您有一条新信息");

    List<ICBCSendMessengerParams.Buttons> buttons = new ArrayList<>();
    ICBCSendMessengerParams.Buttons btn1 = new ICBCSendMessengerParams.Buttons();
    btn1.setDesc("desc0");
    btn1.setHref("28");
    btn1.setIsFunc("1");
    ICBCSendMessengerParams.Buttons btn2 = new ICBCSendMessengerParams.Buttons();
    btn2.setDesc("desc1");
    btn2.setHref("href\":\"https://www.icbc.com.cn");
    btn2.setIsFunc("0");
    ICBCSendMessengerParams.Buttons btn3 = new ICBCSendMessengerParams.Buttons();
    btn3.setDesc("desc2");
    btn3.setHref("26");
    btn3.setIsFunc("1");
    ICBCSendMessengerParams.Buttons btn4 = new ICBCSendMessengerParams.Buttons();
    btn4.setDesc("desc3");
    btn4.setHref("https://www.icbc.com.cn");
    btn4.setIsFunc("0");

    buttons.add(btn1);
    buttons.add(btn2);
    buttons.add(btn3);
    buttons.add(btn4);

    ICBCSendMessengerTitleParams params = new ICBCSendMessengerTitleParams(accessToken, sessionKey);
    params.setTouser(toUser);
    params.setTitle(title);
    params.setSubtitle(subtitle);
    params.setIcon(icon);
    params.setRemark(remark);
    params.setContent(content);
    params.setButtons(buttons);

    ICBCSendMessengerResult result = ICBCAPI.sendTitleMessage(params);

    System.out.println(result);
  }

  /**
   * 获取jsapi凭证.
   */
  @Test
  public void testTicketGet() {
    /* 获取access_token */
    ICBCAccessTokenGetResult accessTokenGetResult = accessTokenGet();
    String accessToken = accessTokenGetResult.getAccesstoken();
    String sessionKey = accessTokenGetResult.getSessionkey();

    /* 获取jsapi凭证 */
    ICBCTicketGetParams ticketGetParams = new ICBCTicketGetParams();
    ticketGetParams.setAccessToken(accessToken);
    ticketGetParams.setSessionKey(sessionKey);
    ICBCTicketGetResult ticketResult = ICBCAPI.ticketGet(ticketGetParams);
    System.out.println(ticketResult.toString());
  }

  /**
   * 获取jsapi支付凭证.
   */
  @Test
  public void testPayTicketGet() {
    /* 获取access_token */
    ICBCAccessTokenGetResult accessTokenGetResult = accessTokenGet();
    String accessToken = accessTokenGetResult.getAccesstoken();
    String sessionKey = accessTokenGetResult.getSessionkey();

    /* 获取支付凭证 */
    ICBCPayTicketGetParams payTicketGetParams = new ICBCPayTicketGetParams();
    payTicketGetParams.setAccessToken(accessToken);
    payTicketGetParams.setSessionKey(sessionKey);
    ICBCPayTicketGetResult payTicketResult = ICBCAPI.payTicketGet(payTicketGetParams);
    System.out.println(payTicketResult.toString());
  }

  /**
   * 订单查询.
   */
  @Test
  public void testOrderQuery() {
    /* 获取access_token */
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    /* 订单查询 */
    String merId = "140201010069";      // 商户编号
    String outTradeNo = "1804020300001546"; // 商户订单号
    String orderId = "140201010069201804022288709";    // 行内订单号

    ICBCOrderQueryParams params = new ICBCOrderQueryParams(accessToken, sessionKey);
    params.setMerId(merId);
    params.setOutTradeNo(outTradeNo);
    params.setOrderId(orderId);

    ICBCOrderQueryResult result = ICBCAPI.orderQuery(params);

    System.out.println(result.toString());
  }

  /**
   * 订单退款.
   */
  @Test
  public void testOrderRefund() {
    /* 获取access_token */
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    /* 订单退款 */
    String merId = "140201010069";      // 商户编号
    String outTradeNo = "1804020300001577"; // 商户订单号
    String orderId = "140201010069201804022364481";    // 行内订单号
    String rejectNo = "R0300001569";   // 退货编号
    String rejectAmt = "1";  // 退款金额
    String operId = "VCAg6NQ0ao5tpENgfuUKi2pAD2hhF4";     // 操作人员ID

    ICBCOrderRefundParams params = new ICBCOrderRefundParams(accessToken, sessionKey);
    params.setMerId(merId);
    params.setOutTradeNo(outTradeNo);
    params.setOrderId(orderId);
    params.setRejectNo(rejectNo);
    params.setRejectAmt(rejectAmt);
    params.setOperId(operId);

    ICBCOrderRefundResult result = ICBCAPI.orderRefund(params);

    System.out.println(result.toString());
  }

  /**
   * 订单冲正.
   */
  @Test
  public void testOrderReject() {
    /* 获取access_token */
    ICBCAccessTokenGetResult tokenGet = accessTokenGet();
    String accessToken = tokenGet.getAccesstoken();
    String sessionKey = tokenGet.getSessionkey();

    /* 订单冲正 */
    String merId = "140201010069";      // 商户编号
    String outTradeNo = "1804020300001577"; // 商户订单号
    String orderId = "140201010069201804022364481";    // 行内订单号
    String rejectNo = "R0300001569";   // 退货编号
    String operId = "VCAg6NQ0ao5tpENgfuUKi2pAD2hhF4";     // 操作人员ID

    ICBCOrderRejectParams params = new ICBCOrderRejectParams(accessToken, sessionKey);
    params.setMerId(merId);
    params.setOutTradeNo(outTradeNo);
    params.setOrderId(orderId);
    params.setRejectNo(rejectNo);
    params.setOperId(operId);

    ICBCOrderRejectResult result = ICBCAPI.orderReject(params);

    System.out.println(result.toString());
  }
}
