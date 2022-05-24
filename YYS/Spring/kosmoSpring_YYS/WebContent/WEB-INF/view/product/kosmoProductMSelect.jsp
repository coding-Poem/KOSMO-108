<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kosmo.product.vo.KosmoProductVO" %> 
<%@ page import="java.util.List" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
      
<!-- 
추가 요구사항
장바구니에 담을 때, alert으로 담을지 물어보기
몇 개 골랐는지 알려주기
한 번에 여러개 담게 하기

select => update

select = 0 => insert
select > 1 => update
 -->    
<% request.setCharacterEncoding("UTF-8");%>    

<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("kosmoProductMSelect.jsp 페이지 입니당 >>> : ");
	Object obj = request.getAttribute("listS");
	List<KosmoProductVO> list = (List)obj;
	
	String mprice = "";
	KosmoProductVO _kvo = null;
	if (list.size() == 1) {
		
		_kvo = list.get(0);
		mprice = _kvo.getMprice();
	}
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kosmoProdctMSelect</title>
<script type="text/javascript" src="/kosmoSpring_YYS/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready~~~~");
		let mprice='<%= mprice %>';
		console.log("before comma mprice >>> : "+mprice);
		mprice=comma(mprice);
		console.log("after comma mprice >>> : "+mprice);
		
		$("#mprice").val(mprice);
		
		$(document).on("change", "#mcnt", function(){
			let cntS=$("#mcnt").val();
			console.log("cntS >>>> : "+cntS);
			let mpricesum=comma_replace(mprice)*cntS;
			console.log("mpricesum >>> : "+mpricesum);
			
			console.log("comma(mpricesum) >>> : "+comma(mpricesum));
			$("#mpricesum").val(comma(mpricesum));
		});
		
		$(document).on("click","#cartBtn", function(){
			
			let mcntV=$("#mcnt").val();
			console.log("mcntV >>> : "+mcntV);
			
			let pricesum=$("#mpricesum").val();
			console.log("pricesum >>> : "+pricesum);
			
			if(mcntV==0 && pricesum==0){
				alert("수량을 선택하세요~");
				
				return;
			}
			
			$("#productSelectForm").attr({
				"action":"kosmoCartInsert.yys",
				"method":"GET"
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
			
		});
		
	});

</script>
<style type = "text/css">
			table {
				
				margin : 20px auto;
			
			}
			
			table, td, th {
			
				border-collapse : collapse;
				border : 1px solid black;
			
			};
</style>
</head>
<body>
<h3>Kosmo Product Merchandise Select jsp</h3>
<hr>
<div>
<form name = "productSelectForm" id = "productSelectForm" >
<table>
	<tr>
		<td rowspan = "7" align = "center" vertical-align = "middle" style = "width:200px;">
		<img src = "/kosmoSpring_YYS/fileupload/board/<%= _kvo.getMimg() %>" width = "130" height = "130">
		</td>
		<td align = "center" colspan = "2">
		<input	type = "text" name = "mname" id = "mname" value = "<%= _kvo.getMname() %>"
				style = "width : 300px; text-align : center;" readonly/>
		</td>
	</tr>
	<tr>
		<td>가격 : </td>
		<!-- <td align = "right" colspan = "2">  -->
		<td align = "right">
			<input	type = "text" name = "mprice" id = "mprice" value = "<%= mprice %>"
					style = "width: 280; text-align = right;" readonly />
		</td>
	</tr>
	<tr>
		<td>
			<label align = "left"> 수량 :</label>
		</td>
		<td align = "right">
			<select name = "mcnt" id = "mcnt" style = "width : 200px;">
				<option value = "0">수량</option>
				<option value = "1">1</option>
				<option value = "2">2</option>
				<option value = "3">3</option>
				<option value = "4">4</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>
		 <label align = "left">총 합계 : </label>
		</td>
		<td align = "right">
		<input 	type="text" name="mpricesum" id="mpricesum" value="0" 
				style="width:170px;text-align:right;" readonly />&nbsp;원
		</td>
		</tr>
	<tr>
		<td align="center" colspan="2">
			<input type="hidden" name="mimg" id="mimg" value="<%= _kvo.getMimg() %>" >
			이미지 이름 : <%  out.println( _kvo.getMimg()); %> <br>
			<input type="hidden" name="mid" id="mid" value="<%= _kvo.getMid() %>" >
			<input type="hidden" name="mnum" id="mnum" value="<%= _kvo.getMnum() %>" >
			상품번호 : <%  out.println( _kvo.getMnum()); %> <br>
			<input type="hidden" name="mcnum" id="mcnum" value="C202205180001" >
			<input type="button" id="cartBtn" value="장바구니" style="width:150px;">
			<input type="button" id="stockBtn" value="재고확인" style="width:155px;">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>