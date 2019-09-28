package com.security;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDao {
	Logger logger = LoggerFactory.getLogger(LoginDao.class);
	
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public String login(Map<String, Object> pMap) {
		String mem_name = sqlSessionTemplate.selectOne("login",pMap);
		return mem_name;
	}
	public void memberAdd(Map<String, Object> pMap) {
		int result = sqlSessionTemplate.update("memberAdd",pMap);
		logger.info("등록 성공 여부 : "+result);
	}
}
