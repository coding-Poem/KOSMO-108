<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript form test</title>
</head>
<body>
<h3>javascript form test</h3>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	Enumeration<String> em=request.getHeaderNames();
	while(em.hasMoreElements()){
		String name=em.nextElement();
		String value=request.getHeader(name);
		out.println(name+" : "+value+"<br>");
		System.out.println(name+" : "+value);
	}
%>

<h3>getParameter</h3>
<hr>
<%
	String method=request.getMethod();
	String isudtype=request.getParameter("isudtype");
	if (isudtype!=null)isudtype.toUpperCase();
	
	if(isudtype!=null &&  isudtype.length()>0){
		System.out.println("isudtype >>> : "+isudtype);
		System.out.println("method >>> : "+method);
		
		if("I".equals(isudtype)){
			String mname=request.getParameter("mname");
			out.println("mname >>> : "+mname+"<br>");
			System.out.println("mname >>> : "+mname);
			
			String mid=request.getParameter("mid");
			out.println("mid >>> : "+mid+"<br>");
			System.out.println("mid >>> : "+mid);
			
			String mpw=request.getParameter("mpw");
			out.println("mpw >>> : "+mpw+"<br>");
			System.out.println("mpw >>> : "+mpw);
			
			String mhp=request.getParameter("mhp");
			out.println("mhp >>> : "+mhp+"<br>");
			System.out.println("mhp >>> : "+mhp);
			
			String mgender=request.getParameter("mgender");
			out.println("mgender >>>> : "+mgender+"<br>");
			System.out.println("mgender >>> : "+mgender);
			
			String mhobby="";
			String hobby[]=request.getParameterValues("mhobby");
			if(hobby!=null){
				for(int i=0; i<hobby.length; i++){
					mhobby += hobby[i]+",";
				}
			}
			out.println("mhobby >>> : "+mhobby+"<br>");
			
			String mlocal=request.getParameter("mlocal");
			out.println("mlocal >>> : "+mlocal);
			System.out.println("mlocal >>> : "+mlocal);
			
			String mmsg =request.getParameter("mmsg");
			out.println("mmsg >>> : "+mmsg+"<br>");
			System.out.println("mmsv >>> : "+mmsg);
		}
		
		
	}else{
		System.out.println("isudtype 탕비을 잘 넘기세요 >>> : ");
	}



%>



</body>
</html>