<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST FORWARD</title>
</head>
<body>
<h3 style="background-color: yellow;">TEST FORWARD : &lt;jsp:forward/&gt; 싱글 태그 </h3>
<hr>
<%
	String mid_forwad_singletag = "kosmo";
	request.setAttribute("mid", mid_forwad_singletag);
%>
3. jsp : &lt;jsp:forward page="" /&gt;<br>   
<jsp:forward page="/kos_jsp/test_forward_3_d.jsp" />
</body>
</html>