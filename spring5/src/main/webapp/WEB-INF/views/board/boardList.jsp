<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WEB-INF/views/board/boardList.jsp</h1>
<%
	List<Map<String,Object>> memList = (List<Map<String,Object>>)request.getAttribute("memList");
	int size = memList.size();
	if(memList != null){
		out.print("<h4>size : "+size+"<br></h4>");
	}
	for(Map<String,Object> ml : memList){
		out.print(ml.get("mem_address")+"<br>");
	}
%>
</body>
</html>