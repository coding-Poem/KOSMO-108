<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오채팅방</title>
<meta name="viweport" content="width=device-width, iitail-scale=1">
<style type="text/css">
	body{
		display:table;
		position:relative;
		width:600px;
  		margin:10px auto;
		background:rgb(255, 255, 77);
		heigth:100%;
		width:400px;
	}

	div{
		position:relative;
		width:600px;
  		margin:10px auto;
		box-sizing:border-box;
		width:400px;
		padding:20px;
		text-align:center;
		font-size:90%;
		margin:12px;
		align-context:space-between;
		margin:10px auto;
	}
	
	
	div.chat{
		position:relative;
		width:600px;
  		margin:10px auto;
		background:hsl(192, 100%, 90%);
		width:200px;
		heigth:500px;
		padding:20px;
		border:3px solid;
		border-color:#ccccb3;
		border-style: solid;
		text-align:center;
	}
		
	#i3{
		position:relative;
  		margin:10px auto;
		float:right;
	}
	
	img{
  		margin:10px auto;
		float:right;
	}
	
	
</style>

</head>
<body>


<%
	String tname=request.getParameter("tname");
%>

<div class="ch">
	<div class="chat">
		<header>
			<img src="/kosMember_YYS/img/img_kakao/2윙크.png" width="50" height="50">
			<p style="text-align:left;"> <%= tname %></p>
		</header>
		<section>
			hi~
		</section>
	</div>

	<div id=i3>
		<img src="/kosMember_YYS/img/img_kakaofriends/3 (2).png" width="80" height="92">
	</div>
</div>

</body>
</html>