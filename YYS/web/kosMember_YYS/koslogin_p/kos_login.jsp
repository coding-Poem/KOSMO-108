<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- import : log4j -->    
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!--  커넥션 클래스 -->
<!--  import : KosConnectivity -->
<%@ page import="a.b.c.common.KosConnectivity" %>

<!-- java.sql.* JDBC 클래스 -->
<!--  import : java.sql.Connection -->
<%@ page import="java.sql.Connection" %>
<!-- import : java.sql.PreparedStatement-->
<%@ page import="java.sql.PreparedStatement" %>
<!-- import : java.sql.ResultSet--> 
<%@ page import="java.sql.ResultSet" %>

<!-- java 깡통 클래스(VO클래스) -->
<!--  import : a.b.c.kos.mem.vo.MemVO --> 
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kos_login.jsp</title>
<link rel="stylesheet" href="/kosMember_YYS/css/yysColor.css">
</head>
<body>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("kos_login.jsp 페이지 >>> : ");
	
	String mid=request.getParameter("mid");
	logger.info("kos_login.jsp ::: mid >>> : "+mid);
	String mpw=request.getParameter("mpw");
	logger.info("kos_login jsp :: mpw >>> : "+mpw);
	
	// 화면 밖으로 표시하기
	out.println("kos_login.jsp ::: mid >>> : "+mid);
	out.println("kos_login jsp :: mpw >>> : "+mpw);
	
	// jdbc 연결 및 sql 사용하기
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rsRs=null;
	MemVO mvo=null;
	mvo=new MemVO();
	int nCnt=0;
	
	mvo.setMid(mid);
	mvo.setMpw(mpw);
	
	conn=KosConnectivity.getConnection();
	String sqls="SELECT COUNT(A.MNUM) NCNT FROM KOS_MEMBER A WHERE A.DELETEYN='Y' AND A.MID=? AND A.MPW=?";
	// place holder 1 : mid
	// place holder 2 : mpw
	
	pstmt=conn.prepareStatement(sqls);
	logger.info("sqls >>> : "+sqls);
	
	pstmt.clearParameters();
	logger.info("kos_login jsp :: mvo.getMid() >>> : "+mvo.getMid());
	logger.info("kos_login jsp :: mvo.getMpw() >>> : "+mvo.getMpw());
	pstmt.setString(1, mvo.getMid());
	pstmt.setString(2, mvo.getMpw());
	rsRs=pstmt.executeQuery();
	logger.info("pstmt.executeQuery() 완료 >>>> :");
	
	if(rsRs!=null){
		logger.info("kos_login jsp :: if(rsRs!=null) 진입 성공 >>> : ");
		while(rsRs.next()){
			nCnt=rsRs.getInt("NCNT");
			/*
			################# getInt(int columnIndex) ########################
			int java.sql.ResultSet.getInt(int columnIndex) throws SQLException

			Retrieves the value of the designated column in the current row of this 
			ResultSet object as an int in the Java programming language. 

 			Parameters:
			columnIndex the first column is 1, the second is 2, ...

			Returns:
					the column value; if the value is SQL NULL, the value returned is 0
			Throws:
					SQLException if the columnIndex is not valid; if a database access error occurs or this method 
	 				is called on a closed result se
			
	 		################# getInt(int columnLabel) ########################
	 		int java.sql.ResultSet.getInt(String columnLabel) throws SQLException

	 		Retrieves the value of the designated column in the current row of this 
	 		ResultSet object as an int in the Java programming language. 
	 		
	 		Parameters:
	 				columnLabel the label for the column specified with the SQL AS clause. If the SQL AS clause was 
	 				not specified, then the label is the name of the column
	 		Returns:
	 				the column value; if the value is SQL NULL, the value returned is 0
	 		Throws:
	 				SQLException if the columnLabel is not valid; if a database access error occurs or this method is 
	 				called on a closed result set	 				
	 				
			*/
			}
		}	
			if(nCnt==1){
				logger.info("kos_login jsp :: if(nCnt==1) 진입 성공 >>> : ");
				request.setAttribute("nCnt", new Integer(nCnt));
				// void javax.servlet.ServletRequest.setAttribute(String name, Object o)
				// 기초자료형 애들은 new Integer, new Double new Boolean.... 등등으로 써야 한다.
				RequestDispatcher rd=request.getRequestDispatcher("/koslogin_p/kos_login_ok.jsp");
				logger.info("kos_login jsp :: RequestDispathcher rd >>> : "+rd);
				rd.forward(request, response);
			}else{
				logger.info("kos_login jsp :: if(nCnt==1) 진입 실패 >>> : ");
%>
			<script>
				alert("로그인 실패 !!!");
				location.href="/kosMember_YYS2/koslogin_p/kos_login.html";
			</script>
<% 						
			}
%>
</body>
</html>