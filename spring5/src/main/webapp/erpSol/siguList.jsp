<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> siguList = (List<Map<String,Object>>)request.getAttribute("siguList");
	int size = 0;
	if(siguList != null){
		size = siguList.size();
	}
%>
<select id="sigu" class="form-control" style="width:150px">
<%
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = siguList.get(i);
%>
	<option value="<%=rMap.get("SIGU")%>"><%=rMap.get("SIGU")%></option>
<%
	}
%>	
</select>