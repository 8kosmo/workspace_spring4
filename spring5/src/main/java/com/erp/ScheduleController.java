package com.erp;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.ScheduleVO;

@Controller
@RequestMapping("/erpSol/*")
public class ScheduleController {
	Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired(required=false)
	private ScheduleLogic scheduleLogic;
	
	@GetMapping("zdoList")
	public String zdoList(Model mod) {
		List<Map<String, Object>> zdoList = null;
		zdoList = scheduleLogic.zdoList();
		mod.addAttribute("zdoList", zdoList);
		return "forward:zdoList.jsp";
	}
	@GetMapping("siguList")
	public String siguList(@ModelAttribute("zdo") String zdo, Model mod) {
		List<Map<String, Object>> siguList = null;
		siguList = scheduleLogic.siguList(zdo);
		mod.addAttribute("siguList", siguList);
		return "forward:siguList.jsp";
	}
	@GetMapping("dongList")
	public String dongList(@ModelAttribute("sigu") String sigu,Model mod) {
		List<Map<String, Object>> dongList = null;
		dongList = scheduleLogic.dongList(sigu);
		mod.addAttribute("dongList", dongList);
		return "forward:dongList.jsp";
	}
}
