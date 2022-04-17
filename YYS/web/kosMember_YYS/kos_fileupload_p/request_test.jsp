<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST TEST</title>
</head>
<body>
<h3>REQUEST TEST</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	String context_path=pageContext.getServletContext().getRealPath("/");
	logger.info("context_path >>> : "+context_path);
	// context_path >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work
	// \.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember_YYS2\
	
	
	/*
	javax.servlet.ServletConfig : getServletContext
	
	Returns a reference to the ServletContext 
	in which the caller is executing.
	
	Returns: a ServletContext object, used by the caller to interact with its servlet container
	
	javax.servlet.ServletContext : getRealPath
	
	java.lang.String getRealPath(java.lang.String path)
	
	Returns a String containing the real path for a given virtual path. 
	For example, the path "/index.html" returns the absolute file path 
	on the server's filesystem would be served by a request for "http://host/contextPath/index.html", 
	where contextPath is the context path of this ServletContext..
	*/

	String method=request.getMethod();
	logger.info("method >>> : "+method);
	// method >>> : GET
	
	/*
	Returns the name of the HTTP method with which this request was made,
	for example, GET, POST, or PUT.
	
	Returns : a String, decoded by the web container, specifying extra path information 
	that comes after the servlet path but before the query string in the request URL; 
	or null if the URL does not have any extra path information
	*/
%>
<form action="reqeust_test.jsp"
	   method="POST"
	   enctype="multipart/form-data">
<input type="submit" value="보낵기">
</form>
</body>
</html>