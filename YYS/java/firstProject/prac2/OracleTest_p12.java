package a.b.c.prac2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import a.b.c.prac2.OracleConnProperty_p;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * 	다음 데이터 입력하기 
 *  '윤요섭', 27,  'Y',  SYSDATE); 
 *	'민경호', 27,  'Y',  SYSDATE); 
 *	'송정흔', 27,  'Y',  SYSDATE); 
 *	'박성훈', 27,  'Y',  SYSDATE); 
 *	'우한슬', 29,  'Y',  SYSDATE); 
 *	'황신애', 23,  'Y',  SYSDATE);
 *	'김영하', 22,  'Y',  SYSDATE);
 *	'김민배', 32,  'Y',  SYSDATE);
 * */

public class OracleTest_p12 {
	
	public int tInsert(String t1, String t2, String t3){
		System.out.println("<<< OracleTest_p12 :: tInsert(String t1, String t2, String t3) 시작 >>> \n");
		System.out.println("tInsert(String t1, String t2, String t3) :: t1 >>> "+t1);
		System.out.println("tInsert(String t1, String t2, String t3) :: t2 >>> "+t2);
		System.out.println("tInsert(String t1, String t2, String t3) :: t3 >>> "+t3);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		// ResultSet 이 없다는게 SELECT와 가장 큰 차이이다.
		int nCnt=0;
		
		try {
			conn=OracleConnProperty_p.getConnection();
			
			String sql="INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES (?,?,?,'Y',SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			System.out.println("sql >>> \n"+sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, t1);
			pstmt.setString(2, t2);
			pstmt.setString(3, t3);
			
			nCnt=pstmt.executeUpdate();
			
			// excuteUpdate() 메서드를 사용한다.
			 
			 
			 /*
			 * ResultSet executeQuery()
             * throws SQLException
			 * SELECT는 excuteQuery() 였다. 
			 * 
			 * DQL : SELECT
			 * 
			 * excuteQuery()
			 */
			
			
			/*
			 * 
			 * int executeUpdate()
           	 * 			throws SQLException
			 * 
			 * DML : INSERT, UPDATE, DELETE
			 * 
			 * Executes the SQL statement in this PreparedStatement object, 
			 * which must be an SQL Data Manipulation Language (DML) statement, 
			 * such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, 
			 * such as a DDL statement.
			 * 
			 * Returns:
			 * either (1) the row count for SQL Data Manipulation Language (DML) statements 
			 * or (2) 0 for SQL statements that return nothing
			 * 
			 * */
				
		}catch(Exception e){
			System.out.println("OracleTest_p12 :: tInsert(String t1, String t2, String t3) : error >>> : "+e.getMessage());
		}
		
		return nCnt;
	}
	
	public ArrayList hashMapO(){
		 /*
		 * 	다음 데이터 입력하기 
		 *  '윤요섭', 27,  'Y',  SYSDATE); 
		 *	'민경호', 27,  'Y',  SYSDATE); 
		 *	'송정흔', 27,  'Y',  SYSDATE); 
		 *	'박성훈', 27,  'Y',  SYSDATE); 
		 *	'우한슬', 29,  'Y',  SYSDATE); 
		 *	'황신애', 23,  'Y',  SYSDATE);
		 *	'김영하', 22,  'Y',  SYSDATE);
		 *	'김민배', 32,  'Y',  SYSDATE);
		 */
		
		
		HashMap hm4=new HashMap();
		hm4.put("T1","4");
		hm4.put("T2","윤요섭");
		hm4.put("T3","27");
		
		HashMap hm5=new HashMap();
		hm5.put("T1","5");
		hm5.put("T2","민경호");
		hm5.put("T3","27");
		
		HashMap hm6=new HashMap();
		hm6.put("T1","6");
		hm6.put("T2","송정흔");
		hm6.put("T3","27");
		
		HashMap hm7=new HashMap();
		hm7.put("T1","7");
		hm7.put("T2","박성훈");
		hm7.put("T3","27");
		
		HashMap hm8=new HashMap();
		hm8.put("T1","8");
		hm8.put("T2","우한슬");
		hm8.put("T3","29");
		
		HashMap hm9=new HashMap();
		hm9.put("T1","9");
		hm9.put("T2","황신애");
		hm9.put("T3","23");
		
		HashMap hm10=new HashMap();
		hm10.put("T1","10");
		hm10.put("T2","김영하");
		hm10.put("T3","22");
		
		HashMap hm11=new HashMap();
		hm11.put("T1","11");
		hm11.put("T2","김민배");
		hm11.put("T3","32");
		
		ArrayList aList=new ArrayList();
		

		aList.add(hm4);
		aList.add(hm5);
		aList.add(hm6);
		aList.add(hm7);
		aList.add(hm8);
		aList.add(hm9);
		aList.add(hm10);
		aList.add(hm11);
		
		System.out.println("OracleTest_p12 :: hashMapO() ::aList.size() >>> : "+aList.size());
		return aList;
	}
	
	
	public static void main(String[] args) { // throws ParseException{
		int nCnt=0;
		ArrayList rList=null;
		
		OracleTest_p12 ot12= new OracleTest_p12();
		
		rList=ot12.hashMapO();
		
		System.out.println("OracleTest_p12 ::main(String[] args) :: rList.size() >>> "+rList.size());
		for (int i=0; i<rList.size(); i++){
			String t1="";
			String t2="";
			String t3="";
			String t4="";
			String t5="";
			
			HashMap hm=(HashMap)rList.get(i);
			Object o1=hm.get("T1");
			t1=(String)o1;
			System.out.println("T1 >>> : "+t1);
			Object o2=hm.get("T2");
			t2=(String)o2;
			System.out.println("T2 >>> : "+t2);
			Object o3=hm.get("T3");
			t3=(String)o3;
			System.out.println("T3 >>> : "+t3);
			
			nCnt+=ot12.tInsert(t1, t2, t3);
			System.out.println(i+"번째 nCnt >>> : "+nCnt);
			
			if (nCnt==i){
				System.out.println(nCnt + "건 입력 성공");
			}
		}
	}

}
