<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: cyan;">TEST FORWARD : &lt;jsp:forward /&gt; 싱글 태그</h3>
<hr>
<%
	// String mid = request.getParameter("mid");	
	Object obj = request.getAttribute("mid");
	String mid = (String)obj;
%>
<%= mid %>
</body>
</html>