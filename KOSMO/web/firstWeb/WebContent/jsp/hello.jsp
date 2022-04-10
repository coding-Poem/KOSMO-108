<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello Jsp !!!<br>
	<hr>
<%
	out.println("Hello JSP !!!!");
	out.println("<hr>");
	java.util.Date d = new java.util.Date();
	out.println("Date >>> : " + d + "<br>");
	
	// java.lang.String getParameter(java.lang.String name)
	// Returns the value of a request parameter as a String, 
	// or null if the parameter does not exist.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	System.out.println("id >>> : " + id);
	System.out.println("pw >>> : " + pw);
	out.println("id >>> : " + id + "<br>");
	out.println("pw >>> : " + pw + "<br>");
%>	
</body>
</html>