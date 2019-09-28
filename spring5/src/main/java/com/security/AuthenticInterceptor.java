package com.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(AuthenticInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle 호출:컨트롤러 실행전");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		/*
		 * getSession(true)이면 세션이 있으면 그 세션을 돌려주고 세션이 없으면 새로운 세션을 생성함.
		 * getSession(false)이면 세션이 있으면 그 세션을 돌려주고 세션이 없으면 null을 돌려줌.
		 */
		HttpSession session = request.getSession();
		if(session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		logger.info("postHandle 호출:컨트롤러 실행후 아직 뷰는 처리안됨.");
		long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		logger.info(startTime+" , "+endTime);
		modelAndView.addObject("handlingTime ",endTime-startTime);
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		logger.info("afterCompletion 호출:뷰가 처리 됨.");
	}
}
