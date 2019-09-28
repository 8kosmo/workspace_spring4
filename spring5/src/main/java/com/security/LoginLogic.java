package com.security;

import java.util.Map;
//@Service
public class LoginLogic {
	//@Autowired
	private LoginDao loginDao = null;
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	public String login(Map<String, Object> pMap) {
		String mem_name = loginDao.login(pMap);
		return mem_name;
	}
	public void memberAdd(Map<String, Object> pMap) {
		loginDao.memberAdd(pMap);
	}
}
