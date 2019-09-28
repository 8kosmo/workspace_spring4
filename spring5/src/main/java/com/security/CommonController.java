package com.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security/*")
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	@GetMapping("/customLogin")
	public String loginForm() {
		return "login/main";
	}
	@GetMapping("/accessError?")
	public String accessDenied(Authentication auth, Model model) {
		logger.info("access denied : "+auth);
		model.addAttribute("msg",auth);
		return "security/accessError";
			}
}
