package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.vo.EmpVO;
@Service
public class EmpDao {
	Logger logger = Logger.getLogger(EmpDao.class);
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;

	public void empInsert(EmpVO eVO) throws DataAccessException{
		logger.info("empInsert");
		sqlSessionTemplate.update("emp_Insert",eVO);
	}
	
}
