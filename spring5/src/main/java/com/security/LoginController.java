package com.security;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/security/*")
public class LoginController { 
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private LoginLogic loginLogic = null;
	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}
	@GetMapping("login")
	public String login
	(@RequestParam Map<String, Object> pMap,HttpSession session) {
		logger.info("called login(pMap,session):String");
		String mem_name = loginLogic.login(pMap);
		if("로그인실패".equals(mem_name)) {
			session.setAttribute("smem_name",mem_name);
			logger.info(mem_name);
		}
		return "redirect:/login/main.jsp";
	}
	@GetMapping("memberAdd")
	public String memberAdd
	(@RequestParam Map<String, Object> pMap) {
		logger.info("called memberAdd(pMap):String");
		loginLogic.memberAdd(pMap);
		return "redirect:/login/main.jsp";
	}
}
