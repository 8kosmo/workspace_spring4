package com.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * CSRF(Cross-site request forgery)공격과 토큰
 * 스프링 시큐리티에서 POST방식을 이용하는 경우 기본적으로 CSRF토큰이라는 것을 이용해야 함.
 * 별도의 설정이 없다면 스프링 시큐리티가 적용된 사이트의 모든 POST방식에느느 CSRF토큰이 사용
 * 되는 데 사이트 간 위조 방지를 목적으로 특정한 값의 토큰을 사용하는 방식
 * 
 * 서버에서 받아들이는 정보가 특별히 사전 조건을 검증하지 않는다는 단점을 이용하여 공격방식
 * 
 * 이 공격을 이용하면 게시물의 조회수를 늘리거나 피해자의 계정을 이용하여 다양한 공격이 가능해짐.
 * 
 * <form action="www.aaa.com/update?grade=admin&account=123">
 * </form>
 * 혹은
 * <img src="www.aaa.com/update?grade=admin&account=123"/>
 * 
 * CSRF토큰
 * 사용자가 임의로 변경하는 특정한 토큰값을 서버에서 체크하는 방식
 * 서버에는 브라우저에 데이터를 전송할 때 CSRF토큰을 같이 전송
 * 사용자가 POST방식으로 특정한 작업을 할 때 브라우저에서 전송된 CSRF토큰의 값과 서버가
 * 보관하는 토큰 값을 비교
 * 만일 토큰이 다르면 작업을 처리하지 않음.
 * 
 * 스프링 시큐리티의 CSRF설정
 * <security:csrf disabled="true"/>
 * 
 */
@Controller
@RequestMapping("/security/*")
public class introController {
	private static final Logger logger = LoggerFactory.getLogger(introController.class);
	
	@GetMapping("/all")
	public String doAll() {
		logger.info("do all can access everybody");
		return "security/all";
	}
	@GetMapping("/member")
	public String doMember() {
		logger.info("logined member");
		return "security/member";
	}
	@GetMapping("/admin")
	public String doAdmin() {
		logger.info("admin only");
		return "security/admin";
	}
}
