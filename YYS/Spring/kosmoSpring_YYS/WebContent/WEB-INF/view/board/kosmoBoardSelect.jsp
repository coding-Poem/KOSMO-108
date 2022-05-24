<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="a.b.c.com.kosmo.board.vo.KosmoBoardVO" %> 
<%@ page import="a.b.c.com.kosmo.common.CodeUtil" %> 
<%@ page import="java.util.List" %> 
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("kosmoBoardSelect 페이지 입니다 >>> : ");
	
	Object obj=request.getAttribute("listS");
	if(obj==null) return;
	
	List<KosmoBoardVO> list=(List<KosmoBoardVO>)obj;
	int nCnt=list.size();
	
	KosmoBoardVO _bvo=null;
	if(nCnt==1){
		_bvo=list.get(0);
	}
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready~~~");
		// pwBtn : 비밀번호
		$(document).on("click", "#pwBtn", function(){
			alert("비밀번호 버튼을 클릭하셧습니다 >>> : ");
			let input_kbpw = prompt('비밀번호를 입력하세요', 'enter password');
			// alert("input_kbpw >>> : "+input_kbpw);
			let pwcheckURL="/kosmoSpring_YYS/kosmoBoardPwCheck.yys";
			let reqType="POST";
			let input_kbnum=$("#kbnum").val();
			console.log("input_kbnum >>> : "+input_kbnum);
			let dataParam={
					kbnum:input_kbnum,
					kbpw:input_kbpw
			};
			console.log("input_kbpw >>> : "+input_kbpw);
			console.log("pwcheckURL >>> : "+pwcheckURL);
			console.log("reqType >>> : "+reqType);
			console.log("dataParam >>> : "+dataParam);
			
			
			$.ajax({
				url:pwcheckURL,
				type:reqType,
				data:dataParam,
				success:whenSuccess,
				error:whenError
			});
			function whenSuccess(resData){
				console.log("resData >>> : "+resData);
				if("ID_YES"==resData){
					alert("비밀번호 GOOD.");
					$("#updateBtn").css('background-color','yellow');	
					if ($("#updateBtn").prop("disabled")==true){
						$("#updateBtn").attr("disabled", false);
					}
				}else if("ID_NO"==resData){
					alert("비밀번호 BAD.");
					return;
				};
			}
			function whenError(e){
				alert("비밀번호 확인 실패 >>> : "+e.responseText);
			}
			
		});
	
		// insertBtn
		$(docuemnt).on("click", "#insertBtn", function(){
			location.href="kosmoBoardInsertForm.yys";
		});
		
		// selectAllBtn
		$(document).on("click", "#selectAllBtn", function(){
			$("#boardUpdateForm").attr({"method":"GET","action":"kosmoBoardSelectAll.yys"}).submit();
		});
		
		// updateBtn
		$(document).on("click", "#updateBtn", function(){
			alert("updateBtn");
			$("#boardUpdateForm").attr({"method":"GET", "action":"kosmoBoardUpdate.yys"}).submit();
		});
	});
</script>
</head>
<body>
<h3>게시글 내용</h3>
<hr>
<div>
<form name="boardUpdateForm" id="boardUpdateForm">
<table border="1">
<tr>
<td align="center">
<font size="4" style="color:black;"><%= _bvo.getKbsubject() %></font>
<input type="hidden" name="kmnum" id="kmnum" value="<%= "KM202205170001"  %>" />
<input type="hidden" id="kbnum" name="kbnum" value="<%= _bvo.getKbnum() %>" />
</td>
</tr>
<tr>
<td align="left">
<font size="1" style="color:gray;">
최초작성일 : <%= _bvo.getMinsertdate() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
최종수정일 : <%= _bvo.getMupdatedate() %>
</font>
</td>
</tr>
<tr>
<td align="center"> 
<img src="/kosmoSpring_YYS/fileupload/board2/<%= _bvo.getKbfile() %>" border="1" width="380" height="300" alt="image">
</td>
</tr>
<tr>
<td align="center">
<textarea name="kbcontent" id="kbcontent" rows="5" cols="50"><%= _bvo.getKbcontent() %>
</textarea>
</td>
</tr>
<tr>
<td align="left">
<font size="1" style="color:gray;">
작성자 : <%=  _bvo.getKbname() %>
</font>
</td>
</tr>
<!--  패스워드 -->
<tr>
<td>패스워드
<input type="password" name="kbpw" id="kbpw" />
<button type="button" id="pwBtn">비밀번호</button>
</td>
</tr>
<tr>
<td colspan="2" align="left">
<button type="button" id="insertBtn">글쓰기</button>
<button type="button" id="selectAllBtn">글목록</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
<button type="button" id="updateBtn" disabled>수정</button>
<button type="button" id="pwBtnChk">비밀번호확인</button>
</tr>
</table>
</form>
</div>
<!--  댓글 처리하는 루틴 -->
</body>
</html>