<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import=" org.apache.log4j.LogManager" %>    
<%@ page import="org.apache.log4j.Logger" %>   
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>  
<%@ page import="a.b.c.kos.mem.service.MemService" %>
<%@ page import="a.b.c.kos.mem.service.MemServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제</title>
</head>
<body>
<h3>회원정보 삭제</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());

	logger.info(" memDeleteOk.jsp 페이지 >>> : ");
	
	/*******  memSelect.jsp :::: request.getParameter or request.getParameterValues  *****/
	// 회원번호
	// <input type="text" name="mnum" id="mnum"
	String mnum=request.getParameter("mnum");
	
	MemVO mvo=null;
	mvo=new MemVO();
	mvo.setMnum(mnum);
	
	logger.info("mnum >>> : "+mvo.getMnum());
	
	MemService ms=new MemServiceImpl();
	boolean bool=ms.memDelete(mvo);
	if(bool){	
%>
	<script>
		alert("삭제 성공");
		location.href="/kosMember_YYS2/kosmem/memSelectAll.jsp";
		// /kosMember_YYS2/kosmem/memSelectAll.jsp
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