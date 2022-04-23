<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.sql.DataSource" %>

<!--  JNDI 객체  import -->
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
    
<!--  log4j -->
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
JNDI InitialContext <br>
JNDI : Java Naming and Directory Interface
</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());	

	Context context=new InitialContext();
	// 여기서 에러 난다. 다음에 처리하기
	DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/jndi_orclYYS00");
	logger.info("ds >>> : "+ds);
	
	// getConncetion 메서드를 이용해서 커넥션 풀로 부터 커넥션 객체를 얻어내어 conn변수에 저장
	Connection conn=ds.getConnection();
	PreparedStatement stmt=conn.prepareStatement("SELECT*FROM EMP");
	ResultSet rsRs=stmt.executeQuery();
	
	while(rsRs.next()){
		out.println(rsRs.getString(1)+" ");
		out.println(rsRs.getString(2)+" ");
		out.println(rsRs.getString(3)+" ");
		out.println(rsRs.getString(4)+" ");
		out.println(rsRs.getString(5)+" ");
		out.println(rsRs.getString(6)+" ");
		out.println(rsRs.getString(7)+" ");
		out.println(rsRs.getString(8)+" <br> ");
	}
%>
</body>
</html>