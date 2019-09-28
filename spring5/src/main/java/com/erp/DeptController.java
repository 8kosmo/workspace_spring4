package com.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeptController {
	@Autowired
	public DeptLogic deptLogic = null;
	
	public void deptInsert(HttpServletRequest req, HttpServletResponse res) throws Exception {

	}

}
