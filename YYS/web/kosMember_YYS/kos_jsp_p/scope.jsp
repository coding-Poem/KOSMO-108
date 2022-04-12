<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCOPE JSP</title>
</head>
<body>
<%
	String scope = "scope test";
%>
String scope = "scope test";
<%
	pageContext.setAttribute("scope_page", scope);
	request.setAttribute("scope_request", scope);
	session.setAttribute("scope_session", scope);
	application.setAttribute("scope_application", scope);
%>
<p>
jsp expression 표현식 
<hr>
&lt;%= scope %&gt; -> <%= scope %><br>
&lt;%= pageContext.getAttribute("scope_page") %&gt; -> <%= pageContext.getAttribute("scope_page") %><br>
&lt;%= request.getAttribute("scope_request") %&gt; -> <%= request.getAttribute("scope_request") %><br>
&lt;%= session.getAttribute("scope_session") %&gt; -> <%= session.getAttribute("scope_session") %><br>
&lt;%= application.getAttribute("scope_application") %&gt; -> <%= application.getAttribute("scope_application") %><br>


<p>
el : Expression Language 표현식 
<hr>
\${ scope } -> ${ scope }<br>
\${ scope_page } -> ${ scope_page }<br>
\${ scope_request } -> ${ scope_request }<br>
\${ scope_session } -> ${ scope_session }<br>
\${ scope_application } -> ${ scope_application }<br>
</body>
</html>


