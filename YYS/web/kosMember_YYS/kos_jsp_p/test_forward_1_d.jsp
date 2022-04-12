<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: cyan;">TEST FORWARD : RequestDispather.forward()</h3>
<hr>
<%
	// test_forward_1.jsp 페이지 line 18에서 정의한  request.setAttribute("mid", mid) 객체를 
	// test_forward_1.jsp 페이지 line 23에서 test_forward_1_d.jsp 로 forward 한 객체를
	// test_forward_1_d.jsp 페이지 ling 16에서 request.getAttribute("mid") 함수로 받아온다.
	Object obj = request.getAttribute("mid");
	String mid = (String)obj;	
%>
<%= mid %>
</body>
</html>