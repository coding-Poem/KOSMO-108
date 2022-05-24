<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN FORM</title>
<meta name="viweport" content="width=device-width, iitail-scale=1">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#kmidFind").click(function(){
			alert("id 찾기 클릭 >>> : ");
			
		});
		
		$("#kmpwFind").click(function(){
			alert("pw 찾기 클릭 >>> : ");
			
		});
		
		$("#kminsert").click(function(){
			location.href="/kosmoSpring_YYS/kosmoMemberInsertForm.yys"
		});
		
			
			
		$("#login_btn").click(function(){
			$("#loginfrom").attr(
				{
					"action":"/kosmoSpring_YYS/kosmoLoginCheck.yys",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}		
			).submit();
		});
	});
</script>
<style type="text/css">
.card{
    font-family: dotum,sans-serif;
    font-size: 12px;
    color: #666;
    width: 50%;
    margin:auto;
    display:block;
    text-align:center;
}

.loginform{
    font-family: dotum,sans-serif;
    font-size: 12px;
    line-height: 1.6;
    color: #666;
}
</style>
</head>
<body>
<form class="loginform" id="loginfrom" name="loginform" >
<div class="card">
	<input type=text class="kmid" id="kmid" name="kmid" placeholder="아이디를 입력하세요" style="width=50px;"><br>
	<input type=password class="kmpw" id="kmpw" name="kmpw" placeholder="비밀번호를 입력하세요" style="width=50px;"><br>
	<br>
	<input class="login_btn" type="button" id="login_btn" name="login_btn" value="로그인" style="width=50px;"><br>
	<hr>
	<input type="button" id="kminsert" value="회원가입" style="color:#2ECC71" style="width=50px;">
	<hr>
	<input type="button" id="kmidFind" value="아이디 찾기" style="color:#2ECC71">
	<input type="button" id="kmpwFind" value="비밀번호 찾기" style="color:#2ECC71">
</div>	
</form>
</body>
</html>