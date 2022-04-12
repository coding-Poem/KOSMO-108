<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: yellow;">TEST FORWARD : RequestDispather.forward()</h3>
<hr>
<%
	String mid = "kosmo";

	// request 내장형 객체의 함수 중 setAttribuate(java.lang.String, java.lang.Object) 함수로 데이터를 저장한다.
	// 이렇게 저장한 데이터는 
	// 요청한 페이지에서 request.getAttribute(java.lang.String) 함수로 데이터를 찾아서 사용할 수 있다.
	request.setAttribute("mid", mid);
	
	// 1. Servlet : RequestDispatcher.forward()
	RequestDispatcher rd = request.getRequestDispatcher("/kos_jsp/test_forward_1_d.jsp");
	rd.forward(request, response);	
	//  rd.forward 함수가 실행이 되면 
	// 	line 18 에서 정의한 request.setAttribute("mid", mid) 객체가 
	//  line 23 에서 rd.forward 함수의 첫번째 매개변수에 바인딩 되서 forward 페이지로 전송된다.
%>
</body>
</html>