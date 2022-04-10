<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>html5_6 요청 데이터 받기</title>
</head>
<body>
<h3>html5_6 요청 데이터 받기</h3>
<hr>
<%
	String uid = request.getParameter("uid");
	String umail = request.getParameter("umail");
	String pwd1 = request.getParameter("pwd1");
	String path = request.getParameter("path");
	String memo = request.getParameter("memo");
	String mailing = request.getParameter("mailing");
	
	System.out.println("html5_6.html 파일 form 태그에서 전송된 요청 정보를 ");
	System.out.println("html5_6.jsp jsp 파일에서 받아서 콘솔에 출력하기");
	System.out.println("uid >>> : " + uid);
	System.out.println("umail >>> : " + umail);
	System.out.println("pwd1 >>> : " + pwd1);
	System.out.println("path >>> : " + path);
	System.out.println("memo >>> : " + memo);
	System.out.println("mailing >>> : " + mailing);
	
	
	out.println("html5_6.html 파일 form 태그에서 전송된 요청 정보를 " + "<br>");
	out.println("html5_6.jsp jsp 파일에서 받아서 브라우저에 출력하기" + "<br>");
	out.println("uid >>> : " + uid + "<br>");
	out.println("umail >>> : " + umail + "<br>");
	out.println("pwd1 >>> : " + pwd1 + "<br>");
	out.println("path >>> : " + path + "<br>");
	out.println("memo >>> : " + memo + "<br>");
	out.println("mailing >>> : " + mailing + "<br>");
%>
</body>
</html>