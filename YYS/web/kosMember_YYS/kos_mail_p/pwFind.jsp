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
		$("#pwBtn").click(function(){
			$("#f1").attr({
				"action":"/kosMember_YYS2/kos_mail_p/pwTempSend.jsp",
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});

</script>
</head>
<body>
<h3>패스워드 찾기</h3>
<hr>
<form class="f1" id="f1" name="f1">
전화번호<input type="text" class="mhp" name="mhp" id="mhp"><br>
이메일<input type="text" class="memail" name="memail" id="memail"><br>
<input type="button" id="pwBtn" value="보내기">
</form>
</body>
</html>