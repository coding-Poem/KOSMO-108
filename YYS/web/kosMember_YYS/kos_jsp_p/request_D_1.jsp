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
<h3 style="background-color:red;">RequestDispatcher.forward :: request_D_1.jsp</h3>
<p style="backgroun-color:red;">reqeust_D_1.jsp 페이지 입니다.</p>

<%
	/* response vs request 
		request : 가지고 와라
		response : 가라
	*/
	// response 해보기
	// response.sendRedirect("http://www.naver.com");
	// http://www.naver.com을 주석 처리 안 하면, naver로 갔다.
	
	
	
	// request 해보기
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
<h3 style="background-color:red;">RequestDispatcher.forward :: request_D_1.jsp</h3>
<hr>
</body>
</html>