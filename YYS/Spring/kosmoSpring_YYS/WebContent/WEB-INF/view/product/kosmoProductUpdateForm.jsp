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
		alert("jQuery ready ~~~");
		$(document).on("click", "#updateBtn", function(){
			alert("수정 버튼을 클릭하셨습니다 >>> : ");
			$("#kosmoProductUpdate").attr({
				"action":"kosmoProductUpdate.yys",
				"method":"POST",
				"enctype":"multipart/form-data"
			}).submit();
			
		});
	});
</script>
</head>
<body>
<h3>상품 수정 페이지 입니다.</h3>
<hr>
<form name="kosmoProductUpdate" id="kosmoProductUpdate">
<table border="1" class="align">
	<tr>
		<td colspan="2" class="align">상품 수정</td>				
	</tr>
	<tr>
		<td class="align">상품번호</td>
		<td><input type="text" name="mnum" id="mnum" size="20"></td>
	</tr>
	<tr>
		<td class="align">상품아이디</td>
		<td><input type="text" name="mid" id="mid" size="20"></td>
	</tr>
	<tr>
		<td  class="align">수량</td>
		<td><input type="text" name="mcnt" id="mcnt" size="20"></td>
	</tr>	
	<tr>
		<td  class="align">상품명</td>
		<td><input type="text" name="mname" id="mname" size="20"></td>
	</tr>
	<tr>
		<td  class="align">가격</td>
		<td><input type="text" name="mprice" id="mprice" size="20"></td>
	</tr>
	<tr>
		<td  class="align">상품설명</td>
		<td><input type="text" name="mdes" id="mdes" size="20"></td>
	</tr>
	<tr>
		<td  class="align">상품제조사</td>
		<td><input type="text" name="mcom" id="mcom" size="20"></td>
	</tr>
	<tr>
		<td  class="align">이미지파일</td>
		<td><input type="file" name="mimg" id="mimg" size="20"></td>
	</tr>
	<tr>
		<td colspan="2" class="align">				
		<input type="button" value="KOSMO_PRODUCT_수정" id="updateBtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>