<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String bm_no = request.getParameter("bm_no");
	String bm_pw = request.getParameter("bm_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/JEasyUICommon.jsp"%>
</head>
<body>
	<input class="easyui-textbox" id="u_pw" name="u_pw" label="비밀번호 : " 
	       style="width:200px;height:25px">	
</body>
</html>