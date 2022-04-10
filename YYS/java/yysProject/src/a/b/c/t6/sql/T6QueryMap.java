package a.b.c.t6.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

// ORA-00923: FROM 키워드가 필요한 위치에 없습니다.
public abstract class T6QueryMap {
	public static String getT6SelectAll(){
		StringBuffer sb= new StringBuffer();
		sb.append("SELECT			 							\n");
		sb.append("		 A.T1 AS T1,							\n");
		sb.append("		 A.T2 AS T2,							\n");
		sb.append("		 A.T3 AS T3,							\n");
		sb.append("		 A.T4 AS T4,							\n");
		sb.append("		 TO_CHAR(A.T5, 'YYYY.MM.DD') AS T5,		\n");
		sb.append("		 A.T6 AS T6								\n");
		sb.append("FROM	 TEST_T6 A								\n");
		sb.append("ORDER BY T1 ASC								\n");
		
		return sb.toString();
	}
	
	
	public static String getT6SelectName(){
		StringBuffer sb= new StringBuffer();
		sb.append("SELECT										\n");
		sb.append("		 A.T1 AS T1,							\n");
		sb.append("		 A.T2 AS T2,							\n");
		sb.append("		 A.T3 AS T3,							\n");
		sb.append("		 A.T4 AS T4,							\n");
		sb.append("		 TO_CHAR(A.T5, 'YYYY.MM.DD') AS T5,		\n");
		sb.append("		 A.T6 AS T6								\n");
		sb.append("FROM	 TEST_T6 A								\n");
		sb.append("WHERE A.T2 LIKE UPPER('%'|| ? || '%')		\n"); // place holder 1 :: 회원이름
		sb.append("ORDER BY T1 ASC								\n");
		
		return sb.toString();
	}
	
	public static String getT6SelectDate(){
		StringBuffer sb= new StringBuffer();
		sb.append("SELECT									    \n");
		sb.append("		 A.T1 AS T1,							\n");
		sb.append("		 A.T2 AS T2,							\n");
		sb.append("		 A.T3 AS T3,							\n");
		sb.append("		 A.T4 AS T4,							\n");
		sb.append("		 TO_CHAR(A.T5, 'YYYY.MM.DD') AS T5, 	\n");
		sb.append("		 A.T6 AS T6					 		 	\n");
		sb.append("FROM	 TEST_T6 A								\n");
		sb.append("WHERE TO_CHAR(TO_DATE(A.T5), 'YYYYMMDD')		\n");
		sb.append("		 >=TO_CHAR(TO_DATE(?), 'YYYYMMDD')  	\n"); // place holder 1 :: 입사일 :: fromdate
		sb.append("AND	 TO_CHAR(TO_DATE(A.T5), 'YYYYMMDD')		\n");
		sb.append("		 <=TO_CHAR(TO_DATE(?), 'YYYYMMDD')  	\n"); // place holder 2 :: 입사일 :: todate
		sb.append("ORDER BY T1 ASC								\n");
		
		return sb.toString(); // StringBuffer 클래스이기 때문에 toString으로 String으로 변환
	}
	
	public static String getT6Insert(){
		StringBuffer sb= new StringBuffer();
		sb.append("INSERT INTO TEST_T6 (T1,T2,T3,T4,T5) VALUES (?,?,?,'Y',SYSDATE) \n");
		// place holder 1 :: 회원번호 : T1 :: T6+YYYYMMDD+0001 :: UNIQUE && NOT NULL
		// place holder 2 :: 회원이름 : T2 :: NOT NULL 조건이 있다. 
		// place holder 3 :: 회원나이 : T3
		return sb.toString();
	}
	
	
	public static String getT6Update(){
		StringBuffer sb=new StringBuffer();
		sb.append("UPDATE TEST_T6 SET T2=?, T3=?, T6=TO_CHAR(TO_DATE(SYSDATE), 'YY/MM/DD') WHERE T4='Y' AND T1=? \n");
		// place holder 1 :: T2 :: 회원이름 :: NOT NULL
		// place holder 2 :: T3 :: 회원나이 
		// place holder 3 :: T1 :: PK :: UNIQUE && NOT NULL
		
		return sb.toString();
	}
	
	public static String getT6Delete(){
		StringBuffer sb=new StringBuffer();
		sb.append("UPDATE TEST_T6 SET T4='N', T6=TO_CHAR(TO_DATE(SYSDATE), 'YY/MM/DD') WHERE T4='Y' AND T1=? \n");
		// place holder 1 :: T1 :: PK :: UNIQUE && NOT NULL
		return sb.toString();
	}
}
