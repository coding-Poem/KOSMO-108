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
	HTML --------------------  Web Server ----------------------------------- WAS -------- DATABASE
							인코딩
							HTML	JSP
		GET		HEADER				탐캣 서버 환경설정 파일에서 한다.
		POST	BODY				탐캣 서버 환경설정 파일에서 한다.
									: 요청한 스트림을 받아서 인코딩한 것
									request.setCharacterEncoding("UTF-8"); 
									
	탐캣 서버 환경설정 파일에서 한다.
	1. server.xml : 탐캣 서버 전체에 인코딩 : GET 방식을 들어오는 스트림 인코딩
		탐캣 서버 - Servers - Tomcat v8.5 Server at localhost-config -	server.xml	
		63라인 : Connector 	connectionTimeout="20000" 
						port="8088" 
						protocol="HTTP/1.1" 
						redirectPort="8443"
						URIEncoding="UTF-8"		
	2. Context/WebContent/WEB-INF/web.xml : Context 만 인코딩하는 것						
 -->

<% 
	request.setCharacterEncoding("UTF-8");
%>

<%
	String mname = request.getParameter("mname");
	String maddr = request.getParameter("maddr");
	
	System.out.println("mname >>> : " + mname);
	System.out.println("maddr >>> : " + maddr);
%>
이름 : <%= mname %><br>
주소 : <%= maddr %>

</body>
</html>