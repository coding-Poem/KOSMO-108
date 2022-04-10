<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.kos.mem.service.MemService" %>
<%@ page import="a.b.c.kos.mem.service.MemServiceImpl" %>
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>
<%@ page import="a.b.c.common.ChabunUtil" %>

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 화면</title>
</head>
<body>
<h3>회원 가입</h3>

<% 
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("memInsert.jsp 페이지 >>> : ");
	 
	//  placeholder : 1 :: MNUM  :  1 
	//  placeholder : 2 :: MNAME :  2
	//  placeholder : 3 :: MID :    3
	//  placeholder : 4 :: MPW :    4
	//  placeholder : 5 :: MHP :    5
	//  placeholder : 6 :: MEMAIL : 6
	//  placeholder : 7 :: MGENDER :7
	//  placeholder : 8 :: MHOBBY : 8
	//  placeholder : 9 :: MZONE :  9
	//  placeholder : 10 :: MROAD :  10
	//  placeholder : 11 :: MJIBUN : 11
	//  placeholder : 12 :: MMSG :   12
	
	
	/*******  mem.html :::: request.getParameter or request.getParameterValues  *****/
	
	// 회원번호 :: MNUM
	// 회원 번호는 input태그로 넘기지 않고, ChabunUtil 클래스에서 
	// 가져오도록 한다.
	String mnum=ChabunUtil.getMemChabun("d");
	 
	// 회원이름 :: MNAME
	// <input type="text" name="mname" id="mname" />
	String mname=request.getParameter("mname");
	
	// 아이디 :: MID
	// <input type="text" name="mid" id="mid" placeholder="아이디체크"/>
	String mid=request.getParameter("mid");
	
	// 패스워드 :: MPW
	/* <input type="text" name="mpw" id="mpw" */ 
	String mpw=request.getParameter("mpw");
	// mpw_r은 정보를 넘기는 용이 아니다.
	// <input type="text" name="mpw_r" id="mpw_r" placeholder="비밀번호 확인" style="width:100px" />
	
	// 핸드폰 :: MHP
	// <select name="mhp" id="mhp" 
	// - <input type="text" name="mhp1" id="mhp1"
	// - <input type="text" name="mhp2" id="mhp2"
	String mhp=request.getParameter("mhp");
	String mhp1=request.getParameter("mhp1");
	String mhp2=request.getParameter("mhp2");
	mhp=mhp.concat(mhp1).concat(mhp2);
	
	// 이메일 :: MEMEAIL
	// <input type="text" name="memail" id="memail" style="width:100px"/>
	// <input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력"/>
	String memail=request.getParameter("memail");
	String memail1=request.getParameter("memail1");
	memail=memail.concat("@").concat(memail1);	
	
	// 성별 :: MGENDER
	// <input type="radio" name="mgender" value="01" checked="checked" />여자
	// <input type="radio" name="mgender" value="02" /> 남자
	String mgender=request.getParameter("mgender");
	
	// 취미 :: MHOBBY
	// <input type="checkbox" name="mhobby" value="01" />독서
	// <input type="checkbox" name="mhobby" value="02" />운동
	// <input type="checkbox" name="mhobby" value="03" />음악감상
	// <input type="checkbox" name="mhobby" value="04" />여행
	String[] hobby=request.getParameterValues("mhobby");
	String mhobby="";
	
	for (int i=0; i<hobby.length; i++){
		mhobby+=hobby[i]+", ";
	}
	
	// 주소 :: 우편번호 :: MZONE
	/* <input type="text" name="mzone" id="mzone" placeholder="우편번호"  */
	String mzone=request.getParameter("mzone");
	
	// 주소 :: 도로명주소 :: MROAD
	/*  <input type="text" name="mroad" id="mroad" placeholder="도로명주소"  */
	String mroad=request.getParameter("mroad");
	
	// 주소 :: 도로명 상세주소 :: MROAD에 추가하기
	/*  <input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소"	 */
	String mroaddetail=request.getParameter("mroaddetail");
	mroad=mroad.concat("@").concat(mroaddetail);
	
	// 주소 :: 지번주소 :: MJIBUN
	// <input type="text" name="mjibun" id="mjibun" placeholder="지번주소"
	String mjibun=request.getParameter("mjibun");
	
	// 내 소개 :: MMSG
	// <textarea name="mmsg" id="mmsg" rows="5" cols="50"></textarea>
	String mmsg=request.getParameter("mmsg");
	
	MemVO mvo=null;
	mvo = new MemVO();
	mvo.setMnum(mnum); 	 	 //  placeholder : 1
	mvo.setMname(mname); 	 //  placeholder : 2
	mvo.setMid(mid); 	 	 //  placeholder : 3
	mvo.setMpw(mpw); 	 	 //  placeholder : 4
	mvo.setMhp(mhp); 	 	 // placeholder : 5
	mvo.setMemail(memail);   // placeholder : 6
	mvo.setMgender(mgender); // placeholder : 7
	mvo.setMhobby(mhobby);   // placeholder : 8
	mvo.setMzone(mzone); 	 // placeholder : 9
	mvo.setMroad(mroad); 	 // placeholder : 10
	mvo.setMjibun(mjibun); 	 // placeholder : 11
	mvo.setMmsg(mmsg); 		 // placeholder : 12
	
	MemService ms=new MemServiceImpl();
	boolean bool=ms.memInsert(mvo);
	
	if(bool){
%>
	<script>
		alert("회원가입 성공 >>> : ");
		location.href="/kosMember_YYS2/kosmem/memSelectAll.jsp";
		// /kosMember_YYS2/kosmem/memSelectAll.jsp
	</script>
	
<%
	}else{
%>
	<script>
		alert("회원가입 실패 >>> : ");
		history.go(-1);
	</script>
<%
	}
%>
</body>
</html>