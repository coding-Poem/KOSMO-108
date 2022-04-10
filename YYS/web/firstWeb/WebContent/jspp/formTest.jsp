<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>VELOG 회원가입 데이터 입력</title>
</head>
<body>
<%
  String id=request.getParameter("id");
  String pw=request.getParameter("pw");
  out.println("입력된 아이디는 >>> : "+id+"<br>");
  out.println("입력된 비밀번호는 >>> : "+pw+"<br>");
%>
</body>
</html>