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
<h3 style="background-color:yellow;">RequestDispatcher.forward :: request_C_1.jsp</h3>
<hr>
<%
	/* response vs request 
		request : 가지고 와라
		response : 가라
	*/
	
	// response 해보기
	// url이 넘어간다.
	// response.sendRedirect("/kosMember_YYS/kos_jsp_p/request_D_1.jsp");
	// request_D_1.jsp 에서 아무 동작도 하지 않을 경우
	// request_D_1 페이지에서 머무른다.
	
	
	// request 해보기
	// url이 넘어가지 않고, request_D_1.jsp 내용이 출력된다.
	ArrayList aList=new ArrayList();
	aList.add("abc");
	
	
	// 페이지를 이동하면서 넘겨야 할 데이터를 세팅하기
	request.setAttribute("aaa", aList);
	
	/*
	"aaa" : a String specifying the name of the attribute
	aList : the Object to be stored
	*/
	
	// 이동할 페이지를 세팅하기
	RequestDispatcher rd=request.getRequestDispatcher("/kos_jsp_p/request_D_1.jsp");
	// 자기 자신 파일이 아닌 다른 곳으로 보내야 한다.
	// /kosMember_YYS는 생략한다. (컨텍스트 밖으로 못나가서 이미 내장 되어 있음.)
	
	rd.forward(request, response);
	/*
	Forwards a request from a servlet to another resource
    (servlet, JSP file, or HTML file) on the server.
    */
%>
<h3 style="background-color:yellow;">RequestDispathcer.forward :: request_C_1.jsp</h3>
<hr>
</body>
</html>