<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kosmo.member.vo.KosmoMemberVO" %> 
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

 <% request.setCharacterEncoding("UTF-8");%> 
 <%
 	Logger logger=LogManager.getLogger(this.getClass());
 	logger.info("kosmoMemberSelect.jsp 페이지 입니다 >>>> : ");
 	
 	Object obj = request.getAttribute("searchList");
 	if(obj==null) return;
 	
 	List<KosmoMemberVO> list=(List<KosmoMemberVO>)obj;
 	int nCnt=list.size();
 	
 	String kmhp="";
 	String kmemail="";
 	
 	String kmhpList[]=null;
 	String kmhp0="";
 	String kmhp1="";
 	String kmhp2="";
 	
 	String kmemailList[]=null;
 	String kmemail1="";
 	String kmemail2="";
 	
 	KosmoMemberVO _kmvo=null;
 	
 	if(nCnt==1){
 		_kmvo=list.get(0);
 		kmhp=_kmvo.getKmhp();
 		logger.info("kmhp >>> : "+kmhp);
 		kmemail=_kmvo.getKmemail();
 		logger.info("kmemail >>> : "+kmemail);
 		
 		kmhpList=kmhp.split("-");
 		kmhp0=kmhpList[0];
 		kmhp1=kmhpList[1];
 		kmhp2=kmhpList[2];
 		
 		kmemailList=kmemail.split("@");
 		kmemail1=kmemailList[0];
 		kmemail2=kmemailList[1];
 			
 		logger.info("kmid >>> : "+_kmvo.getKmid());
 		logger.info("kmpw >>> : "+_kmvo.getKmpw());
 		logger.info("kmname >>> : "+_kmvo.getKmname());
 		logger.info("kmhp0 >>> : "+kmhp0);
 		logger.info("kmhp1 >>> : "+kmhp1);
 		logger.info("kmhp2 >>> : "+kmhp2);
 		logger.info("kmemail1 >>> : "+kmemail1);
 		logger.info("kmemail2 >>> : "+kmemail2);
 		
 		logger.info("kmzone >>> : "+_kmvo.getKmzone());
 		logger.info("kmroad >>> : "+_kmvo.getKmroad());
 		logger.info("kmroad2 >>> : "+_kmvo.getKmroad2());
 		logger.info("kmjibun >>> : "+_kmvo.getKmjibun());
 		logger.info("minsertdate >>> : "+_kmvo.getMinsertdate());
 		logger.info("mupdatedate >>> : "+_kmvo.getMupdatedate());
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready~");
		
		// 아이디 중복체크
		$("#kmidCheckBtn").click(function(){
			alert("midCheckBtn 함수 진입 >>> : ");
			
			let urlVal="/kosmoSpring_YYS/kosmoMemberIdcheck.yys";
			let typeVal="POST";
			let kmidVal=$("#kmid").val();
			
			if(kmidVal==''){
				alert("중복 체크할 아이디를 입력하세요 >>> : ");
				$("#kmid").focus();
				return false;
			}
			
			console.log("urlVal >>> : "+urlVal);
			console.log("typeVal >>> : "+typeVal);
			console.log("kmidVal >>> : "+kmidVal);
			
			$.ajax({
				url:urlVal,
				type:typeVal,
				data:{
					"kmid":kmidVal
				},
				success:whenSuccess,
				error:whenError
			});
			
			function whenSuccess(resData){			
				if (resData == 'ID_YES'){
					alert("사용할 수 있는 아이디 입니다.");
					$("#kmid").focus();
				}else{
					alert("아이디가 이미 있습니다.");
					$("#kmpw").focus();
				}
			}
			 
			function whenError(){
				alert("error");
			}
			
		});
		
		$("#kmpwChange").click(function(){
			alert("비밀번호 변경 버튼 >>> : ");
			$("#kmpw").prop("readonly", false);
			$("#kmpw_r").prop("readonly", false);
			
		});
		
		
		// 비밀번호 체크
		$("#kmpwCheck").click(function(){
			alert("비밀번호 체크 버튼 클릭 >>> : ");
			var pw=$("#kmpw").val();
			var pw_r=$("#kmpw_r").val();
			alert(pw+" : "+pw_r);
			if(pw==pw_r){
				alert("비밀번호가 변경되었습니다.  >>> : ");
				// $("#kmpw_r").val(' ');
				$("#kmname").focus();
				return true;
			}
			else{
				alert("비밀번호가 다릅니다 >>> : ");
				$("#kmpw").val(' ');
				$("#kmpw_r").val(' ');
				$("#kmpw").focus();
				return false;
			}
		});
		
		
		// 이메일
		$("#kmemail2").change(function(){
			$("#kmemail2 option:selected").each(function(){
				// 직접입력일 경우
				if($(this).val()==1){
					var aa=$("#kmemail1").val();
					$("#kmemail1").val(' '); // 값 초기화
					$("#kmemail1").attr("readonly", false);
					}else{
						$("#kmemail1").val($(this).text()); // 선택값 입력
						$("#kmemail1").attr("readonly", true); // 비활성화
					}
			});
		}); // change function
		
		// 우편번호
		$("#kmzone_btn").click(function(){
			alert("우편번호 찾기 >>> : ");
			new daum.Postcode({
				oncomplete: function(data){
					$("#kmzone").val(data.zonecode); // 5자리 새우편번호 사용
					$("#kmroad").val(data.roadAddress); // 도로명 주소
					$("#kmjibun").val(data.jibunAddress); // 지번주소
				}
			}).open();
		}); 
		
		
		$("#updatebtn").click(function(){
			alert("update 버튼 클릭 >>> : ");
			$("#kosmoMemberSelect").attr({
				"action":"kosmoMemberUpdate.yys",
				"method":"POST",
				"enctype":"multipart/form-data"
			}).submit();
		});
		
		$("#deletebtn").click(function(){
			alert("delete 버튼 클릭 >>> : ");
			var vkmnum=$("#kmnum").val();
			var vmdeleteyn=$("#mdeleteyn").val();
			console.log("kmnum >>> : "+kmnum);
			console.log("mdeleteyn >>> : "+mdeleteyn);
			location.href="/kosmoSpring_YYS/kosmoMemberDelete.yys?kmnum="+vkmnum+"&mdeleteyn="+vmdeleteyn;
		});
		
	});

</script>
<style type="text/css">
	body{
		text-align:center;
	}
	
	table, tr, td{
		border:1px solid black;
		text-align:center;
	}
	tt{
		border:1px solid black;
		text-align:center;
	}
		
	img{
		height:150px;
		width:150px;
		border-radius:60%;
	}
</style>
</head>
<body>
<h3>회원정보</h3>
<hr>
<form name="kosmoMemberSelect" id="kosmoMemberSelect">
<table class="align">
	<tr>
		<td colspan="2" class="align">회원 정보</td>	
	</tr>
	<tr>
		<td  class="tt">회원사진</td>
		<td><img src="/kosmoSpring_YYS/fileupload/member/<%= _kmvo.getKmimage() %>" width="50" height="50" alt="이미지가 안 나와요"><br>
			이미지 변경하기 : <input type="file" name="kmimage" id="kmimage">
		</td>
	</tr>	
	<tr>	
		<td  class="tt">회원아이디</td>
		<td>
			<input type="text" name="kmid" id="kmid"  value=<%= _kmvo.getKmid()  %> size="25">
			<input type="button" id="kmidCheckBtn" name="kmidCheckBtn" value="아이디중복확인" >	
		</td>
	</tr>
	<tr>	
		<td  class="tt">회원비밀번호</td>
		<td>
			<input type="password" name="kmpw" id="kmpw" placeholder="아래에서 비밀번호 확인 후 변경" value=<%= _kmvo.getKmpw()  %> readonly size="25"><br>
			<input type="password" name="kmpw_r" id="kmpw_r" placeholder="비밀번호 변경 버튼 클릭 후 입력"  readonly size="25"><br>
			<input type="button" name="kmpwChange" id="kmpwChange" value="비밀번호 변경  버튼">
			<input type="button" name="kmpwCheck" id="kmpwCheck" value="비밀번호 변경하기">
		</td>
	</tr>	
	<tr>	
		<td  class="tt">회원이름</td>
		<td><input type="text" name="kmname" id="kmname" value=<%= _kmvo.getKmname() %> size="25"></td>
	</tr>
	<tr>	
		<td  class="tt">회원휴대폰번호</td>
		<td>
		<input type="text" name="kmhp" id="kmhp" value=<%= kmhp0  %> size="8">
		- <input type="text" name="kmhp1" id="kmhp1" value=<%= kmhp1  %> size="8">
		- <input type="text" name="kmhp2" id="kmhp2" value=<%= kmhp2  %> size="8">
		</td>
	</tr>
	<tr>	
		<td  class="tt">회원이메일</td>
		<td>
			<input type="text" name="kmemail" id="kmemail" value=<%= kmemail1 %> size="14">
			@ <input type="text" name="kmemail1" id="kmemail1" value=<%= kmemail2 %> size="14">
			<select name="kmemail2" id="kmemail2">
				<option value="1" selected>직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="daum.net">daum.net</option>
			</select>
		</td>		
	</tr>
	<tr>
		<td  class="tt">회원우편번호</td>
		<td>
			<input type="text" name="kmzone" id="kmzone" value=<%= _kmvo.getKmzone()  %> size="20">
			<input type="button" name="kmzone_btn" id="kmzone_btn" value="우편번호 찾기">
		</td>
	</tr>
	<tr>		
		<td  class="tt">회원도로명주소</td>
		<td>
			<input type="text" name="kmroad" id="kmroad" value=<%= _kmvo.getKmroad() %> size="25">
		</td>
	</tr>
	<tr>
		<td  class="tt">회원도로명상세주소</td>
		<td>
			<input type="text" name="kmroad2" id="kmroad2" value=<%= _kmvo.getKmroad2() %> size="25">
		</td>
	</tr>
	<tr>
		<td class="tt">지번주소</td>
		<td>
			<input type="text" name="kmjibun" id="kmjibun" value=<%= _kmvo.getKmjibun() %> size="25">
		</td>
	</tr>
	<tr>
		<td class="tt">회원유무</td>	
		<td>
			<input type="text" name="mdeleteyn" id="mdeleteyn" value=<%= _kmvo.getMdeleteyn() %> readonly size="25"> 
		</td>
	</tr>
	<tr>
		<td class="tt">등록일</td>
		<td><input type="text" name="minsertdate" id="minsertdate" value=<%= _kmvo.getMinsertdate() %> readonly size="25"></td>
	</tr>
	<tr>	
		<td class="tt">수정일</td>
		<td>
			<input type="text" name="mupdatedate" id="mupdatedate" value=<%= _kmvo.getMupdatedate() %> readonly size="25">
		</td>
	</tr>
	<tr>		
		<td colspan="12"><input type="button" id="updatebtn" name="updatebtn" value="회원수정" id="updateBtn"><input type="button" id="deletebtn" name="deletebtn" value="회원삭제" id="insertBtn"></td>		
	<tr>
</table>
<input type="hidden" id="kmnum" name="kmnum" value=<%= _kmvo.getKmnum() %>>
</form>
</body>
</html>