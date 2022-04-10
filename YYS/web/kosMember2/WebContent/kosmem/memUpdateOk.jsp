<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" org.apache.log4j.LogManager" %>    
<%@ page import="org.apache.log4j.Logger" %>     
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>  
<%@ page import="a.b.c.kos.mem.service.MemService" %>
<%@ page import="a.b.c.kos.mem.service.MemServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<h3>회원정보 수정</h3>
<hr>
<%
	Logger logger=LogManager.getLogger(this.getClass());

	logger.info(" memUpdateOk.jsp 페이지 >>> : ");
	
	/*******  memSelect.jsp :::: request.getParameter or request.getParameterValues  *****/
	// 회원번호
	// <input type="text" name="mnum" id="mnum"
	String mnum=request.getParameter("mnum");
	
	//이매일
	/* <input type="text" name="memail" id="memail" style="width:100px"/> */
	//	@ <input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력" />
	String memail=request.getParameter("memail");
	String memail1=request.getParameter("memail1");
	memail=memail.concat("@").concat(memail1);
	// @ 이전 + @ + @ 이후
	
	// 취미
	/*
		<input type="checkbox" name="mhobby" value="01" />독서
		<input type="checkbox" name="mhobby" value="02" />운동
		<input type="checkbox" name="mhobby" value="03" />음악감상
		<input type="checkbox" name="mhobby" value="04" />여행
	*/
	String[] hobby=request.getParameterValues("mhobby");
	String mhobby="";
	for(int i=0; i<hobby.length; i++){
		mhobby += hobby[i]+",";
	}
	
	// 주소 : 우편번호
	// <input type="text" name="mzone" id="mzone" placeholder="우편번호"
	String mzone=request.getParameter("mzone");
	// 주소 : 도로명 주소
	// <input type="text" name="mroad" id="mroad" placeholder="도로명주소"
	String mroad=request.getParameter("mroad");
	// <input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소" 
	String mroaddetail=request.getParameter("mroaddetail");
	
	// 주소 : 지번 주소
	// <input type="text" name="mjibun" id="mjibun" placeholder="지번주소" 
	String mjibun=request.getParameter("mjibun");
	
	// vo 세팅
	MemVO mvo=null;
	mvo=new MemVO();
	mvo.setMnum(mnum);
	mvo.setMemail(memail);
	mvo.setMhobby(mhobby);
	mvo.setMzone(mzone);
	mvo.setMroad(mroad);
	mvo.setMjibun(mjibun);
	
	logger.info("mnum >>> : "+mvo.getMnum());
	logger.info("memail >>> : "+mvo.getMemail());
	logger.info("mhobby >>> : "+mvo.getMhobby());
	logger.info("mzone >>> : "+mvo.getMzone());
	logger.info("mroad >>> : "+mvo.getMroad());
	logger.info("mjibun >>> : "+mvo.getMjibun());
	
	MemService ms=new MemServiceImpl();
	boolean bool=ms.memUpdate(mvo);
	if(bool){
%>
	<script>
		alert("수정 성공");
		location.href="/kosMember_YYS2/kosmem/memSelectAll.jsp";
		// /kosMember_YYS2/kosmem/memSelectAll.jsp
	</script>
<%
	}else{
%>
	<script>
		alert("수정 실패");
		history.go(-1);
	</script>
<%
	}
%>
</body>
</html>