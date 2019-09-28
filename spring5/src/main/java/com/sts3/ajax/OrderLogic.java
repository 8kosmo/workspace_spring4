package com.sts3.ajax;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderLogic {
	private static final Logger logger = LoggerFactory.getLogger(OrderLogic.class);
	@Autowired
	private OrderDao orderdao;
	
	public void orderPizza(Map<String, Object> pMap) {
		logger.info("주방:OO피자 주문이요.");
		orderdao.orderPizza(pMap);
	}
}
