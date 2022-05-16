<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/kosmoSpring_YYS/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/kosmoSpring_YYS/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#search_btn").click(function(){
			alert('검색버튼 클릭! >>> 전체조회 조건검색 컨트롤러로 이동');
			
			$("#kosmoSearchForm").attr({
				"method":"GET",
				"action":"kosmoProductSelect.yys",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
		
		$("#startDate").datepicker({
			showOn: "button",			
	        buttonImage: "/kosmoSpring_YYS/calendar_datepicker/images/calendar.gif",
	        dateFormat: 'yy-mm-dd',
		    buttonImageOnly: false,
			buttonText: "Select date"
		});
		
		$("#endDate").datepicker({
			showOn: "button",
	        buttonImage: "/kosmoSpring_YYS/calendar_datepicker/images/calendar.gif",
	        dateFormat: 'yy-mm-dd',
		    buttonImageOnly: false,
			buttonText: "Select date"
		});
	});
</script>
</head>
<body>
<form name="kosmoSearchForm" id="kosmoSearchForm">
	<select id="searchFilter" name="searchFilter">
		<option value="key_00">전체-----------</option>
		<option value="key_01">상품번호</option>
		<option value="key_02">상품명</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder="검색어 입력"><br>
	<input type="text" id="startDate" name="startDate" size="10" placeholder="시작일">
	~
	<input type="text" id="endDate" name="endDate" size="10" placeholder="종료일">
	<input type="button" id="search_btn" name="search_btn" value="검색">
	<input type="reset" id="reset_btn" name="reset_btn" value="리셋"><br>
</form>
</body>
</html>