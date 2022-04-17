<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  import log4j -->
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>   
    
<!--  import java.io.DateInputStream -->    
<%@ page import="java.io.DataInputStream" %>    
<%@ page import="java.util.Enumeration" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD JSP</title>
<link rel="stylesheet" href="/kosMember_YYS2/css/yysColor.css" >
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<hr>
<h3>enctype="multipart/form-data"</h3>
<h3>file 업로드 데이터는 request.getParameter() 받을 수 없다.</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
/*
<input type="text" name="name"><br>
<input type="file" name="fileupload"><br>
*/
	String name=request.getParameter("name");
	logger.info("name >>>> : "+name);
	// name >>>> : null
	
	String fileupload=request.getParameter("fileupload");
	logger.info("fileupload >>> : "+fileupload);
	// fileupload >>> : null
	
	out.println("name >>> : "+name+"<br>");
	out.println("fileupload >>> : "+fileupload+"<br>");
	out.println("<p>");
%>

<h3>스트림 방식으로 받기</h3>
<!--POST 방식으로 받아왔기 때문에 request.setCharacterEncoding을 해주어야 한다. -->
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Enumeration<String> en = request.getHeaderNames();
	logger.info("Enumeration en >>> : "+en);
	// Enumeration en >>> : org.apache.tomcat.util.http.NamesEnumerator@194c2af1
	out.println("<h4>전송받은 헤더 정보 출력</h4>");
	// POST 방식으로 보냈어도  Chrome 개발자 도구의 Network의 Headers 정보는 출력이 가능하다.
	while(en.hasMoreElements()){
		String headerName=en.nextElement();
		String headerValue=request.getHeader(headerName);
		out.println(headerName+" : "+headerValue+"<br>");
	}
	
	out.println("<br> <h4>전송받은 데이터 출력 출력</h4>");
	
		ServletInputStream sis=request.getInputStream();
		logger.info("Servlet InputStream sis >>> "+sis);
		// Servlet InputStream sis >>> org.apache.catalina.
		// connector.CoyoteInputStream@329c7399
		
		DataInputStream dis=new DataInputStream(sis);
		logger.info("DataInputStream dis >>> : "+dis);
		// DataInputStream dis >>> : java.io.DataInputStream@a431952
		String line="";
		
		while((line=dis.readLine())!=null){
			out.println(new String(line.getBytes("ISO-8859-1"), "UTF-8")+"<br>");
			// 이미지로 출력되지는 않지만, 코드로서 출력된다.
		}
%>
</body>
</html>