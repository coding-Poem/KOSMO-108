<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getData_1 jsp</title>
</head>
<body>
<h3>getData_1 jsp</h3>
<hr>

<!-- 	
		WEB => WAS로 GET방식일 때, UTF-8로 인코딩하는 법
		1. server.xml :  탐켓 서버 전체에 인코딩 : GET방식으로 들어오는 스트림 인코딩
		<Connector connectionTimeout="20000" port="8088" 
		protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/> 
		
		2. Context/WebContent/WEB-INF/web.xml
-->
		
<% request.setCharacterEncoding("UTF-8"); %>

<%	
	// java.servlet.http 
	// Interface ServletRequest
	// Subinterfaces : HttpServletRequest
	// java.lang.String : 	getParameter(java.lang.String name)
	// Returns the value of a request parameter as a String, or null 
	// if the parameter does not exist.
	String mname = request.getParameter("mname");
	String maddr = request.getParameter("maddr");
	
	System.out.println("getData_1 jsp >>> mname >>> : " + mname);
	// 이클립스 콘솔창 :: mname >>> : 바이
	// getData_1 jsp >>> mname >>> : 111

	System.out.println("getData_1 jsp >>> maddr >>> : " + maddr);
	// 이클립스 콘솔창 :: maddr >>> : 부산
	// getData_1 jsp >>> maddr >>> : 222
%>
	<%= "이름 : "+mname %><br>
	<!-- 화면 출력 결과 :: 이름 : 바이 -->
	<%= "주소 : "+maddr %>
	<!-- 화면 출력 결과 :: 주소 : 부산 -->
	<hr>
	<a href="https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html">Servlet 3.1 - Apache Tomcat 8.0.53 API 보기</a>
</body>
</html>