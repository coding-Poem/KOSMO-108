<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  java.io  패키지 클래스 가져오기 -->
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<!--  java.net 패키지 클래스 가져오기 -->
<%@ page import="java.net.URL" %>
<!--  log4j -->
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<!--  java src에서 클래스 import 해오기 -->
<%@ page import="a.b.c.test.xml_p.OracleXmlTest_1" %>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("1. test_xml_table.jsp 페이지 시작 >>> : ");	
	// 1. test_xml_table.jsp 페이지 시작 >>> : 
	
	// test_xml_table.html :: 
	// <input type="text" class="tablename" name="tablename" id="tablename" />
	String tablename=request.getParameter("tablename");
	logger.info("2. tablename >>> : "+tablename);	
	//  2. tablename >>> : emp

	OracleXmlTest_1 oxt_1=new OracleXmlTest_1();
	// OracleXmlTest_1 클래스에 기본 생성자를 만듭니다.
	boolean bool=oxt_1.makeXml(tablename);
	// OracleXmlTest 클래스의 makeXml 함수에 test_xml_table input 태그에 입력한 emp를
	// 인수로 입력합니다.
	// final 매개변수에 세팅
	// 원하는 경로에 tablename.xml이 만들어지면, bool이 true로 리턴된다.
	
	logger.info("bool >>> : "+bool);
	// bool >>> : true
	
	if(!bool) return;
	// tablename.xml이 만들어지지 않으면,  bool은 false가 된다.
	// !false는 곧 true이가
	// 즉, 파일이 경로에 생성되지 않으면, 끝내라는 의미이다.
	
	String strHtml="";
	String strLine="";
	String xmlFilename= tablename+".xml";
	logger.info("xmlFilename >>> : "+xmlFilename);
	// xmlFilename >>> : emp.xml
	
	try{
		String strUrl="http://localhost:8088/kosMember_YYS2/kos_xml_p/"+xmlFilename;
		// http://localhost:8088/kosMember_YYS2/kos_xml_p/emp.xml
		BufferedReader br = new BufferedReader(
				new InputStreamReader((new URL(strUrl))
				.openConnection().getInputStream(),"UTF-8"));
		// java.net.URL
		// Creates a URL object from the String representation
		// java.net.URL
		// method: openConnection()
		// return : URLConnection
		// URL에서 참조하는 원격 개체에 대한 연결을 나타내는 URLConnection 인스턴스를 반환합니다.
		
		// java.netURLConnection
		// method: getInputStream()
		// return : InputStream 
		// 이 열린 연결에서 읽는 입력 스트림을 반환합니다. 
		
		/*
		// new InputStreamReader(InputStream in, String charsetName)
		// Creates an InputStreamReader that uses the named charset.
		
		// java.io.BufferedReader
		// BufferedReader(Reader in)
		*/
		
		while((strLine=br.readLine())!=null){
			strHtml+=strLine;
			// br.readLine()으로 Reads a line of text
			// 한 뒤, 이를 strHtml에 저장
		}	
		logger.info("strHtml >>> : "+strHtml);
		// 다 저장했으면 출력시켜라.
		// strHtml >>> : <?xml version='1.0'....<DEPTNO>10</DEPTNO></EMP>
		br.close();	
	}catch(Exception e){
		throw e;
		// catch문으로 들어오면 Exception으로 날려라.
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML PARSING</title>
<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var xmlText, xmlParser, xmlDoc;
		
		xmlText="<%= strHtml %>";
		// 위에 jsp에서 만들어진 strHtml을 xmlTest에 저장
		alert("xmlText >>> : "+xmlText);
		console.log("xmlText >>> : "+xmlText);
		//  <?xml version='1.0' encoding='euc-kr'?><EMP>...><DEPTNO>10</DEPTNO></EMP>
		
		xmlParser = new DOMParser();
		// 자바스크립트에서 DOMParser 객체를 인스턴스
		
		xmlDoc=xmlParser.parseFromString(xmlText, "text/xml");
		// 인스턴스된 DOMParser를 xml파일 형식으로 파싱
		alert("xmlDoc >>> : "+xmlDoc);
		console.log("xmlDoc >>> : "+xmlDoc);
		// xmlDoc >>> : [object XMLDocument]
		
		$("#parseText").click(function(){
			//<button id="parseText">DOM Parser로 XML 파싱하기</button>
			// <p id="text"></p>
			document.getElementById("text").innerHTML=xmlDoc;
			// button 태그의 아이디가 parseText 인 버튼은 클릭하면
			// xmlDoc을 innerHTML으로 써라.
			// [object XMLDocument]
		});
		
		$("#parseFind").click(function(){
			// <button id="parseFind">find() 함수로 파싱하기</button>
			// <p id="text"></p>
			var text=$(xmlDoc).find("ENAME").text();
			document.getElementById("text").innerHTML=text;
			// SMITHALLENWARDJONESMARTINBLAKECLARKSCOTTKINGTURNERADAMSJAMESFORDMILLER
			// EMP 테이블에 있는 ENAME 태그 안의 text들이 전부 화면으로 출력되었음.
		});
	});
</script>
</head>
<body>
<h3>XML 데이터 파싱하기</h3>
<hr>
<button id="parseText">DOM Parser로 XML 파싱하기</button>
<button id="parseFind">find() 함수로 파싱하기</button>
<p id="text"></p>
</body>
</html>