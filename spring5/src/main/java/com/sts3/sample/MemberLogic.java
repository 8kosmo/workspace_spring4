package com.sts3.sample;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	@Autowired
	public MemberDao memberDao;
	public void memberAdd(Map<String, Object> pMap) {
		logger.info("called memberAdd");
	}

	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("called memberList");
		List<Map<String, Object>> memberList =
						memberDao.memberList(pMap);
		return memberList;
	}
}
