package com.sts3.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/rest/*")
public class RestCommonController {
	private static final Logger logger = LoggerFactory.getLogger(RestCommonController.class);
//	@Autowired
//	private OrderLogic orderLogic;
	
	//http://localhost:8000/sample/rest/rtest.do
	@GetMapping(value="rtest.do", produces="text/plain; charset=UTF-8")
	public String rtest(@RequestParam Map<String, Object> pMap) {
		return "테스트";
	}
	//http://localhost:8000/sample/rest/rJson.do
	@GetMapping(value="rJson.do", produces="application/json;charset=UTF-8")
	public String rJson() {
		List<Map<String,Object>> cusList = new ArrayList<>();
	    Map<String,Object> rMap = new HashMap<>();
	    rMap.put("mem_name","이순신");
	    rMap.put("mem_addr","서울시 마포구 공덕동");
	    rMap.put("mem_tel","025559999");
	    cusList.add(rMap);
	    rMap = new HashMap<>();
	    rMap.put("mem_name","김유신");
	    rMap.put("mem_addr","서울시 영등포구 당산동");
	    rMap.put("mem_tel","026669999");
	    cusList.add(rMap);
	    rMap = new HashMap<>();
	    rMap.put("mem_name","강감찬");
	    rMap.put("mem_addr","서울시 구로구 개봉동");
	    rMap.put("mem_tel","027779999");
	    cusList.add(rMap);
	    Gson g = new Gson();
	    String temp = g.toJson(cusList);
		return temp;
	}
	//jackson-core, jackson-datatype-jsr310 모듈 추가하면 return List<Map>으로 가능
	//http://localhost:8000/sample/rest/rJson2.do
	@GetMapping(value="rJson2.do", produces="application/json;charset=UTF-8")
	public List<Map<String, Object>> rJson2() {
		List<Map<String,Object>> cusList = new ArrayList<>();
	    Map<String,Object> rMap = new HashMap<>();
	    rMap.put("mem_name","이순신");
	    rMap.put("mem_addr","서울시 마포구 공덕동");
	    rMap.put("mem_tel","025559999");
	    cusList.add(rMap);
	    rMap = new HashMap<>();
	    rMap.put("mem_name","김유신");
	    rMap.put("mem_addr","서울시 영등포구 당산동");
	    rMap.put("mem_tel","026669999");
	    cusList.add(rMap);
	    rMap = new HashMap<>();
	    rMap.put("mem_name","강감찬");
	    rMap.put("mem_addr","서울시 구로구 개봉동");
	    rMap.put("mem_tel","027779999");
	    cusList.add(rMap);
	    return cusList;
	}
	//http://localhost:8000/sample/rest/breaknek.do?mem_tel=026669999
	@GetMapping(value="breaknek.do", produces="text/plain; charset=UTF-8")
	public String breaknek
	(@ModelAttribute("mem_tel") String mem_tel) {
		logger.info("사용자가 입력한 전화번호 : "+mem_tel);
		List<Map<String,Object>> cusList = new ArrayList<>();
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("mem_name","이순신");
		rMap.put("mem_addr","서울시 마포구 공덕동");
		rMap.put("mem_tel","025559999");
		cusList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_name","김유신");
		rMap.put("mem_addr","서울시 영등포구 당산동");
		rMap.put("mem_tel","026669999");
		cusList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_name","강감찬");
		rMap.put("mem_addr","서울시 구로구 개봉동");
		rMap.put("mem_tel","027779999");
		cusList.add(rMap);
		String your_addr = null;
		for(int i=0;i<cusList.size();i++) {
			Map<String, Object> map = cusList.get(i);
			if(map.containsKey("mem_tel")) {
				if(mem_tel.equals(map.get("mem_tel").toString())){
					your_addr = map.get("mem_addr").toString();
				}
			}
		}
		return your_addr;
	}
}
