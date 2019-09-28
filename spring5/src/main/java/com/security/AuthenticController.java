package com.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/*")
public class AuthenticController {
	Logger logger = LoggerFactory.getLogger(AuthenticController.class);
	
	@GetMapping("admin")
	public String admin() {
		logger.info("admin 호출 성공");
		return "redirect:adminManager.jsp";
		//return 타입을 void로 줬을 때 /sample/WEB-INF/views/auth/admin.jsp 경로로 바라본다.
	}
}
