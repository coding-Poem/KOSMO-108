<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oralce Test</title>
</head>
<body>
<h3>Oralce Test</h3>
<hr>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclHBE00", "scott", "tiger");						
	Statement stmt = conn.createStatement();
	ResultSet rsRs = stmt.executeQuery("SELECT * FROM TEST_T6 ORDER BY 1 DESC");
	
	while (rsRs.next()) {
		System.out.print(rsRs.getString(1) + " : ");
		System.out.print(rsRs.getString(2) + " : ");
		System.out.print(rsRs.getString(3) + " : ");
		System.out.print(rsRs.getString(4) + " : ");
		System.out.print(rsRs.getString(5) + " : ");
		System.out.println(rsRs.getString(6));	
		
		out.print(rsRs.getString(1) + " : ");
		out.print(rsRs.getString(2) + " : ");
		out.print(rsRs.getString(3) + " : ");
		out.print(rsRs.getString(4) + " : ");
		out.print(rsRs.getString(5) + " : ");
		out.println(rsRs.getString(6) + "<br>");
	}

%>
</body>
</html>