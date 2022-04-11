<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- log4j 객체 import -->    
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.util.HashMap" %>  
<%@ page import="java.util.ArrayList" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request_B.jsp</title>
</head>
<body>
<h3>request_B.jsp</h3>
<hr>
<table border="1">
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("request_B.jsp 페이지 >>> : ");

	Object obj = request.getAttribute("aList");
	logger.info("obj >>> : " + obj);
	
	ArrayList<HashMap<String,String>> aList = (ArrayList<HashMap<String,String>>)obj;
	
	if (aList !=null && aList.size() > 0) {
%>
		<tr>
			<td>EMPNO</td>
			<td>ENAME</td>
			<td>JOB</td>
			<td>MGR</td>
			<td>HIREDATE</td>
			<td>SAL</td>
			<td>COMM</td>
			<td>DEPTNO</td>
		</tr>
<%		
		for (int i=0; i < aList.size(); i++){
			HashMap<String,String> hs = aList.get(i);
			logger.info(hs.get("empno"));
			logger.info(hs.get("ename"));
			logger.info(hs.get("job"));
%>		
		<tr>
			<td><%= hs.get("empno") %></td>
			<td><%= hs.get("ename") %></td>
			<td><%= hs.get("job") %></td>
			<td><%= hs.get("mgr") %></td>
			<td><%= hs.get("hiredate") %></td>
			<td><%= hs.get("sal") %></td>
			<td><%= hs.get("comm") %></td>
			<td><%= hs.get("deptno") %></td>
		</tr>		
<%			
		}
	}
%>
</table>
</body>
</html>
















