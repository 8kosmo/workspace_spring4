package com.sts3.ajax;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderDao {
	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void orderPizza(Map<String, Object> pMap) {
		logger.info("OO피자 나왔습니다.");
		sqlSessionTemplate.insert("orderPizza", pMap);
	}
}
