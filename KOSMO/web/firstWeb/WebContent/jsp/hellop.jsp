<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello Jsp!!<br>
	<hr>
<%
	out.println("Hello JSP !!!!");
	out.println("<hr>");
	java.util.Date d = new java.util.Date();
	out.println("Date >>> : " + d + "<br>");
	
	String id = request.getParameter("id");
	// request는 클라이언트가 서버에게 요청하다
	// response는 서버가 클라이언트에게  응답하다
	String pw = request.getParameter("pw");
	System.out.println("id >>> : " + id);
	System.out.println("pw >>> : " + pw);
	out.println("id >>> : " + id + "<br>");
	out.println("pw >>> : " + pw + "<br>");
%>	

</body>
</html>