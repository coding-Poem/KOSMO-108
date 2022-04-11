<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestDispatcher.forward</title>
</head>
<body>
<h3>RequestDispatcher.forward :: request_C.jsp</h3>
<hr>

<%
	ArrayList aList=new ArrayList();
	aList.add("abc");
	
	
	// 페이지를 이동하면서 넘겨야 할 데이터를 세팅하기
	request.setAttribute("aaa", aList);
	
	/*
	"aaa" : a String specifying the name of the attribute
	aList : the Object to be stored
	*/
	
	// 이동할 페이지를 세팅하기
	RequestDispatcher rd=request.getRequestDispatcher("/kos_jsp_p/request_D.jsp");
	// 자기 자신 파일이 아닌 다른 곳으로 보내야 한다.
	// /kosMember_YYS는 생략한다. (컨텍스트 밖으로 못나가서 이미 내장 되어 있음.)
	
	rd.forward(request, response);
	/*
	Forwards a request from a servlet to another resource
    (servlet, JSP file, or HTML file) on the server.
    */
%>

</body>
</html>