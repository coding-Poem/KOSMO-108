<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Check</title>
</head>
<body>
	<h3>Login Check</h3>
	<hr>
<%= "Login Check를 시작합니다." + "<br>"%>
<%
	String uid=request.getParameter("uid");
	String upw=request.getParameter("upw");
%>
<%= "입력된 아이디는 : "+uid+"입니다."+"<br>" %>
<%= "입력된 비밀번호는 : "+upw+"입니다."+"<br>" %>
</body>
</html>