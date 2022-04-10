<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS 실험실</title>
</head>
<body>
<h3>윤요섭의 자바스크립트 실험실 :: JSP File</h3>
<br>
<hr>
<br>
<%
	String tid=request.getParameter("tid");
%>
<%= "test 결과 : 나와야 하는 값  >> tid :::::::: 실제 나온 값 >> : "+tid %>
<!-- 목표 : html 안의 javascript 영역을 조작해서 tid 가 안 나오게 만들기 -->
</body>
</html>