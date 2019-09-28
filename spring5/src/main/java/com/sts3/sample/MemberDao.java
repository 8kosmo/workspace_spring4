package com.sts3.sample;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("called memberList");
		List<Map<String, Object>> memberList =
						sqlSessionTemplate.selectList("memberList",pMap);
		return memberList;
	}

}
