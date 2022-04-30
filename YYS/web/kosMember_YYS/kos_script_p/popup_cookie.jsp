<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>POPUP COOKIE CHECK</h3>
<hr>
<%
	String chkpop = request.getParameter("chkpop");
	System.out.println("chkpop >>> : " + chkpop);
	
	boolean bool = false;
	if ("01".equals(chkpop)){
		bool = true;
	}
	
%>
<?xml version="1.0" encoding="UTF-8"?>
<root>
	<result><%= bool %></result>	
</root>
</body>
</html>
