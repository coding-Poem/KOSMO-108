<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax load()함수</title>
<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").click(function(){
			$("#target").load("text_file.txt");
		});
	});
</script>
</head>
<body>
<h3>Ajax load() 함수 사용하기</h3>
<hr>
<div id="target" style="width:400px; height:150px; border:solid 1px red">
</div>
<button>Get Data</button>
</body>
</html>