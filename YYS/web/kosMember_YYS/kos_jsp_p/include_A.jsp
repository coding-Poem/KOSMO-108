<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/kosMember_YYS/css/yysColor.css">
<title>INCLUDE_A</title>
</head>
<body>
<!-- 
/kosMember_YYS/kos_jsp_p/include_A.jsp?mid=1111&mpw=2222

실제로 foward.html에서 input태그로 입력한 값이 String Query로
mid=1111, mpw=2222로 넘어왔다.

실제 출력화면

INCLUDE_A JSP
forward_A mid >>> : 1111
forward_A mpw >>> : 2222
INCLUDE_B JSP
include_B mid >>> : 1111
include_B mpw >>> : 2222
include_B param_3 >>> : include_A.jsp:param_3
include_B param_4 >>> : include_A.jsp:param_4
footer

위의 3 줄은 include_A.jsp에서 출력 된 것이고
jsp:foward로 include_B.jsp에서 out.println으로 4~8번째 줄을 
include_A.jsp 에서 출력 시켰다.

마지막 줄은 include_footer.html 에서  가져와 

include_A.jsp에서 출력시켰다.
 -->
<h3 style="background-color:blue;">INCLUDE_A JSP</h3>
<!--  <h> : 레퍼런스에 아무것도 안 나온다.-->
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("include_A.jsp 페이지 >>> : ");
	// include_A.jsp 페이지 >>> :

	// include.html :: <input type="text" class="mid" name="mid" id="mid" /><br>
	String mid=request.getParameter("mid");
	logger.info("include_A.jsp ::mid >>> : "+mid);
	// include_A.jsp ::mid >>> : 1111
	
	// include.html :: <input type="text" class="mpw" name="mpw" id="mpw" /><br>
	String mpw=request.getParameter("mpw");
	logger.info("include_A.jsp :: mpw >>> : "+mpw);
	// include_A.jsp :: mpw >>> : 2222
	
	String param_3="include_A.jsp:param_3";
	logger.info("include_A.jsp ::param_3 >>> : "+param_3);
	// include_A.jsp ::param_3 >>> : include_A.jsp:param_3
	
	String param_4="include_A.jsp:param_4";
	logger.info("include_A.jsp :: param_4 >>> : "+param_4);
	// include_A.jsp :: param_4 >>> : include_A.jsp:param_4
	
	out.println("forward_A mid >>> : " + mid + "<br>");
	out.println("forward_A mpw  >>> : " + mpw + "<br>");
%>
<%--
<jsp:forward page="/kos_jsp_p/foward_B.jsp"/>
 --%>
 <!-- https://www.javatpoint.com/jsp-include-action -->
 <!-- /kos_jsp_p/include_B.jsp -->
<jsp:include page="/kos_jsp_p/include_B.jsp">
	<jsp:param name="param_1" value="<%= mid %>"/>
	<jsp:param name="param_2" value="<%= mpw %>"/>
	<jsp:param name="param_3" value="<%= param_3 %>" />
	<jsp:param name="param_4" value="<%= param_4 %>" />
</jsp:include>
<%@ include file="include_footer.html" %>
</body>
</html>