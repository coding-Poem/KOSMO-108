<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 썸네일 객체 import --%>      
<%@ page import="java.awt.Graphics2D"%>
<%@ page import="java.awt.image.renderable.ParameterBlock"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.media.jai.JAI"%>
<%@ page import="javax.media.jai.RenderedOp"%>
<%@ page import="javax.imageio.ImageIO"%>

<%-- cos 파일업로드 라이브러리 객체 import --%>    
<%@ page import="com.oreilly.servlet.MultipartRequest" %>   
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    

<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>    

<%-- 자바 클래스 불러오기--%>
<%@ page import="a.b.c.common.CommonUtils" %>
<%@ page import="a.b.c.common.FileUploadUtil" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE SIZE JSP</title>
</head>
<body>
<h3>FILE SIZE JSP : Thumbnail image: 썸네일 이미지</h3>
<h3>JAI(Java Advanced Imaging) API</h3>
<h2>Thumbnail image 썸네일 이미지 : jai_codec.jar, jai_core.jar</h2>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("filesize jsp 시작 >>> : ");
	// filesize jsp 시작 >>> : 
	
	// 파일 경로, 이미지 사이즈, 엔코딩 타입 
	String saveDirectory = pageContext.getServletContext().getRealPath("/upload/aaaa/");
	logger.info("filePaths >>> : "+saveDirectory);
	// filePaths >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work
	// \.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember_YYS2\
	// upload\aaaa\
	out.println("saveDirectory >>> : "+saveDirectory+"<br>");
	
	int size_limit=CommonUtils.TEST_IMG_FILE_SIZE;
	logger.info("size_limit >>> : "+size_limit);
	// size_limit >>> : 5242880
	
	String encode_type=CommonUtils.TEST_IMG_ENCODE;
	logger.info("encode_type >>> : "+encode_type);
	// encode_type >>> : UTF-8
	
	String filename1="";
	File saveDir=new File(saveDirectory);
	if(!saveDir.exists()){
		saveDir.mkdirs();
	}
	
	
	try{
	// MultipartRequest mr에 들어갈 인수
	// request, saveDirectory, maxPostsize, encoding, new DefaultFileRenamePolicy()
	
	MultipartRequest mr=new MultipartRequest(request, saveDirectory, size_limit,
			encode_type, new DefaultFileRenamePolicy());
	
	// name
	String name=mr.getParameter("name");
	
	// file
	Enumeration<String> files=mr.getFileNames();
	String file1=String.valueOf(files.nextElement());
	filename1=mr.getFilesystemName(file1);
	
	logger.info("name >>> : "+name);
	// name >>> : smile
	logger.info("filename1 >>> : "+filename1);
	// filename1 >>> : 5눈물.png
	
	out.println("name >>> : "+name+"<br>");
	out.println("filename1 >>> : "+filename1+"<br>");
	
	}catch(Exception e){
		logger.info("에러가 >>> : "+e.getMessage());	
	}
	
	ParameterBlock pb=new ParameterBlock();
	pb.add(saveDirectory+"/"+filename1);
	logger.info("saveDirectory+'/'+filename1 >>> : "+saveDirectory+"/"+filename1);
	// saveDirectory+'/'+filename1 >>> : 
	// C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work\.metadata\.plugins\org.eclipse.wst.server.core
	// \tmp0\wtpwebapps\kosMember_YYS2\
	// upload\aaaa\/5눈물.png
	RenderedOp rOp=JAI.create("fileload", pb);
	BufferedImage bi=rOp.getAsBufferedImage();
	
	// 사이즈 조정하기
	BufferedImage thumb=new BufferedImage(100, 100, BufferedImage.TYPE_INT_BGR);
	Graphics2D g=thumb.createGraphics();
	
	// 사이즈 조정하기
	g.drawImage(bi, 0, 0, 100, 100, null);
	
	// 변경되는 파일 이름만 바꾸기
	File file=new File(saveDirectory+"/sm_"+filename1);
	ImageIO.write(thumb, "jpg", file);
%>
<h3>이미지 썸네일</h3>
<hr>
- 원본 이미지 - <br>
<img src="/kosMember_YYS2/upload/aaaa/<%= filename1 %>"><br>
- 썸네일 이미지 - <br>
<img src="/kosMember_YYS2/upload/aaaa/sm_<%= filename1 %>"><br>
</body>
</html>