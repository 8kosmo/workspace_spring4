package com.test;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TestController extends MultiActionController {
	Logger logger = Logger.getLogger(TestController.class);
	
	public TestLogic testLogic = null;
	public void setTestLogic(TestLogic testLogic) {
		this.testLogic = testLogic;
	}
	
	public ModelAndView testList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("testList 호출성공");
		ModelAndView mav = new ModelAndView();
		List<Map<String , Object>> tList = null;
		tList = testLogic.testList();
		mav.addObject("tList", tList);
		mav.setViewName("test/testList");//setViewName을 생략하면 testList메소드 이름이 URL주소가 된다.
		return mav;//ModelAndView로 리턴값이 넘어가야지, viewName에 담긴 url주소를 불러들일 수 있다.
	}
	public void testAdd(HttpServletRequest req, HttpServletResponse res) {
		logger.info("testAdd 호출성공");
	}
	public void testUpd(HttpServletRequest req, HttpServletResponse res) {
		logger.info("testUpd 호출성공");
	}
	public void testDel(HttpServletRequest req, HttpServletResponse res) {
		logger.info("testDel 호출성공");
	}
}
