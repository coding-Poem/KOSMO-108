<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="a.b.c.com.kosmo.product.vo.KosmoProductVO" %>   
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>kosmoProductSelect.jsp 페이지 입니당</h3>
<hr>
<table>
	<tr>
		<!-- <td>상품번호</td>  -->
		<!-- <td>상품아이디</td>   -->
		<!-- <td>수량</td>  -->
		<td>상품명</td>
		<td>가격</td>
		<td>상품설명</td>
		<td>상품제조사</td>
		<td>이미지파일</td>
		<td>등록일</td>
		<!-- <td>수정일</td>  -->
		<!-- <td>상품등록여부</td>  -->
	</tr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("kosmoProductSelect.jsp 페이지 입니당 >>> : ");
	
	Object obj = request.getAttribute("searchList");
	if (obj == null){ return; }
	
	List<KosmoProductVO> list=(List<KosmoProductVO>)obj;
	if(list.size()>0){
		for(int i=0; i<list.size(); i++){
			KosmoProductVO kvo=list.get(i);
%>			
	<tr>
		<!--  <td><= kvo.getMnum()    %></td> -->
		<!-- <td><= kvo.getMid()    %></td>  -->
		<!--  <td><= kvo.getMcnt()    %></td>  -->
		<td><%= kvo.getMname()    %></td>
		<td><%= kvo.getMprice()    %></td>
		<td><%= kvo.getMdes()    %></td>
		<td><%= kvo.getMcom()    %></td>
		<td><img src="/kosmoSpring_YYS/fileupload/board/<%= kvo.getMimg() %>" width="50" height="50" alt="이미지가 안 나와요"></td>
		<td><%= kvo.getMinsertdate()    %></td>
		<!-- <td><= kvo.getMupdatedate()    %></td>  -->
		<!-- <td><= kvo.getMdeleteyn()    %></td>  -->
	</tr>
			
<% 
		}
	}
%>

</body>
</html>