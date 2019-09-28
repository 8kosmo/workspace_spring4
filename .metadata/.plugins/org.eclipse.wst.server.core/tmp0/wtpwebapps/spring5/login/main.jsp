<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String smem_name = (String)session.getAttribute("smem_name");
	if(smem_name==null){
		response.sendRedirect("");
	}
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
<title>메인뷰</title>
	<style>
	.carousel-inner img {
	    width: 100%;
	    height: 100%;
	}
	</style>
 	<script type="text/javascript">
 		function loginAction(){
 			$("#form-login").attr("method","post");
 			$("#form-login").attr("action","/sample/security/login");
 			$("#form-login").submit();
 		}
 	    function logoutAction(){
 	    	$("#logoutForm").hide();
 			$("#loginForm").show();
 		}
	</script>
</head>
<body>
	<script>
		$(document).ready(function() {
			$("#logoutForm").hide();
		});
	</script>
<div class="top-bar">
	<div class="container" id="loginForm">
		<div class="col" style="text-align: left">
			<nav class="navbar navbar-expand-sm">
			  <ul class="navbar-nav">
			    <li class="nav-item active">
			      <a class="nav-link">회원가입</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" data-toggle="modal" data-target="#login">로그인</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">경매참여방법</a>
			    </li>
			  </ul>
			</nav>
		</div>
	</div>
		<div class="container" id="logoutForm">
		<div class="col" style="text-align: left">
			<nav class="navbar navbar-expand-sm">
			  <ul class="navbar-nav">
			    <li class="nav-item active">
			      <a class="nav-link" href="myPage.jsp">마이페이지</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" onclick="logoutAction()">로그아웃</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">경매참여방법</a>
			    </li>
			  </ul>
			</nav>
		</div>
	</div>
</div>
	<div class="container" style="margin-top: 10px;align:right">
		<div class="row">
			<div class="col">
				<img src="../images/index.gif" class="rounded" width="428" height="160">
			</div>
			<div class="col">
				<img src="../images/ny.jpg" class="rounded" width="428" height="140" alt="Image">
				<form>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search here">
						<div class="input-group-append">
						  	<button class="btn btn-success" type="submit">검색</button> 
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- modal(#signUp) -->
	
	<!-- /modal(#signUp) -->
	<!-- modal(#login) -->
	<div class="modal fade" id="login">
    <div class="modal-dialog">
    <div class="modal-content">      
        <!-- modal header -->
        <div class="modal-header">
          <h4 class="modal-title">로그인 화면</h4>
          <button type="button" class="close" data-dismiss="modal">x</button>
        </div>
        <!-- modal body -->
        <div class="modal-body">
        	<form:form id="form-login" method="post" enctype="multipart/form-data">
        		<div class="from-group">
	        		<label for="id">ID</label>
	        		<input type="text" class="form-control" id="mem_id" name="mem_id">
        		</div>
        		<div class="from-group">
	        		<label for="pw">Password</label>
	        		<input type="text" class="form-control" id="mem_pw" name="mem_pw">
        		</div>
        	</form:form>
        </div>
        <!-- modal footer -->
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary" onclick="loginAction()" data-dismiss="modal">로그인</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
        </div>
	</div>
    </div>
	</div>
	<!-- /modal(#login) -->
	<div class="container" style="margin-top: 10px">
	<!-- category -->
		<div class="row">
			<div class="col-sm-3 bg-dark">
				<ul class="nav flex-column">
					<li class="nav-item">
						<a class="nav-link text-white" href="#">브랜드 의류<span class="badge badge-primary ml-1">best</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-white" href="#">콜라보레이션</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-white" href="#">한정판</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-white" href="#">list4</a>
					</li>
					<li class="nav-item">
						<a class="nav-link " href="#">list5</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">list6</a>
					</li>

				</ul>
			</div>
	<!-- /category -->
			<div class="col-sm-9">
	<!-- carousel -->
				<div id="demo" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ul class="carousel-indicators">
				    <li data-target="#demo" data-slide-to="0" class="active"></li>
				    <li data-target="#demo" data-slide-to="1"></li>
				    <li data-target="#demo" data-slide-to="2"></li>
				  </ul>
				  <!-- The slideshow -->
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="../images/la.jpg" alt="Los Angeles" width="100%" height="500">
				    </div>
				    <div class="carousel-item">
				      <img src="../images/chicago.jpg" alt="Chicago" width="100%" height="500">
				    </div>
				    <div class="carousel-item">
				      <img src="../images/ny.jpg" alt="New York" width="100%" height="500">
				    </div>
				  </div>
				  <!-- Left and right controls -->
				  <a class="carousel-control-prev" href="#demo" data-slide="prev">
				    <span class="carousel-control-prev-icon"></span>
				  </a>
				  <a class="carousel-control-next" href="#demo" data-slide="next">
				    <span class="carousel-control-next-icon"></span>
				  </a>
				</div>
	<!-- /carousel -->
			</div>
		</div>
	</div>
	<div class="container bg-3 text-center" style="margin-top: 10px">
		<h3>현재 경매 준비 중인 상품</h3>
		<div class="row bg-secondary">	
			<div class="col-sm-3">
				<p>goods<span class="badge badge-danger ml-2">new</span></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods<span class="badge badge-danger ml-2">new</span></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods<span class="badge badge-danger ml-2">new</span></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods<span class="badge badge-danger ml-2">new</span></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
		</div>
		<div class="row">	
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
		</div>
		<div class="row bg-secondary">	
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>goods <small class="text-info">5 mins ago</small></p>
				<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="jumbotron"></div>
	</div>
</body>
</html>