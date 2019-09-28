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
<h1>listBean에는 무엇이 담겨있을까?</h1>
<%
	List<String> listBean = (List<String>)request.getAttribute("listBean");
	for(int i=0;i<listBean.size();i++){
		out.print(listBean.get(i)+"<br>");
	}
%>
</body>
</html>