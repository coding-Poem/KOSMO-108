<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cgiForm 테스트</title>
</head>
<body>
<h3>cgiForm 테스트</h3>
<hr>
<%-- 
	void setCharacterEncoding(java.lang.String env) throws java.io.UnsupportedEncodingException
	Overrides the name of the character encoding used in the body of this request
	method >>> : GET 
	http://localhost:8088/firstWeb/jsp/form_1.jsp?mname=&mid=%EC%95%84%EC%9D%B4%EB%94%94&mpw=&mhp=&mgender=M&mlocal=seoul&mmsg=&isudtype=I
--%>
<% request.setCharacterEncoding("UTF-8"); %>
<%-- 요청한 웹브라우저에서 header 정보 추출하기  --%>
<%
	// java.util.Enumeration<java.lang.String> getHeaderNames()
	Enumeration<String> em = request.getHeaderNames();
	while (em.hasMoreElements()){
		String name = em.nextElement();
		// java.lang.String getHeader(java.lang.String name)
		String value = request.getHeader(name);
		out.println(name + " : " + value + "<br>");
		System.out.println(name + " : " + value);		
	}
%>
<h3>getParameter</h3>
<hr>
<%
	String method = request.getMethod();	
	
	// <input type="hidden" id="isudtype" name="isudtype" value="I">	
	String isudtype = request.getParameter("isudtype");
	if (isudtype !=null) isudtype.toUpperCase();
	
	if (isudtype !=null && isudtype.length() > 0){
		System.out.println("isudtype >>> : " + isudtype);
		System.out.println("method >>> : " + method);
		
		if ("I".equals(isudtype)){
			
			// input type="text"	
			// <input type="text" name="mname" />
			String mname = request.getParameter("mname");
			out.println("mname >>> : " + mname + "<br>");
			System.out.println("mname >>> : " + mname);
			
			// <input type="text" name="mid" value="아이디" />
			String mid = request.getParameter("mid");
			out.println("mid >>> : " + mid + "<br>");			
			System.out.println("mid >>> : " + mid);
			
			// <input type="text" name="mpw" />
			String mpw = request.getParameter("mpw");
			out.println("mpw >>> : " + mpw + "<br>");			
			System.out.println("mpw >>> : " + mpw);
			
			// <input type="text" name="mhp" />
			String mhp = request.getParameter("mhp");
			out.println("mhp >>> : " + mhp + "<br>");			
			System.out.println("mhp >>> : " + mhp);
				
			// input type="radio"
			// <input type="radio" name="mgender" value="M" checked="checked" />남자
			// <input type="radio" name="mgender" value="F" /> 여자
			// 토그 버튼 : toggle button : 두개 또는 여러개 에서 하나만 선택 되는 버튼 
			String mgender = request.getParameter("mgender");
			out.println("mgender >>> : " + mgender + "<br>");
			System.out.println("mgender >>> : " + mgender);
					
			// input type="checkbox"
			/*
				<input type="checkbox" name="mhobby" value="book" />독서		      
				<input type="checkbox" name="mhobby" value="sports" />운동
				<input type="checkbox" name="mhobby" value="music" />음악감상
				<input type="checkbox" name="mhobby" value="travel" />여행
			*/
			String mhobby = "";		
			// java.lang.String[] getParameterValues(java.lang.String name)
			String hobby[] = request.getParameterValues("mhobby");		
			if (hobby !=null){
				for(int i=0; i < hobby.length; i++){
					//out.println("hobby : " + hobby[i] + ", <br>");
					//System.out.println("hobby : " + hobby[i] + ",");
					mhobby += hobby[i] + ",";
				}		
			}
			out.println("mhobby >>> : " + mhobby + "<br>");	
		
			// input type="select"
			/*
				<select name="mlocal">
					<option value="seoul">서울</option>
					<option value="gunggido">경기도</option>
					<option value="junju">전주</option>
				</select>
			*/
			String mlocal = request.getParameter("mlocal");
			out.println("mlocal >>> : " + mlocal + "<br>");
			System.out.println("mlocal >>> : " + mlocal);
			
			// textarea
			// <textarea name="mmsg" rows="5" cols="50"></textarea>
			String mmsg = request.getParameter("mmsg");
			out.println("mmsg >>> : " + mmsg + "<br>");
			System.out.println("mmsg >>> : " + mmsg);				
		}
		
	}else{
		System.out.println("isudtype 타입을 잘 넘기세요 >>> : ");
	}
%>
</body>
</html>