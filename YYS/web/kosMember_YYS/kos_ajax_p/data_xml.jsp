<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id=request.getParameter("id");
	System.out.println("jQueryIdCheck :: id >>> : "+id);
	
	int idNcnt=0;
	boolean bool=false;
	
	if(idNcnt==0){
		System.out.println("idNcnt가 0입니다 >>>> : "+idNcnt);
		bool=true;
		System.out.println("bool이 true로 바뀌었습니다. >>> : "+bool);
	}else{
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax XML</title>
</head>
<body>
<?xml version='1.0' encoding='UTF-8'?>
	<login>
		<result><%= bool %></result>	
	</login>	
</body>
</html>