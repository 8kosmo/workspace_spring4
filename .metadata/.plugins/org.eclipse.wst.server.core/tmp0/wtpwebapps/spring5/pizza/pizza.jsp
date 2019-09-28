<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Break Neck Pizza Delivery</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
    function orderPizza(){
        $("#f_pizza").attr("action","orderConfirm.jsp");
        $("#f_pizza").attr("method","post");
        $("#f_pizza").submit();
    }
    function getCustomerInfo(){
        var user_tel = $("#mem_tel").val();
        // alert(user_tel);
        // $("#mem_tel").text("입력한 값");
        /*
        jquery api를 사용하면 비동기 통신 객체 생성하지 않고 바로 요청 처리할 수 있어서
        코딩양도 줄어들고 메소드 한개로 처리가 가능함.
        */
        $.ajax({
            method:"GET"
            ,url:"breaknek.jsp"
            ,success:function(data){
                // alert(data);
//사용자가 입력한 전번을 응답으로 받은 json포맷에서 찾아서 TextArea에 출력해보기
                var jsonDoc = JSON.parse(data);
                if(jsonDoc.length>0){
                    var temp="";
                    for(var i=0;i<jsonDoc.length;i++){
                        if(user_tel==jsonDoc[i].mem_tel){
                            temp+=jsonDoc[i].mem_addr;
                        }
                    }//////end of for
                }//////////end of if
                $("#mem_addr").text(temp);
            }//////////////end of success
        });////////////////end of ajax
    }
  </script>
</head>
<body>
		<p>
			Enter your phone number: <input type="text" size="14" id="mem_tel"
				name="mem_tel" onChange="getCustomerInfo();" />
		</p>
	<form id="f_pizza">
		<input type="hidden" id="mem_name" name="mem_name" value="홍길동">
		<p>
			<img src="../images/breakneck-logo.gif" alt="Break Neck Pizza" />
		</p>
		<p>Type your order in here:</p>
		<p>
			<textarea name="paper" id="paper" rows="6" cols="50"></textarea>
		</p>
		<p>Your order will be delivered to:</p>
		<!--
    JSON포맷의 이름과 태그의 name속성과 id속성을 같은 값으로 통일함.
    name속성은 jsp에서 사용자가 입력한 값을 읽을 때 사용함.
    id속성은 javascript에서 사용자가 입력한 값을 읽을 때 사용함.
    name과 id속성은 같은 값을 사용함.
    오라클 서버에 테이블 컬럼명과 VO패턴의 멤버변수 이름, Map의 key는 모두 통일해서 사용함.
    -->
		<p>
			<textarea name="mem_addr" id="mem_addr" rows="4" cols="50"></textarea>
		</p>
		<p>
			<input type="button" id="btn_order" value="Order Pizza"
				onclick="orderPizza()" />
		</p>
		<div id="d_msg"></div>
	</form>
</body>
</html>
