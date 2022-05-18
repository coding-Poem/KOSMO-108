<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="a.b.c.com.kosmo.member.vo.KosmoMemberVO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 한글 깨짐 방지 -->
<% request.setCharacterEncoding("UTF-8"); %>   
<%
	Logger logger=LogManager.getLogger(this.getClass()); 
	logger.info("kosmoProductSelectAll.jsp 페이지 입니당 >>> : ");
	
	// 페이징 변수 세팅
	int pageSize=0;
	int groupSize=0;
	int curPage=0;
	int totalCount=0;
	
	Object objPaging=request.getAttribute("pagingKMVO");
	KosmoMemberVO pagingKMVO=(KosmoMemberVO)objPaging;
	
	Object obj=request.getAttribute("listAll");
	List<KosmoMemberVO> list=(List<KosmoMemberVO>)obj;
	
	int nCnt=list.size();
	logger.info("nCnt >>> : "+nCnt);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>kosmoProductSelectAll.jsp</h3>
<h3>회원목록</h3>
<hr>
<form name="memberList" id="memberList">
<table border="1" align="center">
<thead>
	<tr>
		<th>사진</th>
		<th>내용</th>
	</tr>
</thead>	
<%
String kmnum="";

for(int i=0; i<nCnt; i++){
	KosmoMemberVO kmvo=list.get(i);
	kmnum=kmvo.getKmnum();
	
	// 페이징 세팅
	pageSize=Integer.parseInt(pagingKMVO.getPageSize());
	groupSize=Integer.parseInt(pagingKMVO.getGroupSize());
	curPage=Integer.parseInt(pagingKMVO.getCurPage());
	totalCount=Integer.parseInt(kmvo.getTotalCount());
%>
<tbody>
<tr>
		<td rowspan="2" align="center" style="width:100px;">
			<img src="/kosmoSpring_YYS/fileupload/member/<%= kmvo.getKmimage() %>" width="50" height="50" alt="이미지가 안 나와요"><br>
			<%= kmvo.getKmid() %>
		</td>	
		<td align="left" style="width:300px;">회원번호 : <%= kmnum %></td>
</tr>
<tr><td>회원가입일 : <%= kmvo.getMinsertdate() %></td></tr>
<%	
}
%>
</tbody>
</table>
</form>	
</body>
</html>