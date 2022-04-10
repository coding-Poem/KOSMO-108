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
<title>KOS_MEMBER UPDATE||DELETE</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	alert("JavaScript 진입 >>> : ");

	console.log("JavaScript 진입 >>> : ");
	$(document).ready(function(){
		alert("jQuery ready 함수 시작 >>> : ");

		// 수정 하기
		// <input type="button" value="수정" id="memupdate_btn_ok">
		$("#memupdate_btn_ok").click(function(){
			alert("memupdate_btn_ok 버튼 클릭 >>> : ");
			console.log("memupdate_btn_ok 버튼 클릭 >>> : ");
			// <form name="form_mem_update_ok" id="form_mem_update_ok">
			$("#form_mem_update_ok").attr(
					{
						"action":"/kosMember/jsp/memUpdateOk.jsp",
						"method":"GET"
					}
			).submit();
		})
		
		// 삭제 하기
		// <input type="button" value="삭제" id="memdeletedate_btn_ok">
		$("#memdeletedate_btn_ok").click(function(){
			alert("memdeletedate_btn_ok 버튼 클릭 >>> : ");
			console.log("memdeletedate_btn_ok 버튼 클릭 >>> : ");
			// <form name="form_mem_update_ok" id="form_mem_update_ok">
			$("#form_mem_update_ok").attr(
					{
						"action":"/kosMember/jsp/memDelete.jsp",
						"method":"GET"
					}
			).submit();	
		})
	}) // document ready
</script>

</head>
<body>
	<h3>KOS_MEMBER UPDATE or DELETE</h3>
	<hr>
	
	<form name="form_mem_update_ok" id="form_mem_update_ok">
	<table border="1" align="center">
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>	
<%
	// <input type="text" name="udmnum"  id="udmnum"/> 
    String udmnum = request.getParameter("udmnum");
    System.out.println("memUpdate :: jsp :: mnum >>> : " + udmnum);

    // memUpdate :: jsp :: mnum >>> : 456
    MemVO mvo = null;
    mvo = new MemVO();		
    mvo.setMnum(udmnum);
    
    MemService ms = new MemServiceImpl();	
    ArrayList<MemVO> aList = ms.memSelectNum(mvo);
    System.out.println("aList >>> : "+aList);
    
    if (aList !=null && aList.size() == 1) {
    	
    	MemVO _mvo = aList.get(0);
    	MemVO.printMemVO(_mvo);
%>	
	<tr>
	<td colspan="2" align="center">회원 글 수정하기</td>
	</tr>	
	<tr>
	<td align="center">MNUM</td>
	<td><input type="text" name="mnum" id="mnum" size="25"  readonly value="<%= _mvo.getMnum() %>"></td>
    </tr>
    <tr>
    	<td align="center">MNAME</td>
    	<td><input type="text" name="mname" id="mname" size="25" maxlength="50"  value="<%= _mvo.getMname() %>"></td>
    </tr>
    <tr>
    	<td  align="center">MID</td>
    	<td><input type="text" name="mid" id="mid" size="25" maxlength="50"  value="<%= _mvo.getMid() %>" required /></td>			
    </tr>
    <tr>
    	<td  align="center">MPW</td>
    	<td><input type="text" name="mpw" id="mpw" size="50" maxlength="300" value="<%= _mvo.getMpw() %>" required /></td>			
    </tr>						
    <tr>
    	<td  align="center">MHP</td>
    	<td><input type="text" name="mhp" id="mhp" size="20" maxlength="16" value="<%= _mvo.getMhp() %>" required /></td>
    </tr>
    <tr>
    	<td  align="center">MEMAIL</td>
    	<td><input type="text" name="memail" id="memail" size="50" maxlength="200"  value="<%= _mvo.getMemail() %>" required /></td>
    </tr>
    <tr>
    	<td  align="center">MGENDER</td>
    	<td><input type="text" name="mgender" id="mgender" size="20" maxlength="10" value="<%= _mvo.getMgender() %>"></td>
    </tr>
    <tr>
    	<td  align="center">MHOBBY</td>
    	<td><input type="text" name="mhobby" id="mhobby" size="25" maxlength="100"  value="<%= _mvo.getMhobby() %>"></td>
    </tr>
    <tr>
    	<td  align="center">MLOCAL</td>
    	<td><input type="text" name="mlocal" id="mlocal" size="50" maxlength="200"  value="<%= _mvo.getMlocal() %>"></td>
    </tr>
    <tr>
    	<td  align="center">MMSG</td>
    	<td><input type="text" name="mmsg" id="mmsg" size="250" maxlength="2000"  value="<%= _mvo.getMmsg() %>"></td>
    </tr>
    <tr>
    	<td  align="center">DELETEYN</td>
    	<td><input type="text" name="deleteyn"   size="20" disabled value="<%= _mvo.getDeleteyn() %>"></td>
    </tr>
    <tr>
    	<td  align="center">UPDATEDATE</td>
    	<td><input type="text" name="updatedate" size="25" disabled value="<%= _mvo.getUpdatedate() %>"></td>
    </tr>
    <tr>
    	<td colspan="2" align="center">		
    		<input type="button" value="수정" id="memupdate_btn_ok">
    		<input type="button" value="삭제" id="memdeletedate_btn_ok">							
    	</td>	
    </tr>
<%
    }
%>
	</table>	
	</form>
</body>
</html>