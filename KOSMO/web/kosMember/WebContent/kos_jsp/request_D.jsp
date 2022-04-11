<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestDispatcher</title>
</head>
<body>
<h3 style="background-color:red;">RequestDispatcher.forward :: request_D.jsp</h3>
<hr>
<p style="background-color:red;"> request_D.jsp 페이지 입니다. </p>
<%
	/*
	ArrayList aList = new ArrayList(); 
	aList.add("abc");
	
	request.setAttribute("aaa", aList);
	
	RequestDispatcher rd = request.getRequestDispatcher("/kos_jsp/request_D.jsp");
	rd.forward(request, response);
	*/
	// reqeust.setAttribute("aaa", aList); 
	
	Object obj = request.getAttribute("aaa");
	if (obj == null) return;
	
	ArrayList aList = (ArrayList)obj;
	String str = (String)aList.get(0);
%>
<%= str %>
<h3 style="background-color:blue;">RequestDispatcher.forward :: request_D.jsp</h3>
<hr>
</body>
</html>