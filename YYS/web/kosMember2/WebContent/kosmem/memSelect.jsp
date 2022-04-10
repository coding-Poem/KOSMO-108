<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>
<%@ page import="a.b.c.kos.mem.service.MemService" %>
<%@ page import="a.b.c.kos.mem.service.MemServiceImpl" %>
<%@ page import="a.b.c.common.CodeUtil" %>
    
<!DOCTYPE html>
<html>
<head>
<!-- ################  head ################ -->
<meta charset="UTF-8">
<title>회원 전체 조회</title>
<!--디바이스에 최적화된 크기로 출력됨 -->
<meta name="viweport" content="width=device-width, iitail-scale=1">
<!-- jQuery CDN 불러오기 -->
<script src="http://code.jquery.com/jquery-latest.min.js" ></script>
<!-- 다음 주소록 OPEN API CDN 불러오기 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
//javascript area
	// $(document).ready(function(){});
	$(document).ready(function(){
		// 이메일
		// <select name="memail2" id="memail2">
		// $('#memail2').change(function(){});
		// .change(handler)
		// Description: Bind an event handler to the "change" JavaScript event, 
		// or trigger that event on an element.
		$('#memail2').change(function(){
			// $('#memail2 option:selected').each(function(){});
			// .each(function)
			// Description: Iterate over a jQuery object, 
			// executing a function for each matched element.
			$("#memail2 option:selected").each(function(){
				// <option value="1" selected>직접입력</option>
				if($(this).val()=='1'){ // 직접 입력일 경우
					// <input type="text" name="memail1" id="memail1" 
					// style="width:100px" placeholder="직접입력" />
					var aa=$("#memail1").val();
					$("#memail1").val(''); // 값  초기화
					$("#memail1").attr("readonly", false); // 활성화
					}else{ // 직접입력이 아닐경우
						$("#memail1").val($(this).text()); // 선택값 입력
						$("#memail1").attr("readonly", true); // 비활성화	
					}
			}); // end of $('#memail2 option:selected').each(function(){});
		}); // end of // $('#memail2').change(function(){});
		
		// 우편번호
		/* <input type="button" name="mzone_btn" id="mzone_btn" value="우편번호 찾기"><br> */
		// $("#mzone_btn").click(function(){});
		$("#mzone_btn").click(function(){
			console.log("mzone_btn >>> : ");
			// new daum.Postcode({{}}).open();
			new daum.Postcode({
				oncomplete: function(data){		
					// <input type="text" name="mzone" id="mzone" placeholder="우편번호"
					$("#mzone").val(data.zonecode); // 5자리 새우편번호 사용
					// <input type="text" name="mroad" id="mroad" placeholder="도로명주소"
					$("#mroad").val(data.roadAddress); // 도로명주소
					// <input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소"
					$("#mroaddetail").val(''); // 도로명 상세주소
					// <input type="text" name="mjibun" id="mjibun" placeholder="지번주소"
					$("#mjibun").val(data.jibunAddress); // 지번주소
				}
			}).open();	
		}); // end of $("#mzone_btn").click(function(){})
		
		// 수정
		// <input type-"button" value="회원정보수정" id="memUpdateBtn" />
		// $("#memUpdateBtn").click(function(){});
		$("#memUpdateBtn").click(function(){
			alert("memUpdateBtn 버튼 클릭 성공 >>> : ");
			// <form name="memSelectForm" id="memSelectForm">
			// $("#memSelectForm").attr({}).submit();
			
			// MEMAIL, MHOBBY, MZONE, MROAD, MJIBUN 수정 가능
			$("#memSelectForm").attr(
					{
						"action":"/kosMember_YYS2/kosmem/memUpdateOk.jsp",
						// /kosMember_YYS2/kosmem/memUpdateOk.jsp
						"method":"GET"
					}
				).submit();
		}); // end of // $("#memUpdateBtn").click(function(){});
		
		// 삭제
		/* <input type="button" value="회원정보삭제" id="memDeleteBtn" /> */
		// $("#memDeleteBtn").click(function(){});
		$("#memDeleteBtn").click(function(){
			alert("memDeleteBtn 버튼 클릭 성공 >>> : ");
			// <form name="memSelectForm" id="memSelectForm">
			// $("#memSelectForm").attr({}).submit();
			$("#memSelectForm").attr(
					{
						"action":"/kosMember_YYS2/kosmem/memDeleteOk.jsp",
						// /kosMember_YYS2/kosmem/memDeleteOk.jsp
						"method":"GET"
					}
				).submit();
		}); // end of $("#memDeleteBtn").click(function(){});
	});// end of $(document).ready(function(){});
</script>
</head>
<!-- ################  body ################ -->
<body onload="compCheck()">
<!--  body 태그의 onload 이벤트 :: compCheck()는 javascript 함수 이름 -->
<!-- index.html "action" : "/kosMember_YYS2/kosmem/memSelect.jsp" -->
<% request.setCharacterEncoding("EUC-KR"); %>
SELECT ALL

<!--  ################ 1st jsp ################ -->
<%
	Logger logger=LogManager.getLogger(this.getClass());
	
	logger.info("memSelect.jsp 페이지 >>> : ");
	
	/*******  index.html :::: request.getParameter or request.getParameterValues  *****/
	// 회원정보 수정 삭제 버튼 누르면 입력한 회원 번호가 넘어온다.
	// <a href="#">회원정보 수정 삭제</a>
	// 회원번호 <input type="text" name="mnum" id="mnum"/>
	String mnum=request.getParameter("mnum");
	
	MemVO mvo=null;
	mvo=new MemVO();
	mvo.setMnum(mnum);
	logger.info("mnum >>> : "+mvo.getMnum());
	
	MemService ms=new MemServiceImpl();
	ArrayList<MemVO> aList=ms.memSelect(mvo);
	if(aList==null) return;
	
	// SELECT ALL (MemDAOImpl.java)
	// MNUM :: 1   
	// MNAME :: 2
    // MID :: 3
    // MPW :: 4
    // MHP :: 5
	// MEMAIL :: 6
	// MGENDER :: 7
	// MHOBBY :: 8
	// MZONE :: 9 
	// MROAD :: 10 
	// MJIBUN :: 11
	// MMSG :: 12
	// DELETEYN :: 13
	// INSERTDATE :: 14
	// UPDATEDATE :: 15
	
	String mhp="";
	String memail="";
	String mgender="";
	String mhobby="";
	String mzone="";
	String mroad="";
	String mroaddetail="";
	String mjibun="";
	
	// index.html에서 mnum을 받아옴.
	// 나머지 변수는 selectAll.jsp로 간다.
	// mname, mid, mpw, mmsg, deleteyn, insertdate, updatedate....
	
	MemVO _mvo=aList.get(0);
	// // MNUM : 1
	
	// 핸드폰 
	mhp=CodeUtil.hp(_mvo.getMhp());
	// return ss=s0+"-"+s1+"-"+s2; // 예시 :010-1234-5678
	logger.info("mhp >>> : "+mhp);
	
	String hp[]=mhp.split("-");
	String mhp0=hp[0]; // 예시 : 010
	String mhp1=hp[1]; // 예시 : 1234
	String mhp2=hp[2]; // 예시 : 5678
	
	// 이메일
	memail=_mvo.getMemail();
	logger.info("memail >>> : "+memail);
	
	// 성별 
	logger.info("_mvo.getMgender() >>> : "+_mvo.getMgender());
	mgender=CodeUtil.gender(_mvo.getMgender()); // null
	logger.info("mgender >>> : "+mgender);
	// return "01".equals(s.toUpperCase()) ? "여자" : "남자";
	
	// 취미
	mhobby=_mvo.getMhobby();
	logger.info("mhobby >>> : "+mhobby);
	
	// 우편번호, 도로명 주소, 지번 주소
	mzone=_mvo.getMzone();
	logger.info("mzone >>> : "+mzone);
	
	mroad=_mvo.getMroad();
	logger.info("mroad >>> : "+mroad);
	
	String addr[]=mroad.split("@");
	// memInsert.jsp
	// mroad=mroad.concat("@").concat(mroaddetail);
	
	mroad=addr[0]; 
	/*
	// memInsert.jsp
	// 주소 :: 도로명주소 :: MROAD
	//  <input type="text" name="mroad" id="mroad" placeholder="도로명주소" 
	String mroad=request.getParameter("mroad");
	*/
	
	logger.info("mroad >>> : "+mroad);
	logger.info("addr[0] >>> :"+addr[0]);
	logger.info("addr[1] >>> :"+addr[1]);
	mroaddetail=addr[1];
	
	/* 
	  // memInsert.jsp
	  // 주소 :: 도로명 상세주소 :: MROAD에 추가하기
	  <input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소"	 
	  String mroaddetail=request.getParameter("mroaddetail"); */
	logger.info("mroaddetail >>> : "+mroaddetail);
	
	mjibun=_mvo.getMjibun();
	logger.info("mjibun >>> : "+mjibun);
%>
<!--  ################ 1st div, form ################ -->
<div>
<h3>회원 정보 수정 삭제</h3>
<hr>
<form name="memSelectForm" id="memSelectForm">
<table border="1">
<script>
	// javascript 영역
	function compCheck(){
		console.log("compCheck >>> 진입 >>> : ");
		
		// 핸드폰
		var hp0= '<%= mhp0 %>';
		// 해당 값을 javascript의 String 변수로 지정한다.
		console.log("hp0 >>> : "+hp0);
		/*
		mhp=CodeUtil.hp(_mvo.getMhp());
		// return ss=s0+"-"+s1+"-"+s2; // 예시 :010-1234-5678
	
		String hp[]=mhp.split("-");
		String mhp0=hp[0]; // 예시 : 010
		*/
		
		if('010'==hp0){
			// javascript에서 문자열 비교는 ==(상등 연산자로 한다.)
			
			/*
				<select name="mhp" id="mhp" style="width:50px;">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
			*/
			
			document.memSelectForm.mhp.options[0].selected=true;
			// document 객체의 memSelectForm이라는 Form 객체 안에
			// selected=true는 document.memSelectForm.mhp.option[0]을 선택해서
			// true로 지정해주는 것이다. why? 010 == 010 이 맞았기 때문이다.
			// if() 소괄호 안이 true여야 아래 명령어가 실행된다.
		}
		if('011'==hp0){
				document.memSelectForm.mhp.options[1].selected=true;
		}
		if('016'==hp0){
			document.memSelectForm.mhp.options[2].selected=true;
		}
		if('017'==hp0){
			document.memSelectForm.mhp.options[3].selected=true;
		}
		
		// 성별
		var gen='<%= mgender %>';
		console.log("gen >>> : "+gen);
		if('여자'==gen){
			/*
				<input type="radio" name="mgender" value="01" checked="checked" />여자
				<input type="radio" name="mgender" value="02" />남자
			*/
			document.getElementsByName("mgender")[0].checked=true;
		}
		if('남자'==gen){
			document.getElementsByName("mgender")[1].checked=true;
		}
		
		// 이메일
		var email='<%= memail %>';
		var emails=email.split('@');
		/*
		<input type="text" name="memail" id="memail" style="width:100px"/>
		@ <input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력" />
		<select name="memail2" id="memail2">
		*/
		console.log("email >>> : "+email);
		
		document.getElementById("memail").value=emails[0];  // 이메일에서 @ 이전
		document.getElementById("memail1").value=emails[1]; // 이메일에서  @ 이후
		
		// 취미
		var hobs='<%= mhobby %>';
		console.log("hobs >>> : "+hobs);
		var hob=hobs.split(',');
		for(var m=0; m<hob.length; m++){
			var hobValue=hob[m];
			console.log("hobValue >>> : "+hobValue);
			if('01'==hobValue){
				/*
					<input type="checkbox" name="mhobby" value="01" />독서
					<input type="checkbox" name="mhobby" value="02" />운동
					<input type="checkbox" name="mhobby" value="03" />음악감상
					<input type="checkbox" name="mhobby" value="04" />여행
				*/
				document.getElementsByName("mhobby")[0].checked=true;
			}
			if('02'==hobValue){
				document.getElementsByName("mhobby")[1].checked=true;
			}
			if('03'==hobValue){
				document.getElementsByName("mhobby")[2].checked=true;
			}
			if('04'==hobValue){
				document.getElementsByName("mhobby")[3].checked=true;
			}
		}
	} // function compCheck()
</script>
<!-- tr :: 회원 정보 :: 2개 열  열병합-->
<tr>
	<td colspan="2">회원 정보</td>
</tr>
<!-- tr : 회원 번호 -->
<tr>
	<td>회원번호</td>
	<td><input type="text" name="mnum" id="mnum" value="<%= _mvo.getMnum() %>" readonly /></td>
</tr>
<!-- tr : 이름 -->
<tr>
	<td>이름</td>
	<td><input type="text" name="mname" id="mname" value="<%= _mvo.getMname() %>" /></td>
</tr>
<!-- tr : 아이디 -->
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="mid" id="mid" value="<%= _mvo.getMid() %>" />
	</td>
</tr>
<!-- tr : 패스워드 -->
<tr>
	<td>패스워드</td>
	<td>
		<input type="text" name="mpw" id="mpw" value="<%= _mvo.getMpw() %>" style="width:100px" /><br>
	</td>
</tr>
<!-- tr : 핸드폰 -->
<tr>
	<td>핸드폰</td>
	<td>
		<select name="mhp" id="mhp" style="width:50px;">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="016">016</option>
		<option value="017">017</option>
		</select>
		- <input type="text" name="mhp1" id="mhp1" value="<%= mhp1 %>" maxlength="4" style="width:50px;"/>
		- <input type="text" name="mhp2" id="mhp2" value="<%= mhp2 %>" maxlength="4" style="width:50px;"/>
	</td>
</tr>
<!--  tr : 이메일 -->
<tr>
	<td>
		<input type="text" name="memail" id="memail" style="width:100px"/>
		@ <input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력" />
		<select name="memail2" id="memail2">
		<option value="1" selected>직접입력</option>
		<option value="naver.com">naver.com</option>
		<option value="gmail.com">gmail.com</option>
		<option value="daum.net">daum.net</option>
		</select>
	</td>
</tr>
<!--  tr : 성별 -->
<tr>
	<td>성별</td>
	<td>
		<input type="radio" name="mgender" value="01" checked="checked" />여자
		<input type="radio" name="mgender" value="02" />남자
	</td>
</tr>
<!-- tr : 취미 -->
<tr>
	<td>취미</td>
	<td>
		<input type="checkbox" name="mhobby" value="01" />독서
		<input type="checkbox" name="mhobby" value="02" />운동
		<input type="checkbox" name="mhobby" value="03" />음악감상
		<input type="checkbox" name="mhobby" value="04" />여행
	</td>
</tr>
<!-- tr : 주소 -->
<tr>
	<td>주소</td>
	<td>
		<input type="text" name="mzone" id="mzone" placeholder="우편번호" value="<%= mzone %>" style="width:70px" maxlength="6">
		<input type="button" name="mzone_btn" id="mzone_btn" value="우편번호 찾기"><br>
		<input type="text" name="mroad" id="mroad" placeholder="도로명주소" value="<%= mroad %>" style="width:250px"><br>
		<input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소" value="<%= mroaddetail %>" style="width:250px"><br>
		<input type="text" name="mjibun" id="mjibun" placeholder="지번주소" value="<%= mjibun %>" style="width:250px">
	</td>
</tr>
<!-- 소개글 -->
<tr>
<td>
	<textarea name="mmsg" id="mmsg" rows="5" cols="50"><%= _mvo.getMmsg() %></textarea>
</td>
</tr>
<!--  tr : 회원정보수정, 회원정보삭제 -->
<tr>
	<td colspan="2">
		<input type="button" value="회원정보수정" id="memUpdateBtn" />
		<input type="button" value="회원정보삭제" id="memDeleteBtn" />
		<input type="reset" value="취소" />
	</td>
</tr>
</table>
</form>
</div>
</body>
</html>