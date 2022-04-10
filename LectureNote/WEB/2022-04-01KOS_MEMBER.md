1. 테이블

```sql
DROP TABLE KOS_MEMBER;
CREATE TABLE KOS_MEMBER(
     MNUM	VARCHAR2(20)	    PRIMARY KEY  -- M + YYYYMMDD + 0001 M202203300001
    ,MNAME	VARCHAR2(50)
    ,MID	VARCHAR2(50)	    NOT NULL
    ,MPW	VARCHAR2(300)	    NOT NULL
    ,MHP	VARCHAR2(16)	    NOT NULL
    ,MEMAIL	VARCHAR2(200)	    NOT NULL
    ,MGENDER	VARCHAR2(10)
    ,MHOBBY	VARCHAR2(100)
    ,MZONE	VARCHAR2(6)
    ,MROAD	VARCHAR2(300)    
    ,MJIBUN	VARCHAR2(300)
    ,MMSG	VARCHAR2(2000)
    ,DELETEYN	VARCHAR2(1)	    NOT NULL	    -- Y/N
    ,INSERTDATE	DATE				    -- YYYY-MM-DD
    ,UPDATEDATE	DATE			            -- YYYY-MM-DD
);

-- SYS_C0011084
SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('KOS_MEMBER');

SELECT * FROM KOS_MEMBER;
```

2. log4j 사용법

```
System.out.println() --> 대신 사용할 것 

Context/WebConent/WEB-INF/lib/log4j-1.2.17.jar
Context/WebConent/WEB-INF/lib/commons-logging-1.1.2.jar
Context/Java Resources/src/log4j.xml


kosMember/WebContent/WEB-INF/web.xml
<!-- log4j setting -->
<context-param>
	<param-name>log4jConfigLocation</param-name>
	<param-value>/WEB-INF/classes/log4j.xml</param-value>
</context-param>  	

kosMember/Java Resources/src/log4j.xml <-- 카피 (복사) 할 것 
해당 파일이 컴파일 되면 아래 위치로 복사가 된다.
C:\00.KOSMO108\30.Web\eclipse_web_work\kosMember\WebContent\WEB-INF\classes\log4j.xml
```

memSelectAll.jsp

-----------------------------------------------------------------

```java
<%	
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("memSelectAll.jsp 페이지 >>> : ");
```  
  

### MemSerivceImpl.java

-----------------------------------------------------------------

```java
public class MemSerivceImpl implements MemSerivce {
	Logger logger = LogManager.getLogger(MemSerivceImpl.class);

	logger.info("MemSerivceImpl memSelectAll() 함수 진입 >>> : ");
```

### MemDAOImpl.java

-----------------------------------------------------------------

```java
public class MemDAOImpl implements MemDAO {
	Logger logger = LogManager.getLogger(MemDAOImpl.class);

	logger.info("MemDAOImpl memSelectAll() 함수 진입 >>> : ");


3. 다음 주소록 : OPEN Api
<!-- 다음 주소록 OPEN API CDN 불러오기  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

// 우편번호	
$("#mzone_btn").click(function(){
	console.log("mzone_btn >>> : ");
	=============================================================
	new daum.Postcode().open();

	new daum.Postcode(
		{
			oncomplete: function(data) {
				$("#mzone").val(data.zonecode); // 5자리 새우편번호 사용
				$("#mroad").val(data.roadAddress); // 도로명 주소
				$("#mjibun").val(data.jibunAddress); // 지번주소			
			}
		}
	).open();
	=============================================================
});


https://postcode.map.daum.net/guide
```

4. CodeUtil 사용법

### memInsert.jsp

---------------------------

```java
// 성별
String mgender = request.getParameter("mgender");
	
// 취미 
String[] hobby = request.getParameterValues("mhobby");
String mhobby = "";
for (int i=0; i < hobby.length; i++){
	mhobby += hobby[i] + ",";
}		
```

### KOS_MEMBER 테이블 

---------------------------

남자
02	

운동 음악감상
01,02,

### memSelectAll.jsp

---------------------------

```java
String hp = "";
String email = "";
String gender = "";
String hobby = "";
String addr = "";

for(int i=0; i<nCnt; i++){		
	MemVO _mvo = aList.get(i);
			
	gender = CodeUtil.gender(_mvo.getMgender());			
	hobby = CodeUtil.hobbys(_mvo.getMhobby());		
	addr = _mvo.getMroad().replace("@", " ");
	
	logger.info("gender >>> : " + gender);
	logger.info("hobby >>> : " + hobby);
	logger.info("addr >>> : " + addr);

// 성별
public static String gender(String s) {
	return "01".equals(s.toUpperCase()) ? "여자" : "남자";
}

// 취미 라벨
public static final String[] hobby_lavel = {"독서", "운동", "음악감상", "여행"};
public static final String[] hobby_value = {"01", "02", "03", "04"};

// 취미들 
public static String hobbys(String s){
	System.out.println(s);
	String h = "";
	String ss[] = s.split(",");
	for (int i=0; i < ss.length; i++){			
		System.out.println(hobby(ss[i]));
		h += hobby(ss[i]) + " ";
	}		
	return h;
}

// 취미
public static String hobby(String s) {
	
	String h = "";				
	if (s !=null && s.length() > 0){							
		for (int i=1; i < hobby_lavel.length; i++) {	
			if (("0" + i).equals(s)) {
				h = CodeUtil.hobby_lavel[i-1];
			}
		}			
	}		
	return h;
}
		

<td class="tt"><%= gender %> </td>
<td class="tt"><%= hobby %> </td>
```

5. 다이나믹 쿼리 Dynamic Sql 

### MemVO.java

----------------------------

```java
private String searchFilter;	// 검색조건
private String keyword;			// 검색어
private String fromdate;		// 검색기간 시작일
private String todate;			// 검색기간 종료일
```

mem.html

----------------------------

```html
<form name="searchForm" id="searchForm">
<table>
<tr>
<td>
<select id="searchFilter" name="searchFilter" style="width:100px;height:21px;">
	<option value="전체" selected>전체</option>
	<option value="회원번호">회원번호</option>
	<option value="이름">이름</option>
	<option value="아이디">아이디</option>
</select>
<input type="text" id="keyword" name="keyword" placeholder="검색어 입력">		
</td>
</tr>
<tr>
<td>		
<input type="text" id="fromdate" name="fromdate" placeholder="시작일 " style="width:100px;height:20px;">
~
<input type="text" id="todate" name="todate" placeholder="종료일" style="width:100px;height:20px;">
</td>
<td>
	<input type="button" id="search_btn" name="search_btn" value="검색">
	<input type="reset" value="다시">							
</td>
</tr>
</table>
</form>
```

### memSelectAll.html

----------------------------

```java
<%
String searchFilter =  request.getParameter("searchFilter");	
String keyword =  request.getParameter("keyword");	
String fromdate =  request.getParameter("fromdate");	
String todate =  request.getParameter("todate");	

MemVO mvo = null;
mvo = new MemVO();

mvo.setSearchFilter(searchFilter);
mvo.setKeyword(keyword);
mvo.setFromdate(fromdate);
mvo.setTodate(todate);

MemSerivce ms = new MemSerivceImpl();
ArrayList<MemVO> aList = ms.memSelectAll(mvo);
```

### MemDAOImpl.java

----------------------------

```java
// 회원 전체 조회
@Override
public ArrayList<MemVO> memSelectAll(MemVO mvo) {
	// TODO Auto-generated method stub		
	logger.info("MemDAOImpl memSelectAll() 함수 진입 >>> : ");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rsRs = null;
	
	ArrayList<MemVO> aList = null;
	
	try {			
		conn = KosConnectivity.getConnection();			
		String sql = MemQueryMap.getMmemSelectAllQuery(mvo);
```


### MemQueryMap.java

----------------------------

```java
public static String getMmemSelectAllQuery(MemVO mvo){
		
	String searchFilter = mvo.getSearchFilter();
	String keyword = mvo.getKeyword();
	String fromdate = mvo.getFromdate();
	String todate = mvo.getTodate();	
	
	StringBuffer sb = new StringBuffer();			
	sb.append(" SELECT 									\n");
	sb.append("      A.MNUM 			MNUM 			\n");
	sb.append("		,A.MNAME  			MNAME 			\n");
	sb.append("		,A.MID  			MID 			\n");
	sb.append("		,A.MPW  			MPW   			\n");
	sb.append("		,A.MHP  			MHP 			\n");
	sb.append("		,A.MEMAIL  			MEMAIL 			\n");
	sb.append("		,A.MGENDER  		MGENDER 		\n");
	sb.append("		,A.MHOBBY  			MHOBBY   		\n");	   
	sb.append("		,A.MZONE  			MZONE 			\n");		
	sb.append("		,A.MROAD  			MROAD   		\n");
	sb.append("		,A.MJIBUN  			MJIBUN 			\n");
	sb.append("		,A.MMSG  			MMSG 			\n");
	sb.append("		,A.DELETEYN 		DELETEYN		\n");
	sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	sb.append("	FROM 								\n");
	sb.append("		 KOS_MEMBER A 					\n");
	sb.append("	WHERE DELETEYN = 'Y'				\n");
	
	if(fromdate !=null && fromdate.length() > 0 && todate !=null && todate.length() > 0){
		 sb.append("AND	A.INSERTDATE >= TO_DATE(" + "'" + fromdate + "'"  + ") \n");
		 sb.append("AND	A.INSERTDATE <= TO_DATE(" + "'" + todate 	+ "'" + ") \n");
	}
	if ("전체".equals(searchFilter)) {	    	 
	}
	if ("회원번호".equals(searchFilter)) {
		sb.append("AND	A.MNUM 	= " + "'" + keyword + "'" + "\n");
	}
	if ("이름".equals(searchFilter)) {
		sb.append("AND	A.MNAME = " + "'" + keyword + "'" + "\n");
	}
	if ("아이디".equals(searchFilter)) {
		sb.append("AND	A.MID 	= " + "'" + keyword + "'"  + "\n");
	}
	sb.append("	ORDER BY 1 DESC					\n");
	
	return sb.toString();
}
```

6. 수정 항목  

```
jsp --> html --> javaScript
jsp <-- html <--- javaScript X
readonly
desablecd

이메일
취미
주소 

추가하기
------------
핸드폰
소개글 

XXX_CCC_CCCC --> Xxx_Ccc_Ccccc --> XxxCccCcccc
```
