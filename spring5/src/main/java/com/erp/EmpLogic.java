package com.erp;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.DeptVO;
import com.vo.EmpVO;
@Service
public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	@Autowired
	public DeptDao deptDao;
	@Autowired
	public EmpDao empDao;
	/*
	 * 트랜잭션의 전파 규칙
	 * REQUIRED:기존의 트랜잭션이 존재하면 같은 트랜잭션에서 실행되며 기존의 트랜잭션이 존재하지 않으면 새로운 트랜잭션 발생시킴
	 * NEVER:기존의 트랜잭션이 존재하면 예외를 발생시키고 기존의 트랜잭션이 존재하지 않으면 트랜잭션 없이 실행됨.
	 * NESTED:기존 트랜잭션이 존재하면 중첩된 트랜잭션이 실행되며 기존의 트랜잭션이 존재하지않으면 REQUIRED와 동일하게 실행됨.
	 * NOT_SUPPORTED:기존의 트랜잭션이 존재해도 트랜잭션없이 실행됨.
	 * SUPPORTS:기존의 트랜잭션이 존재하면 같은 트랜잭션에서 실행되며 기존의 트랜잭션이 존재하지 안흥면 트랜잭션 없이 실행됨.
	 * MANDATORY:기존의 트랜잭션이 존재하면 같은 트랜잭션에서 실행되며 기존의 트랜잭션이 존재하지 않으면 예외가 발생
	 */
	//기존의 트랜잭션이 존재하면 실행을 보류시키고 새로운 트랜잭션을 생성시켜 실행함.
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor= {DataAccessException.class})
	@Pointcut(value="execution(* com.erp.*Logic.*(..)")
	public void doEmp(EmpVO eVO) {
		eVO.setEmpno(9904);
		eVO.setEname("Maven");
		eVO.setDeptno(92);
		try {
			DeptVO dVO = new DeptVO();
			dVO.setDeptno(92);
			dVO.setDname("개발3팀");
			dVO.setLoc("부산");
			deptDao.deptInsert(dVO);
			empDao.empInsert(eVO);
		} catch (DataAccessException e) {
			throw e;//throws 는 예외처리는 미루는 것.
		}
	}
}
