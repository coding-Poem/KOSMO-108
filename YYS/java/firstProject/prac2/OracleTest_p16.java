package a.b.c.prac2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import a.b.c.common.OracleConnProperty;


//  a.b.c.oracle.OracleTest_10_1
public class OracleTest_p16 {
	public boolean t4Update(String t1, String t2){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=OracleConnProperty.getConnection();
			String sql="UPDATE TEST_T4 SET T2=?, T5=SYSDATE WHERE T4='Y' AND T1=?";
			pstmt=conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n"+sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, t2); // place holder 1 :: T2=?
			pstmt.setString(2, t1); // place holder 2 :: T1=?
			
			nCnt=pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : "+nCnt+" 건 수정 되었음.");
			if (nCnt > 0) {bool=true;}
			
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("error >>> : "+e.getMessage());
		}finally{
			OracleConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}
	
	public static void main(String []args){
		String t1="7";
		String t2="YYS";
		String t3="";
		String t4="";
		String t5="";
		
		OracleTest_p16 ot16=new OracleTest_p16();
		boolean bool=ot16.t4Update(t1,t2);
		
		if(bool){
			System.out.println("수정 성공 >>> : "+bool);
		}else{
			System.out.println("수정 실패 >>> : "+bool);
		}
	}

}
