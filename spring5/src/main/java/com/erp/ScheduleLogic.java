package com.erp;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleLogic {
	Logger logger = LoggerFactory.getLogger(ScheduleLogic.class);
	
	@Autowired(required=false)
	private ScheduleDao scheduleDao;

	public List<Map<String, Object>> zdoList() {
		List<Map<String, Object>> zdoList = null;
		zdoList = scheduleDao.zdoList();
		return zdoList;
	}

	public List<Map<String, Object>> siguList(String zdo) {
		List<Map<String, Object>> siguList = null;
		siguList = scheduleDao.siguList(zdo);
		return siguList;
	}

	public List<Map<String, Object>> dongList(String sigu) {
		List<Map<String, Object>> dongList = null;
		dongList = scheduleDao.dongList(sigu);
		return dongList;
	}
}
