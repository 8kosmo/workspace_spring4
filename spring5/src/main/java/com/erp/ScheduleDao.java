package com.erp;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleDao {
	Logger logger = LoggerFactory.getLogger(ScheduleDao.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Map<String, Object>> zdoList() {
		List<Map<String, Object>> zdoList = null;
		zdoList = sqlSessionTemplate.selectList("zdoList");
		return zdoList;
	}

	public List<Map<String, Object>> siguList(String zdo) {
		List<Map<String, Object>> siguList = null;
		siguList = sqlSessionTemplate.selectList("siguList",zdo);
		return siguList;
	}

	public List<Map<String, Object>> dongList(String sigu) {
		List<Map<String, Object>> dongList = null;
		dongList = sqlSessionTemplate.selectList("dongList",sigu);
		return dongList;
	}

	
}
