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
	String filePaths = CommonUtils.TEST_IMG_UPLOAD_PATH;
	out.println("filePaths >>> : "+filePaths+"<br>");
	
	int size_limit=CommonUtils.TEST_IMG_FILE_SIZE;
	logger.info("size_limit >>> : "+size_limit);
	// size_limit >>> : 5242880
	
	String encode_type=CommonUtils.TEST_IMG_ENCODE;
	logger.info("encode_type >>> : "+encode_type);
	// encode_type >>> : UTF-8
	
	String filename1="";
	FileUploadUtil fu=new FileUploadUtil();
	boolean bool=fu.fileUpldad3(request, filePaths, size_limit, encode_type);
	logger.info("bool >>> : "+bool);
	// bool >>> : true
	
	if(bool){
		String name=fu.getParameter("name");
		logger.info("name >>> : "+name);
		out.println(name+"<hr>");
		
		ArrayList<String> aListFile=fu.getFileNames();
		logger.info("aListFile >>> : "+aListFile);
		// aListFile >>> : [6절규.png]
		
		filename1=aListFile.get(0);
		logger.info("filename1 >>> : "+filename1);
		// filename1 >>> : 6절규.png
		
		ParameterBlock pb=new ParameterBlock();
		pb.add(filePaths+"/"+filename1);
		logger.info("filePaths+'/'+filename1 >>> : "+filePaths+"/"+filename1);
		// filePaths+'/'+filename1 >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work
		// \.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember_YYS2\
		// upload\aaaa/6절규.png
		
		RenderedOp rOp=JAI.create("fileload", pb);
		BufferedImage bi=rOp.getAsBufferedImage();
	
		// 사이즈 조정하기
		BufferedImage thumb=new BufferedImage(100, 100, BufferedImage.TYPE_INT_BGR);
		Graphics2D g=thumb.createGraphics();
	
		// 사이즈 조정하기
		g.drawImage(bi, 0, 0, 100, 100, null);
	
		// 변경되는 파일 이름만 바꾸기
		File file=new File(filePaths+"/sm_"+filename1);
		ImageIO.write(thumb, "jpg", file);
	}
%>
<h3>이미지 썸네일</h3>
<hr>
- 원본 이미지 - <br>
<img src="/kosMember_YYS2/upload/aaaa/<%= filename1 %>" alt="filenam1의 이미지를  업로드할 수 없습니다."><br>
- 썸네일 이미지 - <br>
<img src="/kosMember_YYS2/upload/aaaa/sm_<%= filename1 %>" alt="filenam1의 이미지를  업로드할 수 없습니다."><br>
</body>
</html>