/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-09-26 05:22:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.PageBar;
import java.util.Map;
import java.util.List;

public final class boardListVer2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/JEasyUICommon.jsp", Long.valueOf(1569475292056L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.util.PageBar");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

//총 레코드 수
	int tot = 0;
	if(session.getAttribute("s_tot")!=null){
		tot = Integer.parseInt(session.getAttribute("s_tot").toString());
	}
	out.print("tot:"+tot);
	int size = 0;
	List<Map<String, Object>> boardList = 
			(List<Map<String, Object>>)request.getAttribute("boardList");
	if(boardList != null && boardList.size()>0){
		size = boardList.size();
	}
	/////////////페이지 네비게이션 추가분/////////////
	int numPerPage = 7;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}

      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("\t화면처리를 태그로 할 때와 스크립트로 할 때\r\n");
      out.write("\t1.태그안에 코드를 작성하면 디자인과 코드가 분리가 안되서 가독성이 떨어짐.\r\n");
      out.write("\t2.스크립트로 처리할 때 화면에서 코드가 분리됨(이벤트 처리나 DOM조작하는 코드작성시 접근성이 좋다)\r\n");
      out.write("\t3.화면과 스크립트 코드를 분리하게 되면 react적용시 라이프 사이클에 따라 코드 적용이 용이함.\r\n");
      out.write("\t -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>MVC패턴을 적용한 계층형 게시판</title>\r\n");

	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/sample");

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString());
      out.write("/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString());
      out.write("/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString());
      out.write("/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString());
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString());
      out.write("/js/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString());
      out.write("/js/commons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString());
      out.write("/js/jquery.cookie.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar tb_value;\r\n");
      out.write("/*\r\n");
      out.write(" * 각 로우별로 DB에서 새로 읽어들인 값이 출력이 되고 그 파일이름으로 다운로드 파일명을 찾아야 하므로\r\n");
      out.write(" 이벤트가 발생할 때 파일 이름은 달라지게 된다.\r\n");
      out.write(" 자바코드로 읽어들인 정보를 자바스크립트 변수로 사용하는 것은 가능한 일이나 그 값은 상수처럼 정해진 값\r\n");
      out.write(" 즉 정적인 성격을 가지고 있으므로 사용할 때 주의할 것.\r\n");
      out.write(" 서버에서 바뀐 값이 화면에 즉시 반영 될 수 없는 것은 서버페이지가 아닌 응답 페이지의 경우 이미 html코드로\r\n");
      out.write(" 변경된 페이지가 다운되고 출력되므로 절대로 유동적인 변화를 기대할 수 없다.\r\n");
      out.write(" */\r\n");
      out.write("\tfunction fileDown(fname) {\r\n");
      out.write("\t\tlocation.href=\"download.jsp?bs_file=\"+fname;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction boardDetail(p_bmno){\r\n");
      out.write("\t\t//common_window_popup(\"test.mo?crud=boardDetail&bm_no=\"+p_bmno,\"900\",\"650\",\"read\");\r\n");
      out.write("\t\tlocation.href=\"/sample/board/boardDetail.mvc?bm_no=\"+p_bmno;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addAction() {\r\n");
      out.write("\t\t$(\"#f_boardAdd\").attr(\"method\",\"post\");\r\n");
      out.write("\t\t$(\"#f_boardAdd\").attr(\"action\",\"/sample/board/boardAdd.mvc\");\r\n");
      out.write("\t\t$(\"#f_boardAdd\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addForm(){\r\n");
      out.write("\t\t//alert();\r\n");
      out.write("\t\t$(\"#dlg_boardAdd\").dialog('open');\r\n");
      out.write("\t};\r\n");
      out.write("\tfunction updForm(){\r\n");
      out.write("\t\tlocation.href=\"/sample/board/boardList.mvc?nowPage=0\";\r\n");
      out.write("\t};\r\n");
      out.write("\tfunction delForm(){\r\n");
      out.write("\t\talert();\r\n");
      out.write("\t};\r\n");
      out.write("\tfunction deleteRow() {\r\n");
      out.write("\t\tvar vbmnos = \"\";\r\n");
      out.write("\t\tvar vbsfiles = \"\";\r\n");
      out.write("\t\t//배열에 담기 위해 선언한 배열 객체\r\n");
      out.write("\t\tvar bmnoArr = [];\r\n");
      out.write("\t\tvar bsfileArr = []\r\n");
      out.write("\t\t//선택한 로우의 값을 담을 변수 -배열\r\n");
      out.write("\t\tvar rows = $(\"#dg_board\").datagrid('getSelections');//로우에 대한 Object\r\n");
      out.write("\t\talert(\"rows.length : \"+rows.length);\r\n");
      out.write("\t\t$.messager.confirm('Confirm','정말삭제하시겠습니까?'\r\n");
      out.write("\t\t,function(r){\r\n");
      out.write("\t\t\tif(r){\r\n");
      out.write("\t\t\t\t//사용자가 선택한 로우에 Object를 이용하면 field에 접근할 수 있다.\r\n");
      out.write("\t\t\t\tif(rows==null){\r\n");
      out.write("\t\t\t\t\talert(\"삭제할 들을 선택하세요.\");\r\n");
      out.write("\t\t\t\t\treturn;//deleteRow함수 탈출\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//선택한 로우의 객체배열을 활용하여 값 로우에 담긴 글번호를 배열안에 넣기\r\n");
      out.write("\t\t\t\t//아래 변수는 선택한 로우에서 글번호는 존재하지만 첨부파일이 없는 경우\r\n");
      out.write("\t\t\t\t//배열의 인덱스값이 달라져야 하므로 그 값을 담을 변수임.\r\n");
      out.write("\t\t\t\tvar isOk=0;\r\n");
      out.write("\t\t\t\tfor(var i=0;i<rows.length;i++){\r\n");
      out.write("\t\t\t\t\t//필드명은 myBatis의 Map을 사용하였으므로 반드시 대문자로 처리함.\r\n");
      out.write("\t\t\t\t\tbmnoArr.push(rows[i].BM_NO);\r\n");
      out.write("\t\t\t\t\tif(rows[i].BS_FILE2 != null && rows[i].BS_FILE2.length>1){\r\n");
      out.write("\t\t\t\t\t\tisOk++;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\talert(\"isOk:\"+isOk);\r\n");
      out.write("\t\t\t\tfor(var j=0;j<isOk;j++){\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//필드명은 myBatis의 Map을 사용하였으므로 반드시 대문자로 처리함.\r\n");
      out.write("\t\t\t\t\tbsfileArr.push(rows[j].BS_FILE2);//이제는 <a href=...아니고 bs_file명만 찍힌다.\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//배열에 담긴 정보 출력해보기\r\n");
      out.write("\t\t\t\tfor(var i=0;i<rows.length;i++){\r\n");
      out.write("\t\t\t\t\t//맨 마지막에 붙는 값 뒤에는 콤마를 붙일 필요가 없음.\r\n");
      out.write("\t\t\t\t\tif(i==(rows.length-1)){\r\n");
      out.write("\t\t\t\t\t\tvbmnos += bmnoArr[i];\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t//뒤에 값이 더 있을 경우에는 콤마를 붙여줍니다.\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tvbmnos += bmnoArr[i]+\",\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}//end of 2nd for\r\n");
      out.write("\t\t\t\t/* 로우의수는 고정이지만 첨부파일은 있는 경우도 있고 없는 경우도있으므로\r\n");
      out.write("\t\t\t\t똑같이 반복되서는 안될 것임.\r\n");
      out.write("\t\t\t\t배열에 담기는 글번호의 갯수와 첨부 파일의 갯수가 다를 수 있다는 것음.\r\n");
      out.write("\t\t\t\t따라서 별도로 인덱스값을 계산해야 하므로 변수 j를 사용한 것임.\t\t*/\r\n");
      out.write("\t\t\t\tfor(var j=0;j<isOk;j++){\r\n");
      out.write("\t\t\t\t\t//맨 마지막에 붙는 값 뒤에는 콤마를 붙일 필요가 없음.\r\n");
      out.write("\t\t\t\t\tif(j==(isOk-1)){\r\n");
      out.write("\t\t\t\t\t\tvbsfiles += bsfileArr[j];\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t//뒤에 값이 더 있을 경우에는 콤마를 붙여줍니다.\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tvbsfiles += bsfileArr[j]+\",\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}//end of 2nd for\r\n");
      out.write("\t\t\t\t//12,9,6\r\n");
      out.write("\t\t\t\talert(\"vbmnos:\"+vbmnos+\"   file명:\"+vbsfiles);\r\n");
      out.write("\t\t\t\t//location.href=\"/sample/board/boardDelAll.mvc?bmnos=\"+vbmnos+\"&bsfiles=\"+vbsfiles;//서버에 요청(get방식)\r\n");
      out.write("\t\t\t\t//화면상에서만 삭제된다 - 삭제 후 새로 select처리할 것이므로 의미없다.\r\n");
      out.write("\t\t\t\t//$(\"#grid_emp\").datagrid('deleteRow',getRowIndex(target));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//전역변수 선언위치\r\n");
      out.write("\t//목록화면에서 사용자가 제목을 더블클릭 했을때 셀에 대한 정보만 들어있으므로\r\n");
      out.write("\t//선택한 로우에 숫자값을 가지고 숨어있는 필드 bm_no값을 가져와서 담는다.\r\n");
      out.write("\tvar g_no\r\n");
      out.write("\tvar user_combo;//콤보박스에서 선택한 값 담기\r\n");
      out.write("/* ==========================[날짜 기본 포맷을 재정의]========================== */\r\n");
      out.write("\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\tvar d = date.getDate();\r\n");
      out.write("\t\treturn y+'-'+(m<10?\"0\"+m:m)+'-'+(d<10?\"0\"+d:d);\r\n");
      out.write("\t}\r\n");
      out.write("\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\treturn new Date(t);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn new Date();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("/* ==========================[combobox 이벤트 처리]========================== */\r\n");
      out.write("\t\t$(\"#cb_search\").combobox({\r\n");
      out.write("\t\t\tonChange:function(){\r\n");
      out.write("\t\t\t\tuser_combo = $(this).combobox('getValue');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("/* ==========================[textbox 엔터 이벤트 처리]========================== */\r\n");
      out.write("\t\t$(\"#keyword\").textbox('textbox').bind('keydown',function(e){\r\n");
      out.write("\t\t\tif(e.keyCode==13){\r\n");
      out.write("\t\t\t\t//alert(\"엔터이벤트\");\r\n");
      out.write("\t\t\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\t\turl:\"/sample/board/boardList.mvc&cb_search=\"+user_combo+\"&keyword=\"+$(\"#keyword\").val()\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});//end of ready\r\n");
      out.write("</script>\r\n");
      out.write("<!--==========================[글목록화면 시작]==========================\r\n");
      out.write("jEasyui의 DataGrid API를 활용하여 작성\t\r\n");
      out.write("1)익스프레션을 이용하여 화면 처리\r\n");
      out.write("\t:tr, td태그를 직접 작성해서 처리하는 방식\r\n");
      out.write("2)json포맷으로 처리해서 매핑\r\n");
      out.write("\t:field명만 맞춰주면 자동으로 매핑\r\n");
      out.write("-->\r\n");
      out.write("<table id=\"dg_board\" class=\"easyui-datagrid\" title=\"글목록\" style=\"width:800px;height:600px\"\r\n");
      out.write(" data-options=\"singleSelect:false, toolbar:'#tb_board,#tb_search',footer:'#pn_board'\">\r\n");
      out.write("<!-- 헤더 부분 추가 -->\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th data-options=\"field:'BM_NO',width:'50px',hidden:'true'\">&nbsp;</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'BM_TITLE',width:'350px'\">제목</th>\r\n");
      out.write("            <th data-options=\"field:'BM_WRITER',width:'100px'\">작성자</th>\r\n");
      out.write("            <th data-options=\"field:'BM_DATE',width:'100px'\">작성일</th>\r\n");
      out.write("            <th data-options=\"field:'BS_FILE',width:'100px'\">첨부파일</th>\r\n");
      out.write("            <th data-options=\"field:'BS_FILE2',width:'100px',hidden:'true'\">&nbsp;</th>\r\n");
      out.write("            <th data-options=\"field:'BM_HIT',width:'100px'\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<!-- 데이터 출력 영역 -->\r\n");
      out.write("\t<tbody>\r\n");

	if(size==0){

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"5\">조회결과가 없습니다.</td>\r\n");
      out.write("\t\t</tr>\r\n");

	}
	else if(size>0){
//		for(int i=0;i<size;i++){
		for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){//초기값nowPage=0,numPerPage=2일경우, i=0;i<2;i++라는 뜻
			if(size == i) break;
			Map<String, Object> rMap = boardList.get(i);

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("<!-- \r\n");
      out.write("header영역에서 hidden으로 처리해서 화면상에는 보이지 않지만 datagrid안에는 값이 들어있는 상태여야 함.\r\n");
      out.write("그래야 값을 꺼낼 수 있기 때문임.\r\n");
      out.write(" -->\r\n");
      out.write("\t\t\t<td>");
      out.print(rMap.get("BM_NO") );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("<!-- 당신은 댓글 입니까? -->\r\n");
	
	String imgPath = path+"\\images\\";
	if(Integer.parseInt(rMap.get("BM_POS").toString()) > 0){
		for(int j=0;j<Integer.parseInt(rMap.get("BM_POS").toString());j++){
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		}

      out.write("\r\n");
      out.write("\t<img src=\"");
      out.print(imgPath );
      out.write("reply.gif\" border=\"0\">\r\n");

	}

      out.write("\r\n");
      out.write("\t<a href=\"javascript:boardDetail('");
      out.print(rMap.get("BM_NO") );
      out.write("')\" style=\"text-decoration:none;color:black\">\r\n");
      out.write("\t\t\t");
      out.print(rMap.get("BM_TITLE"));
      out.write("</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rMap.get("BM_WRITER"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rMap.get("BM_DATE"));
      out.write("</td>\r\n");
      out.write("<!-- \r\n");
      out.write("익스프레션을 사용하게 되면 자바 코드로 읽어들인 값을 html태그 영역에 출력해준 결과가 로컬 PC로 다운된다.\r\n");
      out.write("소스보기를 해보면 익스프레션 식은 보이지 않고 처리 결과 즉 문자열만 확인할 수 있을 것이다.\r\n");
      out.write("이것만 보더라도 서버에서 변경된 결과값들이 화면에 왜 즉시 반영될 수 없는 구조 인지확인 할 수 있겠다.\r\n");
      out.write("자바 스크립트에서 값을 넘길 때는 반드시 싱글 혹은 더블 쿼테이션을 붙여야 변수로 취급 반지 않는다.\r\n");
      out.write("F12에서 undefine variable 메세지를 봤다면 그것 때문이다. -->\r\n");
      out.write("\t\t\t<td><a href=\"javascript:fileDown('");
      out.print(rMap.get("BS_FILE"));
      out.write("')\" style=\"text-decoration:none;color:black\">");
      out.print(rMap.get("BS_FILE"));
      out.write("</a></td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rMap.get("BS_FILE"));
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(rMap.get("BM_HIT"));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");

		}//end of for
	}//////end of else if

      out.write("\r\n");
      out.write("\t</tbody>\r\n");
      out.write(" </table>\r\n");
      out.write("<!--==========================[페이지 네이션 추가]==========================-->\r\n");
      out.write("<table border=\"1\" bordercolor=\"red\" style=\"width:800px;height:20px\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\" >\r\n");
      out.write("\t\r\n");

	String pagePath = "boardList.mvc";
	PageBar pb = new PageBar(numPerPage,tot,nowPage,pagePath);
	String pagination = null;
	pagination = pb.getPageBar();
	out.print(pagination);

      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<!-- 조건검색 추가(툴바하기) -->\r\n");
      out.write("<div id=\"tb_search\" style=\"padding:2px 5px;\">\r\n");
      out.write("\t<select id=\"cb_search\" name=\"cb_search\" class=\"easyui-combobox\" panelHeight=\"auto\" style=\"width:100px\">\r\n");
      out.write("\t\t<option selected value=\"\">선택</option>\r\n");
      out.write("\t\t<option value=\"bm_title\">제목</option>\r\n");
      out.write("\t\t<option value=\"bm_content\">내용</option>\r\n");
      out.write("\t\t<option value=\"bm_writer\">작성자</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input class=\"easyui-textbox\" id=\"keyword\" name=\"keyword\" style=\"width:320px\">\r\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t작성일:<input class=\"easyui-datebox\" id=\"bm_date\" name=\"bm_date\" style=\"width:120px\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"tb_board\" style=\"padding:2px 5px;\">\r\n");
      out.write("\t<a href=\"javascript:boardList()\" class=\"easyui-linkbutton\" iconCls='icon-search' plain=\"true\">조회</a>\r\n");
      out.write("\t<a href=\"javascript:addForm()\" class=\"easyui-linkbutton\" iconCls='icon-edit' plain=\"true\">입력</a>\r\n");
      out.write("\t<a href=\"javascript:updForm()\" class=\"easyui-linkbutton\" iconCls='icon-add' plain=\"true\">수정</a>\r\n");
      out.write("\t<a href=\"javascript:deleteRow()\" class=\"easyui-linkbutton\" iconCls='icon-remove' plain=\"true\">삭제</a>\r\n");
      out.write("</div>\r\n");
      out.write("<!--==========================[글목록화면 끝   ]==========================-->\r\n");
      out.write("\r\n");
      out.write("<!--==========================[글쓰기화면 시작]==========================\r\n");
      out.write("jEasyui의 Dialog API를 활용하여 작성\r\n");
      out.write("-->\r\n");
      out.write("<div id=\"dlg_boardAdd\" title=\"글쓰기\" class=\"easyui-dialog\" data-options=\"closed:'true', modal:'true', footer:'#tbar_boardAdd'\">\r\n");
      out.write("<!-- form전송 -->\t\r\n");
      out.write("\t<form id=\"f_boardAdd\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_no\" value=\"0\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_group\" value=\"0\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_pos\" value=\"0\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_step\" value=\"0\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100px\">제목</td>\r\n");
      out.write("\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_title\" name=\"bm_title\" data-options=\"width:'400px'\" required>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100px\">작성자</td>\r\n");
      out.write("\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_writer\" name=\"bm_writer\" data-options=\"width:'200px'\" required>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100px\">이메일</td>\r\n");
      out.write("\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_email\" name=\"bm_email\" data-options=\"width:'300px'\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100px\">내용</td>\r\n");
      out.write("\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_content\" name=\"bm_content\" data-options=\"multiline:'true',width:'400px',height:'150px'\" required>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100px\">비번</td>\r\n");
      out.write("\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-passwordbox\" id=\"bm_pw\" name=\"bm_pw\" data-options=\"width:'200px'\" required>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"100px\">첨부파일</td>\r\n");
      out.write("\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-filebox\" id=\"bs_file\" name=\"bs_file\" \r\n");
      out.write("\t\t\t\t\t\tdata-options=\"width:'300px'\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 입력 화면 버튼 추가 -->\r\n");
      out.write("<div id=\"tbar_boardAdd\" align=\"right\">\r\n");
      out.write("\t<a href=\"javascript:addAction()\" class=\"easyui-linkbutton\" iconCls=\"icon-save\">저장</a>\r\n");
      out.write("\t<a href=\"javascript:$('#dlg_boardAdd').dialog('close')\"\r\n");
      out.write("\t   class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">닫기</a>\r\n");
      out.write("</div> \r\n");
      out.write("<!--==========================[글쓰기화면 끝   ]==========================-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
