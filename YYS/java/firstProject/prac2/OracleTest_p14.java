package a.b.c.prac2;
// 원본 파일 : a.b.c.OracleTest_9

import java.sql.Connection;
import java.sql.PreparedStatement;

import a.b.c.prac.comm.ChabunUtil_p;
// import a.b.c.prac2.OracleConnProperty_p;

public class OracleTest_p14 {
	private int t4Insert(String t1, String t2, String t3) {
		System.out.println("<<< 8. OracleTest_p14 :: t4Insert(String t1, String t2, String t3) 시작 >>>");
		System.out.println("t1 >>> : "+t1);
		System.out.println("t2 >>> : "+t2);
		System.out.println("t3 >>> : "+t3);
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		
		try {
			conn=OracleConnProperty_p.getConnection();
			// OracleConnProperty_p로 연결합니다.
			
			String sql="INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES (?,?,?,'Y',SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n"+sql);
			
			pstmt.clearParameters();
			// System.out.println("pstmt >>> : "+pstmt);
			// pstmt >>> : oracle.jdbc.driver.OraclePreparedStatementWrapper@23ceabc1
			// 잘  나온다.
			
			pstmt.setString(1,t1);
			// ChabunUtil_p.getTestChabun("yyyyMMdd")
			// T0001
			pstmt.setString(2, t2);
			// "윤요섭"
			pstmt.setString(3, t3);
			// "27"
			
			nCnt=pstmt.executeUpdate();
			System.out.println("9. try 문 :: nCnt Update 이후 >>> : "+nCnt);
			
		}catch(Exception e){
			System.out.println("에러 >> : "+e.getMessage());
		}
		
		return nCnt;
	}

	public static void main(String[] args) {
		// String t1="7";
		String t1=ChabunUtil_p.getTestChabun("yyyyMMdd");
		// ChabunUtil_p 클래스에 
		// getTestChabun("n") 메서드에 인수 n을 입력한다.
		String t2="윤요섭";
		String t3="27";
		String t4="";
		String t5="";
		
		OracleTest_p14 ot14=new OracleTest_p14();
		int nCnt = ot14.t4Insert(t1,t2,t3);
		System.out.println("10. OracleTest_p14 :: main :: nCnt >>> : "+nCnt);
		
		if (nCnt==1){
			System.out.println(nCnt+" 건 입력 성공");
		}else{
			boolean bool= nCnt==1;
			System.out.println("nCnt==1 >>> : "+bool);
			System.out.println("else문 >>  nCnt >>>"+nCnt);
		}

	}
}
