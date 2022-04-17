<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!-- 커넥션 클래스 import -->
<%@ page import="a.b.c.common.KosConnectivity" %>

<!-- java.sql.* JDBC 클래스 import -->    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>    

<%@ page import="a.b.c.test.vo.FileVO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILEUPLOAD IMG</title>
<style type="text/css">	
.card{
		padding: 25px;
		background-image:url("https://t1.daumcdn.net/cfile/blog/99885B435C0623B82F?original");
		background-repeat: no-repeat;
		background-size:cover;
		height:75%;
		width:75%;
		margin:100px auto;
}

.container {
  padding: 25px;
  align-content:center;
}


img{
	height:40%;
	width: 40%;
	margin:100px 0px 0px 100px auto;
	padding: 2px 16px;
  	box-shadow: 20px 20px 10px grey;
  	border-radius:50%
  	margin: 0px 0px 0px 50px;
}

img:hover{
	height:100%;
	width: 100%;
}
</style>
</head>
<body>
<div class="card">
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
	Logger logger = LogManager.getLogger(this.getClass());

	// fnumChk=7&ISUD_TYPE=
	String fnumChk=request.getParameter("fnumChk");
	logger.info("fnumChk >>> : "+fnumChk);
	
	String name="";
	String p="";
	String p2="";
	FileVO fvo = null;
	fvo = new FileVO();
	fvo.setFnum(fnumChk);
	
	if(fnumChk !=null){
		// 업데이트가 완료된다면 nCnt는 이제 0보다 큼
		Connection conn_s=null;
		PreparedStatement pstmt_s=null;
		ResultSet rsRs_s=null;
		ArrayList<FileVO> aList=null;
		
		conn_s=KosConnectivity.getConnection();
		String sqls_s = "SELECT * FROM KOS_FILE_IMAGE WHERE FNUM=?";
		logger.info("SELECT >>> : "+sqls_s);
		pstmt_s=conn_s.prepareStatement(sqls_s);
		pstmt_s.clearParameters();
		pstmt_s.setString(1, fvo.getFnum());
		
		rsRs_s=pstmt_s.executeQuery();
		
		if(rsRs_s!=null){
			aList=new ArrayList<FileVO>();
			
			while(rsRs_s.next()){
				FileVO _fvo=new FileVO();
				_fvo.setFnum(rsRs_s.getString("FNUM"));
				_fvo.setFname(rsRs_s.getString("FNAME"));
				_fvo.setFpath(rsRs_s.getString("FPATH"));
				aList.add(_fvo);	
				}
			}
		
			FileVO __fvo=aList.get(0);
			logger.info("FileVO __fvo >>> : "+__fvo.getFpath());
			name=__fvo.getFname();
			p=__fvo.getFpath();
			logger.info("p >>> : "+p);
		}
	p2="/kosMember_YYS2/upload/aaaa/"+p;
	logger.info("p2 >>> : "+p2);
%>
<h3 style="text-align:center;
		font-size:60px;
		color:white;"><%= name %></h3>

	<div class="container" style="align:center">
			<img class="i" src="<%= p2 %>" size=20;>
	</div>
</div>
</body>
</html>