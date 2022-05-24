<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- log 4j -->
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="a.b.c.com.kosmo.cart.vo.KosmoCartVO" %> 
<%@ page import="java.util.List" %>  

<%@ page import="a.b.c.com.kosmo.common.NumUtil" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger=LogManager.getLogger(this.getClass()); 
	logger.info("kosmoCartSelectAll.jsp 페이지 입니다 >>> : ");
	
	String strPage="";
	strPage=request.getParameter("page");
	logger.info("page >>> : "+strPage);
	
if(strPage.equals("insert")){
	Object obj = request.getAttribute("listAll");
	List<KosmoCartVO> list = (List<KosmoCartVO>)obj;
	
	int nCnt = list.size();
	logger.info("nCnt >>> : " + nCnt);	
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
		alert("jQuery ready~~");		
		
		$(document).on("click", "#chek", function(){
			if($(this).prop('checked')){
				$(".mcnum").prop('checked', true);
			}else{
				$(".mcnum").prop('checked', false);
			}
		});
		
		// 주문하기 버튼
		$(document).on("click", "#buyBtn", function(){
			alert("주문하기 버튼을 클릭하셨습니다 >>> : ");
			location.href="/kosmoSpring_YYS/kosmoLoginForm.yys"
		});
		
		// 쇼핑하기 버튼
		$(document).on("click", "#shopingBtn", function(){
			alert("쇼핑하기 버튼을 클릭하셨습니다 >>> : ");
			location.href="/kosmoSpring_YYS/kosmoProductSelectAll.yys"
		});
		
		// 선택삭제 버튼
		$(document).on("click", "#delBtn", function(){
			alert("선택삭제 버튼을 클릭하셨습니다 >>> : ");
		});
		
		// 장바구니 비우기
		$(document).on("click", "#delAllBtn", function(){
			alert("장바구니 버튼을 클릭하셨습니다 >>> : ");
			$("#productList").attr({
				"action":"/kosmoSpring_YYS/kosmoCartDeleteAll.yys",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});		
	});
</script>
</head>
<body>
<h3 align="center">장바구니</h3>
<hr>
<form name="productList" id="productList">
<table border="1" align="center">
<thead>
<tr>
	<td align="center">
		<input type="checkbox" name="chek" id="chek" class="chek">
	</td>
	<td align="center">상품명</td>
	<td align="center">가격</td>
	<td align="center">수량</td>
	<td align="center">합계</td>	
	<td align="center">적립금</td>	
	<td align="center">배송비</td>
	<td align="center">관심상품/삭제</td>		
</tr>
</thead>
<%
String mnum = "";
String mprice = "";
String mpricesum = "";
String kmnum="";
int payment=0;
String totalpayment="";

for(int i=0; i<nCnt; i++){		
	KosmoCartVO _cvo = list.get(i);
	mprice = NumUtil.comma(_cvo.getMprice());
	mpricesum = NumUtil.comma(_cvo.getMpricesum());
	kmnum=_cvo.getKmnum();
%>
<tbody>
<tr>
	<td align="center">
		<input type="checkbox" name="mcnum" id="mcnum" class="mcnum" value=<%= _cvo.getMcnum() %> >
	</td>		
	<td class="tt">
		<img src="/kosmoSpring_YYS/fileupload/board/<%= _cvo.getMimg() %>" width="50" height="50" alt="이미지가 안 나와요"><br>
		<%= _cvo.getMid() %> 
	</td>
	<td class="tt"><%= mprice %> </td>
	<td class="tt"><%= _cvo.getMcnt() %> </td>
	<td class="tt"><%= mpricesum %> </td>
	<td class="tt">적립금</td>
	<td class="tt">배송비</td>
	<td class="tt" align="center">		
		<input type="button" value="관심상품" /><br>
		<input type="button" value="삭제" id="dbtn"/><br>
	</td>	
</tr>
<%
	payment=payment+Integer.parseInt(NumUtil.comma_replace(mpricesum));
	logger.info("payment >>> : "+payment);
	}
	totalpayment=NumUtil.comma(String.valueOf(payment));
%>	
<input type="hidden" id="kmnum" name="kmnum" value=<%= kmnum  %>>
<tr>
<td colspan="8" align="right">장바구니 총합 금액 <input type="text" id="totalpayment" value=<%= totalpayment %>  disabled> 원</td>
</tr>
<tr>
<td colspan="8" align="right">
	결제 예정금액 <font size="5" style="color:red;"><input type="text" id="totalpayment" value=<%= totalpayment %>  disabled></font>원
</td>
</tr>
<tr>
	<td colspan="8" align="left">		
		<input type="button" value="선택삭제" id='delBtn'>	
		<input type="button" value="장바구니 비우기" id='delAllBtn'>
		 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		<input type="button" value="쇼핑하기" id='shopingBtn'>							
		<input type="button" value="주문하기" id='buyBtn'>							
	</td>
</tr>					
</tbody>			
</table>
</form>	
<%
}else{
%>
	<h3>장바구니가 담은 상품이 없습니다.</h3>
<%
}	
%>
</body>
</html>