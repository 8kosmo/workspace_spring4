<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> memList = null;
	int size = 0;
	if(request.getAttribute("memList") != null) {
		memList = (List<Map<String,Object>>)request.getAttribute("memList");
		size = memList.size();
	}
	if(memList != null){
		out.print("<h4>size : "+size+"<br></h4>");
		for(Map<String,Object> ml : memList){
			out.print(ml.get("mem_address")+"<br>");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function boardList() {
			document.getElementById("f_test").submit();
		}
	</script>
</head>
<body>
	<h1>webapp/board/boardList.jsp</h1>
	<form id="f_test" action="boardList3" method="post">
	<button onclick="boardList()">Click</button>
	</form>
</body>
</html>