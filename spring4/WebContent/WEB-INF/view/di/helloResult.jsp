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
<h1>어서와 xml에서 넘어가는건 처음이지</h1>
<%
	List<String> nameList = (List<String>)request.getAttribute("nameList");
	out.println(nameList.get(0));
	out.println(nameList);
%>
</body>
</html>