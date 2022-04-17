<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.codepoemVO.CodingPoemVO" %>
<%@ page import="a.b.c.codepoem.CodingPoem" %>
<%@ page import="java.util.ArrayList" %>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
<%	
	//html에서 값 받아오기(name을 통한 데이터 받기)
	String p1 = request.getParameter("text1");
	String p2 = request.getParameter("text2");
	String p3 = request.getParameter("text3");
	String p4 = request.getParameter("text4");
	String p5 = request.getParameter("text5");
	String p6 = request.getParameter("text6");
	
%>		
		<%--인클루드 더블 액션 태그를 이용하여 동적 데이터 요청 --%> 
		<jsp:include page="/CodingPoem/Result.jsp">
			<jsp:param name="p1" value="<%=p1 %>"/>
			<jsp:param name="p2" value="<%=p2 %>"/>
			<jsp:param name="p3" value="<%=p3 %>"/>
			<jsp:param name="p4" value="<%=p4 %>"/>
			<jsp:param name="p5" value="<%=p5 %>"/>
			<jsp:param name="p6" value="<%=p6 %>"/>
		</jsp:include> 
	</body>
</html>