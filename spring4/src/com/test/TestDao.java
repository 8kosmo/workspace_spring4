package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestDao {
	Logger logger = Logger.getLogger(TestLogic.class);

	public List<Map<String, Object>> testList() {
		logger.info("testList 호출 성공");
		List<Map<String, Object>> tList = new ArrayList<>();
		return tList;
	}
}
