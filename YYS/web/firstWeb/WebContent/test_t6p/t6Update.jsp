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
<script type="text/javascript">

	$(document).ready(function(){
		
		// $(#t6update_btn_ok).click(funtion(){});
		
		// <input type="button" value="수정" id="t6update_btn_ok">
		// <input type="button" value="삭제" id="t6delete_btn_ok">
		$("#t6update_btn_ok").click(function(){
			alert("t6update_btn_ok 버튼 클릭 성공 >>> : ");
			
			// $().attr({}).submit();
			// $("#form_t6_update_ok").attr({}).submit();
			$("#form_t6_update_ok").attr(
					{
						"action":"/firstWeb/test_t6p/t6UpdateOk.jsp",
						"method":"GET"
					}
			).submit();
		}); // end of $("#t6update_btn_ok").click(funtion()
				
		$("#t6delete_btn_ok").click(function(){
			alert("t6delete_btn_ok 버튼 클릭 성공 >>> : ");
			
			// $().attr({}).submit();
			// $("#form_t6_update_ok").attr({}).submit();
			$("#form_t6_update_ok").attr(
					{
						"action":"/firstWeb/test_t6p/t6DeleteOk.jsp",
						"method":"GET"
					}
			).submit();
		}); // end of $("#t6update_btn_ok").click(funtion()
	}) // $(document).ready(function(){
</script>
</head>
<body>
<h3 align="center">TEST_T6 SELECT NUM</h3>
<hr>
<form name="form_t6_update_ok" id="form_t6_update_ok">
<table border="1" align="center">
<%
	String t1=request.getParameter("t1");
	// 회원번호 <input type="text" name="t1" id="t1">
	System.out.println("t1 >>> : "+t1);
	T6VO tvo= null;
	tvo = new T6VO();
	tvo.setT1(t1);
	
	T6Service ts=new T6ServiceImpl();
	ArrayList<T6VO> aList=ts.t6SelectNum(tvo);
	
	if (aList!=null && aList.size()==1){
		T6VO _tvo=aList.get(0);
		// 이름만 받아오면 그만임.
		T6VO.printT6VO(_tvo);
%>
<tr>
	<td colspan="2" align="center">회원 글 수정하기</td>
	<!--  열 병합 -->
</tr>
<tr>
	<td align="center">T1</td>
	<td><input type="text" name="t1" id="t1" size="20" readonly value="<%= _tvo.getT1() %>"></td>
	<!--  disabled value : 데이터를 웹 서버로 못 던진다.
		  readonly value : 데이터를 웹 서버로 던질 수 있다. 
		  readonly value하고 "" 안에 내용을 써야 한다.-->
</tr>
<tr>
	<td align="center">T2</td>
	<td><input type="text" name="t2" id="t2" size="20" value="<%= _tvo.getT2() %>"></td>
</tr>
<tr>
	<td align="center">T3</td>
	<td><input type="text" name="t3" id="t3" size="20" value="<%= _tvo.getT3() %>"></td>
</tr>
<tr>
	<td align="center">T4</td>
	<td><input type="text" name="t4" id="t4" size="20" disabled value="<%= _tvo.getT4() %>>"></td>
</tr>
<tr>
	<td align="center">T5</td>
	<td><input type="text" name="t5" id="t5" size="20" disabled value="<%= _tvo.getT5() %>"></td>
</tr>
<tr>
	<td align="center">T6</td>
	<td><input type="text" name="t6" id="t6" size="20" disabled value="<%= _tvo.getT6() %>>"></td>
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
	} // end of if (aList!=null && aList.size()==1)
%>
</body>
</html>