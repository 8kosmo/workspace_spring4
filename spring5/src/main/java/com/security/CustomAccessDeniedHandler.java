package com.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request
					 , HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		//accessError는 컨트롤러에 매핑된 이름
		//페이지 이름이 아니야
		response.sendRedirect("accessError");
	}

}
