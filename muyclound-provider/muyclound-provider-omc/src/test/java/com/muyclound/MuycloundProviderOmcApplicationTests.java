package com.muyclound;

import com.muyclound.provider.enums.OrderChannelEnum;
import com.muyclound.provider.enums.OrderStatusEnum;
import com.muyclound.provider.enums.OrderTypeEnum;
import com.muyclound.provider.model.PlaceOrderModel;
import com.muyclound.provider.model.entity.OrderDO;
import com.muyclound.provider.service.OrderService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuycloundProviderOmcApplicationTests {
	@Resource
	private OrderService orderService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createOrder() {
		PlaceOrderModel model = new PlaceOrderModel();
		model.setUserId(1000000L);
		model.setOrderStatus(OrderStatusEnum.CREATE);
		model.setOrderChannel(OrderChannelEnum.B2B);
		model.setOrderType(OrderTypeEnum.NORMAL);
		model.setTotalAmount(12);

		OrderDO orderDO = orderService.createOrder(model);

		System.out.println(orderDO);
	}

}
