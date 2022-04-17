<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- cos 파일업로드 라이브러리 객체 import --%>    
<%@ page import="com.oreilly.servlet.MultipartRequest" %>   
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    

<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>

<%@ page import="a.b.c.common.CommonUtils" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD JSP</title>
<style type="text/css">
	#circle{border-radius: 50%;}
</style>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("fileupload_1.jsp 페이지 >>> : ");
	// fileupload_1.jsp 페이지 >>> : 
	
	String saveDirectory=CommonUtils.TEST_IMG_UPLOAD_PATH;
	logger.info("saveDirectory >>> : "+saveDirectory);
	/*
	saveDirectory >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember_YYS2\
	upload\aaaa
	*/
	out.println("saveDirectory >>> : "+saveDirectory+"<br>");
	
	int maxPostSize=CommonUtils.TEST_IMG_FILE_SIZE;
	logger.info("maxPostSize >>> : "+maxPostSize);
	// maxPostSize >>> : 10485760
	String encoding=CommonUtils.TEST_IMG_ENCODE;
	logger.info("encoding >>> : "+encoding);
	// encoding >>> : UTF-8
	String filename1="";
	String filename2="";
	try{
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, maxPostSize
												,encoding, new DefaultFileRenamePolicy());
		/*
			이름: <input type="text" name="name"/><br>
			파일1: <input type="file" name="fileName1"/><br>
			파일2: <input type="file" name="fileName2"/><br>
		*/
		// name
		String name=mr.getParameter("name");
		logger.info("String name >>> : "+name);
		// String name >>> : kakao_emoticon
		// input 태그에서 input type = "text" 에 입력한  내용이
		// 출력됩니다.
		
		// file
		Enumeration<String> files=mr.getFileNames();
		
		String file1=String.valueOf(files.nextElement());
		logger.info("file1 >>> : "+file1);
		// file1 >>> : fileName2
		filename1=mr.getFilesystemName(file1);
		logger.info("filename1 >>> : "+filename1);
		// filename1 >>> : 4반함.png
		
		String file2=String.valueOf(files.nextElement());
		logger.info("file2 >>> : "+file2);
		// file2 >>> : fileName1
		// 파일이 정상적으로 업로드 된 것을 확인
		
		filename2=mr.getFilesystemName(file2);
		logger.info("filename2 >>> : "+filename2);
		// filename2 >>> : 1미소.png
		// 두 번째 파일 또한 정상적으로 업로드 된 것을 확인
		
		/*
		 왜 순서대로 안 나와요?
				 
		배열과는 다르게 Enumeration은 깡통이라 인덱스 순서에 맞게
		저장하지 않습니다.
		
		따라서, 뭐가 먼저 나올지는 모릅니다.
		
		*/
		
		out.println("name >>> : "+name+"<br>");
		out.println("filename1 >>> : "+filename1+"<br>");
		out.println("filename2 >>> : "+filename2+"<br>");
	}catch(Exception e){
		logger.info("에러가 >>> : "+e.getMessage());
	}
%>
<h3>File Upload Testing</h3>
<hr>
<!-- html img 태그의 src 경로 속성은 웹 경로를 사용한다. -->
<table border="1">
<tr align="center">
	<td><%= filename1 %></td>
	<td>
		<img id="circle" src="/kosMember_YYS2/upload/aaaa/<%= filename1 %>" width="100" height="100" />
	</td>
</tr>
<tr>
	<td><%= filename2 %></td>
	<td>
		<img id="circle" src="/kosMember_YYS2/upload/aaaa/<%= filename2 %>" width="100" height="100" />
	</td>
</tr>
</table>
</body>
</html>