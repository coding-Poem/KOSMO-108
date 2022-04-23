<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.net.URL" %>    
<%
	String strHtml="";
	String strLine="";
	
	try{
		String strUrl="http://localhost:8088/kosMember_YYS2/kos_xml_p/test_xml.xml";
		// xml이 있는 파일의 주소를 입력합니다.
		/*
		test_xml.xml 안의 내용
		
		<?xml version="1.0" encoding="UTF-8"?>
        <country>
        	<name>korea</name>
        	<capital>seoul</capital>
        </country>
		*/
		
		BufferedReader br=new BufferedReader(
			new InputStreamReader((new URL(strUrl)).openConnection().getInputStream(), "UTF-8"));
		// java.net.URL
		// Constructor :: URL(String spec)
		// Creates a URL object from the String representation.
		// spec - the String to parse as a URL
		
		// java.net.URL
		// method : openConnection()
		// Modifier and Type :: Method and Description
		// URLConnection :: openConnection
		// Returns a URLConnection instance that represents a connection to the remote object referred to by the URL.
		// URL에서 참조하는 원격 개체에 대한 연결을 나타내는 URLConnection 인스턴스를 반환합니다.
		
		// java.net.URLConnection
		// method : getInputStream()
		// Modifier and Type :: Method and Description
		// InputStream :: getInputStream()
		// Returns an input stream that reads from this open connection.
		// A SocketTimeoutException can be thrown when reading 
		// from the returned input stream 
		// if the read timeout expires before data is available for read.
		// 이 열린 연결에서 읽는 입력 스트림을 반환합니다. 
		// 소켓 제한 시간데이터를 읽을 수 있기 전에 읽기 시간 초과가 만료된 경우 
		// 반환된 입력 스트림에서 읽을 때 예외가 발생할 수 있습니다.
		
		// new InputStreamReader(InputStream in, String charsetName)
		// Creates an InputStreamReader that uses the named charset.
		
		
		/*
		For top efficiency, consider wrapping an InputStreamReader 
		within a BufferedReader. 
		For example:

 		BufferedReader in
   		= new BufferedReader(new InputStreamReader(System.in));
		*/
		
		// java.io.BufferedReader
		// BufferedReader(Reader in)
		
		
		while((strLine=br.readLine()) != null){
			// java.io.BufferedReader
			// method : readLine()
			// // Modifier and Type :: Method and Description
			// String :: readLine()
			// Reads a line of text. 
			// br.readLine()으로 text를 읽은 것은 strLine에 대입하였을 때,ㅡ
			// 그것이 null이 아닌 경우에만 수행
			strHtml+=strLine;
			// 읽은 것을 strHtml에 누적 대입
		}
		
		System.out.println(strHtml);
		/*
		test_xml의 내용이 출력된다.
		<?xml version="1.0" encoding="UTF-8"?><country>	<name>korea</name>	<capital>seoul</capital></country>
		<?xml version="1.0" encoding="UTF-8"?><country>	<name>korea</name>	<capital>seoul</capital></country>
		*/
		br.close();
	}catch(Exception e){
		throw e;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML PARSING</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
	 var xmlText, xmlParser, xmlDoc;
	 
	 xmlText='<%= strHtml %>';
	 // JSP 안에서 완성된 strHtml을 javascript xmlText 변수에 대입
	 alert(xmlText);
	 console.log("xmlText >>> : "+xmlText);
	 /*
	 xmlText >>> : 
	<?xml version="1.0" encoding="UTF-8"?><country>	<name>korea</name>	<capital>seoul</capital></country>	 
	 */
	 
	 // // 자바스크립트에서 DOMParser 객체를 인스턴스 함
	 xmlParser=new DOMParser();
	 
	 /*
	    .parseFromString() 함수에서 자바스크립트 변수에 담겨 있는 문자열을
		 xml 파일 형식으로 파싱한다.
	 */
	 xmlDoc=xmlParser.parseFromString(xmlText, "text/xml");
	 alert(xmlDoc);
	 console.log("xmlDoc >>> : "+xmlDoc);
	 // xmlDoc >>> : [object XMLDocument]
	 
	 // <button id="parseText">DOM Parser로 XML 파싱하기</button>
	 $("#parseText").click(function(){
		console.log(xmlDoc.getElementsByTagName("name")[0].childNodes[0].nodeValue);
		// korea
		console.log(xmlDoc.getElementsByTagName("capital")[0].childNodes[0].nodeValue);
		// seoul
		document.getElementById("text").innerHTML=
			xmlDoc.getElementsByTagName("name")[0].childNodes[0].nodeValue 
			+ "의 수도는 " + 
			xmlDoc.getElementsByTagName("capital")[0].childNodes[0].nodeValue + " 입니다.";
	 });
	 
	 // <button id="parseFind">find() 함수로 파싱하기</button>
	 $("#parseFind").click(function(){
		 console.log("xmlDoc >>> : "+xmlDoc);
		 // xmlDoc >>> : [object XMLDocument]
		 var name=$(xmlDoc).find('name').text();
		 // xmlDoc(== object XMLDocument)에서 name을 찾아라
		 
		 /*
		 jQuery API
		 .find(selector) or .find(element)
		 
		 Description: Get the descendants of each element in the current set of matched 
		 elements, filtered by a selector, jQuery object, or element.	
		 
		 .text()
		 Description: Get the combined text contents of each element 
		 in the set of matched elements, including their descendants.
		 
		 태그 다 빼고 안에 있는 text를 찾아서 출력하는 함수이다.
		 <name>korea</name>이 있으면, korea만 뽑아낸다.
		 */
		 
		 console.log("name >>> : "+name);
		 // name >>> : korea
		 var capital=$(xmlDoc).find('capital').text();
		 alert(name + " 의 수도는 " + capital + " 입니다.");
		 console.log(name + " 의 수도는 " + capital + " 입니다.");
		 // korea 의 수도는 seoul 입니다.
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