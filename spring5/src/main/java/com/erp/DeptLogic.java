package com.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptLogic {
	@Autowired
	public DeptDao deptDao = null;

}
