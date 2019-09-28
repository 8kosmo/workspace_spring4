package com.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vo.EmpVO;

public class EmpController extends MultiActionController  {
	Logger logger = Logger.getLogger(EmpController.class);

	public EmpLogic empLogic = null;

	public void setEmpLogic(EmpLogic empLogic) {
		this.empLogic = empLogic;
	}

	public String doEmp(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("doEmp");
		EmpVO eVO = new EmpVO();
		empLogic.doEmp(eVO);
		return "redirect:empInsertOk.jsp";//ModelAndView를 활용하지 않을경우 <bean id="viewResolver"를 타지 않기 때문에 .jsp를 해줘야한다.
	}
}
