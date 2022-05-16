<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<%
Logger logger=LogManager.getLogger(this.getClass()); 
logger.info("KosmoProductInsertForm.jsp 페이지 입니당 >>> : ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KosmoProductInsertForm</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){							
		
		$(document).on("click", "#insertBtn", function(){
			console.log("insertBtn >>> : ");	
			
			$('#kosmoProductInsert').attr({
				'action':'kosmoProductInsert.yys',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
			
			
			/*
			$('#kosmoProductInsert').attr({
				'action':'kosmoProductInsert.yys',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
			*/
		});
});
</script>
<style type="text/css">
	body{
		test-align:ceter;
	}
	
	td{
		text-align:center;
	}
</style>
</head>
<body>
<h3>상품 입력 페이지 입니다.</h3>
<hr>

<form name="kosmoProductInsert" id="kosmoProductInsert">
<table border="1" class="align">
	<tr>
		<td colspan="2" class="align">상품 입력</td>				
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
		<input type="button" value="KOSMO_PRODUCT_입력" id="insertBtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>