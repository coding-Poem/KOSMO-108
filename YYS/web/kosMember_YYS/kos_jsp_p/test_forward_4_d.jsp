<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: cyan;">TEST FORWARD : &lt;jsp:forward&gt;&lt;/jsp:forward&gt;  더블 태그</h3>
<hr>  
<%
	String param_1 = request.getParameter("param_1");	
%>
<%= param_1 %>

</body>
</html>