<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD : 게시판 글쓰기</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready~~");
		$(document).on("click", "#kbBtn", function(){
			alert("글쓰기 버튼을 클릭하셨습니다 >>> : ");
			$("#boardForm").attr({
				"action":"kosmoBoardInsert.yys",
				"method":"POST",
				"enctype":"multipart/form-data"
			}).submit();
		});
	});
</script>
</head>
<body>
<h3>kosmoBoardInsertForm.jsp</h3>
<hr>
<form name="boardForm" id="boardForm">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">게시판 글쓰기</td>				
	</tr>
	<tr>
		<td class="tt">글번호</td>
		<td><input type="text" name="kbnum" id="kbnum" size="20" readonly></td>
	</tr>
	<tr>
		<td class="tt">제목</td>
		<td><input type="text" name="kbsubject" id="kbsubject" size="53"></td>
	</tr>
	<tr>
		<td class="tt">이름</td>
		<td><input type="text" name="kbname" id="kbname" size="53"></td>
	</tr>
	<tr>
		<td class="tt">비밀번호</td>
		<td><input type="password" name="kbpw" id="kbpw" size="20"></td>
	</tr>
	<tr>
		<td class="tt">내용</td>
		<td>
		<textarea name="kbcontent" id="kbcontent" cols="50" rows="10"></textarea>
	</td>
	</tr>
	<tr>
		<td class="tt">사진</td>
		<td>
		<input type="file" name="kbfile" id="kbfile">
	</td>
	</tr>
	<tr>
		<td colspan="2" align="right">				
		<input type="button" value="글쓰기" id="kbBtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>