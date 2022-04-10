package a.b.c.kos.mem.sql;

import a.b.c.kos.mem.vo.MemVO;

public abstract class MemQueryMap {
	// 회원 전체 조회
	public static String getMemSelectAllQuery(MemVO mvo){
		String searchFilter=mvo.getSearchFilter();
		String keyword=mvo.getKeyword();
		String fromdate=mvo.getFromdate();
		String todate=mvo.getTodate();
		
		
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT															 \n");  
		sb.append(" 	 A.MNUM	AS MNUM												 \n");  // 회원 번호
		sb.append("     ,A.MNAME AS MNAME        									 \n");  // 회원 이름
		sb.append("     ,A.MID AS MID       										 \n");  // 아이디
		sb.append("     ,A.MPW AS MPW        										 \n");  // 패스워드
		sb.append("     ,A.MHP AS MHP        										 \n");  // 핸드폰번호
		sb.append("     ,A.MEMAIL AS MEMAIL        									 \n");  // 이메일
		sb.append("     ,A.MGENDER AS MGENDER            						 	 \n");  // 성별
		sb.append("     ,A.MHOBBY AS MHOBBY             							 \n");  // 취미
		sb.append("     ,A.MZONE AS MZONE              								 \n");  // 우편번호
		sb.append("     ,A.MROAD AS MROAD              								 \n");  // 도로명주소
		sb.append("     ,A.MJIBUN AS MJIBUN             							 \n");  // 지번주소
		sb.append("     ,A.MMSG AS MMSG           									 \n");  // 내용
		sb.append("     ,A.DELETEYN AS DELETEYN           							 \n");  // 회원여부
		sb.append("     ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD') AS INSERTDATE  \n");  // 등록일
		sb.append("     ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD') AS UPDATEDATE  \n");  // 수정일
		sb.append("FROM 															 \n");  
		sb.append("		KOS_MEMBER A 												 \n");  
		sb.append("WHERE DELETEYN='Y' 												 \n"); 
		
		// Dynamic Query
		if(fromdate !=null && fromdate.length() > 0 && todate != null && todate.length()>0){
			sb.append("AND A.INSERTDATE >= TO_DATE("+"'"+fromdate+"'"+") \n");
			sb.append("AND A.INSERTDATE <= TO_DATE("+"'"+todate+"'"+") \n");
			// java에서 fromdate와 todate가 String이여도 DB에서의 VARCHAR2에 적합한지 알 수 없으므로,
			// Oracle DB에서 쿼리문 치듯이 '문자열' 이렇게 지정해준다.
		}
		
		if("01".equals(searchFilter)){
			// java에서는 문자열(String)을 비교할 떄, equals 함수를 사용한다.
		}
		
		if("02".equals(searchFilter)){
			sb.append("AND A.MNUM = "+"'"+keyword+"'"+"\n");
		}
		
		if("03".equals(searchFilter)){
			sb.append("AND A.MNAME = "+"'"+keyword+"'"+"\n");
		}
		
		if("04".equals(searchFilter)){
			sb.append("AND A.MID= "+"'"+keyword+"'"+"\n");
		}
		
		sb.append("ORDER BY 1 DESC \n");
		// COLUMN_NAME : MNUM, COLUMN_ID : 1

		return sb.toString();
	}
	// 회원 조건 조회
	public static String getMemSelectQuery(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT															 \n");  
		sb.append(" 	 A.MNUM	AS MNUM												 \n");  // 회원 번호
		sb.append("     ,A.MNAME AS MNAME        									 \n");  // 회원 이름
		sb.append("     ,A.MID AS MID       										 \n");  // 아이디
		sb.append("     ,A.MPW AS MPW        										 \n");  // 패스워드
		sb.append("     ,A.MHP AS MHP        										 \n");  // 핸드폰번호
		sb.append("     ,A.MEMAIL AS MEMAIL        									 \n");  // 이메일
		sb.append("     ,A.MGENDER AS MGENDER            						 	 \n");  // 성별
		sb.append("     ,A.MHOBBY AS MHOBBY             							 \n");  // 취미
		sb.append("     ,A.MZONE AS MZONE              								 \n");  // 우편번호
		sb.append("     ,A.MROAD AS MROAD              								 \n");  // 도로명주소
		sb.append("     ,A.MJIBUN AS MJIBUN             							 \n");  // 지번주소
		sb.append("     ,A.MMSG AS MMSG           									 \n");  // 내용
		sb.append("     ,A.DELETEYN AS DELETEYN           							 \n");  // 회원여부
		sb.append("     ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD') AS INSERTDATE  \n");  // 등록일
		sb.append("     ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD') AS UPDATEDATE  \n");  // 수정일
		sb.append("FROM 															 \n");  
		sb.append("		KOS_MEMBER A 												 \n");  
		sb.append("WHERE DELETEYN='Y' 												 \n"); 
		sb.append("AND A.MNUM=?											  			 \n"); // placeholder 1
		return sb.toString();
	}
	// 회원 입력
	public static String getMemInsertQuery(){
		StringBuffer sb=new StringBuffer();
		/*
		 * 
		 * MNUM  :  1
		 * MNAME :  2
		 * MID :    3
		 * MPW :    4
		 * MHP :    5
		 * MEMAIL : 6
		 * MGENDER :7
		 * MHOBBY : 8
		 * MZONE :  9
		 * MROAD :  10
		 * MJIBUN : 11
		 * MMSG :   12
		 * 
		 * DELETEYN : 13
		 * INSERTDATE : 14
		 * UPDATEDATE : 15
		 * 
		 * */
		
		sb.append("INSERT INTO 				\n");
		sb.append("  KOS_MEMBER				\n");
		sb.append(" 	(		    		\n");
		sb.append(" 	 MNUM				\n");
		sb.append("     ,MNAME         		\n");
		sb.append("     ,MID       			\n");
		sb.append("     ,MPW        		\n");
		sb.append("     ,MHP        		\n");
		sb.append("     ,MEMAIL        		\n");
		sb.append("     ,MGENDER            \n");
		sb.append("     ,MHOBBY             \n");
		sb.append("     ,MZONE              \n");
		sb.append("     ,MROAD              \n");
		sb.append("     ,MJIBUN             \n");
		sb.append("     ,MMSG            	\n");
		sb.append("     ,DELETEYN           \n");
		sb.append("     ,INSERTDATE         \n");
		sb.append("     ,UPDATEDATE         \n");
		sb.append("     )            		\n");
		sb.append("      VALUES           	\n");
		sb.append("      (           		\n");
		sb.append("         ?               \n"); // placeholder : 1 :: MNUM  :  1 
		sb.append("        ,?               \n"); // placeholder : 2 :: MNAME :  2
		sb.append("        ,?               \n"); // placeholder : 3 :: MID :    3
		sb.append("        ,?               \n"); // placeholder : 4 :: MPW :    4
		sb.append("        ,?               \n"); // placeholder : 5 :: MHP :    5
		sb.append("        ,?               \n"); // placeholder : 6 :: MEMAIL : 6
		sb.append("        ,?               \n"); // placeholder : 7 :: MGENDER :7
		sb.append("        ,?               \n"); // placeholder : 8 :: MHOBBY : 8
		sb.append("        ,?               \n"); // placeholder : 9 :: MZONE :  9
		sb.append("        ,?               \n"); // placeholder : 10 :: MROAD :  10
		sb.append("        ,?               \n"); // placeholder : 11 :: MJIBUN : 11
		sb.append("        ,?               \n"); // placeholder : 12 :: MMSG :   12
		sb.append("        ,'Y'         	\n"); // DELETEYN : 13
		sb.append("        ,SYSDATE         \n"); // INSERTDATE : 14
		sb.append("        ,SYSDATE         \n"); // UPDATEDATE : 15
		sb.append("        )         \n");

		return sb.toString();
	}
	// 회원 수정
	public static String getMemUpdateQuery(){
		StringBuffer sb=new StringBuffer();
		
		/*
		 * memUpdateOk.jsp
		 * 
		 * mvo.setMnum(mnum);
	       mvo.setMemail(memail);
	       mvo.setMhobby(mhobby);
	       mvo.setMzone(mzone);
	       mvo.setMroad(mroad);
	       mvo.setMjibun(mjibun);
		 * */
		
		sb.append("UPDATE						\n");  
		sb.append(" 	 KOS_MEMBER				\n");  
		sb.append("SET 						    \n");  
		sb.append("      MEMAIL    = ?       	\n");  // placeholder : 1 :: MEMAIL
		sb.append("     ,MHOBBY    = ?        	\n");  // placeholder : 2 :: MHOBBY
		sb.append("     ,MZONE 	   = ?        	\n");  // placeholder : 3 :: MZONE
		sb.append("     ,MROAD 	   = ?       	\n");  // placeholder : 4 :: MROAD
		sb.append("     ,MJIBUN    = ?          \n");  // placeholder : 5 :: MJIBUN
		sb.append("     ,UPDATEDATE=SYSDATE     \n"); 
		sb.append("WHERE MNUM      = ?          \n");  // placeholder : 6 :: MNUM
		sb.append("AND 	 DELETEYN='Y'           \n");
		
		return sb.toString();
	}
	//회원 삭제
	public static String getMemDeleteQuery(){
		StringBuffer sb=new StringBuffer();
		sb.append("UPDATE						\n");  
		sb.append(" 	 KOS_MEMBER				\n");  
		sb.append("SET 						    \n");  
		sb.append("      DELETEYN='N'           \n");  
		sb.append("     ,UPDATEDATE=SYSDATE     \n");  
		sb.append("WHERE MNUM      = ?          \n");  // placeholder : 1 :: MNUM
		sb.append("AND 	 DELETEYN='Y'           \n");
		
		return sb.toString();
	}
}
