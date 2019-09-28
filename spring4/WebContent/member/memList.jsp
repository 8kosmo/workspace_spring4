<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> memList = (List<Map<String,Object>>)request.getAttribute("memList");
	out.println(memList);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%@ include file="../../../common/JEasyUICommon.jsp" %> --%>
</head>
<body>
<h1>이 페이지는 /WebContent/member/memlist.jsp입니다.</h1>
<%-- <table id="dg"></table>
	<script type="text/javascript">
		$('#dg').datagrid({
			columns : [[ 
				{field : 'MEM_ID', title : 'ID', width : 100}, 
				{field : 'MEM_NAME', title : '이름', width : 100}, 
				{field : 'MEM_ADDR',title : '주소',width : 100,align : 'right'}
			]],
			data:[
				{"MEM_ID":"<%=%>","MEM_NAME":"<%=%>","MEM_ADDR":"<%=%>"}
			]
		});
	</script> --%>
</body>
</html>