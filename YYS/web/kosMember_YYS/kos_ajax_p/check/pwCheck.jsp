<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW CHECK</title>
</head>
<body>
<h3>PW CHECK</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	String mpw=request.getParameter("mpw");
	logger.info("mpw >>> : "+mpw);
	
	String ISUD_TYPE=request.getParameter("ISUD_TYPE");
	logger.info("ISUD_TYPE >>> : "+ISUD_TYPE);

	String sVal="";
	
	if("PWCHECK".equals(ISUD_TYPE)){
		logger.info("ISUD_TYPE이 PWCHECK와 같습니다. >>> : "+ISUD_TYPE);
		if("test00".equals(mpw)){
			logger.info("mpw가 test00과 같습니다. >>> : "+mpw);
			sVal="PW_GOOD";
			logger.info("sVald이 PW_GOOD 되었습니다. >>>  : "+sVal);
		}
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= sVal %></result>	
</login>
</body>
</html>