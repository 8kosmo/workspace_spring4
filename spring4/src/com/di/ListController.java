package com.di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {
	private List<String> listBean = null;
	
	public void setListBean(List<String> listBean) {
		this.listBean = listBean;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("di/insaList");
		mav.addObject("listBean", listBean);
		return mav;
	}

}
