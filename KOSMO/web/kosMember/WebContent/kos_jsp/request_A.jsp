<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- log4j 객체 import -->    
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!-- JDBC 객체 import -->
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<!-- Connection 공통 클래스 import : KosConnectivity  -->  
<%@ page import="a.b.c.common.KosmoConnProperty" %>
  
  
<%@ page import="java.util.HashMap" %>  
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST SCOPE</title>
</head>
<body>
<h3>REQUEST SCOPE</h3>
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("request_A.jsp 페이지 >>> : ");
	
	// 데이터베이스연결 
	Connection conn = KosmoConnProperty.getConnection();
	logger.info("conn >>> : " + conn);
	String sqls = "SELECT A.* FROM EMP A WHERE ROWNUM <= 3";
	PreparedStatement pstmt = conn.prepareStatement(sqls);
	ResultSet rsRs = pstmt.executeQuery();
	
	ArrayList<HashMap<String,String>> aList = null;
	
	if (rsRs !=null){
		
		aList = new ArrayList<HashMap<String,String>>();
		
		while(rsRs.next()){
			HashMap<String,String> hp = new HashMap<String,String>();
			hp.put("empno", rsRs.getString(1));
			hp.put("ename", rsRs.getString(2));
			hp.put("job", rsRs.getString(3));
			hp.put("mgr", rsRs.getString(4));
			hp.put("hiredate", rsRs.getString(5));
			hp.put("sal", rsRs.getString(6));
			hp.put("comm", rsRs.getString(7));
			hp.put("deptno", rsRs.getString(8));
			aList.add(hp);
		}
	}
	
	// ArrayList 객체를 다른 jsp 에 넘기기 
	// http://localhost:8088/kosMember/kos_jsp/request_B.jsp
	// setAttribute(key, value) 
	request.setAttribute("aList", aList);
	
	// request.getRequestDispatcher() 함수는 Context 내부에서 사용하는 함수로 
	// 자원의 url 을 사용할 때는 Context 패스는 생략한다. 
	// /kosMember/kos_jsp/request_B.jsp --> /kos_jsp/request_B.jsp
	RequestDispatcher rd = request.getRequestDispatcher("/kos_jsp/request_B.jsp");
	rd.forward(request, response);
%>
</body>
</html>