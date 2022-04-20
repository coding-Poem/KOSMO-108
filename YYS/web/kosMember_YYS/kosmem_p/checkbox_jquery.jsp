<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHECKBOX TAG</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		/*
		CSS 선택자 우선순위 점수
		직접기입  : style='' : 1000 점 
		id : #mnumCheck : 100점
		class : .mnumCheck : 10점
		속성 : [name="mnumCheck"] : 10점
	*/
	
	/*
		prop() javaScript property vs attr() html attribute
		1.  jQuery 1.6 이후 부터는 
			form 요소 (element)의  disabled, selected, checked 속성 값을
			확인 또는 변경하는 경우는 prop() 함수 사용 권장
		2. 	prop() 	: element의 활성화, 체크, 선택여부  disabled, selected, checked 등에 사용
	*/
	
	// mnumCheck
	$(document).on("click", "#mnumCheck", function(){
		alert("mnumCheck >>> : ");
		if($(this).prop('checked')){
			//$('input[type="checkbox"][name="mnumCheck"]').prop('checked',false);
			$(".mnumCheck").prop("checked", false);
			$(this).prop("checked", true);
		}	
	});
		
	// U
	$(document).on("click", "#U", function(){
		// alert("U >>> : ");
		/* input type="checkbox" =mnumCheck" name="mnumCheck" id="mnumCheck"  */
		if($(".mnumCheck:checked").length==0){
			alert("수정할 글번호 하나를 선택하세요!!");
			return;
		}else{
			alert("체크박스 선택 :: action은 어디로 ");
		}
	});
	
	// D
	$(document).on("click", "#U", function(){
		// alert("U >>> : ");
		if($(".mnumCheck:cheked").length==0){
			alert("삭제할 글 번호 하나를 선택하세요!!");
			return;
		}else{
			alert("체크박스 선택 :: action은 어디로 ");
		}
	});
	
		
	}); // $(document).ready(function()
</script>
<style type="text/css">
	table {
		border: 1px solid blue;
		width: 300px;
		height: 50px;
		margin: 5px auto;
		text-align: center;
	}
	
	h3,hr {
		text-align: center;
	}
</style>
</head>
<body>
<h3>CHECKBOX TAG</h3>
<hr>
<div class="wrap">
<form name="check_form_1" id="check_form_1">
<table>
<thead>
<tr>
	<td class="tt"><input type="checkbox" class="chkAll" name="chkAll" id="chkAll"></td>
	<td class="tt">순번</td>
	<td class="tt">회원번호</td>
	<td class="tt">이름</td>
</tr>
</thead>
<%
	for(int i=0; i<5; i++){
%>
<tbody>
	<tr>
		<td class="tt">
			<input type="checkbox" class="mnumCheck" name="mnumCheck" id="mnumCheck" value=<%= i %>>
		</td>
		<td class="tt"><%= i+"_순번" %></td>
		<td class="tt"><%= i+"_회원번호" %></td>
		<td class="tt"><%= i+"_이름" %></td>
	</tr>	
<%
	}
%>
<tr>
	<td colspan="5" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="등록" id="I">
		<input type="button" value="조회" id="SALL">
		<input type="button" value="수정" id="U">
		<input type="button" value="삭제" id="D">		
	</td>
</tr>
</tbody>
</table>
</form>
</div>
</body>
</html>