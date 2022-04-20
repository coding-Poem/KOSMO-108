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
<title>Insert title here</title>	
</head>
<body>
<%
	// String filename1="1_1_1.JPG";
	String filename1=request.getParameter("it1");
	
	String filePaths=CommonUtils.TEST_IMG_UPLOAD_PATH;
	
	ParameterBlock pb=new ParameterBlock();
	pb.add(filePaths+"/"+filename1);
		
	RenderedOp rOp=JAI.create("fileload", pb);
	BufferedImage bi=rOp.getAsBufferedImage();
	
	// 사이즈 조정하기
	BufferedImage thumb=new BufferedImage(800, 800, BufferedImage.TYPE_INT_BGR);
	Graphics2D g=thumb.createGraphics();
	
	// 사이즈 조정하기
	g.drawImage(bi, 0, 0, 800, 800, null);
	/*
	    public abstract boolean drawImage(Image img, int x, int y,
                                      int width, int height,
                                      ImageObserver observer);
	
	*/
	
	// 변경되는 파일 이름만 바꾸기
	File file_=new File(filePaths+"/sm_"+filename1);
	ImageIO.write(thumb, "jpg", file_);
	
%>
<h3>이미지 썸네일</h3>
<h1 style="text-align:center; color:red;">축하합니다!! 당첨되셨습니다!!</h1>
<img src="/kosMember_YYS2/upload/aaaa/sm_<%= filename1 %>" alt="filenam1의 이미지를  업로드할 수 없습니다."><br>
<hr>
</body>
</html>