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
<title>KOS_MEMBER SELECT ALL</title>
</head>
<body>
<h3>KOS_MEMBER SELECT ALL</h3>
<hr>
<%
	MemService ms=new MemServiceImpl();
	ArrayList<MemVO> aList=ms.memSelectAll();
	
	if (aList !=null && aList.size() > 0) {
		for (int i=0; i < aList.size(); i++) {
			MemVO _mvo = aList.get(i);
			MemVO.printMemVO(_mvo);
%>

<!-- 
	MNUM	VARCHAR2(20)	PRIMARY KEY  M + YYYYMMDD + 0001 M202203300001
    MNAME	VARCHAR2(50)
    MID		VARCHAR2(50)	NOT NULL
    MPW		VARCHAR2(300)	NOT NULLL
    MHP		VARCHAR2(16)	NOT NULL
    MEMAIL	VARCHAR2(200)	NOT NULL
    MGENDER	VARCHAR2(10)
    MHOBBY	VARCHAR2(100)
    MLOCAL	VARCHAR2(200)
    MMSG	VARCHAR2(2000)
    DELETEYN	VARCHAR2(1)	NOT NULL	Y/N
    INSERTDATE	DATE					YYYY-MM-DD
    UPDATEDATE	DATE					YYYY-MM-DD
 -->
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