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
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>FILE SIZE JSP</title>
<script type="text/javascript">
	$(document).ready(function(){	
		$("#timeBtn").click(function(){
			
			var time = 180;
			var min = "";
			var sec = "";
			
			// setInterval('', 천분에일초);
			// setInterval(function(), 1000); // 1초에 한번씩 invoke(호출) 하시ㅗㅇ 
			var x = setInterval(function(){
				
					min = parseInt(time / 60);
					sec = time % 60;
	
					document.getElementById("time").innerHTML = min + "분" + sec + "초"; 
					time--;
					
					if (time < 0){
						clearInterval(x)
						document.getElementById("time").innerHTML = "시간초과";
					}				
			}, 1000);
		});

		$("#i1").click(function(){
			$("#f1").attr({
				"action":"/kosMember_YYS2/kos_script_p/filesize4.jsp",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
			
		})
	});
	
</script>
<style type="text/css">
	/*
	h2{
		background-image:url("data:image/jpeg;base64,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");
		background-repeat:no-repeat;
		background-size:cover;
	}
	*/
	img{
		float:left;
		margin:100px auto;
	}
	
	#time{
		float:left;
	}
	
</style>
</head>
<body>
<h3>시작 버튼을 누르면 경매가 시작 됩니다!! </h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("filesize jsp 시작 >>> : ");
	
	String filename="";
	
	
	String filePaths=CommonUtils.TEST_IMG_UPLOAD_PATH;
	logger.info("filePaths >>> : "+filePaths);	

	
	int size_limit=CommonUtils.TEST_IMG_FILE_SIZE;
	logger.info("size_limit >>> : "+size_limit);
	
	String encode_type=CommonUtils.TEST_IMG_ENCODE;
	logger.info("encode_type >>> : "+encode_type);
	
	String filename1="";
	
	FileUploadUtil fu=new FileUploadUtil();
	MultipartRequest mr=new MultipartRequest(request, filePaths, size_limit, 
											encode_type, new DefaultFileRenamePolicy());
	
	Enumeration<String> files=mr.getFileNames();
	String file=String.valueOf(files.nextElement());
	filename1=mr.getFilesystemName(file);
			
	ParameterBlock pb=new ParameterBlock();
	pb.add(filePaths+"/"+filename1);
	// logger.info("filePaths+'/'+filename1 >>> : "+filePaths+"/"+filename1);
		
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
<form id="f1">
	<input type="hidden" id="it1" name="it1" class="it1" value="<%= filename1 %>"/>
</form>
<hr>
<h3>이미지 썸네일</h3>
<img id="i1" src="/kosMember_YYS2/upload/aaaa/sm_<%= filename1 %>" alt="filenam1의 이미지를  업로드할 수 없습니다."><br>
<hr>
<button type="button" id="timeBtn" style="right:100%">시작</button>
<hr>
<h1 id="time" style="right:100%"></h1>
</body>
</html>