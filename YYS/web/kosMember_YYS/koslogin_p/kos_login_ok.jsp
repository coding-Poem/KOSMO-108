<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- import : log4j -->    
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!-- import : Date 관련 클래스  -->
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_LOGIN_OK JSP</title>
<link rel="stylesheet" href="/kosMember_YYS2/css/yysColor.css">
<style type="text/css">
	body{
		background-color:#d6d6c2;
	}
</style>
</head>
<body>
<%@ include file="/koslogin_p/include_header.html" %>
<h3>KOS_LOING_OK JSP</h3>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("kos_login_ok.jsp 페이지 >>> : ");
	
	String browser="";
	String uagent=request.getHeader("User-Agent");
	logger.info("kos_login_ok.jsp :: uagent >>> : "+uagent);
	
	// "-Djava.net.preferIPv4Stack"=true
	// ip : 32bit, 128bit
	String raddr=request.getRemoteAddr();
	logger.info("kos_login_ok.jsp :: raddr >>> : "+raddr);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
	String dtime=sdf.format(new Date()).toString();
	logger.info("kos_login_ok.jsp :: dtime >>> : "+dtime);
	
	if(uagent.indexOf("Chrome")>0){
		logger.info("kos_login_ok.jsp :: if(uagent.indexOf('Chrome')>0) 진입 성공");
		browser="Chrome";
%>
	<script>
		var b='<%= browser %>'
		var r='<%= raddr %>'
		var d='<%= dtime %>'
		alert(b+' : '+r+' : '+d+"\n 로그인 성공");
	</script>
<%
	}
%>
<jsp:include page="/kosmem/memSelectAll.jsp"/>
<%@ include file="/koslogin_p/include_footer.html" %>
</body>
</html>