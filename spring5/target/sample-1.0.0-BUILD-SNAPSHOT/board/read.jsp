<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> boardDetail = 
			(List<Map<String,Object>>)request.getAttribute("boardDetail");
	Map<String, Object> rMap = new HashMap<>();
	/*
	마이바티스 사용시 자동으로 담아주므로 vo의 경우 사용자가 대소문자를 구분해서 사용하지만
	Map의 경우 마이바티스가 컬럼명을 기준으로 자동으로 키값을 생성하는데 디폴트가 대문자임.
	*/
	if(boardDetail != null){
		rMap = boardDetail.get(0);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<%@ include file="/common/JEasyUICommon.jsp"%>
<script type="text/javascript">
	function addAction() {
		$("#f_boardAdd").attr("method","post");
		$("#f_boardAdd").attr("action","/board/test.mo?crud=boardAdd");
		$("#f_boardAdd").submit();
		//부모창에 함수를 호출할 때 opener.함수명(); - e.g. opener.boardList();
		self.close();
	}
	/***댓글***/
	function repleForm(){
		$("#dlg_boardAdd").dialog('open');
	}
	/***수정***/
	function updateForm(){
		common_window_popup('/board/test.mo?crud=updateForm&bm_no=<%=rMap.get("BM_NO")%>', '700', '400', 'updateForm');
	}
	/***삭제***/
	function deleteForm(){
		$("#dlg_boardDel").dialog({
			buttons:btn_boardDel
			,title:"글삭제"
			,width:420
			,height:250
			,modal:true
			,href:'boardDelForm.jsp'
		});
		$("#dlg_boardDel").dialog('open');
	}
	//삭제 처리
	function boardDelClose(){
		$("#dlg_boardDel").dialog('close');    	
    }
	//삭제 처리 화면에서 확인 버튼을 클릭했을 때
	function boardDel(){
		var db_pw = "<%=rMap.get("BM_PW")%>";
		//현재 내가 위치하는 페이지와 비번 입력받는 화면이 다르다. 접근이 가능한가?
		var u_pw = $("#u_pw").textbox('getValue');
		//alert(db_pw+", "+u_pw);
		/* 
		사용자가 입력한 비번과 DB에서 읽어들인 비번을 비교하여 일치하면 삭제 처리 진행
		불일치시 비번을 다시 입력받도록 한다.
		*/
		if(db_pw == u_pw){//비번이 일치했을때 삭제 프로세스를 태운다.
			//alert("==");
			$.messager.confirm('Confirm','정말 삭제하시겠습니까?',function(r){
				if(r){
					location.href="/board/test.mo?crud=boardDel&bm_no=<%=rMap.get("BM_NO")%>&bs_file=<%=rMap.get("BS_FILE")%>"
				}
			});
		}else{//비번이 틀릴때는 새로 입력 받는다.
			//alert("!=");
			$("#dlg_boardDel").textbox('setValue','');
		}
	}
	/***목록***/
	function boardList(){
		location.href="/board/test.mo?crud=boardList";
	}
</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function (){		
		$("#dlg_boardDel").hide();
	});
</script>
<table id="pan_read" class="easyui-panel" title="글상세보기" data-options="footer:'#tb_read'"
style="width:670px;height:380px;padding:10px;background:#fafafa;">
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
<div id="tb_read" style="padding:2px 5px;" align="center">
	<a href="javascript:repleForm()" class="easyui-linkbutton" iconCls='icon-edit' plain="true">댓글쓰기</a>
	<a href="javascript:updateForm()" class="easyui-linkbutton" iconCls='icon-add' plain="true">수정</a>
	<a href="javascript:deleteForm()" class="easyui-linkbutton" iconCls='icon-remove' plain="true">삭제</a>
	<a href="javascript:boardList()" class="easyui-linkbutton" iconCls='icon-search' plain="true">목록</a>
</div>
<!-- 수정하기, 삭제하기, 댓글쓰기, 목록 버튼 -->
<!--==========================[글수정하기 화면]==========================-->

<!--==========================[글삭제하기 화면]==========================-->
<div id="dlg_boardDel" closed="true" class="easyui_dialog" style="padding: 20px 50px">

    <!-- 확인 버튼과 닫기 버튼 추가 -->
	<div id="btn_boardDel" align="right">
    <a href="javascript:boardDel()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">확인</a>
    <a href="javascript:boardDelClose()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">닫기</a>
	</div>
</div>
<!--==========================[댓글쓰기    화면]==========================-->
<div id="dlg_boardAdd" title="댓글쓰기" class="easyui-dialog" data-options="closed:'true', modal:'true', footer:'#tbar_boardAdd'">
<!-- form전송 -->	
	<form id="f_boardAdd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO")%>"/>
	<input type="hidden" name="bm_group" value="<%=rMap.get("BM_GROUP")%>"/>
	<input type="hidden" name="bm_pos" value="<%=rMap.get("BM_POS")%>"/>
	<input type="hidden" name="bm_step" value="<%=rMap.get("BM_STEP")%>"/>
		<table>
			<tr>
				<td width="100px">제목</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_title" name="bm_title" data-options="width:'400px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">작성자</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_writer" name="bm_writer" data-options="width:'200px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">이메일</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_email" name="bm_email" data-options="width:'300px'">
				</td>
			</tr>
			<tr>
				<td width="100px">내용</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_content" name="bm_content" data-options="multiline:'true',width:'400px',height:'150px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">비번</td>
				<td width="500px">
					<input class="easyui-passwordbox" id="bm_pw" name="bm_pw" data-options="width:'200px'" required>
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 입력 화면 버튼 추가 -->
<div id="tbar_boardAdd" align="right">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save">저장</a>
	<a href="javascript:$('#dlg_boardAdd').dialog('close')"
	   class="easyui-linkbutton" iconCls="icon-cancel">닫기</a>
</div> 
</body>
</html>