<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.t6.servie.T6Service" %>
<%@ page import="a.b.c.t6.servie.T6ServiceImpl" %>
<%@ page import="a.b.c.t6.vo.T6VO" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST_T6 DELETE OK</title>
</head>
<body>
<h3>TEST_T6 DELETE OK</h3>
<hr>
<%
	String t1 = request.getParameter("t1");
	
	T6VO tvo = null;
	tvo = new T6VO();		
	tvo.setT1(t1);	

	T6Service ts = new T6ServiceImpl();	
	boolean bool = ts.t6Delete(tvo);
	
	if (bool) {
%>
		<script>
			alert("삭제 성공");
			location.href="/firstWeb/test_t6/t6selectAll.jsp";
		</script>
<%		
	}else{
%>
		<script>
			alert("삭제 실패");
			history.go(-1);
		</script>

<%
	}
%>
</body>
</html>