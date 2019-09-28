package com.sts3.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order/*")
public class OrderController {
	@GetMapping(value="pizzaOrder", produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String test() {
		return "피자주문";
	}
}
