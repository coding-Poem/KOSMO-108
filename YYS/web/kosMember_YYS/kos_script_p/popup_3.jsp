<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 팝업</title>

<!-- 뷰포트 : device에 맞게 화면 크기 조정 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 

<!-- 
	레이어 팝업 드래그 하기 위해서 jquery ui draggable 라이브러리 사용
	https://jqueryui.com/draggable/
 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<!--  
<link rel="stylesheet" href="//resources/demos/style.css">
-->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<!-- 
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 -->  
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#noticePop").draggable();
		// jQuery user interface
		
		// <input type="button" id="popBtn" value="닫기" />
		$('#popBtn').on('click', function(){
			alert("popBtn >>> : ");
			
			let chkVal = $("#chkpop").is(":checked");
			alert("checkbox checked >>> : " + chkVal);
			// true
			
			/*
			if (chkVal){
				
				// Ajax 처리 루틴
				let urlV = "/kosMember/kos_script/popup_cookie.jsp";
				let typeV = 'GET';
				let dataV = $("#chkpop").val();
				alert("dataV >>> : " + dataV);			
				
				// $.ajax({});
				// $.("폼네임").attr({}).submit();
				
				if (chkVal){
					$.ajax({
						url: urlV,
						type: typeV,
						data: { "chkpop": dataV },					
						success : whenSuccess,					
						error : whenError
					});				
				}
				
				function whenSuccess(resData){
					alert("리턴 데이터 >>> : \n" + resData);
					var bool = $(resData).find('result').text();
					alert("bool >>> : " + bool);
				}
				
				function whenError(){
					alert("에러가 >>> : ");
				}
			}
			*/
			$('#noticePop').hide();
			// Description : Hide the matched elements.
			$('.imgPop').hide();
		});	
	});

</script>
<style>
	body{
		background-color:#ffe6ff;
	}

	div#noticePop {
		potition: absolute;
		top: 50px; 
		left: 50px;
		color: black;
		border: 1px solid red;
		width: 300px;
		height: 300px;
		text-align: center;
		background-color: #99ff99; /* #ffffff */
		box-shadow: 30px 30px grey;
	}
	
	div#noticePop > div {
		position: relative;				
		top: 0px;
		border: 1px solid gray;
		padding: 10px;
		color: black;
		background-color: #ffffb3; /* #fff */
	}

</style>
</head>
<body>
<%
	boolean popState = true;
%> 
<h2>NOTICE POPUP</h2>
<hr>
<%
	if (popState){
%>
		<div id="noticePop">
			<h4>이무진 - 신호등 광고</h4>
			<hr>
			<div class="imgPop">
				<form name="noticePopForm" id="noticePopForm">
					<img class="img_1" src="/kosServlet_YYS/image/10607796_20210513201807_500.jpg"  width="150" height="150"><br>										
					<input type="checkbox" class="chkpop" name="chkpop" id="chkpop" value="01" />
					하루 동안 열지 않음 
					<input type="button" id="popBtn" value="닫기" />
				</form>
			</div>
		</div>
<%		
	}else{
%>
		<%= "공지사항 팝업 없음" %>
<%		
	}
%>

</body>
</html>