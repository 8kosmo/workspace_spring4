package com.sts3.demo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Chef {
	Logger logger = Logger.getLogger(Chef.class);
	int i = 10;
	public Chef() {
		logger.info("봉골레 파스타 3개");
	}
}
