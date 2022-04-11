<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param_A.jsp</title>
<!-- 
	jQuery CDN 을 사용해서 
	/kos_jsp/param_B.jsp 파일 을 만들어서
 	jQuery click 함수를 이용해서 /kos_jsp/param_A.jsp 의
 	form 태그에 있는 데이터 전송하기
 	click 이벤트는 버튼에 하기  
 -->
 <!-- 1. jQuery CDN -->
 <!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- 2. 스크립트 블럭  -->
<script type="text/javascript">
	alert("스크립트 블럭");

	// 3. jQuery ready() 함수 블럭 만들기 : html 문서가 로딩 된 이후에 jQuery가 동작을 해야 한다.
	$(document).ready(function(){
		alert("jQuery ready() 함수 블럭 ");
		// 4. 버튼 이벤트 
		
		$("#mid_btn").click(function(){
			alert("mid_btn 함수 블럭 ");
			// 5. form 태그 세팅
			// http://localhost:8088/kosMember/kos_jsp/param_B.jsp
			$("#paramForm_A").attr({
				"action":"/kosMember/kos_jsp/param_B.jsp",
				"method":"GET"
			}).submit();
			
		});
	});

</script>

</head>
<body>
<h3>param_A.jsp</h3>
<hr>
<%
// 스크립틀릿 : 자바코드를 기술한다.
	// <input type="text" class="mid" name="mid" id="mid" />	
	// request : 내장형 오브젝트 
	String mid = request.getParameter("mid");
	// <input type="text" class="mpw" name="mpw" id="mpw" />
	String mpw = request.getParameter("mpw");
	
	System.out.println("mid >>> : " + mid);
	System.out.println("mpw >>> : " + mpw);
%>

<!-- &lt;%= mid %&gt; 표현식 : 자바코드를 웹브라우저에 출력하는 것  -->
<%-- <%= mid %> 표현식 : 자바코드를 웹브라우저에 출력하는 것   --%>
&lt;%= mid %&gt; -> <%= mid %><br>
&lt;%= mpw %&gt; -> <%= mpw %><br>

<h3>el : Expression Language</h3>
\${ param.mid } -> ${ param.mid }<br>
\${ param.mpw } -> ${ param.mpw }<br>

<h3>param_A.jsp 에서 form 태그로 전송하기</h3> 
<hr>
<form name="paramForm_A" id="paramForm_A">
<input type="text" class="mid" name="mid" id="mid" value='${ mid }'/>
<input type="text" class="mpw" name="mpw" id="mpw" value="<%= mpw %>"/>
<input type="button" name="mid_btn" id="mid_btn" value="보내기" />
</form>
</body>
</html>






