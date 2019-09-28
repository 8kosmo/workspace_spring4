package com.sts3.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//localhost:8000/pojo/dept/deptList
@Controller
@RequestMapping("/dept/*")
public class DeptController {
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	@GetMapping("deptList")
	public String deptList() {
		logger.info("called deptList():String");
		return "dept/deptList";
	}
}
