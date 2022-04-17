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
	
	log.info(p1);
	log.info(p2);
	log.info(p3);
	log.info(p4);
	log.info(p5);
	log.info(p6);
	
	//ArrayList에 담아서 넘겨볼까요 
	ArrayList<String> aList = null;
	aList = new ArrayList<String>();
	aList.add(0,p1);
	aList.add(1,p2);
	aList.add(2,p3);
	aList.add(3,p4);
	aList.add(4,p5);
	aList.add(5,p6);
	//request.setAttribute();에 aList를 담아서 넘겨볼까요
	request.setAttribute("aList",aList);
	
	log.info("aList.get(0)"+aList.get(0));
	log.info("aList.get(1)"+aList.get(1));
	log.info("aList.get(2)"+aList.get(2));
	log.info("aList.get(3)"+aList.get(3));
	log.info("aList.get(4)"+aList.get(4));
	log.info("aList.get(5)"+aList.get(5));
	
	
%>		
		<%--인클루드 싱글 액션태그를 이용하여 동적 데이터 발사요청 --%> 
		<jsp:include page="/CodingPoem2/Result.jsp"/>
			
	</body>
</html>