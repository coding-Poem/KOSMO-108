<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>  
<%@ page import="java.io.File" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Content-type분기</h3>

<%
/*
	<input type="text" class="i1" name="i1" id="i1"><br>
	<input type="file" class="f1" name="f1" id="f1"><br>

*/
	Logger logger=LogManager.getLogger(this.getClass());
	
	// POST 방식으로 받기
	logger.info("POST 방식으로 받기 >>> : ");
	// POST 방식으로 받기 >>> : 
	out.println("POST 방식으로 받기 >>> : "+"<br>");
	
	String getMethod=request.getMethod();
	/*
	javax.servlet.http.HttpServletRequest
	
	java.lang.String :: getMethod()
	
	Returns the name of the HTTP method with 
	which this request was made, for example, GET, POST, or PUT.
	
	This method returns null if there was no extra path information.
	*/
	logger.info("getMethod >>> : "+getMethod);	
	// getMethod >>> : POST
	out.println("getMethod >>> : "+getMethod+"<br>");
	
	if("POST".equals(request.getMethod().toUpperCase())){
		String type=request.getHeader("Content-Type");
		/*
		javax.servlet.http.HttpServletRequest
		
		java.lang.String :: getHeader
		
		Returns the value of the specified request header as a String. 
		If the request did not include a header of the specified name, 
		this method returns null.
		*/
		logger.info("type >>> : "+type);
		// type >>> : multipart/form-data; 
		// boundary=----WebKitFormBoundaryjcXAK6xQVoHKLOMG
		out.println("type >>> : "+type+"<br>");
		
		boolean bool=type.startsWith("multipart/form-data");
		/*
			java.lang.String
			
			boolean  :: startsWith(String prefix)
			Tests if this string starts with the specified prefix.
			
			Returns:
				true if the character sequence represented 
				by the argument is a prefix of the character sequence 
				represented by this string;
		*/
		logger.info("bool >>> : "+bool);
		// bool >>> : true
		
		if(type!= null && type.startsWith("multipart/form-data")){
			logger.info("파일 업로드 시작 루틴 ");
			// 파일 업로드 시작 루틴 
			out.println("파일 업로드 시작 루틴");
			
			String saveDirectory=pageContext.getServletContext().getRealPath("test/testdir/");
			logger.info("saveDirectory >>> : "+saveDirectory);
			// saveDirectory >>> : C:\00.KOSMO108\30.Web
			// \eclipse_web_yys\eclipse_yys_work\.metadata\.plugins\org.eclipse.wst.server.core
			// \tmp0\wtpwebapps\kosMember_YYS2\test\testdir\
			out.println("saveDirectory >>> : "+saveDirectory+"<br>");
			
			File saveDir=new File(saveDirectory);
			/*
			File(String pathname)
			
			Creates a new File instance by converting the given pathname 
			string into an abstract pathname.	
			*/
			if(!saveDir.exists()){
				saveDir.mkdirs();
			}
		}else{
			logger.info("multipart/form-data에 오타가 있어요.");
			out.println("multipart/form-data에 오타가 있어요.");	
		}
	}  // if("POST".eqauls)
	else{
		logger.info("파일 업로드는 POST 방식으로 요청해야 합니다.");
		out.println("파일 업로느는 POST 방식으로 요청해야 합니다.");
	}
%>
</body>
</html>