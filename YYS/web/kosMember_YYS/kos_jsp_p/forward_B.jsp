<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORWARD_B</title>
<link rel="stylesheet" href="/kosMember_YYS/css/yysColor.css">
</head>
<body>
<h3>FORWARD_B JSP</h3>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("forward_B.jsp 페이지 >>> : ");
	// forward_B.jsp 페이지 >>> :
	
	String mid=request.getParameter("mid");
	logger.info("foward_B.jsp :: mid >>> : "+mid);
	// foward_B.jsp :: mid >>> : 3333
	
	String mpw=request.getParameter("mpw");
	logger.info("foward_B.jsp :: mpw >>> : "+mpw);
	// foward_B.jsp :: mpw >>> : 4444
	
	String param_3=request.getParameter("param_3");
	logger.info("foward_B.jsp :: param_3 >>> : "+param_3);
	// foward_B.jsp :: param_3 >>> : forward_A.jsp::param_3
	
	String param_4=request.getParameter("param_4");
	logger.info("foward_B.jsp :: param_4 >>> : "+param_4);
	// foward_B.jsp :: param_4 >>> : forward_A.jsp::param_4
	
	out.println("forward_B mid >>> : " + mid + "<br>");
	out.println("forward_B mpw  >>> : " + mpw + "<br>");
	out.println("forward_B param_3 >>> : " + param_3 + "<br>");
	out.println("forward_B param_4  >>> : " + param_4 + "<br>");
%>	
</body>
</html>