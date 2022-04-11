<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>param_B.jsp</h3>
<hr>
<%
// 스크립틀릿 : 자바코드를 기술한다.
	// <input type="text" class="mid" name="mid" id="mid" />	
	// request : 내장형 오브젝트 
	String mid = request.getParameter("mid");
	// <input type="text" class="mpw" name="mpw" id="mpw" />
	String mpw = request.getParameter("mpw");
	
	System.out.println("mid >>> : " + mid);
	System.out.println("mpw >>> : " + mpw);
%>

<!-- &lt;%= mid %&gt; 표현식 : 자바코드를 웹브라우저에 출력하는 것  -->
<%-- <%= mid %> 표현식 : 자바코드를 웹브라우저에 출력하는 것   --%>
&lt;%= mid %&gt; -> <%= mid %><br>
&lt;%= mpw %&gt; -> <%= mpw %><br>
</body>
</html>