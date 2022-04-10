<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.t6.servie.T6Service" %>
<%@ page import="a.b.c.t6.servie.T6ServiceImpl" %>
<%@ page import="a.b.c.t6.vo.T6VO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST_T6 SELECT NAME</title>
</head>
<body>
<h3>TEST_T6 SELECT NAME</h3>
<hr>
<% 
	String t2=request.getParameter("t2");
	// <input type="text" name="t2" id="t2" />
	System.out.println("jsp :: t2 :: >>> : "+t2+"<br>");
	T6VO tvo=null;
	tvo=new T6VO();
	tvo.setT2(t2);

	T6Service ts=new T6ServiceImpl();
	ArrayList<T6VO> aList=ts.t6SelectName(tvo);
	
	if(aList!=null && aList.size() > 0 ){
		for (int i=0; i<aList.size(); i++){
			T6VO _tvo=aList.get(i);
			T6VO.printlnT6VO(_tvo);
%>
			<%= _tvo.getT1()+" : "  %>
			<%= _tvo.getT2()+" : "  %>
			<%= _tvo.getT3()+" : "  %>
			<%= _tvo.getT4()+" : "  %>
			<%= _tvo.getT5()+" : "  %>
			<%= _tvo.getT6()+"<br>" %>
<%		} // for (int i=0; i<aList.size(); i++)
	} // if(aList!=null && aList.size() > 0 )

%>
</body>
</html>