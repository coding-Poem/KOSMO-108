<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID CHECK</title>
</head>
<body>
<h3>ID CHECK</h3>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	// <input type="text" name="mid" id="mid" placeholder="아이디체크" style="width:100px" />
	String mid=request.getParameter("mid");
	logger.info("mid >>> : "+mid);
	
	// <input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE">
	String ISUD_TYPE=request.getParameter("ISUD_TYPE");
	logger.info("ISUD_TYPE >>> : "+ISUD_TYPE);
	
	String sVal="";
	if("IDCHECK".equals(ISUD_TYPE)){
		logger.info("IDCHECK와 ISUD_TYPE이 같습니다. >>>> : "+ ISUD_TYPE);
		if("test".equals(mid)){
			logger.info("mid가 test와 같습니다. >>> : "+mid);
		}else{
			sVal="IDGOOD";
			logger.info("mid가 test와 같지 않습니다. >>> : "+mid);
			logger.info("sVald이 IDGOOD이 되었습니다. >>>  : "+sVal);
		}
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= sVal %></result>
</login>
</body>
</html>