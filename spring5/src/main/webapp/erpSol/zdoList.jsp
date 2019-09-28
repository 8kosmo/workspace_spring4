<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> zdoList = (List<Map<String,Object>>)request.getAttribute("zdoList");
	int size = 0;
	if(zdoList != null){
		size = zdoList.size();
	}
%>
<select id="zdo" class="form-control" style="width:150px">
<%
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = zdoList.get(i);
%>
	<option value="<%=rMap.get("ZDO")%>"><%=rMap.get("ZDO")%></option>
<%
	}
%>	
</select>