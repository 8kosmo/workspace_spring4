package com.sts3.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	Logger logger = Logger.getLogger(Restaurant.class);
	@Autowired//chef의 setter메소드 없이 객체주입 가능
	public Chef chef;
	public Restaurant() {
		logger.info("봉골레파스타 3 나왔습니다.");
	}
}
