package com.muyclound.external;

import com.muyclound.external.gen.v1_0_0.model.unions.UnionConsumeIntegralParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionConsumeIntegralResult;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionGetUserInfoParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionGetUserInfoResult;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionRefundIntegralParams;
import com.muyclound.external.gen.v1_0_0.model.unions.UnionRefundIntegralResult;
import com.muyclound.external.invoke.UnionAPI;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/5/7.
 */
public class UnionAPITests {

  @Test
  public void testGetUserInfo() {
    UnionGetUserInfoParams params = new UnionGetUserInfoParams();
    params.setUserName("fzszgh");
    params.setPassword("9bebfae1c3e5721bcef49d1bf106e25e");
    params.setMobile("13615030812");

    UnionGetUserInfoResult result = UnionAPI.getUserInfo(params);
    System.out.println(result);
  }

  @Test
  public void testConsume() {
    UnionConsumeIntegralParams params = new UnionConsumeIntegralParams();
    params.setUserName("fzszgh");
    params.setPassword("9bebfae1c3e5721bcef49d1bf106e25e");
    params.setMobile("13615030812");
    params.setExchangeFee("10");
    params.setPayFee("10");
    params.setOrderId("2018042613254555");
    params.setGoods("海飞丝洗发水等");
    params.setOpenId("oxPWbsyAQGTLrikZ3yzwuClvKLEo");
    params.setUserId("36");

    UnionConsumeIntegralResult result = UnionAPI.consume(params);
    System.out.println(result);
  }

  @Test
  public void testRefund() {
    UnionRefundIntegralParams params = new UnionRefundIntegralParams();
    params.setUserName("fzszgh");
    params.setPassword("9bebfae1c3e5721bcef49d1bf106e25e");
    params.setMobile("13615030812");
    params.setRefundFee("10");
    params.setRemark("取消订单");
    params.setOrderId("oxPWbs6DyART1gxM2Kia96cvWX7w");
    params.setUserId("36");

    UnionRefundIntegralResult result = UnionAPI.refund(params);
    System.out.println(result);
  }
}
