<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.t6.servie.T6Service" %>
<%@ page import="a.b.c.t6.servie.T6ServiceImpl" %>
<%@ page import="a.b.c.t6.vo.T6VO" %>  
<%@ page import="java.util.ArrayList" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST_T6 SELECT NUM</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- CDN : 제이쿼리가 라이브러리이다. 자바스크립트의 기능을 모아두었다 -->
<!-- 다운을 받을 수도 있는데, 편하게 여기서 쓸수 도 있다. -->
<script type="text/javascript">
	
	//jQuery 는 스크립트 블럭 ready 함수 블럭에 만들어야 한다.
	$(document).ready(function(){
		
		// 수정
		$("#t6update_btn_ok").click(function(){
			alert("t6update_btn_ok 버튼 클릭 성공 >>> : ");
			
			// http://localhost:8088/firstWeb/test_t6/t6UpdateOk.jsp
			$("#form_t6_update_ok").attr(
				{
					"action":"/firstWeb/test_t6/t6UpdateOk.jsp",
					"method":"GET"
				}
			).submit();
		});
		
		// 삭제
		$("#t6delete_btn_ok").click(function(){
			alert("t6delete_btn_ok 버튼 클릭 성공 >>> : ");
			
			// http://localhost:8088/firstWeb/test_t6/t6DeleteOk.jsp
			$("#form_t6_update_ok").attr(
				{
					"action":"/firstWeb/test_t6/t6DeleteOk.jsp",
					"method":"GET"
				}
			).submit();
		});
	});

</script>
</head>
<body>
<h3 align="center">TEST_T6 SELECT NUM</h3>
<hr>
<form name="form_t6_update_ok" id="form_t6_update_ok">
<table border="1" align="center">
<%
	String t1 = request.getParameter("t1");
	System.out.println("t1 >>> : " + t1);
	T6VO tvo = null;
	tvo = new T6VO();		
	tvo.setT1(t1);

	T6Service ts = new T6ServiceImpl();	
	ArrayList<T6VO> aList = ts.t6SelectNum(tvo);
	
	if (aList !=null && aList.size() == 1) {
		
		T6VO _tvo = aList.get(0);
		T6VO.printT6VO(_tvo);
%>
<tr>
	<td colspan="2" align="center">회원 글 수정하기</td>
</tr>	 
<tr>
	<td align="center">T1</td>
	<td><input type="text" name="t1" id="t1" size="20" readonly value="<%= _tvo.getT1() %>"></td>
</tr>
<tr>
	<td align="center">T2</td>
	<td><input type="text" name="t2" id="t2" size="20" value="<%= _tvo.getT2() %>"></td>
</tr>
<tr>
	<td  align="center">T3</td>
	<td><input type="text" name="t3" id="t3" size="20" value="<%= _tvo.getT3() %>"></td>			
</tr>
<tr>
	<td  align="center">T4</td>
	<td><input type="text" name="t4" id="t4" size="20" disabled value="<%= _tvo.getT4() %>"></td>			
</tr>						
<tr>
	<td  align="center">T5</td>
	<td><input type="text" name="t5" size="20" disabled value="<%= _tvo.getT5() %>"></td>
</tr>
	<tr>
	<td  align="center">T6</td>
	<td><input type="text" name="t6" size="20" disabled value="<%= _tvo.getT6() %>"></td>
</tr>
<tr>
	<td colspan="2" align="center">		
		<input type="button" value="수정" id="t6update_btn_ok">	
		<input type="button" value="삭제" id="t6delete_btn_ok">						
	</td>	
</tr>	
</table>
</form>		
<%							
	}
%>
</body>
</html>