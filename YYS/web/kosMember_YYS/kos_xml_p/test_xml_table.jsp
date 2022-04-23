<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>

<%@ page import = "a.b.c.test.xml.OracleXmlTest_1" %>
<%

	String tablename = request.getParameter("tablename");
	OracleXmlTest_1 oxt_1 = new OracleXmlTest_1();
	boolean bool = oxt_1.makeXml(tablename);
	//bool = false;
	if (!bool) return;

	String strHtml = "";
	String strLine = "";
	String xmlFilename = tablename + ".xml";
	
	try {
		String strUrl = "http://localhost:8088/kosMember/kos_xml/"+xmlFilename;
		BufferedReader br = new BufferedReader(
			new InputStreamReader((new URL(strUrl))
			.openConnection().getInputStream(),"UTF-8"));
		
		while ((strLine = br.readLine()) != null){
			strHtml += strLine;
		}
		
		System.out.println(strHtml);
		br.close();
	} catch(Exception e) {
		throw e;
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
		
		xmlText = "<%= strHtml %>";
		alert(xmlText);
		
		xmlParser = new DOMParser();
		xmlDoc = xmlParser.parseFromString(xmlText, "text/xml");
		alert(xmlDoc);
		
		$("#parseText").click(function(){
			document.getElementById("text").innerHTML = xmlDoc;			
				
		});
		
		$("#parseFind").click(function(){
			document.getElementById("text").innerHTML = text;		
		});
	});
</script>
</head>
<body>
<h3>XML 데이터 파싱하기</h3>
<hr>
<button id="parseText">DOM Parser로 XML 파싱하기 </button>
<button id="parseFind">find() 함수로 파싱하기 </button> 
<p id="text"></p> 
</body>
</html>