package a.b.c.kos.sql;

public class MemQueryMap {
	
/******************************************************/
	/*    **DQL :: Data Query Language :: SELECT**    */
	// 전체 조회
	public static String getMemSelectAll(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT        A.MNUM             	                          AS      MNUM 		 \n"); // 회원번호  	:: COLUMN_ID :: 1
		sb.append("		 		,A.MNAME           	 	                          AS      MNAME  	 \n"); // 회원이름	:: COLUMN_ID :: 2
		sb.append("             ,A.MID                                            AS      MID 		 \n"); // 아이디		:: COLUMN_ID :: 3
		sb.append("             ,A.MPW                 	                          AS      MPW 		 \n"); // 패스워드	:: COLUMN_ID :: 4
		sb.append("             ,A.MHP                 	                          AS      MHP 		 \n"); // 핸드폰번호	:: COLUMN_ID :: 5
		sb.append("             ,A.MEMAIL           	                          AS      MEMAIL 	 \n"); // 이메일		:: COLUMN_ID :: 6
		sb.append("             ,A.MGENDER      		                          AS      MGENDER  	 \n"); // 성별		:: COLUMN_ID :: 7
		sb.append("             ,A.MHOBBY        		                          AS      MHOBBY 	 \n"); // 취미		:: COLUMN_ID :: 8
		sb.append("             ,A.MLOCAL         		                          AS      MLOCAL 	 \n"); // 지역		:: COLUMN_ID :: 9
		sb.append("             ,A.MMSG               	                          AS      MMSG 		 \n"); // 내용		:: COLUMN_ID :: 10
		sb.append("             ,A.DELETEYN      		                          AS      DELETEYN   \n"); // 회원여부	:: COLUMN_ID :: 11
		sb.append("             ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')     AS      INSERTDATE \n"); // 등록일		:: COLUMN_ID :: 12
		sb.append("             ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')     AS      UPDATEDATE \n"); // 수정일		:: COLUMN_ID :: 13
		sb.append("FROM     	SCOTT.KOS_MEMBER A                                                   \n"); // SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
		sb.append("WHERE		A.DELETEYN='Y'                                                       \n"); // 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
		sb.append("ORDER BY 	MNUM  ASC                                                            \n"); // PRIMARY KEY인 MNUM 칼럼을 오름차순으로 정렬
		// ORDER BY 절에 컬럼 이름이 A.MNUM이 아닌 MNUM인 이유
		// FROM - WHERE - SELECT - ORDER BY 절 순으로 실행 되므로,
		// SELECT의 ALIAS명을  ORDER BY 절의 칼럼으로 입력해야 한다.
		// ASC : 오름차순으로 정렬하세요.
		
		return sb.toString();
		
	}; // end of getMemSelectAll()
	
	// 회원 번호 조회
	public static String getMemSelectNum(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT        A.MNUM             	                          AS      MNUM 		 \n"); // 회원번호  	:: COLUMN_ID :: 1
		sb.append("		 		,A.MNAME           	 	                          AS      MNAME  	 \n"); // 회원이름	:: COLUMN_ID :: 2
		sb.append("             ,A.MID                                            AS      MID 		 \n"); // 아이디		:: COLUMN_ID :: 3
		sb.append("             ,A.MPW                 	                          AS      MPW 		 \n"); // 패스워드	:: COLUMN_ID :: 4
		sb.append("             ,A.MHP                 	                          AS      MHP 		 \n"); // 핸드폰번호	:: COLUMN_ID :: 5
		sb.append("             ,A.MEMAIL           	                          AS      MEMAIL 	 \n"); // 이메일		:: COLUMN_ID :: 6
		sb.append("             ,A.MGENDER      		                          AS      MGENDER  	 \n"); // 성별		:: COLUMN_ID :: 7
		sb.append("             ,A.MHOBBY        		                          AS      MHOBBY 	 \n"); // 취미		:: COLUMN_ID :: 8
		sb.append("             ,A.MLOCAL         		                          AS      MLOCAL 	 \n"); // 지역		:: COLUMN_ID :: 9
		sb.append("             ,A.MMSG               	                          AS      MMSG 		 \n"); // 내용		:: COLUMN_ID :: 10
		sb.append("             ,A.DELETEYN      		                          AS      DELETEYN   \n"); // 회원여부	:: COLUMN_ID :: 11
		sb.append("             ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')     AS      INSERTDATE \n"); // 등록일		:: COLUMN_ID :: 12
		sb.append("             ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')     AS      UPDATEDATE \n"); // 수정일		:: COLUMN_ID :: 13
		sb.append("FROM     	SCOTT.KOS_MEMBER A                                                   \n"); // SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
		sb.append("WHERE		A.DELETEYN='Y'                                                       \n"); // 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
		sb.append("AND      	A.MNUM LIKE UPPER('%'|| ? || '%') 									 \n"); 
		// 회원번호 :: MNUM :: place holder 1 :: mvo.getMnum()
		sb.append("ORDER BY 	MNUM  ASC                                                            \n"); // PRIMARY KEY인 MNUM 칼럼을 오름차순으로 정렬
		
		return sb.toString();
	}; // end of getMemSelectNum()
	
	// 회원 이름 조회
	public static String getMemSelectName(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT        A.MNUM             	                          AS      MNUM 		 \n"); // 회원번호  	:: COLUMN_ID :: 1
		sb.append("		 		,A.MNAME           	 	                          AS      MNAME  	 \n"); // 회원이름	:: COLUMN_ID :: 2
		sb.append("             ,A.MID                                            AS      MID 		 \n"); // 아이디		:: COLUMN_ID :: 3
		sb.append("             ,A.MPW                 	                          AS      MPW 		 \n"); // 패스워드	:: COLUMN_ID :: 4
		sb.append("             ,A.MHP                 	                          AS      MHP 		 \n"); // 핸드폰번호	:: COLUMN_ID :: 5
		sb.append("             ,A.MEMAIL           	                          AS      MEMAIL 	 \n"); // 이메일		:: COLUMN_ID :: 6
		sb.append("             ,A.MGENDER      		                          AS      MGENDER  	 \n"); // 성별		:: COLUMN_ID :: 7
		sb.append("             ,A.MHOBBY        		                          AS      MHOBBY 	 \n"); // 취미		:: COLUMN_ID :: 8
		sb.append("             ,A.MLOCAL         		                          AS      MLOCAL 	 \n"); // 지역		:: COLUMN_ID :: 9
		sb.append("             ,A.MMSG               	                          AS      MMSG 		 \n"); // 내용		:: COLUMN_ID :: 10
		sb.append("             ,A.DELETEYN      		                          AS      DELETEYN   \n"); // 회원여부	:: COLUMN_ID :: 11
		sb.append("             ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')     AS      INSERTDATE \n"); // 등록일		:: COLUMN_ID :: 12
		sb.append("             ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')     AS      UPDATEDATE \n"); // 수정일		:: COLUMN_ID :: 13
		sb.append("FROM     	SCOTT.KOS_MEMBER A                                                   \n"); // SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
		sb.append("WHERE		A.DELETEYN='Y'                                                       \n"); // 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
		sb.append("AND      	A.MNAME LIKE UPPER('%'|| ? || '%')									 \n");
		// 회원이름 :: MNAME :: place holder 1 :: mvo.getMname()
		sb.append("ORDER BY 	MNUM  ASC                                                            \n"); // PRIMARY KEY인  MNUM 칼럼을 오름차순으로 정렬
		
		return sb.toString();
	} // end of getMemSelectName()
	
	// 날짜 조회 (등록일 조회)
	// 수정일 조회는 java ISUD 과제 할 때, 수정일 조회 로직 관련 질문을 했을 때,
	// 수정일 조회 방법은 따로 있으므로, 등록일만 하라고 하셨다.
	public static String getMemSelectDate(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT        A.MNUM             	                          AS      MNUM 		            \n"); // 회원번호  	:: COLUMN_ID :: 1
		sb.append("		 		,A.MNAME           	 	                          AS      MNAME  	            \n"); // 회원이름	:: COLUMN_ID :: 2
		sb.append("             ,A.MID                                            AS      MID 		            \n"); // 아이디		:: COLUMN_ID :: 3
		sb.append("             ,A.MPW                 	                          AS      MPW 		            \n"); // 패스워드	:: COLUMN_ID :: 4
		sb.append("             ,A.MHP                 	                          AS      MHP 		            \n"); // 핸드폰번호	:: COLUMN_ID :: 5
		sb.append("             ,A.MEMAIL           	                          AS      MEMAIL 	            \n"); // 이메일		:: COLUMN_ID :: 6
		sb.append("             ,A.MGENDER      		                          AS      MGENDER  	            \n"); // 성별		:: COLUMN_ID :: 7
		sb.append("             ,A.MHOBBY        		                          AS      MHOBBY 	            \n"); // 취미		:: COLUMN_ID :: 8
		sb.append("             ,A.MLOCAL         		                          AS      MLOCAL 	            \n"); // 지역		:: COLUMN_ID :: 9
		sb.append("             ,A.MMSG               	                          AS      MMSG 		            \n"); // 내용		:: COLUMN_ID :: 10
		sb.append("             ,A.DELETEYN      		                          AS      DELETEYN              \n"); // 회원여부	:: COLUMN_ID :: 11
		sb.append("             ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')     AS      INSERTDATE            \n"); // 등록일		:: COLUMN_ID :: 12
		sb.append("             ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')     AS      UPDATEDATE            \n"); // 수정일		:: COLUMN_ID :: 13
		sb.append("FROM     	SCOTT.KOS_MEMBER A                                                              \n"); // SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
		sb.append("WHERE		A.DELETEYN='Y'                                                                  \n"); // 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
		sb.append("AND      	TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE(?), 'YYYYMMDD')	\n");
		// 등록일 fromdate :: place holder 1 :: mvo.getFromdate()
		sb.append("AND      	TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE(?), 'YYYYMMDD')	\n");
		// 등록일 todate :: place holder 	 2 :: mvo.getTodate()
		sb.append("ORDER BY 	MNUM  ASC                                                            			\n"); // PRIMARY KEY인  MNUM 칼럼을 오름차순으로 정렬
		
		return sb.toString();
	} // end of getMemSelectDate()
	
/*************************************************************/
	
	/*    **DML :: Data Manipulation Language :: INSERT**    */
	public static String getMemInsert(){
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO  							\n");
		sb.append("		SCOTT.KOS_MEMBER  					\n");
		sb.append("				(  							\n");		
		sb.append("			 		 MNUM         	        \n"); // place holder 1 
		sb.append("			 	  	,MNAME         	        \n"); // place holder 2 
		sb.append("			 	  	,MID         	        \n"); // place holder 3 
		sb.append("			 	  	,MPW         	        \n"); // place holder 4	
		sb.append("			 	  	,MHP         	        \n"); // place holder 5
		sb.append("			 	  	,MEMAIL                 \n"); // place holder 6
		sb.append("			 		,MGENDER                \n"); // place holder 7 
		sb.append("			 	  	,MHOBBY                 \n"); // place holder 8 
		sb.append("			 	  	,MLOCAL                 \n"); // place holder 9 
		sb.append("			 	  	,MMSG         	        \n"); // place holder 10	
		sb.append("			 	  	,DELETEYN               \n"); // 'Y'
		sb.append("			 	  	,INSERTDATE             \n"); // SYSDATE
		sb.append("			 	  	,UPDATEDATE             \n"); // SYSDATE
		sb.append("				)  					        \n");
		sb.append("VALUES  					        		\n");
		sb.append("				(  					        \n");
		sb.append("			 		   ?         		    \n"); // place holder 1  :: MNUM :: NOT NULL
		sb.append("			 	  	  ,?         		    \n"); // place holder 2  :: MNAME
		sb.append("			 	  	  ,?         		    \n"); // place holder 3  :: MID  :: NOT NULL
		sb.append("			 	  	  ,?                    \n"); // place holder 4  :: MPW  :: NOT NULL
		sb.append("			 	  	  ,?                    \n"); // place holder 5  :: MHP  :: NOT NULL
		sb.append("			 	  	  ,?                    \n"); // place holder 6  :: MEMAIL :: NOT NULL
		sb.append("			 	  	  ,?                    \n"); // place holder 7  :: MGENDER
		sb.append("			 	  	  ,?                    \n"); // place holder 8  :: MHOBBY
		sb.append("			 	  	  ,?                    \n"); // place holder 9  :: MLOCAL
		sb.append("			 	  	  ,?                    \n"); // place holder 10 :: MMSG
		sb.append("			 	  	  ,'Y'                  \n"); // DELETEYN
		sb.append("			 	  	  ,SYSDATE              \n"); // INSERTDATE
		sb.append("			 	  	  ,SYSDATE              \n"); // UPDATEDATE
		sb.append("				)  							\n");
		
		return sb.toString();
	}
	
/*************************************************************/	
		
	/*    **DML :: Data Manipulation Language :: UPDATE**    */
	public static String getMemUpdate(){
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE		SCOTT.KOS_MEMBER  					    \n");
		sb.append("SET				  								   	\n");		 
		sb.append("			 	  	 MNAME  = ?       	        	    \n"); // place holder 1  :: MNAME
		sb.append("			 	  	,MID    = ?     	        	   	\n"); // place holder 2  ::  MID  :: NOT NULL
		sb.append("			 	  	,MPW    = ?     	       		   	\n"); // place holder 3	 :: MPW  :: NOT NULL
		sb.append("			 	  	,MHP    = ?     	        	   	\n"); // place holder 4  ::  MHP  :: NOT NULL
		sb.append("			 	  	,MEMAIL  = ?               		    \n"); // place holder 5  :: MEMAIL :: NOT NULL
		sb.append("			 		,MGENDER = ?               		    \n"); // place holder 6  ::  MGENDER
		sb.append("			 	  	,MHOBBY  = ?               		    \n"); // place holder 7  :: MHOBBY
		sb.append("			 	  	,MLOCAL  = ?               		    \n"); // place holder 8  :: MLOCAL
		sb.append("			 	  	,MMSG    = ?     	        	   	\n"); // place holder 9  ::	MMSG
		sb.append("			 	  	,UPDATEDATE = SYSDATE               \n"); // SYSDATE 		 :: UPDATEDATE
		sb.append("WHERE  					        				   	\n");
		sb.append("   				DELETEYN='Y'  					    \n");
		sb.append("AND			 	MNUM=?	           		    	    \n"); // place holder 10 :: MNUM :: NOT NULL
		
		return sb.toString();
	}
	
/*************************************************************/	
	
	/*    **DML :: Data Manipulation Language :: DELETE**    */
	public static String getMemDelete(){
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE		SCOTT.KOS_MEMBER  					    \n");
		sb.append("SET				  								   	\n");		 
		sb.append("			 	  	 DELETEYN='N'       	       	    \n"); 
		sb.append("			 	  	,UPDATEDATE = SYSDATE     	        \n"); 
		sb.append("WHERE  					        				   	\n");
		sb.append("   				DELETEYN='Y'  					    \n");
		sb.append("AND			 	MNUM=?	           		    	    \n"); // place holder 1 :: MNUM :: NOT NULL
		
		return sb.toString();
	}
/*************************************************************/	
} // end of class MemQueryMap
