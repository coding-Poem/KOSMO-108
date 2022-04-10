<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>   
<!-- import로 java.util.Enumeration이라는 깡통을 호출하였다.
데이터가 정해져있지 않은 상황에서 담을 수 있는 통 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cgiForm 테스트</title>
</head>
<body>
<!-- 
콘솔에 출력된 내용

isudtype >>> : I
method >>> : GET
mname >>> : 윤요섭
mid >>>> : imyoseob
mpw >>> : 0323
mhp >>> : null
mgender >>> : null
mlocal >>> : seoul
 -->
	<h3>cgiForm 테스트</h3>
	<hr>
	<% request.setCharacterEncoding("UTF-8"); %>
	<!-- request : 내장 객체 : 내장 Object -->
	<!-- javax.servlet.http.HttpServletRequest-->
	<!-- outline을 보면jsp 영역으로 지정한다.  -->
	<%-- 이것도 주석이 가능하다.--%>
	<%-- 일반 html에서는 위의 주석이 되지 않는다. --%>
	<%-- DOCTYPE위에 내용 때문에 그런 듯??? --%>
	<!-- GET 방식으로 들어온다. 
		 GET 방식은 BYTE 제한이 있다. (2^8~2^12)
		 GET 방식은 HEAD로 간다.
		 HEAD에 쿼리 스트링으로 키와 밸류로 간다.
		 한글이 앱시딕코드로 변환되어 가는데,
		 setCharacterEncoding으로 글자가 깨지지 않도록
		 세팅을 해준다. 자세한 것은 API를 참고해야 한다. -->
	
	<%
		Enumeration<String> em=request.getHeaderNames();
		// 인터페이스 클래스, 커서함수를 가지고 있다., 깡통이라고 한다.
		// 순서가 없다.
		while(em.hasMoreElements()){
			// hasMoreElement와 nextElement는 세트이다.
		    // GET 방식으로 수행되었기 때문에 header로 가서 찾아야 한다.
			String name=em.nextElement();
			String value=request.getHeader(name);
			out.println(name+ " : "+value);
			System.out.println(name+ " : " + value);
			
			/*
			화면과 콘솔창 출력된 내용
			
			host : localhost:8088
			connection : keep-alive
			sec-ch-ua : " Not A;Brand";v="99", "Chromium";v="99", "Google Chrome";v="99"
			sec-ch-ua-mobile : ?1
			sec-ch-ua-platform : "Android"
			upgrade-insecure-requests : 1
			user-agent : Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Mobile Safari/537.36
			accept : text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,/;q=0.8,application/signed-exchange;v=b3;q=0.9
			sec-fetch-site : same-origin
			sec-fetch-mode : navigate
			sec-fetch-dest : document
			referer : http://localhost:8088/firstWeb/cgiForm/from_1p.html
			accept-encoding : gzip, deflate, br
			accept-language : ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
			cookie : JSESSIONID=E2EE25CC75B1F7052210EC9452E0CE8F
			
			*/
		}
	%>
	<h3>getParameter</h3>
	<hr>
	<%
		String method=request.getMethod();
		// getMethod는 name에 있는 값을 가져온다.
		String isudtype=request.getParameter("isudtype");
		
		if(isudtype!=null) isudtype.toUpperCase();
		
		if(isudtype!=null && isudtype.length()>0){
			// 감사하게도 jsp %% 안의 영역에서는 잘 못 쳐도 디버깅이 된다. ㅎㅎ
			System.out.println("isudtype >>> : "+isudtype);
			System.out.println("method >>> : "+method);
			
			if("I".equals(isudtype)){
				// input type='text' name="mname"
				String mname=request.getParameter("mname");
				out.println("mname >>> : "+mname+"<br>");
				System.out.println("mname >>> : "+mname);
				// mname >>> : 윤요섭
				
				// input type='text' name="mid" value="아이디"
				String mid=request.getParameter("mid");
				out.println("mid >>> : "+mid+"<br>");
				System.out.println("mid >>>> : "+mid);
				// mid >>> : imyoseob
				
				// input type="text" name="mpw"
				String mpw=request.getParameter("mpw");
				out.println("mpw >>> : "+mpw+"<br>");
				System.out.println("mpw >>> : "+mpw);
				// mpw >>> : 0323
				
				
				// input type="text" name="mhp"
				String mhp=request.getParameter("mhp");
				out.println("mhp >>> : "+mhp+"<br>");
				System.out.println("mhp >>> : "+mhp);
				// mhp >>> : null
				
				// input type="radio" name="mgender" checked="checked"
				// value="M" "F"
				// 토글 버튼 : toggle button : 두 개 또는 여러 개에서 하나만 선택 되는 버튼
				String mgender=request.getParameter("mgender");
				out.println("mgender >>> : "+mgender);
				System.out.println("mgender >>> : "+mgender);
				// mgender >>> : null
				
				
				// input type="checkbox" name="mhobby"
				/*
					<input type="checkbox" name="mhobby" value="book" /> 독서
					<input type="checkbox" name="mhobby" value="sports" />운동
					<input type="checkbox" name="mhobby" value="travel" />여행
				*/		
				String mhobby="";
				// java.lang.String[] getParameterValues(java.lang.String name)
				String hobby[]=request.getParameterValues("mhobby");
				// 받아오는 값이 배열로 들어감. 파라미터가 여러개
				
				if (hobby != null){
					for(int i=0; i<hobby.length; i++){
						// out.println("hobby : "+hobby[i]+", <br>");
						// System.out.println("hobby : "+hobby[i]+",");
						mhobby += hobby[i]+",";
						// mhobby[0] : book
						// mhobby[1] : sports
						// 이를 book, sports로 합쳐서 표현
					}
				}
				out.println("mhobby >>> : "+mhobby+"<br>");
				// mhobby >>> : book,sports,
				
				// input type="select"
				/*
					<select name="mlocal">
						<option value="seoul">서울</option>
						<option value="gunggido">경기도</option>
						<option value="junju">전주</option>
					</select>
				*/
				
				String mlocal=request.getParameter("mlocal");
				out.println("mlocal >>> : "+mlocal+"<br>");
				System.out.println("mlocal >>> : "+mlocal);
				// mlocal >>> : seoul
			} // if("I".equals(isudtype))
			else{
				System.out.println("isudtype 타입을 잘 넘기세요 >>> : ");
			}
		} // if(isudtype!=null && isudtype.length()>0)
	%>


</body>
</html>