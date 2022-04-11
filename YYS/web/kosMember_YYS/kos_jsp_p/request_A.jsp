<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- log4j 객체 import  -->
<%@ page import="org.apache.log4j.LogManager" %> 
<%@ page import="org.apache.log4j.Logger" %>


<!-- HashMap, ArrayList 불러오기 -->
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>

<!-- JDBC 객체 import -->
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<!--  Connection 공통 클래스 import : KosConnectivity -->
<%@ page import="a.b.c.common.KosmoConnProperty" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST SCOPE</title>
<link rel="stylesheet" href="/kosMember_YYS/css/yysColor.css">
</head>
<body>

<h3>REQUEST SCORE</h3>
<hr>

<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("request_A.jsp  >>>> : ");
	
	// 데이터베이스 연결 
	Connection conn=KosmoConnProperty.getConnection();
	logger.info("conn >>> : "+conn);
	String sqls="SELECT A.* FROM EMP A";
	PreparedStatement pstmt=conn.prepareStatement(sqls);
	ResultSet rsRs=pstmt.executeQuery();
	
	ArrayList<HashMap<String, String>> aList=null;
	
	if(rsRs !=null){
		aList=new ArrayList<HashMap<String, String>>();
		while(rsRs.next()){
			HashMap<String, String> hp=new HashMap<String, String>();
			hp.put("empno", rsRs.getString("EMPNO"));
			hp.put("ename", rsRs.getString("ENAME"));
			hp.put("job", rsRs.getString("JOB"));
			hp.put("mgr", rsRs.getString("MGR"));
			hp.put("hiredate", rsRs.getString("HIREDATE"));
			hp.put("sal", rsRs.getString("SAL"));
			hp.put("comm", rsRs.getString("COMM"));
			hp.put("deptno", rsRs.getString("DEPTNO"));
			
			aList.add(hp);
		}
	}
	
	/*
	https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html
	
	javax.servlet.ServletContext
	
	void setAttribute(java.lang.String name,
                java.lang.Object o)
	Stores an attribute in this request. Attributes are 
	reset between requests. This method is most often used 
	in conjunction with RequestDispatcher.
	
	name : a String specifying the name of the attribute
	o : the Object to be stored
	*/
	
	
	request.setAttribute("aList", aList);
	
	// javax.servlet.RequestDispatcher
	
	/* RequestDispatcher getRequestDispatcher(java.lang.String path)
	   Returns a RequestDispatcher object that acts as a wrapper 
	   for the resource located at the given path.
	   The pathname must begin with a "/" and is interpreted 
	   as relative to the current context root.
	   Use getContext to obtain a RequestDispatcher for resources 
	   in foreign contexts.
	*/
	
	RequestDispatcher rd=request.getRequestDispatcher("/kos_jsp_p/request_B.jsp");
	// /kosMember_YYS/kos_jsp_p/request_B.jsp에서 컨텍스트 빼야함.
	// 이유 : 컨텍스트 간 이동이 불가하므로, 컨텍스트가 이미 포함되어있음.
	
	
	// javax.servlet.RequestDispatcher
	
	rd.forward(request, response);
	/*
	void forward(ServletRequest request,
           ServletResponse response)
             throws ServletException,
                    java.io.IOException
                    
    Forwards a request from a servlet to another resource
    (servlet, JSP file, or HTML file) on the server. 
    This method allows one servlet to do preliminary 
    processing of a request and another resource to generate 
    the response.                    
	*/ 
%>

</body>
</html>