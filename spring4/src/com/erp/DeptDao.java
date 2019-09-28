package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.DeptVO;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void deptUpdate(DeptVO dVO) throws DataAccessException {
		logger.info("deptUpdate");
		dVO = new DeptVO();
		dVO.setDeptno(99);
		dVO.setDname("개발부");
		dVO.setLoc("가산");
		sqlSessionTemplate.insert("deptUpdate",dVO);
	}
}
