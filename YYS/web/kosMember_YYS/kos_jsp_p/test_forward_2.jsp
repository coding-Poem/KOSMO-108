<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: yellow;">TEST FORWARD : pageContext.forward()</h3>
<hr>
<%
	String mid_pagecontext = "kosmo";

	// 2. jsp : pageContext.forward();
	// 1. url 에 Query String(꼬리표) ?key=value&key=value 를 사용할 수 있다.
	// 		-> request.getParameter(key) 받아야 한댜ㅏ. 
	// 2. request.setAttribute(java.lang.String, java.lang.Object);
	//		-> request.getAttribute(java.lang.String);
	pageContext.forward("/kos_jsp/test_forward_2_d.jsp?mid="+mid_pagecontext);	
	
	/*
		pageContext.forward() 는 하기 RequestDispatcher 의 jsp 버전이다.
	
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);	
	
	*/
%>
</body>
</html>