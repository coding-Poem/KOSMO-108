<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- log4 객체 import  --> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
    
<!-- PasswordUtil 객체 import  -->    
<%@ page import="a.b.c.common.PasswordUtil" %> 
<%@ page import="a.b.c.common.EncryptAES" %> 
<%@ page import="a.b.c.common.EncryptSHA" %>  

<!-- mail 객체 import  -->    
<%@ page import="a.b.c.test.mail_p.GmailSend"%>
<%@ page import="a.b.c.test.mail_p.GmailVO"%>

<% request.setCharacterEncoding("UTF-8"); %>    
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("pwTempSend.jsp 페이지 >>> : ");
	
	String mhp=request.getParameter("mhp");
	String memail=request.getParameter("memail");
	
	boolean bool=false;
	// 임시 비밀번호를 보내기 위해 회원 정보에서 핸드폰과 이메일 확인
	
	bool=true;
	
	if(bool){
		// 임시 패스워드 불러오기
		String tempPw=PasswordUtil.randomPW(8);
		// UUID 사용하는 방식이 아니라 randomPw 함수에서 char 배열에서
		// 8자리까지 랜덤으로 이어 붙여서 String으로 리턴해서 온다.
		
		int nCnt=0;
		// 패스워드 DB에 저장하기 : 암호화 할 것인가 고민해 볼 것
		EncryptAES ase=EncryptAES.getInstance();
		
		// 암호화 한 값을 String으로 받아옵니다.
		String encryptTempPw=ase.aesEncode(tempPw);
		logger.info("encryptTempPw >>> : "+encryptTempPw);
		
		// DB에 저장하기
		// DB에 저장된 암호화된 임시 비밀번호를 복호화 해서 메일 보내기
		String decryptTempPw=ase.aesDecode(encryptTempPw);
		logger.info("decryptTempPw >>> : "+decryptTempPw);
		
		if(nCnt==1){
			// 메일 보내기
			String mailsubject="임시 비밀번호 보내기";
			String sendmail="보내는 사람 메일 주소";
			String mailpw="보내는사람 메일주소 비밀번호";
			String resivemail="받는사람 메일 주소";
			String sendmsg="임시비밀번호 및 메시지"+tempPw;
			
			GmailVO gvo=null;
			gvo=new GmailVO();
			gvo.setMailsubject(mailsubject);
			gvo.setSendmail(sendmail);
			gvo.setResivemail(sendmsg);
			gvo.setSendmsg(sendmsg);
			
			GmailSend gms=new GmailSend();
			gms.gmailSend(gvo);
		}
	}
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>pwTempSend</h3>
</body>
</html>