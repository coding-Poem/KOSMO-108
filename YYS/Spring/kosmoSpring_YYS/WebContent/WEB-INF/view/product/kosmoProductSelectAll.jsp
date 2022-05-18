<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kosmo.product.vo.KosmoProductVO" %>    
<%@ page import="java.util.List" %>

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!-- 5000 을 5,000으로 만들어주는 클래스 -->
<%@ page import="a.b.c.com.kosmo.common.NumUtil" %>

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
	
	Object objPaging=request.getAttribute("pagingKVO");
	KosmoProductVO pagingKVO=(KosmoProductVO)objPaging;
	
	Object obj=request.getAttribute("listAll");
	List<KosmoProductVO> list=(List<KosmoProductVO>)obj;
	
	int nCnt=list.size();
	logger.info("nCnt >>> : "+nCnt);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/kosmoSpring_YYS/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready~~~");
		
	});
</script>
<style type="text/css">
	th {
		text-align: center;
	}
</style>
</head>
<body>
<h3>kosmoProductSelectAll.jsp</h3>
<h3>상품목록</h3>
<hr>
<form name="productList" id="productList">
<table border="1" align="center">
<thead>
	<tr>
		<th>사진</th>
		<th>내용</th>
		<th>가격</th>
	</tr>
</thead>	
<%
String mnum="";
String mprice="";

for(int i=0; i<nCnt; i++){
	KosmoProductVO kvo=list.get(i);
	mnum=kvo.getMnum();
	mprice=kvo.getMprice();
	mprice=NumUtil.comma(mprice);
	
	// 페이징 세팅
	pageSize=Integer.parseInt(pagingKVO.getPageSize());
	groupSize=Integer.parseInt(pagingKVO.getGroupSize());
	curPage=Integer.parseInt(pagingKVO.getCurPage());
	totalCount=Integer.parseInt(kvo.getTotalCount());
%>	
<tbody>	
	<tr>
		<td rowspan="4" align="center" style="width:100px;">
			<img src="/kosmoSpring_YYS/fileupload/board/<%= kvo.getMimg() %>" width="50" height="50" alt="이미지가 안 나와요"><br>
			<%= kvo.getMid() %>
		</td>	
		<td align="left" style="width:300px;">상품번호 : <%= mnum %></td>
		<td rowspan="4" align="center" vertical-align:"middle" style="width:150px;">
		<%= mprice %>&nbsp;&nbsp;
		<!-- GET방식으로 보낸다. -->
		<a href="kosmoProductMSelect.yys?mnum=<%= mnum %>">
			<img src="/kosmoSpring_YYS/image/img_mando/ase.gif" width="25" height="25" alt="image"> 
		</a>
		</td>
</tr>
<tr><td>상품설명 : <%= kvo.getMdes() %></td></tr>
<tr><td>제조사 : <%= kvo.getMcom() %></td></tr>
<tr><td>등록일 : <%= kvo.getMinsertdate() %></td></tr>
<%	
		}
%>
</tbody>
<tfoot>
<tr>
<td colspan="3">
	<jsp:include page="productPaging.jsp" flush="true">
		<jsp:param name="url" value="kosmoProductSelectAll.yys"/>
		<jsp:param name="str" value=""/>
		<jsp:param name="pageSize" value="<%= pageSize %>"/>
		<jsp:param name="groupSize" value="<%= groupSize %>"/>
		<jsp:param name="curPage" value="<%= curPage %>"/>
		<jsp:param name="totalCount" value="<%= totalCount %>"/>
	</jsp:include>
</td>
</tr>
</tfoot>
</table>
</form>
</body>
</html>