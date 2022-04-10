<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.kos.service.MemService" %>
<%@ page import="a.b.c.kos.service.MemServiceImpl" %>
<%@ page import="a.b.c.kos.vo.MemVO" %>
<%@ page import="java.util.ArrayList" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_MEMBER SELECT</title>
</head>
<body>
<h3>KOS_MEMBER SELECT</h3>
<hr>
<!-- 
Servlet 3.1 API - Apache Tomcat 8.0.53
https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html
 -->

<!-- 
 request.getParameter
 
 Parameters : name - a String specifying the name of the parameter
 
 java.lang.String :: getParameter(java.lang.String name)
 Returns the value of a request parameter as a String,
 or null if the parameter does not exist.
 
##########################################################
 
 request.getParameterValues(java.lang.String name)
 
 Parameters : name - a String containing the name of the parameter value is requested
 
 java.util.Enumeration<java.lang.String>
 Returns an Enumeration of String objects containing 
 the names of the parameters contained in this request.
 
 ##########################################################
 
 Interface ServletRequest
 void setCharacterEncoding(java.lang.String env)
 Overrides the name of the character encoding used in the body of this request.
 Parameters : env - a String containing the name of the character encoding.
 
 Interface ServletResponse
 void setCharacterEncoding(java.lang.String charset)
 Sets the character encoding (MIME charset) of the response 
 being sent to the client, for example, to UTF-8.
 
 Parameters
 charset - a String specifying only the character set defined by IANA Character Sets 
 (http://www.iana.org/assignments/character-sets)
 
 -->

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>

<%	
		String mnum=request.getParameter("smnum");
		String mname=request.getParameter("smname");
		
		String fromdate=request.getParameter("fromdate");
		String todate=request.getParameter("todate");
		
		System.out.println("\n memSelect jsp :: 검색 시작 >>> : ");
		
		MemVO mvo=null;
		mvo=new MemVO();
		
		if(mnum!=null){
			System.out.println("\n memSelect jsp :: 입력한 회원 번호 >>> : "+mnum);
			mvo.setMnum(mnum);
		}
		
		if(mname!=null){
			System.out.println("\n memSelect jsp :: 입력한 회원 이름 >>> : "+mname);
			mvo.setMname(mname);
		}
		
		if(fromdate!=null){
			System.out.println("\n memSelect jsp :: 입력한 조회 날짜 시작일 >>> : "+fromdate);
			mvo.setFromdate(fromdate);
		}
		
		if(todate!=null){
			System.out.println("\n memSelect jsp :: 입력한 조회 날짜 마지막일 >>> : "+todate);
			mvo.setTodate(todate);
		}

		
		MemService ms=new MemServiceImpl();
		ArrayList<MemVO> aList=ms.memSelectName(mvo);
		
		if (aList !=null && aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				MemVO _mvo = aList.get(i);
				MemVO.printMemVO(_mvo);
%>
			<%=	_mvo.getMnum()+       " : "      %>
			<%=	_mvo.getMname()+      " : "      %>
			<%=	_mvo.getMid()+        " : "      %>
			<%=	_mvo.getMpw()+ 	      " : "      %>
			<%=	_mvo.getMhp()+        " : "      %>
			<%=	_mvo.getMemail()+     " : "      %>
			<%=	_mvo.getMgender()+    " : "      %>
			<%=	_mvo.getMhobby()+     " : "      %>
			<%= _mvo.getMlocal()+     " : "	     %>
			<%=	_mvo.getMmsg()+       " : "      %>
			<%=	_mvo.getDeleteyn()+   " : "      %>
			<%=	_mvo.getInsertdate()+ " : "      %>
			<%=	_mvo.getUpdatedate()+ " : "      %>

<% 
			}
		}
%>
</body>
</html>