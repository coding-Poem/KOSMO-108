<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.t6.servie.T6Service" %>
<%@ page import="a.b.c.t6.servie.T6ServiceImpl" %>
<%@ page import="a.b.c.t6.vo.T6VO" %>  
<%@ page import="java.util.ArrayList" %>    
<%@ page import="a.b.c.common.ChabunUtil" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST_T6 INSERT</title>
</head>
<body>
<h3>TEST_T6 INSERT</h3>
<% 
	String t1=ChabunUtil.getT6Chabun("d");
	// T6 20220329 0005
	
	/*
	<form name="form_t6_insert" id="form_t6_insert">
	이름 <input type="text" name="t2" id="t2"><br>
	나이 <input type="text" name="t3" id="t3"><br>
	*/
	String t2=request.getParameter("t2");
	// 아? 이름이구나? 그 이름을 request javax뭐시기http 클래스
	// request 함수가 있다. 값이 하나면 request.getParameter("name")
	// String t2 = 김별
	String t3=request.getParameter("t3");
	// 나이를 20살 => t3
	
	// setting을 하고 싶어.
	// this.변수 = 새로운값;
	T6VO tvo=null;
	tvo=new T6VO();
	tvo.setT1(t1);
	tvo.setT2(t2);
	tvo.setT3(t3);
	// 세팅담당자 : 나 끝
	
	// 서비스 클래스
	T6Service ts=new T6ServiceImpl();
	boolean bool=ts.t6Insert(tvo);
	// nCnt 정수 : 숫자 : 
	// 야 그래서 추가 됐어? 안 됐어? 그거만 말해!!!!!
	// 추가됐으면 true, 안됐으면 false
	
	if(bool){
		// if 안에 () 소괄호는 true여야만, 실행이 된다.
		// bool: true면 if문 안이 실행이 된다.
		// jsp가 할일은 여기까지 . 나 좀 쉬고 싶어
		// html 너가해
%>
<!--  html 두두등장 !! 화면에 입력 성공 !! 셀렉트올 jsp로 가라  -->
	<script>
		alert("입력 성공");
		location.href="/firstWeb/test_t6p/t6SelectAll.jsp";
	</script>
<% 
	}else{
		// bool : false else블럭으로 넘어온다.
		// jsp 힘들어 html 너가 실패 띄워
%>
<!--  html 등장! 입력 실패 알려주고 이전 페이지로 간다. -->
	<script>
		alert("입력 실패");
		history.go(-1);
	</script>
<%
// jsp 문닫으러 왔어 else문 블럭
	}
%>
</body>
</html>