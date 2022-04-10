<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello Jsp!!<br>
	<hr>
<%
	out.println("Hello JSP !!!!");
	out.println("<hr>");
	java.util.Date d = new java.util.Date();
	out.println("Date >>> : " + d + "<br>");
	
	// java.lang.String getParameter(java.lang.String name)
	// Returns the value of a request parameter as a String
	// or null if the parameter does not exist
	String id = request.getParameter("id");
	// request는 클라이언트가 서버에게 요청하다"
	// response는 서버가 클라이언트에게  응답하다
	
	// request에 마우스를 갖다 대고 F3 키를 누르면 class 파일로 넘어가지가 않는다.
	// 이유 : request가 있는 클래스 파일의 경로는
	// C:\Program Files\Apache Software Foundation\Tomcat 8.5\lib\sevlet-api.jar
	// \servlet-api/javax/servlet/ServletRequest.class 에 있다.
	
	// 여기서, f3 눌러서 볼 수 있는 파일의 경로는
	// C:\Program Files\Java\jdk1.8.0_202\jre\lib\rt.jar 이다.	
	String pw = request.getParameter("pw");
	System.out.println("id >>> : " + id);
	System.out.println("pw >>> : " + pw);
	out.println("id >>> : " + id + "<br>");
	out.println("pw >>> : " + pw + "<br>");
%>	

</body>
</html>