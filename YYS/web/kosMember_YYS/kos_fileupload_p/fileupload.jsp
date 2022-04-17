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
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload</title>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
Context Root 컨텍스트 루트 : /kosMember<br>
pageContext.getServletContext().getRealPath() ==> <br>
C:\00.KOSMO\30.Web\el_web_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember
<br>
<hr>
<br>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("fileupload.jsp 페이지 >>> : ");
	// fileupload.jsp 페이지 >>> : 
	
	String saveDirectory=pageContext.getServletContext().getRealPath("/upload/aaaa/");
	// 가상경로를 실제 경로로 변환하여 지정해준다.
	// javax.servlet.ServletConfig	(ServletRequest에 있는 getServletContext() 아님)
	/*
	ServletContext	  |	getServletContext()	

	Returns: Returns a reference to the ServletContext in which the caller is executing.
	
	javax.servlet.ServletContext (ServletRequest에 있는 getServletContext() 아님)
	
	java.lang.String  |	getRealPath(java.lang.String path)

	Returns: Returns a String containing the real path for a given virtual path. 
	For example, the path "/index.html" returns the absolute file path 
	on the server's filesystem would be served by a request for 
	"http://host/contextPath/index.html", where contextPath is the context path 
	of this ServletContext..
	
	*/
	logger.info("saveDirectory >>> : "+saveDirectory);
	/*
	saveDirectory >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work
	\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember_YYS2\
	upload\aaaa\
	*/
	out.println("saveDirectory >>> : "+saveDirectory+"<br>");
	
	File saveDir=new File(saveDirectory);
	/*
	File(String pathname)
		Creates a new File instance by converting the given pathname 
		string into an abstract pathname.
	*/
	logger.info("File saveDir >>> : "+saveDir);
	/*
	saveDirectory >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work
	\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember_YYS2\
	upload\aaaa\
	*/
	if(!saveDir.exists()){
		saveDir.mkdirs();
	}
	
	int maxPostsize=1024*1024*5;
	String encoding="UTF-8";
	String filename1="";
	String filename2="";
	
	try{
		out.println("reqeust 내장형 오브젝트로 받아온 스트림을 <br>");
		out.println("MultipartRequest 클래스 생성자 매개변수로 바인딩 한다.<br>");
		out.println("MutipartRequest mr = new MultipartRequest(request, "+"<br>");
		out.println("이후에는 MultipartRequest 클래스 mr 참조변수를 이용해서 사용한다.<br>");
		
		MultipartRequest mr=new MultipartRequest(request, 
				saveDirectory, maxPostsize, encoding, new DefaultFileRenamePolicy());
		/*
		Servlets.com
		http://www.servlets.com/cos/javadoc/com/oreilly/servlet
		/MultipartRequest.html#MultipartRequest(javax.servlet.http.HttpServletRequest,%20java.lang.String,%20int,%20java.lang.String,%20com.oreilly.servlet.multipart.FileRenamePolicy)
		
		##### com.oreilly.servlet.MultipartRequest #####
		
			public MultipartRequest(javax.servlet.http.HttpServletRequest request,
                    java.lang.String saveDirectory,
                    int maxPostSize,
                    java.lang.String encoding,
                    FileRenamePolicy policy)
             throws java.io.IOException
             
             Constructs a new MultipartRequest to handle the specified request, 
             saving any uploaded files to the given directory, and limiting the upload size to the specified length. 
             If the content is too large, an IOException is thrown. 
             
             http://www.servlets.com/cos/javadoc/com/oreilly/servlet
             /multipart/DefaultFileRenamePolicy.html
             
         ##### Class DefaultFileRenamePolicy  #####
             
             	기본 생성자 규칙
             
             Implements a renaming policy that adds increasing integers to the body of any file that collides. 
             For example, if foo.gif is being uploaded and a file by the same name already exists, 
             this logic will rename the upload foo1.gif. 
             A second upload by the same name would be foo2.gif. 
             
		*/
		logger.info("mr >>> : "+mr+"mr 참조변수가 출력되면 인스턴스가 완료되었다. 파일업로드가 완료되었다. <br>");
		/*
		 mr >>> : com.oreilly.servlet.MultipartRequest@3390815fmr 
		 참조변수가 출력되면 인스턴스가 완료되었다. 
		 파일업로드가 완료되었다. <br>
		*/
		out.println("mr 참조변수 가지고 서버에 업로드된 파일 정보. <br>");
		
		// name
		String name=mr.getParameter("name");		
		/*
			com.oreilly.servlet.MultipartRequest
			
			java.lang.String :: getParameter(java.lang.String.name)
			
			 Returns the value of the named parameter as a String, 
			 or null if the parameter was not sent or was sent 
			 without a value.
		*/
		
		// file
		Enumeration<String> files=mr.getFileNames();
		
		/* 
			com.oreilly.servlet.MultipartRequest
			
			java.util.Enumeration :  Returns the names of all the uploaded 
			files as an Enumeration of Strings.
		*/
		String file1=String.valueOf(files.nextElement());
		/*
		java.util.Enumeration<E>
		files.nextElement()
		
		Returns the next element of this enumeration 
		if this enumeration object has at least one more element to provide.
		
		Returns:
			the next element of this enumeration.
			
		java.lang.String
		String : valueOf(Object obj)
		Returns:
			the next element of this enumeration.
		
		*/
		filename1=mr.getFilesystemName(file1);
		/*
		java.lang.String : 
			
			getFilesystemName(java.lang.String name)
	          Returns the filesystem name of the specified file, 
	          or null if the file was not included in the upload.
		*/
		logger.info("filename1 >>> : "+filename1);
		// 여기서 null이 출력이 되지 않는다면, 정상적으로 업로드가 완료된 것으로 해석할 수 있음.
		// filename1 >>> : BG1.jpg
		
		String file2=String.valueOf(files.nextElement());
		filename2=mr.getFilesystemName(file2);
		logger.info("filename2 >>> : "+filename2);
		// filename2 >>> : BG.jpg
		
		out.println("name >>> : "+name+"<br>");
		out.println("filename1 >>> : "+filename1+"<br>");
		out.println("filename2 >>> : "+filename2+"<br>");
	}catch(Exception e){
		logger.info("에러가 >>> : "+e.getMessage());
	}
%>	
<h3>File Upload Testing</h3>
<hr>
<!--  html img 태그의 src 경로 속성은 웹 경로를 사용한다. -->
<table border="1">
<tr align="center">
<td><%= filename1 %></td>
<!--  이미지가 정상적으로 업로드 된 file의 이름을 화면으로 출력시킨다. -->
<td><img src="/kosMember_YYS2/upload/aaaa/<%= filename1 %>"></td>
<!-- 이미지를 화면에 출력시킨다. -->
</tr>
<tr>
<td><%= filename2 %></td>
<!--  이미지가 정상적으로 업로드 된 file의 이름을 화면으로 출력시킨다. -->
<td><img src="/kosMember_YYS2/upload/aaaa/<%= filename2 %>"></td>
<!-- 이미지를 화면에 출력시킨다. -->
</tr>
</table>
</body>
</html>