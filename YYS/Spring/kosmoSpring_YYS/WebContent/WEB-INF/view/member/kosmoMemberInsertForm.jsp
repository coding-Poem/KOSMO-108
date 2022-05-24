<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<!--  디바이스에 최적화된 크기로 출력됨 -->
<meta name="viweport" content="width=device-width, iitail-scale=1" />
<!-- jQUery CDN 불러오기 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 다음 주소록 OPEN API CDN 불러오기 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("jQuery ready~~~~");
		
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
		
		// 비밀번호 체크
		$("#kmpwCheck").click(function(){
			alert("비밀번호 체크 버튼 클릭 >>> : ");
			var pw=$("#kmpw").val();
			var pw_r=$("#kmpw_r").val();
			alert(pw+" : "+pw_r);
			if(pw==pw_r){
				alert("비밀번호가 같습니다 >>> : ");
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
		
		// form 태그에 바인딩 된 데이터 jsp로 보내기
		$("#insertBtn").click(function(){
			alert("데이터를 넘기도록 하겠습니다 >>> : ");
			$("#kosmoMemberInsert").attr({
				"action":"kosmoMemberInsert.yys",
				"method":"POST",
				"enctype":"multipart/form-data"
			}).submit();
			
		});
	
	}); // jQuery ready function
</script>
</head>
<body>
<h3>회원 가입 페이지 입니다.</h3>
<hr>
<form name="kosmoMemberInsert" id="kosmoMemberInsert">
<table border="1" class="align">
	<tr>
		<td colspan="2" class="align">회원 가입</td>				
	</tr>
	<tr>
		<td class="align">회원아이디</td>
		<td>
				<input type="text" name="kmid" id="kmid" size="25">
				<input type="button" id="kmidCheckBtn" name="kmidCheckBtn" value="아이디중복확인" >
		</td>
	</tr>
	<tr>
		<td  class="align">회원비밀번호</td>
		<td>
			<input type="password" name="kmpw" id="kmpw" size="25"><br>
			<input type="password" name="kmpw_r" id="kmpw_r" size="25" placeholder="비밀번호 확인"><br>
			<input type="button" name="kmpwCheck" id="kmpwCheck" value="비밀번호 확인">
		</td>
	</tr>	
	<tr>
		<td  class="align">회원이름</td>
		<td><input type="text" name="kmname" id="kmname" size="25"></td>
	</tr>
	<tr>
		<td  class="align">회원휴대폰번호</td>
		<td>
			<select name="kmhp" id="kmhp" style="width:50px;">
			    <option value="010">010</option>
			    <option value="011">011</option>
			    <option value="016">016</option>
			    <option value="017">017</option>
			</select>
			- <input type="text" name="kmhp1" id="kmhp1" maxlength="4" size="4"/>
			- <input type="text" name="kmhp2" id="kmhp2" maxlength="4" size="4"/>
		</td>
	</tr>
	<tr>
		<td  class="align">회원이메일</td>
		<td>
			<input type="text" name="kmemail" id="kmemail" size="7">
			@ <input type="text" name="kmemail1" id="kmemail1" size="7">
			<select name="kmemail2" id="kmemail2">
				<option value="1" selected>직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="daum.net">daum.net</option>
		</select>
		</td>
	</tr>
	<tr>
		<td  class="align">회원우편번호</td>
		<td>
			<input type="text" name="kmzone" id="kmzone" placeholder="우편번호" size="25"><br>
			<input type="button" name="kmzone_btn" id="kmzone_btn" value="우편번호 찾기"><br>
			<input type="text" name="kmroad" id="kmroad" placeholder="회원도로명주소" size="25"><br>
			<input type="text" name="kmroad2" id="kmroad2" placeholder="회원도로명상세주소" size="25"><br>
			<input type="text" name="kmjibun" id="kmjibun" placeholder="지번주소" size="25">
		</td>
	</tr> 
	<tr>
		<td  class="align">회원사진</td>
		<td><input type="file" name="kmimage" id="kmimage" size="25"></td>
	</tr>
	<tr>
		<td colspan="2" class="align">				
		<input type="button" value="회원가입" id="insertBtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>