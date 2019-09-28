package com.erp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	public DeptDao deptDao = null;
	public EmpDao empDao = null;

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public void doEmp(EmpVO eVO) {
		try {
			empDao.empInsert(eVO);
			deptDao.deptUpdate(null);
		} catch (Exception e) {
			throw e;//throws 는 예외처리는 미루는 것.
		}
	}
}
