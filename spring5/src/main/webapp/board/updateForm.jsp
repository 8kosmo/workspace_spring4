<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> updateForm = 
			(List<Map<String,Object>>)request.getAttribute("boardDetail");
	Map<String, Object> rMap = new HashMap<>();
	/*
	마이바티스 사용시 자동으로 담아주므로 vo의 경우 사용자가 대소문자를 구분해서 사용하지만
	Map의 경우 마이바티스가 컬럼명을 기준으로 자동으로 키값을 생성하는데 디폴트가 대문자임.
	*/
	if(updateForm != null){
		rMap = updateForm.get(0);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update table</title>
<%@ include file="/common/JEasyUICommon.jsp"%>
<script type="text/javascript">
	function updateAction() {
		$("#f_boardUpd").attr("method","post");
		$("#f_boardUpd").attr('action','boardUpd.mvc');
		$("#f_boardUpd").submit();
	}
</script>
</head>
<body>
	<form id="f_boardUpd">
	<input type="hidden" name="crud" value="boardUpd"/>
	<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO")%>"/>
	<table id="pan_update" class="easyui-panel" title="글수정하기" data-options="footer:'#tb_read'"
	style="width:570px;height:380px;padding:10px;background:#fafafa;">
		<tr>
			<td>제목</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_TITLE") %>" id="bm_title"
					name="bm_title" data-options="width:'450px'"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_WRITER") %>" id="bm_writer"
					name="bm_writer" data-options="width:'450px'"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_EMAIL") %>" id="bm_email"
					name="bm_email" data-options="width:'450px'"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_CONTENT") %>" id="bm_content"
					name="bm_content" data-options="multiline:'true', width:'450px',height:'90px'"></td>
		</tr>
		<tr>
			<td>비번</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_PW") %>" id="bm_pw"
					name="bm_pw" data-options="width:'450px'"></td>
		</tr>
	</table>
	</form>
	<div id="tb_read" style="padding:2px 5px;" align="right">
		<a href="javascript:updateAction()" class="easyui-linkbutton" iconCls='icon-save' plain="true">수정</a>
		<a href="javascript:self.close()" class="easyui-linkbutton" iconCls='"icon-cancel"' plain="true">닫기</a>
	</div>
</body>
</html>