<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/kosMember_YYS/css/yysColor.css">
<title>INCLUDE_B</title>
</head>
<body>
<h3 style="background-color:cyan;">INCLUDE_B JSP</h3>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("include_B.jsp 페이지 >>> : ");
	//  include_B.jsp 페이지 >>> :
		
	String mid=request.getParameter("mid");
	logger.info("include_B.jsp :: mid >>> : "+mid);
	// include_B.jsp :: mid >>> : 1111
	
	String mpw=request.getParameter("mpw");
	logger.info("include_B.jsp :: mpw >>> : "+mpw);
	// include_B.jsp :: mpw >>> : 2222
	
	String param_3=request.getParameter("param_3");
	logger.info("include_B.jsp :: param_3 >>> : "+param_3);
	// include_B.jsp :: param_3 >>> : include_A.jsp:param_3
	
	String param_4=request.getParameter("param_4");
	logger.info("include_B.jsp :: param_4 >>> : "+param_4);
	// include_B.jsp :: param_4 >>> : include_A.jsp:param_4
	
	out.println("include_B mid >>> : " + mid + "<br>");
	out.println("include_B mpw  >>> : " + mpw + "<br>");
	out.println("include_B param_3 >>> : " + param_3 + "<br>");
	out.println("include_B param_4  >>> : " + param_4 + "<br>");
%>
</body>
</html>