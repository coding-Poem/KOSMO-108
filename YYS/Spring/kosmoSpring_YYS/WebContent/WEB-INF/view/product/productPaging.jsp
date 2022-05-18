<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>  
<%
	Logger logger=LogManager.getLogger(this.getClass()); 
	logger.info("productPaging.jsp 페이지 입니당 >>> : ");
	
	/*
		============
	 	전달해야 할 변수
	 	=============	
	*/
	String url=null;
	String str=null;
	
	url=request.getParameter("url");
	logger.info("url >>> : "+url);
	
	str=request.getParameter("str");
	logger.info("str >>> : "+str);
	
	if(str!=null && str.length()>0){
		str=str+"&";
		logger.info("str+ & >>>> : "+str);
	}
%>  
<%
	/*
	페이지 네비게이션 관련 변수
	*/
	
	// 한 페이지에 보여질 게시물 수
	int pageSize=0;
	// 그룹의 크기
	int groupSize=0;
	// 전체 게시물의 개수
	int totalCount=0;
	// 현재 페이지
	int curPage=0;
	// 전체 페이지의 개수
	int pageCount=0;
	
	if(request.getParameter("pageSize")!=null){
		pageSize=Integer.parseInt(request.getParameter("pageSize"));
		logger.info("pageSize >>> : "+pageSize);
	}
	if(request.getParameter("groupSize")!=null){
		groupSize=Integer.parseInt(request.getParameter("groupSize"));
		logger.info("groupSize >>> : "+groupSize);
	}
	if(request.getParameter("curPage")!=null){
		curPage=Integer.parseInt(request.getParameter("curPage"));
		logger.info("curPage >>>> : "+curPage);
	}
	if(request.getParameter("totalCount")!=null){
		totalCount=Integer.parseInt(request.getParameter("totalCount"));
		logger.info("totalCount >>> : "+totalCount);
	}
	
	// 전체게시물수와 페이지크기를 가지고 전체 페이지 개수를 계산함.
	// 소수점에 따라 계산상의 오류가 없도록 한것임.
								//  4      /       3
	pageCount = (int)Math.ceil(totalCount / (groupSize + 0.0));
	logger.info("pageCount >>> : "+pageCount);
	// 2
	
	// 현재 그룸 설정
	int curGroup=(curPage-1)/groupSize;
	logger.info("curGroup >>> : "+curGroup);
	// 0
	
	int linkPage = curGroup * groupSize;
	logger.info("linkPage >>> : "+linkPage);
	// 0
%>
	<p align="right">
<%
	// 첫 번째 그룹이 아닌 경우
	if(curGroup>0){
%>
	<a href="<%=url%>?<%=str%>curPage=1">◁◁</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>">◀</a>&nbsp;&nbsp;&nbsp;
<%		
	}else{
%>
	◁◁&nbsp;&nbsp;&nbsp;◀&nbsp;&nbsp;&nbsp;
<%
	}

	// 다음 링크를 위해 증가시킴
	linkPage++;
	logger.info("linkPage++ >>> : "+linkPage);
	// 1
	
	int loopCount=groupSize;
	logger.info("loopCount >>> : "+loopCount);
	// 3
	
	// 그룹범위내에서 페이지 링크만듬.
	while((loopCount > 0) && (linkPage <= pageCount)){
		if(linkPage == curPage){
			logger.info("그룹 범위 내에서 페이지 링크 if");
%>
			<%=linkPage%>
<%					
		}else{
			logger.info("그룹 범위 내에서 페이지 링크  else");
%>
	[<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>"><%=linkPage%></a>]&nbsp;
<%			
		}
		linkPage++;
		loopCount--;
	}
	
	// 다음 그룹이 있는 경우
	if(linkPage<=pageCount){
		logger.info("다음 그룹이 있는 경우 linkPage >>> : "+linkPage);
		logger.info("다음 그룹이 있는 경우 pageCount >>>> : "+pageCount);
%>
	<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>">▶</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=url%>?<%=str%>curPage=<%=pageCount%>">▷▷</a>&nbsp;&nbsp;&nbsp;
<%		
	}else{
		logger.info("다음 그룹이 있는 경우 linkPage >>> : "+linkPage);
		logger.info("다음 그룹이 있는 경우  pageCount >>> : "+pageCount);
		logger.info("다음 그룹이 있는 경우  else ");
%>
	▶&nbsp;&nbsp;&nbsp;▷▷&nbsp;&nbsp;&nbsp;
<%		
	}
%>