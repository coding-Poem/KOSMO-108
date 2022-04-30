<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready function >>> : ");
		$("#btn").on("click", function(){
			alert("버튼을 클릭하셨습니다. >>> : ");
			//--------------------------------------
			// $.ajax({});
			/*
			$.ajax({
				url: 요청할 페이지 url 주소 : action,
				type: GET, POST : method,
				data: ?key=value&key=value$key=value,
						
				success: function(resData){}, : resData : 매개변수 : 변수이름은 가변적이다. 	
				error: function(e){}
			});
			*/
			//--------------------------------------
			let urlV="data_2.jsp";
			let typeV="POST";
			alert("url >>> : "+urlV);
			alert("type >>> : "+typeV);
			
			
			$.ajax({
				// url      : 요청이 전송되는 URL이 포함된 문자열
				url:urlV,
				
				// type     : http요청 방식 : GET/POST
				type:typeV,
				
				// data     : http요청 파라미터 문자열 key=value&key=value
				data:{
					id : $("#id").val(), // data 는 쿼리 스트링 data_2.jsp?id=값
				},
				     
				//success  : function(data: 리턴매개변수, 변수 이름이 가변적이다 ){....}
				// : http요청 성공시 이벤트 핸들러
				success: returnCheck,
				
				// error    : function(){.....} : http요청 실패시 이벤트 핸들러
				error : errCheck
			});
			
			// JavaScript 함수 
			function returnCheck(returnData){
				$("#ajaxResData").html("화면에 리턴 데이터 출력 : "+returnData);
				// $(selector).html(content)
				// Required. Specifies the new content 
				// for the selected elements (can contain HTML tags)
				console.log("콘솔에 리턴 데이터 출력 : "+returnData);
			}
			
			function errCheck(err){
				alert("error \n"+err);
			}
			
		}); // click function
	}); // ready function
</script>
</head>
<body>
<form id="fm">
	<label>아이디</label>
	<input name="id" id="id">
	<input type="button" id="btn" value="버튼">
	<div id="ajaxResData">리턴 데이터</div>
</form>
</body>
</html>