<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> dongList = (List<Map<String,Object>>)request.getAttribute("dongList");
	int size = 0;
	if(dongList != null){
		size = dongList.size();
	}
%>
<select id="dong" class="form-control" style="width:150px">
<%
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = dongList.get(i);
%>
	<option value="<%=rMap.get("DONG")%>"><%=rMap.get("DONG")%></option>
<%
	}
%>	
</select>