<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.t6.servie.T6Service" %>
<%@ page import="a.b.c.t6.servie.T6ServiceImpl" %>
<%@ page import="a.b.c.t6.vo.T6VO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.common.DateUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST_T6 SELECT DATE</title>
</head>
<body>
<h3>TEST_T6 SELECT DATE</h3>
<hr>
<%
	String fromdate=request.getParameter("fromdate");
	String todate=request.getParameter("todate");
//  <input type="text" name="fromdate" id="fromdate"/>~
//	<input type="text" name="todate" id="todate"/>
	System.out.println("jsp :: fromdate :: >>> : "+fromdate+"<br>");
	System.out.println("jsp :: todate :: >>> : "+todate+"<br>");
	
	T6VO tvo=null;
	tvo=new T6VO();
	tvo.setFromdate(fromdate);
	tvo.setTodate(todate);
	
	if(DateUtil.fromtoDate(fromdate, todate)){ 
		out.println("FROM 날짜가 TO 날짜보다 크면 안 됩니다.");
		return;
	}
	
	T6Service ts=new T6ServiceImpl();
	ArrayList<T6VO> aList=ts.t6SelectDate(tvo);
	
	if(aList!=null && aList.size() > 0){
		for(int i=0; i<aList.size(); i++){
			T6VO _tvo=aList.get(i);
			T6VO.printlnT6VO(_tvo);
%>
		<%= _tvo.getT1() + " : "  %>
		<%= _tvo.getT2() + " : "  %>
		<%= _tvo.getT3() + " : "  %>
		<%= _tvo.getT4() + " : "  %>
		<%= _tvo.getT5() + " : "  %>
		<%= _tvo.getT6() + "<br>" %>
<% 		
		} // for(int i=0; i<aList.size(); i++)
		
	} // if(aList!=null && aList.size() > 0)

%>
</body>
</html>