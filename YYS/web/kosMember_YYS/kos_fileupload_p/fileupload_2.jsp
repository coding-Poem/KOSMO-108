<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%-- common 패키지의 클래스 import --%> 
<%@ page import="a.b.c.common.CommonUtils" %>
<%@ page import="a.b.c.common.FileUploadUtil" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLAD JSP</title>
<style type="text/css">
	img{
		height:1000px;
		width:1000px;
	}
	
	img:hover{
		height:1500px;
		width:1500px;
	}
	
	table{
		height:250px;
		weight:800px;
		margin:50px 50px 50px 150px;
	}
</style>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("fileupload_2 jsp 페이지 시작 >>> : ");
	// fileupload_2 jsp 페이지 시작 >>> :
	
	String filePaths=CommonUtils.TEST_IMG_UPLOAD_PATH;
	// filePaths를 CommonUtils 자바클래스의 상수로 지정한다.
	logger.info("filePaths >>> : "+filePaths);
	// filePaths >>> : C: 00.KOSMO108 30.Web eclipse_web_yys
	// eclipse_yys_work .metadata .plugins org.eclipse.wst.server.core
	// tmp0 wtpwebapps kosMember_YYS2 upload aaaa 
	
	int size_limit=CommonUtils.TEST_IMG_FILE_SIZE;
	// img의 사이즈는 1024*1024*10 => 10 byte
	logger.info("size_limit >>> : "+size_limit);
	// size_limit >>> : 10485760
			
	String encode_type=CommonUtils.TEST_IMG_ENCODE;
	// enctype은 UTF-8으로 할게요.
	logger.info("encode_type >>> : "+encode_type);
	// encode_type >>> : UTF-8
	
	String filename1="";
	// filename1은 초기화 합니다.
	
	FileUploadUtil fu=new FileUploadUtil();
	// FileUploadUtil 자바클래스에 기본 생성자를 만듭니다.
	boolean bool=fu.fileUpldad3(request, filePaths, size_limit, encode_type);
	// FileUploadUtil 클래스의 fileUpldad3 함수에 인수 4개를 넣습니다.
	logger.info("bool >>> : "+bool);
	// bool >>> : true
	
	
	if(bool){
		// String name=fu.getFileName("name");
		String name=fu.getParameter("name");
		logger.info("name >>> : "+name);
		// name >>> : juice
		out.println(name+"<hr>");
		
		ArrayList<String> aListFile = fu.getFileNames();
		logger.info("aListFile >>> : "+aListFile);
		// aListFile >>> : [658670ef05962096b018164f1eb18b31.gif]
		
		filename1=aListFile.get(0);
		logger.info("filename1 >>> : "+filename1);
		// filename1 >>> : 658670ef05962096b018164f1eb18b31.gif
		
	}else{
		logger.info("업로드 실패 !!! ");
	}
%>
<!--  html img 태그의 src 경로 속성은 웹 경로를 사용한다. -->
<table border="1">
<tr align="center">
<td>
	<img id="circle" src="/kosMember_YYS2/upload/aaaa/<%= filename1 %>" width="100" height="100"><br>
	<%= filename1 %>
</td>
</tr>
</table>
</body>
</html>