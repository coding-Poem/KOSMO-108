<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.codepoemVO.CodingPoemVO" %>
<%@ page import="a.b.c.codepoem.CodingPoem" %>
<%@ page import="java.util.ArrayList" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	//html에서 값 받아오기
	String p1 = request.getParameter("text1");
	String p2 = request.getParameter("text2");
	String p3 = request.getParameter("text3");
	String p4 = request.getParameter("text4");
	String p5 = request.getParameter("text5");
	String p6 = request.getParameter("text6");
	
	//받아온 값 로그 찍어보기
	System.out.println("키인 된 jsp로 p1 >>> : "+p1);
	System.out.println("키인 된 jsp로 p2 >>> : "+p2);
	System.out.println("키인 된 jsp로 p3 >>> : "+p3);
	System.out.println("키인 된 jsp로 p4 >>> : "+p4);
	System.out.println("키인 된 jsp로 p5 >>> : "+p5);
	System.out.println("키인 된 jsp로 p6 >>> : "+p6);
	
	//VO에 담을 준비
	CodingPoemVO cpvo = null;
	cpvo = new CodingPoemVO();
	
	//VO에 담고
	cpvo.setP1(p1);
	cpvo.setP2(p2);
	cpvo.setP3(p3);
	cpvo.setP4(p4);
	cpvo.setP5(p5);
	cpvo.setP6(p6);
	
	//잘 담겼나 로그 찍어보고.
	System.out.println("보내는 VO에 담긴 p1 >>> : "+cpvo.getP1());
	System.out.println("보내는 VO에 담긴 p2 >>> : "+cpvo.getP2());
	System.out.println("보내는 VO에 담긴 p3 >>> : "+cpvo.getP3());
	System.out.println("보내는 VO에 담긴 p4 >>> : "+cpvo.getP4());
	System.out.println("보내는 VO에 담긴 p5 >>> : "+cpvo.getP5());
	System.out.println("보내는 VO에 담긴 p6 >>> : "+cpvo.getP6());
	
	//필요한 함수 가져오기(랜덤번호+어레이에담기)
	CodingPoem cp =null;
	cp = new CodingPoem();	
	int lo[] = cp.pickRandomNumber();
	System.out.println("CodingPoem.jsp ::: lo[0]>>> : " +lo[0]);
	System.out.println("CodingPoem.jsp ::: lo[1]>>> : " +lo[1]);
	ArrayList<Integer>aList = cp.wrappingNumber(lo);
	
	//사람뽑기함수 담을 VO준비하고 담기(aList에 랜덤번호, cpvo에 게임에 참여한 사람, 함수는 그 두개를 묶는 역할)
	CodingPoemVO _cpvo = null;
	_cpvo = new CodingPoemVO();
	_cpvo = cp.pickPerson(aList, cpvo);
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
		out.println(p1+" 당첨!!");
	}
	if(_cpvo.getP2()!=null){
		out.println(p2+" 당첨!!");
	}
	if(_cpvo.getP3()!=null){
		out.println(p3+" 당첨!!");
	}
	if(_cpvo.getP4()!=null){
		out.println(p4+" 당첨!!");
	}
	if(_cpvo.getP5()!=null){
		out.println(p5+" 당첨!!");
	}
	if(_cpvo.getP6()!=null){
		out.println(p6+" 당첨!!");
	}
%>

	
</body>
</html>