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
<h3 style="background-color:yellow;">RequestDispatcher.forward :: request_C.jsp</h3>
<hr>
<%
	ArrayList aList = new ArrayList(); 
	aList.add("abc");

	// 페이지를 이동하면서 넘겨야할 데이터를 세팅하기
	request.setAttribute("aaa", aList);
	
	// 이동할 페이지를 세팅하기 
	RequestDispatcher rd = request.getRequestDispatcher("/kos_jsp/request_D.jsp");
	rd.forward(request, response);	
%>

</body>
</html>