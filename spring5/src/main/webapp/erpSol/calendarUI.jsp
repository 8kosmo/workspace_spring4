<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String smem_id = "test";
	if(session.getAttribute("smem_id")!=null){
		smem_id = (String)session.getAttribute("smem_id");
	}
	//메모 등록하는 모달창에 출력될 날짜 정보 가져오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
	<script type="text/javascript">
		function memoForm(yyyy,mm,dd) {
			$("#d_curday").text(yyyy+"년"+mm+"월"+dd+"일");
			$("#myModal").modal();
		}
		function moAdd() {
			
		}
	</script>
</head>
<body>
<%
	Calendar cal = Calendar.getInstance();
	int day[][][] = new int[12][6][7];
	DecimalFormat df = new DecimalFormat("00");
	String week[] = {"일","월","화","수","목","금","토"};
	//이번달 정보 가져오기
	Calendar currCal = Calendar.getInstance();
	//달 정보는 0부터 11사이의 값이다. 1~12
	String cmonth = df.format(currCal.get(Calendar.MONTH)+1);
	String cyyyy = df.format(currCal.get(Calendar.YEAR));
	int icmonth = Integer.parseInt(cmonth)-1;
	for(int month=0;month<12;month++){
			//이번달 마지막 날짜 저장하기
			cal.set(Calendar.MONTH,month);
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			for(int i=1;i<=maxDay;i++){
				cal.set(Calendar.DATE,i);
				day[cal.get(Calendar.MONTH)]
						[cal.get(Calendar.WEEK_OF_MONTH)-1]
								[cal.get(Calendar.DAY_OF_WEEK)-1]=i;
			}
		}

//계산한 카렌더 정보를 화면에 출력하기
	for(int month=0;month<12;month++){
		//12달 중에 오늘인 달 9월달
		if(month==icmonth){
%>
<table align="center" border="1" width="1200">
	<tr>
		<td><font size="30" color="green"><%=month+1 %>月</font></td>
		<td><button type="button" class="btn btn-primary">출근</button>
			<button type="button" class="btn btn-primary">퇴근</button>
			<button type="button" class="btn btn-primary">조퇴</button>
	</td></tr>
</table>
<table align="center" border="1" width="1200">
	<tr>
<%
			for(int i=0;i<week.length;i++){ 
				//일 월 화 수 목 금 토
				out.print("<td align='center' width='170' height='30'>"+week[i]+"</td>");
			}
			out.print("</tr>");
			//한달이 속한 주
			for(int i=0;i<cal.get(Calendar.WEEK_OF_MONTH);i++){
				out.print("<tr>");
				//일주일씩 출력하기
				for(int j=0;j<7;j++){
					//날짜 정보를 가지고 있니?
					if(day[month][i][j]!=0){
						//out.print("<td align='right' width='170' height='90' valign='top'>"+day[month][i][j]+"</td>");
						out.print("<td align='right' width='170' height='90'>");
						out.print("<table width='100%' height='100%'>");
						out.print("<tr><td align='right' valign='top'>"+day[month][i][j]+"</td></tr>");
						if(day[month][i][j]==20
								|day[month][i][j]==21
								|day[month][i][j]==22
								|day[month][i][j]==23){
							out.print("<tr><td align='right' style='background-color: darkgrey;'>"+"황금연휴"+"</td></tr>");
						}
						out.print("<tr><td align='right'>"+""+"</td></tr>");
						out.print("<tr><td align='right'>"+""+"</td></tr>");
						out.print("<tr><td align='right'><a href='javascript:memoForm("+cyyyy+","+(month+1)+","+day[month][i][j]+")'>+</a></td></tr>");
						out.print("</table></td>");
					}else{
						out.print("<td>&nbsp;</td>");
					}
				}//end of inner for[주말일자]
				out.print("</tr>");
			}//end of outer for[월별일자]
%>
	</tr>
</table>
<%
		}//end of if[이번달 정보만 출력하기]
	}
%>
<!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">메모 등록</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form class="was-validated">
          <div class="form-group">
         	<label><div id="d_curday">2019년9월20일</div></label>
         	<input type="text" class="form-control" id="content" name="content" placeholder="내용입력">
         	<div class="valid-feedback">Valid.</div>
         	<div class="invalid-feedback">메모를 작성하세요.</div>
          </div>
        </form>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" onClick="moAdd()">Submit</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
</body>
</html>