<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORWARD_A.jsp</title>
<link rel="stylesheet" href="/kosMember_YYS/css/yysColor.css">
</head>
<body>
<!-- 
/kosMember_YYS/kos_jsp_p/forward_A.jsp?mid=3333&mpw=4444
실제로 foward.html에서 input태그로 입력한 값이 String Query로
mid=3333, mpw=4444로 넘어왔다.

실제 출력화면

FORWARD_B JSP
forward_B mid >>> : 3333
forward_B mpw >>> : 4444
forward_B param_3 >>> : forward_A.jsp::param_3
forward_B param_4 >>> : forward_A.jsp::param_4

위의 두 줄은 forward_A.jsp에서 출력 된 것이고
jsp:foward로 forward_B.jsp에서 out.println으로 3~4번째 줄을 
forward_A.jsp 에서 출력 시켰다.
 -->
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("forward_A.jsp 페이지 >>> : ");
	// forward_A.jsp 페이지 >>> : 
	
	// <input type="text" class="mid" name="mid" id="mid" /><br>
	String mid=request.getParameter("mid");
	logger.info("forward_A.jsp :: mid >>> : "+mid);
	// forward_A.jsp :: mid >>> : 3333
	
	// <input type="text" class="mpw" name="mpw" id="mpw" /><br>
	String mpw=request.getParameter("mpw");
	logger.info("forward_A.jsp :: mpw >>> : "+mpw);
	// forward_A.jsp :: mpw >>> : 4444
	
	out.println("forward_A.jsp >>> : "+mid+"<br>");
	out.println("forward_A.jsp >>> : "+mpw+"<br>");
	
	String param_3 = "forward_A.jsp::param_3";
	logger.info("forward_A.jsp::param_3 >>> : "+param_3);
	// forward_A.jsp::param_3 >>> : forward_A.jsp::param_3
	
	String param_4 = "forward_A.jsp::param_4";
	logger.info("forward_A.jsp::param_4 >>> : "+param_4);
	// forward_A.jsp::param_4 >>> : forward_A.jsp::param_4
%>
<%--
<jsp::forward page="/kos_jsp_p/forward_B.jsp" /> 
 --%>
 
 <!-- https://www.javatpoint.com/jsp-action-tags-forward-action -->
 <jsp:forward page="/kos_jsp_p/forward_B.jsp">
 	<jsp:param name="param_1" value="<%= mid %>" />
 	<jsp:param name="param_2" value="<%= mpw %>" />
 	<jsp:param name="param_3" value="<%= param_3 %>"/>
 	<jsp:param name="param_4" value="<%= param_4 %>" />
 </jsp:forward>
</body>
</html>