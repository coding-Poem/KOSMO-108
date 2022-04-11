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
<p style="backgroun-color:red;">reqeust_D.jsp 페이지 입니다.</p>

<%
	Object obj=request.getAttribute("aaa");
	if (obj==null)return;
	// obj가 null이면 멈춤
	
	ArrayList aList=(ArrayList)obj;
	// 클래스 다운캐스팅 Object to ArrayList
	// Object가 ArrayList의 시조새뻘이라
	// 괄호안에 자식 꺼 사용하고 싶으면 저렇게 써줘야 함
	
	String str=(String)aList.get(0);
	// aList의 첫 번째 칸에 들어가 있는 것
	// 객체 to String
%>
<%= str %>
<h3 style="background-color:blue;">RequestDispatcher.forward :: request_D.jsp</h3>
<hr>
</body>
</html>