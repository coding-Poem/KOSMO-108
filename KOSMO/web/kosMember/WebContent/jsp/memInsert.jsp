<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.kos.service.MemService" %>
<%@ page import="a.b.c.kos.service.MemServiceImpl" %>
<%@ page import="a.b.c.kos.vo.MemVO" %>
<%@ page import="java.util.ArrayList" %>   
<%@ page import="a.b.c.common.ChabunUtil" %>
<%@ page import="a.b.c.common.DateUtil" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_MEMBER INSERT</title>
</head>
<body>
<h3>KOS_MEMBER INSERT</h3>
<hr>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<!-- 입력  -->
<!-- 
	체크해야 할 리스트
    MNAME	VARCHAR2(50)
	MID		VARCHAR2(50)	NOT NULL
	MPW		VARCHAR2(300)	NOT NULL
	MHP		VARCHAR2(16)	NOT NULL
	MEMAIL	VARCHAR2(200)	NOT NULL
	MGENDER	VARCHAR2(10)
	MHOBBY	VARCHAR2(100)
	MLOCAL	VARCHAR2(200)
	MMSG	VARCHAR2(2000)
 -->
<% 
	String mnum = ChabunUtil.getMemChabun("d");
	
	String mname = request.getParameter("mname");
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	String mhp = request.getParameter("mhp");
	String memail=request.getParameter("memail");
	String mgender=request.getParameter("mgender");
	String mhobby=request.getParameter("mhobby");
	String mlocal=request.getParameter("mlocal");
	String mmsg=request.getParameter("mmsg");
	
	String s[]= {mnum, mname, mid, mpw, mhp, memail, mgender, mhobby, mlocal, mmsg};
	System.out.println("들어온 입력값의 갯수 >>> : "+s.length);
	
	System.out.println("\n memInsert jsp :: 입력값은 다음과 같습니다. \n");
	for(int i=0; i<s.length; i++){
		System.out.print(s[i]+" :: ");
	}
	
	MemVO mvo=null;
	mvo=new MemVO();
	
	mvo.setMnum(mnum);
	mvo.setMname(mname);
	mvo.setMid(mid);
	mvo.setMpw(mpw);
	mvo.setMhp(mhp);
	mvo.setMemail(memail);
	mvo.setMgender(mgender);
	mvo.setMhobby(mhobby);
	mvo.setMlocal(mlocal);
	mvo.setMmsg(mmsg);
	
	MemService ms=new MemServiceImpl();
	boolean bool=ms.memInsert(mvo);
	if(bool){
%>
	<script>
		alert("입력 성공");
		console.log("입력 성공");
		location.href="/kosMember/jsp/memSelectAll.jsp";
		// javascript : Browser Model Objcet(브라우저 객체 모델)
		 // 내가 히로스다 !!
		 
		 // 내 :: navigator :: 웹 브라우저 객체
		 // 가 
		 // 히 :: history : 기록에 관련된 객체
		 // 로 :: location :: 주소와 관련된 객체
		 // 스 :: screen :: 화면객체
		 // 다 :: document :: HTML 문서와 관련된 객체
	</script>

<%
	}else{
%>
	<script>
		alert("입력 실패");
		history.go(-1);
	</script>
<%
	}
%>

</body>
</html>