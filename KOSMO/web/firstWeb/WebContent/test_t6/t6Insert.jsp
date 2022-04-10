<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.t6.servie.T6Service" %>
<%@ page import="a.b.c.t6.servie.T6ServiceImpl" %>
<%@ page import="a.b.c.t6.vo.T6VO" %>  
<%@ page import="java.util.ArrayList" %>   
<%@ page import="a.b.c.common.ChabunUtil" %>
<%@ page import="a.b.c.common.DateUtil" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST_T6 SELECT ALL</title>
</head>
<body>
<h3>TEST_T6 SELECT NAME</h3>
<hr>
<%
	String t1 = ChabunUtil.getT6Chabun("d");
	String t2 = request.getParameter("t2");
	String t3 = request.getParameter("t3");
		
	T6VO tvo = null;
	tvo = new T6VO();		
	tvo.setT1(t1);
	tvo.setT2(t2);
	tvo.setT3(t3);

	T6Service ts = new T6ServiceImpl();	
	boolean bool = ts.t6Insert(tvo);
	
	if (bool) {
%>
		<script>
			alert("입력 성공");
			location.href="/firstWeb/test_t6/t6selectAll.jsp";
		</script>
<%		
	}else{
%>
		<script>
			alert("입력 실패");
			history.go(-1);
		</script>

<%
	}
%>
</body>
</html>