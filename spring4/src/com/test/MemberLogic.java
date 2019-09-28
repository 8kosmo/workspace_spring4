package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	public MemberDao memberDao = null;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public List<Map<String, Object>> memberList() {
		logger.info("memberList 호출성공");
		List<Map<String, Object>> memList = null;
		memList = memberDao.memberList();
		return memList;
	}

}
