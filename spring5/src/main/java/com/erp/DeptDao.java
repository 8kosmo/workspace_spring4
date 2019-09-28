package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.vo.DeptVO;
@Service
public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;

	public void deptUpdate(DeptVO dVO) throws DataAccessException {
		logger.info("deptInsert");
		dVO = new DeptVO();
		dVO.setDeptno(99);
		dVO.setDname("개발부");
		dVO.setLoc("가산");
		sqlSessionTemplate.insert("deptUpdate",dVO);
	}
	public void deptInsert(DeptVO dVO) {
		logger.info("deptInsert");
		sqlSessionTemplate.update("dept_Insert",dVO);
		
	}

}
