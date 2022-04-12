<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: yellow;">TEST FORWARD : &lt;jsp:forward&gt;&lt;/jsp:forward&gt;  더블 태그</h3>
<hr>  
4. jsp :<br>
&lt;jsp:forward page=""&gt;<br>
	&lt;jsp:param name="" value="" &gt;<br>
&lt;/jsp:forward &gt;<br>
<%
	String mid = "kosmo";
%>
<jsp:forward page="/kos_jsp/test_forward_4_d.jsp">
	<jsp:param name="param_1" value="<%= mid %>" />
</jsp:forward>

</body>
</html>