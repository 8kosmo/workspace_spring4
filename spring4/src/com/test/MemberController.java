package com.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	Logger logger = Logger.getLogger(MemberController.class);
	MemberLogic memberLogic = null;
	public void setMemberLogic(MemberLogic memberLogic) {
		this.memberLogic = memberLogic;
	}
	public ModelAndView memberList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.info("memberList 호출 성공");
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> memList = null;
		memList = memberLogic.memberList();
		mav.addObject("memList", memList);
		mav.setViewName("member/memList");
		return mav;
	}
	public void memberList2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("memberList2 호출성공");
		List<Map<String, Object>> memList = null;
		memList = memberLogic.memberList();
		req.setAttribute("memList", memList);
		try {
			RequestDispatcher view = req.getRequestDispatcher("./memList.jsp");
			view.forward(req, res);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void memberList3(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("memberList3 호출성공");
		List<Map<String, Object>> memList = null;
		memList = memberLogic.memberList();
		req.setAttribute("memList", memList);
		try {
			res.sendRedirect("./memList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
