package com.di;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {
	Logger logger = Logger.getLogger(HelloController.class);
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("handleRequestInternal 호출성공");
		/*
		 * ModelAndView는 scope는 request임
		 * ModelAndView는 forward처리임.
		 * 담는건 addObject(,) 꺼내는건 setAttribute()
		 */
		ModelAndView mav = new ModelAndView();
		// ==>/WEB-INF/view/ page를 찾는데 필요한 접두어
		// ==>접미어 .jsp
		//완결편 ==> /WEB-INF/view/?.jsp
		mav.setViewName("di/helloResult");
		List<String> nameList = new ArrayList<>();
		nameList.add("이성계");
		mav.addObject("nameList", nameList);//req.setAttribute("nameList",nameList);
		return mav;
	}

}
