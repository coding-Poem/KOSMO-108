<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.codepoemVO.CodingPoemVO" %>
<%@ page import="a.b.c.codepoem.CodingPoem" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
<%	
	Logger log = LogManager.getLogger(this.getClass());
	//html에서 값 받아오기(name을 통한 데이터 받기)
	String p1 = request.getParameter("text1");
	String p2 = request.getParameter("text2");
	String p3 = request.getParameter("text3");
	String p4 = request.getParameter("text4");
	String p5 = request.getParameter("text5");
	String p6 = request.getParameter("text6");
	
	request.setAttribute("p1",p1);
	request.setAttribute("p2",p2);
	request.setAttribute("p3",p3);
	request.setAttribute("p4",p4);
	request.setAttribute("p5",p5);
	request.setAttribute("p6",p6);
	
	
	
	
%>		
		<%--인클루드 싱글 액션태그를 이용하여 동적 데이터 발사요청 --%> 
		<jsp:include page="/CodingPoem3/Result.jsp"/>
			
	</body>
</html>