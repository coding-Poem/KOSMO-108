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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>request_B.jsp</title>
<style type="text/css">	
	div{
		box-sizing:border-box;
		margin:50px auto;
	}
		
	tr, td{
		text-align:center;
	 	width:300px;
	 	height:50px;
		margin:10px auto;
	}
	
	table{
		height:50px;
		weight:200px;
		margin:10px auto;
	}
	
	body{
		background-color:#ffffe6;
	}
</style>
</head>
<body>
<div class="container">
<h3>request_B.jsp</h3>
<hr>
<table border="8">
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("request_B.jsp 페이지 >>> : ");
	
	Object obj=request.getAttribute("aList");
	logger.info("obj >>> : "+obj);
	
	ArrayList<HashMap<String, String>> aList=(ArrayList<HashMap<String, String>>)obj;
	// 형변환하기
	
	/*
	kosMember_YYS/kos_jsp_p/request_A.jsp
	
	hp.put("empno", rsRs.getString("EMPNO"));
	hp.put("ename", rsRs.getString("ENAME"));
	hp.put("job", rsRs.getString("JOB"));
	hp.put("mgr", rsRs.getString("MGR"));
	hp.put("hiredate", rsRs.getString("HIREDATE"));
	hp.put("sal", rsRs.getString("SAL"));
	hp.put("comm", rsRs.getString("COMM"));
	hp.put("deptno", rsRs.getString("DEPTNO"));
	*/
	
	if (aList != null && aList.size()>0){
		for (int i=0; i<aList.size(); i++){
			HashMap<String, String> hs=aList.get(i);
			logger.info(hs.get("empno"));
			logger.info(hs.get("ename"));
			logger.info(hs.get("job"));
			logger.info(hs.get("mgr"));
			logger.info(hs.get("hiredate"));
			logger.info(hs.get("sal"));
			logger.info(hs.get("comm"));
			logger.info(hs.get("deptno"));
%>
		<tr>
			<td><%= hs.get("empno") 	%></td>
			<td><%= hs.get("ename") 	%></td>
			<td><%= hs.get("job") 		%></td>
			<td><%= hs.get("mgr") 		%></td>
			<td><%= hs.get("hiredate")  %></td>
			<td><%= hs.get("sal") 		%></td>
			<td><%= hs.get("comm") 		%></td>
			<td><%= hs.get("deptno") 	%></td>
		</tr>	
<%			
		} // end of for
	} // end of if 
%>
</table>
</div>	
</body>
</html>