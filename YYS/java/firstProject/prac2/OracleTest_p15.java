package a.b.c.prac2;
// // 원본 파일 : a.b.c.OracleTest_9_1

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.ArrayList;
import a.b.c.prac.comm.ChabunUtil_p;

public class OracleTest_p15 {
	public ArrayList<HashMap<String, String>> t4Select(){
		System.out.println("OracleTest_p15 :: t4Select() 시작 >>> ");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<HashMap<String, String>> aList=null;
		HashMap<String, String> hp=null;
		
		try {
			conn=OracleConnProperty_p.getConnection();
			String sql="SELECT T1,T2,T3,T4,TO_CHAR(T5, 'YYYYMMDD') AS TS FROM TEST_T4 ORDER BY T1 ASC";
			pstmt=conn.prepareStatement(sql);
			System.out.println("sql >>> : \n"+sql);
			rsRs=pstmt.executeQuery();
			System.out.println("pstmt.executeQuery() 끝");
			
			if (rsRs!=null){
				aList=new ArrayList<HashMap<String, String>> ();
				
				while (rsRs.next()){
					hp=new HashMap<String, String>();
					hp.put("T1", rsRs.getString(1));
					hp.put("T2", rsRs.getString(2));
					hp.put("T3", rsRs.getString(3));
					hp.put("T4", rsRs.getNString(5));
					
					aList.add(hp);
				}
			}
			
		}catch(Exception e){
			boolean bool= rsRs == null;
			System.out.println("rsRs == null >>> : "+bool);
			System.out.println("OracleTest_p15 :: t4Select() error >>> : "+e.getMessage());
		}
		
		return aList;
	}
	
	
	public boolean t4Insert(String t1, String t2, String t3){
		System.out.println("OracleTest_p15 :: t4Insert(String t1, String t2, String t3) 시작 >>> ");
		System.out.println("t1 >>> : "+t1);
		System.out.println("t2 >>> : "+t2);
		System.out.println("t3 >>> : "+t3);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try{
			conn=OracleConnProperty_p.getConnection();
			String sql="INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES (?,?,?,'Y',SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			System.out.print("sql >>> \n"+sql);
				
			pstmt.clearParameters();
			pstmt.setString(1,t1);
			pstmt.setString(2, t2);
			pstmt.setString(3, t3);
			
			nCnt=pstmt.executeUpdate();
			/*
			 * boolean b= !conn.getAutoCommit();
			 * System.out.println("b >>> : "+b);
			 * if (b) conn.commit();
			 *
			 * */
			System.out.println("nCnt >> :"+nCnt);
			if (!conn.getAutoCommit()){conn.commit();}
			// DML 쿼리는 commit을 해주어야 한다.
			// conn은 Connection 클래스의 참조변수이다.
			
			System.out.println("OracleTest_p15 :: t4Insert(String t1, String t2, String t3) :: nCnt >>>> : "+nCnt+" 건 등록 되었음");
			if (nCnt >0){bool=true;}
			
			OracleConnProperty_p.conClose(conn, pstmt);
			
		}catch(Exception e){
			System.out.println("에러가 >>> : "+e.getMessage());
		}finally{
			if (conn!=null){try{OracleConnProperty_p.conClose(conn, pstmt);}catch(Exception ec){}}
			if (pstmt!=null){try{OracleConnProperty_p.conClose(conn, pstmt);}catch(Exception ec){}}
			// 이중으로 확인
		}
		System.out.println("OracleTest_p15 :: t4Insert(String t1, String t2, String t3) :: return되는 bool >>> : "+bool);
		return bool;
	}

	public static void main(String[] args) {
		String t1="9";
		String t2=ChabunUtil_p.getTestChabun("n");
		String t3="27";
		String t4="";
		String t5="";
		
		OracleTest_p15 ot15= new OracleTest_p15();
		boolean bool=ot15.t4Insert(t1,t2,t3);
		
		if (bool){
			System.out.println("입력 성공 :: OracleTest_p15 :: main :: bool >>> : "+bool);
			
			OracleTest_p15 ot15_1 = new OracleTest_p15();
			ArrayList<HashMap<String, String>> aList=ot15_1.t4Select();
			
		}else{
		System.out.println("입력 실패 :: OracleTest_p15 :: main :: bool >>> : "+bool);
		}


	}

}
