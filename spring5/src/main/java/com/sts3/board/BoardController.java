package com.sts3.board;
/*
 * ModelAndView. "board/boardList" - ViewResolver 사용, -WEB-INF아래에서 찾음
 * forwawrd or redirect - webapp아래에서 찾음
 * 
 * 세션처리 - 1)HttpSession session = req.getSession(); (세션을 직접 만들어서 처리하는 경우)
 * 			-이렇게 하면 필요한 시점에만 사용할 수 있음.
 * 		   2)public String methodA(HttpSession session){} (메소드에 세션을 직접 선언하는 방법)
 * 			-주의사항은 반드시 요청 매핑 어노테이션에서 사용하고, 항상 세션 객체가 생성되는것을 알아야한다.
 * 
 * 메이븐 프로젝트의 기본 디렉토리 구조
 * src/main/java : 자바소스 파일이 위치함
 * src/main/resources: 프로퍼티나 xml등 리소스 파일이 위치함.
 * 						클래스 패스에 포함됨.
 * 예)<property name="" value="classpath:mapper/mybatis-config.xml/>
 * src/main/webapp: 웹어플리케이션 관련 파일이 위치함.
 * src/test/java: 테스트 자바 소스파일이 위치함.
 * src/test/resources: 테스트 과정에서 사용되는 리소스 파일 위치함.
 * 
 * POM 파일 기본 -메이븐 프로젝트를 생성하면 pom.xml파일이 프로젝트 루트 폴더에 생성됨. 이 pom.xml파일은 Project Object Model정보를 담고있음.
 * 1)프로젝트 정보: 프로젝트이름. 개발자 목록, 라이센스 등
 * 2)빌드설정: 소스, 리소스, 라이프사이클별 실행할 플러그인 등 빌드와 관련된 설정을 기술함.
 * 3)빌드환경: 사용자 환경별로 달라질 수 있는 프로파일 정보기술
 * 4)POM연관정보: 의존 프로젝트, 상위 프로젝트, 모듈등을 기술
 * 
 * POM에서 기술하는 태그
 * <name>프로젝트 이름
 * <url>프로젝트 사이트 URL
 * 
 * POM연관정보 관련 태그
 * <groupId> 프로젝트 그룹 ID설정
 * <articleId>프로젝트 ArtifactID설정
 * <version>버전 설정
 * <pakcaging>패키징 타입 설정함 jar 혹은 war
 * <dependencies>이 프로젝트에서 의존하는 다른 프로젝트 정보기술
 * <dependency>의존하는 프로젝트 POM정보 기술
 * <groupId>의존하는 프로젝트의 그룹ID
 * <articleId>의존하는 프로젝트 아티팩트Id설정
 * <version>의존하는 프로젝트 버전 설정
 * <scope>의존범위 설정 - 기본값은 compile이다.
 * compile: 컴파일할 때 필요, 설정하지 않을 경우 기본값이다.
 * test: 테스트 코드를 컴파일할 때 필요함. 테스트시에 클래스패스에 포함되고, 배포시에는 제외됨.
 * runtime: 런타임에 필요, JDBC드라이버등이 여기에 해당, 프로젝트를 컴파일 할 때는 필요없으나 실행할땐 필요함.
 * provided: 컴파일 할 때 필요하지만 실제 런타임 때에는 컨테이너 같은 것에서 기본으로 제공되는 모듈을 말함.
 * 			 예를 들어 서블릿이나 jsp API등이 여기에 해당됨, 배포시에는 제외됨.
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.util.HangulConversion;
import com.vo.BoardMasterVO;
import com.vo.MemberVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardLogic boardLogic;
	
	@RequestMapping(value="boardDelAll.mvc",method=RequestMethod.GET)
	public String boardDelAll
	(@RequestParam Map<String, Object> pMap) {
		logger.info("called boardDelAll(pMap):String");
		int result = 0;
		result = boardLogic.boardDelAll(pMap);
		logger.info("DeleteAll 결과 : result = "+result);
		return "redirect:boardList.mvc";
	}
	@RequestMapping(value="boardDel.mvc",method=RequestMethod.GET)
	public String boardDel
	(@RequestParam Map<String, Object> pMap) {
		logger.info("called boardDel(pMap):String");
		int result = 0;
		result = boardLogic.boardDel(pMap);
		logger.info("boardDel 결과 : result = "+result);
		return "redirect:boardList.mvc";
	}
	@RequestMapping(value="boardUpd.mvc", method=RequestMethod.POST)
	public String boardUpd
	(BoardMasterVO bmVO) {
		logger.info("called boardUpd(bmVO):String");
		int result = 0;
		String path = "";
		result = boardLogic.boardUpd(bmVO);
		if(result==1) {
			path = "redirect:boardList.mvc?nowPage=0";
		}else {
			path = "redirect:boardAddFail.jsp";
		}
		return path;
	}
	@RequestMapping(value="updateForm.mvc", method=RequestMethod.GET)
	public String updateForm
	(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("called updateForm(pMap,mod,req):String");
		logger.info("pMap.get(\"pageNumber\") : "+pMap.get("pageNumber"));
		logger.info("pMap.get(\"pageSize\") : "+pMap.get("pageSize"));
		List<Map<String, Object>> boardDetail = null;
		boardDetail = boardLogic.boardList(pMap);
		mod.addAttribute("boardDetail",boardDetail);
		return "forward:updateForm.jsp";
	}
	@RequestMapping(value="boardDetail.mvc", method=RequestMethod.GET)
	public String boardDetail
	(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("called boardDetail(pMap,mod,req):String");
		logger.info("pMap.get(\"pageNumber\") : "+pMap.get("pageNumber"));
		logger.info("pMap.get(\"pageSize\") : "+pMap.get("pageSize"));
		List<Map<String, Object>> boardDetail = null;
		pMap.put("gubun","hit");
		boardDetail = boardLogic.boardList(pMap);
		mod.addAttribute("boardDetail",boardDetail);
		return "forward:read.jsp";
	}
	@RequestMapping(value="boardAdd.mvc", method=RequestMethod.POST)
	public String boardAdd
	(@RequestParam Map<String, Object> pMap, @RequestParam(value="bs_file",required=false) MultipartFile bs_file) {
		logger.info("called boardAdd(@RequestParam pMap, @RequestParam bs_file):String");
		//logger.info("bs_file : "+HangulConversion.toUTF(bs_file.getOriginalFilename()));
		//logger.info("bs_file : "+bs_file.getOriginalFilename());
		logger.info("pMap.get(\"bm_group\") : "+pMap.get("bm_group"));
		logger.info("pMap.get(\"bm_pos\") : "+pMap.get("bm_pos"));
		logger.info("pMap.get(\"bm_step\") : "+pMap.get("bm_step"));
		logger.info("pMap.get(\"bs_file\") : "+bs_file);
		String savePath = "D:\\workspace_spring4\\spring5\\src\\main\\webapp\\pds";
		String fileName = null;
		String fullPath = null;
		if(bs_file != null) {
			fileName = bs_file.getOriginalFilename();
			fullPath = savePath+"\\"+fileName;
		}
		logger.info(fileName);
		logger.info(fullPath);
		//첨부파일이 존재하니?
		if(bs_file != null && !bs_file.isEmpty()) {
			try {
				File file = new File(fullPath);
				byte[] bytes = bs_file.getBytes();
				BufferedOutputStream bos =
						new BufferedOutputStream(new FileOutputStream(file));
				//52번에서 생성된 File객체에 내용쓰기
				bos.write(bytes);
				bos.close();
				//파일크기
				long size = file.length();
				double d_size = Math.floor(size/1024.0);
				pMap.put("bs_file",fileName);
				pMap.put("bs_size",d_size);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int result = 0;
		result = boardLogic.boardAdd(pMap);
		String path = "";
		if(result == 1) {
			path = "redirect:boardList.mvc";
		}else {
			path = "redirect:boardAddFail.jsp";			
		}
		return path;
	}
	@RequestMapping(value="boardList.mvc", method=RequestMethod.GET)
	public String boardList
	(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req){
		logger.info("called boardList(@RequestParam pMap, mod, req):String");
		logger.info("pageNumber : "+pMap.get("pageNumber"));
		logger.info("pageSize: : "+pMap.get("pageSize"));
		int tot = 0;
		tot = boardLogic.getTot(null);
		HttpSession session = req.getSession();
		session.setAttribute("s_tot", tot);
		List<Map<String, Object>> boardList = null;
		//페이지처리 초기값 담기
		int pageNumber = 0;
		int pageSize   = 0;
		if(pMap.containsKey("pageNumber")) {
			pageNumber = Integer.parseInt
					(pMap.get("pageNumber").toString());
		}
		if(pMap.containsKey("pageSize")) {
			pageSize = Integer.parseInt
					(pMap.get("pageSize").toString());
		}
		logger.info("pageNumber:"+pageNumber+",pageSize:"+pageSize);
		boardList = boardLogic.boardList(pMap);
		mod.addAttribute("boardList",boardList);
		return "forward:boardListVer2.jsp";
	}
	
	//ViewResolver 사용
	@RequestMapping(value="boardList.do", method=RequestMethod.GET)
	public String boardList(Model mod) {
	//public String boardList(MemberVO mVO) {
		//http://localhost:8000/sample/board/boardList.do?mem_id=John
		logger.info("called boardList:String");
	//	logger.info("mem_id : "+mVO.getMem_id());//John
		List<Map<String, Object>> memList = new ArrayList<>();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("mem_id", "test1");
		rMap.put("mem_name", "김과학");
		rMap.put("mem_address", "과학실");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "test2");
		rMap.put("mem_name", "최수학");
		rMap.put("mem_address", "교실");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "test3");
		rMap.put("mem_name", "황미술");
		rMap.put("mem_address", "미술실");
		memList.add(rMap);
		mod.addAttribute("memList",memList);
		return "board/boardList";
	}
	//WEB-INF/views/board/*
	//ViewResolver 사용
	@RequestMapping(value="boardList4")
	public String boardList4(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("called boardList4:ModelAndView");
		logger.info("mem_id : "+pMap.get("mem_id"));
		logger.info("mem_pw : "+pMap.get("mem_pw"));
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> memList = new ArrayList<>();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("mem_id", "test1");
		rMap.put("mem_name", "김과학");
		rMap.put("mem_address", "과학실");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "test2");
		rMap.put("mem_name", "최수학");
		rMap.put("mem_address", "교실");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "test3");
		rMap.put("mem_name", "황미술");
		rMap.put("mem_address", "미술실");
		memList.add(rMap);
		mod.addAttribute("memList",memList);
		return "board/boardList";
	}
	//webapp/board/*
	//ViewResolver 사용하지않음
	@GetMapping("boardList2")
	public String boardList2() {
		logger.info("called boardList2 - redirect");
		return "redirect:boardList.jsp";
	}
	//webapp/board/*
	//ViewResolver 사용하지않음
	@PostMapping("boardList3")
	public String boardList3(Model mod) {
		logger.info("called boardList3 - forward");
		List<Map<String, Object>> memList = new ArrayList<>();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("mem_id", "test1");
		rMap.put("mem_name", "김과학");
		rMap.put("mem_address", "과학실");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "test2");
		rMap.put("mem_name", "최수학");
		rMap.put("mem_address", "교실");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "test3");
		rMap.put("mem_name", "황미술");
		rMap.put("mem_address", "미술실");
		memList.add(rMap);
		mod.addAttribute("memList",memList);
		return "forward:boardList.jsp";
	}
}
