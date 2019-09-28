package com.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	
	TestDao testDao = new TestDao();
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	public List<Map<String, Object>> testList() {
		logger.info("testList 호출성공");
		List<Map<String, Object>> tList = null;
		tList = testDao.testList();
		return tList;
	}
}
