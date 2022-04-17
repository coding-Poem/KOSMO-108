<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="a.b.c.common.CommonUtils" %>
<%@ page import="a.b.c.common.FileUploadUtil" %>

<%@ page import="java.util.ArrayList" %>

<!-- 커넥션 클래스 import -->
<%@ page import="a.b.c.common.KosConnectivity" %>

<!-- java.sql.* JDBC 클래스 import -->    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page import="a.b.c.test.vo.FileVO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD JSP</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#U").click(function(){
			$("#checkForm").attr({
				"action":"/kosMember_YYS2/kos_fileupload_p/fileupload_img.jsp",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
			
		});
	});
</script>

<style type="text/css">
	body{
		background-image:url("https://mblogthumb-phinf.pstatic.net/MjAyMDA3MDlfMjA1/MDAxNTk0MjczOTYwMTYx.gy7FiC488LOHFi4yyAXEGReJJKV8FAdqHsZqodz2cjsg.Oxf5MIJYZjt1v6VLD1xXBm84stj8M3gX0K8yjYySupAg.JPEG.pola0216/%EC%95%84%EC%9D%B4%ED%8F%B0%EC%97%AC%EB%A6%84%EB%B0%B0%EA%B2%BD%ED%99%94%EB%A9%B412.jpg?type=w800");
		background-repeat:no-repeat;
		background-size:cover;
		position: relative; width: 100%;height: 100%;
	}
	
	table{
		height:1000px;
		width:1000px;
	}
</style>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("fileupload_3.jsp 페이지 >>> : ");
	
	String filePaths=CommonUtils.TEST_IMG_UPLOAD_PATH;
	logger.info("filePaths >>> : "+filePaths);
	
	int size_limit=CommonUtils.TEST_IMG_FILE_SIZE;
	logger.info("size_limit >>> : "+size_limit);
	
	String encode_type=CommonUtils.TEST_IMG_ENCODE;
	logger.info("encode_type >>> : "+encode_type);
	
	String filename1="";
	
	FileUploadUtil fu=new FileUploadUtil();
	boolean bool=fu.fileUpldad3(request, filePaths, size_limit, encode_type);
	logger.info(" >>> : "+bool);
	
	ArrayList<FileVO> aList=null;
	if(bool){
		// <input type="text" name="name" placeholder="파일 이름"><br>
		String name=fu.getParameter("name");	
		logger.info("name >>> : "+name);
		
		ArrayList<String> aListFile=fu.getFileNames();
		logger.info("aListFile >>> : "+aListFile);
		filename1=aListFile.get(0);
		logger.info("filename1 >>> : "+filename1);
		
		// 파일 이름 테이블에 적재하기 ------------
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		
		conn=KosConnectivity.getConnection();
		logger.info("데이터 베이스 연동 성공 >>> : ");
		
		String sqls = "INSERT INTO KOS_FILE_IMAGE (FNUM, FNAME, FPATH, INSERTDATE, UPDATEDATE) VALUES (KOS_FILE_IMAGE_SEQ.NEXTVAL, ?, ?, SYSDATE, SYSDATE)";
		logger.info("INSERT >>> : "+sqls);
		pstmt=conn.prepareStatement(sqls);
		
		pstmt.clearParameters();
		pstmt.setString(1, name);
		pstmt.setString(2, filename1);
		
		nCnt=pstmt.executeUpdate();
		// insert, update, delete는 pstmt.executeUpdate();
		// select만 pstmt.executeQuery();
		logger.info("nCnt >>> : "+nCnt);
		
		if(nCnt>0){
			// 업데이트가 완료된다면 nCnt는 이제 0보다 큼
			Connection conn_s=null;
			PreparedStatement pstmt_s=null;
			ResultSet rsRs_s=null;
			
			conn_s=KosConnectivity.getConnection();
			String sqls_s = "SELECT * FROM KOS_FILE_IMAGE ORDER BY 1";
			logger.info("SELECT >>> : "+sqls_s);
			pstmt_s=conn_s.prepareStatement(sqls_s);
			
			rsRs_s=pstmt_s.executeQuery();
			
			if(rsRs_s!=null){
				aList=new ArrayList<FileVO>();
				
				while(rsRs_s.next()){
					FileVO fvo=new FileVO();
					fvo.setFnum(rsRs_s.getString("FNUM"));
					fvo.setFname(rsRs_s.getString("FNAME"));
					fvo.setFpath(rsRs_s.getString("FPATH"));
					fvo.setInsertdate(rsRs_s.getString("INSERTDATE"));
					fvo.setUpdatedate(rsRs_s.getString("UPDATEDATE"));
					aList.add(fvo);
				}
			}
		}
	}else{
		logger.info("업로드 실패 !!!");
	}
%>
<!-- html img 태그의 src 경로 속성은 웹 경로를 사용한다. -->
<form name="checkForm" id="checkForm">
<table border="1">
	<tr>
		<td><input type="checkbox" class="chkAll" name="chkAll" id="chkAll"></td>
		<td>순번</td>
		<td>이름</td>
		<td>파일</td>
	</tr>
<%
	if(aList!=null && aList.size()>0){
		for(int i=0; i<aList.size(); i++){
			FileVO _fvo=aList.get(i);
%>
	<tr>
		<td>
			<input type="checkbox" class="fnumChk" name="fnumChk" id="fnumChk"value=<%=  _fvo.getFnum() %> />
		</td>
		<td>
			<%= _fvo.getFnum() %>
		</td>
		<td>
			<%= _fvo.getFname() %>
		</td>
		<td>
			<img src="/kosMember_YYS2/upload/aaaa/<%= _fvo.getFpath() %>" width="50" height="50"><br>				
		</td>
	</tr>
<%
		}
	}
%>
	<td colspan="5" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">
		<input type="button" value="이미지보기" id="U">
	</td>		
</table>
</form>
</body>
</html>