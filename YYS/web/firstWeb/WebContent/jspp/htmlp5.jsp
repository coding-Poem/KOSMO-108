<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOSMO 스터디 회원가입 데이터 받기</title>
</head>
<body>
<h3>KOSMO 스터디 회원가입 데이터 받기</h3>
<hr>
<%
	String name=request.getParameter("name");
	String umail=request.getParameter("umail");
	String path=request.getParameter("path");
	String memo=request.getParameter("memo");
	String mailing=request.getParameter("mailing");
	
	out.println("KOSMO 스터디 새로운 회원 정보"+"<br>");
	out.println("jsp 파일에서 받아서 브라우저에 출력하기"+"<br>");
	out.println("새로운 회원 이름 : "+name+"<hr>");
	out.println("새로운 회원 이메일 : "+umail+"<hr>");
	out.println("새로운 회원의 가입 경로 : "+path+"<hr>");
	out.println("앞으로의 각오 : "+memo+"<hr>");
	out.println("메일 수신 여부 : "+mailing+"<hr>");
%>


</body>
</html>