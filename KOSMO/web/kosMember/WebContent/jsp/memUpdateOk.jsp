<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.kos.service.MemService" %>
<%@ page import="a.b.c.kos.service.MemServiceImpl" %>
<%@ page import="a.b.c.kos.vo.MemVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_MEMBER OK</title>
</head>
<body>
<h3>KOS_MEMBER UPDATE OK</h3>
<hr>
<!-- Update jsp에서 Update Ok로 넘어가는 폼태그의 인풋태그 이름명 -->
<!--  
mname
mid
mpw
mhp
memail
mgender
mhobby
mlocal
mmsg
mnum
-->
 
 <%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
 
 
<%
	String mname=request.getParameter("mname");
	String mid=request.getParameter("mid");
	String mpw=request.getParameter("mpw");
	String mhp=request.getParameter("mhp");
	String memail=request.getParameter("memail");
	String mgender=request.getParameter("mgender");
	String mhobby=request.getParameter("mhobby");
	String mlocal=request.getParameter("mlocal");
	String mmsg=request.getParameter("mmsg");
	String mnum=request.getParameter("mnum");
	
	String s[]={mname, mid, mpw, mhp, memail, mgender, mhobby,mlocal,mmsg,mnum};
	
	System.out.println("memUpdateOk :: jsp :: 들어온 입력값의 개수 >>> : "+s.length);
	System.out.println("들어온 입력값은 다음과 같습니다. \n");
	System.out.println("mname :: mid :: mpw :: mhp :: memail :: mgender :: mhobby :: mlocal :: mmsg :: mnum \n");
	for(int i=0; i<s.length; i++){
		System.out.print(s[i]+" :: ");
	}

	MemVO mvo=null;
	mvo=new MemVO();
	mvo.setMname(mname);
	mvo.setMid(mid);
	mvo.setMpw(mpw);
	mvo.setMhp(mhp);
	mvo.setMemail(memail);
	mvo.setMgender(mgender);
	mvo.setMhobby(mhobby);
	mvo.setMlocal(mlocal);
	mvo.setMmsg(mmsg);
	mvo.setMnum(mnum);
	
	MemService ms=new MemServiceImpl();
	boolean bool=ms.memUpdate(mvo);
	
	if(bool){
%>
	<script>
	// body 에서는 "text/javascript" 를 script 태그 안에 기재하지 않는다.
		 alert("수정 성공");
		 console.log("수정 성공");
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
		alert("수정 실패");
		history.go(-1);
	</script>
<%
	}
%>
</body>
</html>