<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM TAG 연습</title>
</head>
<body>
<h3>FORM TAG 연습 ::  JSP에 넘어온 데이터 보기</h3>

<%
	String name=request.getParameter("mname");
	String addr=request.getParameter("maddr");
	
	out.println("formtagpractice.html에서 받아온 이름 >>> : "+name+"<br>");
	out.println("formtagpractice.html에서 받아온  주소 >>> : "+addr);
%>

</body>
</html>