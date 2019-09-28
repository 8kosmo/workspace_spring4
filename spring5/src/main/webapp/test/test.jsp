<%@page import="com.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sample/test/test.jsp</h1>
	<h1>page : ${page}</h1>
	<h1>mVO : ${mVO}</h1>
	<h1>mVO2 : ${mVO2.mem_id}</h1>
	<h1>mVO2 : ${mVO2.mem_pw}</h1>
	<h1>member : ${member.mem_id}</h1>
	<h1>member : ${member.mem_pw}</h1>
	<h1>start : ${start}</h1>
	<h1>status : ${status}</h1>
</body>
</html>