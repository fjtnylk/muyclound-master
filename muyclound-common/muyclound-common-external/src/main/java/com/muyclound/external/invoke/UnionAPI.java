package com.muyclound.external.invoke;

import com.muyclound.external.client.auth.Simple;
import com.muyclound.external.client.config.postprocessor.unions.UnionPostProcessor;
import com.muyclound.external.client.core.Client;
import com.muyclound.external.client.core.DefaultClient;
import com.muyclound.external.gen.v1_0_0.api.unions.UnionConsumeIntegral;
import com.muyclound.external.gen.v1_0_0.api.unions.UnionGetUserInfo;
import com.muyclound.external.gen.v1_0_0.api.unions.UnionRefundIntegral;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionConsumeIntegralParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionConsumeIntegralResult;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionGetUserInfoParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionGetUserInfoResult;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionRefundIntegralParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionRefundIntegralResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 积分接口.
 * Created by yanglikai on 2018/5/7.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UnionAPI {

  /**
   * 积分用户获取.
   *
   * @param params
   * @return
   */
  public static UnionGetUserInfoResult getUserInfo(UnionGetUserInfoParams params) {
    UnionGetUserInfo api = new UnionGetUserInfo();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new UnionPostProcessor());

    return client.invoke(api);
  }

  /**
   * 积分消费.
   *
   * @param params
   * @return
   */
  public static UnionConsumeIntegralResult consume(UnionConsumeIntegralParams params) {
    UnionConsumeIntegral api = new UnionConsumeIntegral();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new UnionPostProcessor());

    return client.invoke(api);
  }

  /**
   * 积分返还.
   *
   * @param params
   * @return
   */
  public static UnionRefundIntegralResult refund(UnionRefundIntegralParams params) {
    UnionRefundIntegral api = new UnionRefundIntegral();
    api.setAPIParams(params);

    Client client =
        new DefaultClient(
            new Simple(),
            new UnionPostProcessor());

    return client.invoke(api);
  }
}
