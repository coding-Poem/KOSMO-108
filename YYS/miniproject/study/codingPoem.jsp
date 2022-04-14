<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<%@ page import="a.b.c.study.CodingPoem" %>    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과공개</title>
</head>
<body>
<h3>codingPoem.jsp 이게 출력이 되면 안 된다.</h3>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	String firstPerson="";
	String secondPerson="";

	CodingPoem rs=new CodingPoem();

	ArrayList<String> aList=new ArrayList();
	
	aList.add("윤요섭");
	aList.add("박건원");
	aList.add("김별");
	aList.add("성연제");
	aList.add("박성훈");
	aList.add("강민");
	
	ArrayList<String> rList=rs.random(aList);
	
	firstPerson=rList.get(0);
	logger.info("firstPerson >>> : "+new String(firstPerson));
	
	request.setAttribute("first", firstPerson);
	
	secondPerson=rList.get(1);
	logger.info("second >>> : "+secondPerson);
	
	request.setAttribute("second", new String(secondPerson));
	
	RequestDispatcher rd=request.getRequestDispatcher("/study/result.jsp");
	rd.forward(request, response);
%>
</body>
</html>