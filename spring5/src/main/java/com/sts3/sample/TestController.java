package com.sts3.sample;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vo.MemberVO;

@Controller
@SessionAttributes({"member","page"})
@RequestMapping("/test/*")
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	/*
	 * Model, ModelMap은 화면에서 넘어온 값을 응답페이지에 강제로 보내주지 않음.
	 * @ModelAttribute는 두 가지 표현식이 가능한데
	 * 하나는 파라미터에 이름을 쓴 경우 - 화면에서 그 값을 사용가능
	 * 두번째는 파라미터 없이 변수이름만 쓴 경우 - 화면에서 사용불가
	 * @ModelAttribute는 forward시 유지해주지만, @RequestParam은 유지해주지 않는다.
	 */
	//http://localhost:8000/sample/test/test1?page=10&start=5
	@GetMapping("/test1")
	public String methodA
	(int page
			, @ModelAttribute("start") int start) {
		logger.info("page : "+page);
		return "redirect:test.jsp";
	}
	//http://localhost:8000/sample/test/test2?page=10&mem_id=test&mem_pw=123&start=5
	@GetMapping("/test2")
	public String methodB
	(int page
			, @ModelAttribute("mVO") MemberVO mVO
			, MemberVO mVO2
			, @ModelAttribute("start") int start) {
		logger.info("page : "+page);
		logger.info("mVO : "+mVO);
		logger.info("mVO2 : "+mVO2);
		return "forward:test.jsp";
	}
	//http://localhost:8000/sample/test/test3?mem_id=test&mem_pw=123
	@GetMapping("/test3")
	public String methodC
	(MemberVO mVO
			,MemberVO member
			,Model model
			,HttpSession session) {
		logger.info("mVO : "+mVO);
		logger.info("mVO2 : "+member);
		model.addAttribute("member",member);
		return "redirect:test.jsp";
	}
	@ModelAttribute("member")
	public MemberVO member() {
		return new MemberVO();
	}
	//http://localhost:8000/sample/test/test4?status=휴가중
	@GetMapping("/test4")
	public String methodD
	(@RequestParam(defaultValue="야근 해야지") String status) {
		logger.info("status : "+status);
		return "forward:test.jsp";
	}
}
