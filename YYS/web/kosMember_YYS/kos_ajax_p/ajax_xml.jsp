<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready function");
		$("#button").click(function(){
			alert("버튼 클릭!!!");
			callAjax();
		});
	});
	
	function callAjax(){
		alert("callAjax 함수 진입 >>> : ");
		$.ajax({
			url:"data_xml.jsp",
			type:"POST",
			data:{
				id:$("#id").val(),
			},
			success: whenSuccess,
			error:whenError
		});
		
		function whenSuccess(data){
			alert("리턴 데이터 >>> : "+data);
			
			var boolVal=$(data).find("result").text();
			console.log("boolVal >>> : "+boolVal);
			
			// 자바스크립트 eval() 이발함수, 객체변환하는 함수 
			// boolVal 문자열을 자바스크립트 true, false 객체로 변환하는 함수 
			// 현재는 사용금지 : 보안 취약점에 적용되는 함수 
			var result=eval(boolVal);
			console.log("result >>> : "+result);
			
			if (result){
				alert("성공");
				console.log("result >>> : " + result);
			}else{
				alert("실패");
				console.log("result >>> : " + result);
			}
		} // end of  whenSuccess
		
		function whenError(){
			alert("error");
		} // end of whenError 
	}
	
</script>
</head>
<body>
<form id="fm">
	<label>아이디</label><input name="id" id="id">
	<input id="button" type="button" value="버튼">
</form>
</body>
</html>