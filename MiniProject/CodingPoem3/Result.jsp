<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.codepoemVO.CodingPoemVO" %>
<%@ page import="a.b.c.codepoem.CodingPoem" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Result</title>
	</head>
	<body>
	<h3>Result.jpg</h3>
	<hr>
<% 		
		Logger log = LogManager.getLogger(this.getClass());
		
		//CoingPoem.jsp에서 보낸 데이터 받아오기
		String p1 = (String)request.getAttribute("p1");
		String p2 = (String)request.getAttribute("p2");
		String p3 = (String)request.getAttribute("p3");
		String p4 = (String)request.getAttribute("p4");
		String p5 = (String)request.getAttribute("p5");
		String p6 = (String)request.getAttribute("p6");
		//받아온 값 로그 찍어보고
		//log.info("p1 >>> :" +p1);
		//log.info("p2 >>> :" +p2);
		//log.info("p3 >>> :" +p3);
		//log.info("p4 >>> :" +p4);
		//log.info("p5 >>> :" +p5);
		//log.info("p6 >>> :" +p6);
%>
	 
		&lt;jsp:useBean id = "user" class="com.personInfo.personInfo" scope="page"/&gt;<br>
		id : 생성할 객체(인스턴스)의 이름을 정의(생략불가)<br>
		class : 객체를 생성할 클래스명을 정의 (패키지명.클래스명으로 설정)<br>
		scope : 자바빈 객체가 공유되는 범위를 지정 (scope 생략시 기본값은 page)<hr>
		
		<jsp:useBean id="VO" class="a.b.c.codepoemVO.CodingPoemVO" scope="request"/>
		
		<br>
		
		&lt;jsp:setProperty name="객체명" property ="프로퍼티 명(필드명)" value="설정값"/&gt;<br>
		name : useBean을 이용해 생성한 객체 이름을 명시<br>
		property : 값을 저장할 프로퍼티의 이름을 명시<br>
		value : 저장할 값을 정의<hr>
		
		<br>
		
		<jsp:setProperty name="VO" property="*"/>
		<!--어머나 놀라워라 이름만 잘 맞추면 한번에 가능합니다.
		<jsp:setProperty name="VO" property="p1"  value="<%=p1 %>"/>
		<jsp:setProperty name="VO" property="p2"  value="<%=p2 %>"/>
		<jsp:setProperty name="VO" property="p3"  value="<%=p3 %>"/>
		<jsp:setProperty name="VO" property="p4"  value="<%=p4 %>"/>
		<jsp:setProperty name="VO" property="p5"  value="<%=p5 %>"/>
		<jsp:setProperty name="VO" property="p6"  value="<%=p6 %>"/>
		-->
		
		
		
		 getProperty 액션태그는 자바빈 파일의 getter 메서드를 사용하기 위해, 즉 저장된 데이터의 값을 읽어올 때 사용된다. <br>
		 형식은 아래와 같다.(참고로 getProperty 액션태그는 거의 사용하지 않는다.)<br>
		&lt;jsp:getProperty name="빈이름" property="필드명" /&gt;<hr>
		<!--<jsp:getProperty name="VO" property="p1"  /><br>
		<jsp:getProperty name="VO" property="p2"  /><br>
		<jsp:getProperty name="VO" property="p3"  /><br>
		<jsp:getProperty name="VO" property="p4"  /><br>
		<jsp:getProperty name="VO" property="p5"  /><br>
		<jsp:getProperty name="VO" property="p6"  /><br>-->
		<br>
		<br>
		
		결론====================================================<br>
		&lt;jsp:useBean id="VO" class="a.b.c.codepoemVO.CodingPoemVO" scope="request"/&gt;<br>
		&lt;jsp:setProperty name="VO" property="*"/&gt;<br>
		
		이 두줄로 <br>
		
		//VO에 담을 준비<br>
		CodingPoemVO cpvo = null;<br>
		cpvo = new CodingPoemVO();<br>
	
		//VO에 담고<br>
		cpvo.setP1(p1);<br>
		cpvo.setP2(p2);<br>
		cpvo.setP3(p3);<br>
		cpvo.setP4(p4);<br>
		cpvo.setP5(p5);<br>
		cpvo.setP6(p6);<br>
		
		이걸 줄일 수 있었다.<br>
		======================================================<br>
		<br>
		<br>
		<br>
		
		
	
		뽑기결과====================================================<br>
		
<%		//<jsp:useBean id="VO" class="a.b.c.codepoemVO.CodingPoemVO" scope="request"/>
		//에서 참조변수명(id)를 VO라 정했기 때문에 VO로 사용가능
		//찍었는데 맞췄음, 확실한 DOC필요, 인터넷엔 죄다 그냥 딱 정의만 나와있네
		
		
		//필요한 함수 가져오기 1.(랜덤번호+어레이에담기)
		CodingPoem cp =null;
		cp = new CodingPoem();	
		int lo[] = cp.pickRandomNumber();
		System.out.println("CodingPoem.jsp ::: lo[0]>>> : " +lo[0]);
		System.out.println("CodingPoem.jsp ::: lo[1]>>> : " +lo[1]);
		ArrayList<Integer>aList = cp.wrappingNumber(lo);
		
		//사람뽑기함수 담을 VO준비하고 담기(aList에 랜덤번호, cpvo에 게임에 참여한 사람, 함수는 그 두개를 묶는 역할)
		
		CodingPoemVO _cpvo = null;
		_cpvo = new CodingPoemVO();
		_cpvo = cp.pickPerson(aList, VO);
		System.out.println("-------------------------------------------");
		System.out.println("받는 VO에 담긴 p1 >>> : "+_cpvo.getP1());
		System.out.println("받는 VO에 담긴 p2 >>> : "+_cpvo.getP2());
		System.out.println("받는 VO에 담긴 p3 >>> : "+_cpvo.getP3());
		System.out.println("받는 VO에 담긴 p4 >>> : "+_cpvo.getP4());
		System.out.println("받는 VO에 담긴 p5 >>> : "+_cpvo.getP5());
		System.out.println("받는 VO에 담긴 p6 >>> : "+_cpvo.getP6());
		
		System.out.println("==================================최종결론=========================================");
		//_cpvo에 당첨자가 걸려있다. ==> if get함수가 아니면, 보여라
		if(_cpvo.getP1()!=null){
			out.println(p1+"당첨!!"+"<br>");
		}else{
			out.println(p1+"은 다음주에 발표가 아닙니다!!"+"<br>");
		};
		if(_cpvo.getP2()!=null){
			out.println(p2+" 당첨!!"+"<br>");
		}else{
			out.println(p2+"은 다음주에 발표가 아닙니다!!"+"<br>");
		}
		if(_cpvo.getP3()!=null){
			out.println(p3+" 당첨!!"+"<br>");
		}else{
			out.println(p3+"은 다음주에 발표가 아닙니다!!"+"<br>");
		}
		if(_cpvo.getP4()!=null){
			out.println(p4+" 당첨!!"+"<br>");
		}else{
			out.println(p4+"은 다음주에 발표가 아닙니다!!"+"<br>");
		}
		if(_cpvo.getP5()!=null){
			out.println(p5+" 당첨!!"+"<br>");
		}else{
			out.println(p5+"은 다음주에 발표가 아닙니다!!"+"<br>");
		}
		if(_cpvo.getP6()!=null){
			out.println(p6+" 당첨!!"+"<br>");
			//http://localhost:8088/kosMember/CodingPoem/CodingPoem.jsp
		}else{
			out.println(p6+"은 다음주에 발표가 아닙니다!!"+"<br>");
		}
	
 %>
	</body>
</html>