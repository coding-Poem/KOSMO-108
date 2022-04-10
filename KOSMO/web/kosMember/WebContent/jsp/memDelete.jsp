<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.kos.service.MemService" %>
<%@ page import="a.b.c.kos.service.MemServiceImpl" %>
<%@ page import="a.b.c.kos.vo.MemVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_MEMBER DELETE</title>
</head>
<body>
<h3>KOS_MEMBER DELETE</h3>
<hr>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>

<%
	String mnum=request.getParameter("mnum");
	//<input type="text" name="mnum" id="mnum" size="25"  readonly value= mvo.getMnum()
	System.out.println("\n memDelete :: jsp :: mnum >>> : "+mnum);
	MemVO mvo=null;
	mvo=new MemVO();
	mvo.setMnum(mnum);
	MemService ms=new MemServiceImpl();
	boolean bool=ms.memDelete(mvo);
	
	if(bool){
%>
 	<script>
 		alert("삭제 성공");
 		location.href="/kosMember/jsp/memSelectAll.jsp";
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