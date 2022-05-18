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
		$("#deleteBtn").click(function(){
			$("#kosmoProductDelete").attr({
				"action":"kosmoProductDelete.yys",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});
</script>
</head>
<body>
<h3>상품 삭제 페이지 입니다.</h3>
<hr>
<form name="kosmoProductDelete" id="kosmoProductDelete">
<table border="1" class="align">
	<tr>
		<td class="align">상품번호</td>
		<td><input type="text" name="mnum" id="mnum" size="20"></td>
	</tr>
	<tr>
		<td colspan="2" class="align">				
		<input type="button" value="KOSMO_PRODUCT_삭제" id="deleteBtn">		
	</td>				
	</tr>
</table>
</form>	
</body>
</html>