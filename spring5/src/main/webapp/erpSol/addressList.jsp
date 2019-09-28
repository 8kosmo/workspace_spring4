<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<style>
		.col-sm-2 {
		background-color: navy;
		text-align: center;
		color: white;
		}
		.col-sm-6 {
		background-color: aqua;
		text-align: center;
		color: red;
		}
	</style>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			method:"get"
			,url:"zdoList"
			,success:function(data){
				$("#d_zdo").html(data);
				$("#zdo").change(function(){
					var vzdo = $("#zdo option:selected").text();//경기
					if(vzdo != null && vzdo.length > 1){
						$.ajax({
							method:"get"
							,url:"siguList?zdo="+vzdo
							,success:function(data){
								$("#d_sigu").html(data);
 								$("#sigu").change(function(){
									var vsigu = $("#zdo option:selected").text();//경기
									if(vsigu != null && vsigu.length > 1){
										$.ajax({
											method:"get"
											,url:"dongList?sigu="+vsigu
											,success:function(data){
												$("#d_dong").html(data);
				 								$("#dong").change(function(){
													var vsigu = $("#sigu option:selected").text();//경기
													if(vsigu != null && vsigu.length > 1){
														
													}
												});
											}
										});
									}
								});
							}
						});
					}
				});
			}
		});//ajax
	});//ready
</script>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<div id="d_zdo">
				<select id="zdo">
					<option>도를 아십니까</option>
				</select>
				</div>
			</div>
		  <div class="col-sm-2">
				<div id="d_sigu">
				<select id="sigu">
					<option>시꾸럿</option>
				</select>
				</div>
		  </div>
		  <div class="col-sm-2">
				<div id="d_dong">
				<select id="dong">
					<option>동욷</option>
				</select>
				</div>
		  </div>
		  <div class="col-sm-6">4 of 4</div>
		</div>
	</div>
</body>
</html>