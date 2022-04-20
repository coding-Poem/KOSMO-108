<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!-- mail 객체 import  -->    
<%@ page import="a.b.c.test.mail_p.GmailSend"%>

<%@ page import="a.b.c.test.mail_p.GmailVO"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GMAIL SEND</title>
</head>
<body>
<h3>GMAIL SEND</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger=LogManager.getLogger(this.getClass());

	String mailsubject=request.getParameter("mailsubject");
	String sendmail=request.getParameter("sendmail");
	String mailpw=request.getParameter("mailpw");
	String resivemail=request.getParameter("resivemail");
	String sendmsg=request.getParameter("sendmsg");
	
	logger.info("mailsubject >>> : "+mailsubject);
	logger.info("sendmail >>> : "+sendmail);
	logger.info("mailpw >>> : "+mailpw);
	logger.info("resivemail >>> : "+resivemail);
	logger.info("sendmsg >>> : "+sendmsg);
	
	out.println("mailsubject >>> : "+mailsubject+"<br>");
	out.println("sendmail >>> : "+sendmail+"<br>");
	out.println("mailpw >>> : "+mailpw+"<br>");
	out.println("resivemail >>> : "+resivemail+"<br>");
	out.println("sendmsg >>> : "+sendmsg+"<br>");

	GmailVO gvo = null;
	gvo = new GmailVO();
	gvo.setMailsubject(mailsubject);
	gvo.setSendmail(sendmail);
	gvo.setMailpw(mailpw);
	gvo.setResivemail(resivemail);
	gvo.setSendmsg(sendmsg);
	
	GmailSend gms = new GmailSend();
	gms.gmailSend(gvo);
%>

</body>
</html>