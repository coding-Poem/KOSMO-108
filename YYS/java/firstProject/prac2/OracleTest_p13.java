package a.b.c.prac2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import a.b.c.prac2.OracleConnProperty_p;

public class OracleTest_p13 {
	public int t4Update(String t1, String t2){
		System.out.println("<<< OracleTest_p13 ::t4Update(String t1, String t2) 시작 >>>");
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		
		try {
			conn = OracleConnProperty_p.getConnection();
			
			String sql="UPDATE TEST_T4 SET T2=?, T5=SYSDATE WHERE T4='Y' AND T1=?";
			// UPDATE할 때, 언제 UPDATE했는지, SYSDATE 꼭 업데이트 해주기
			// Y인 회원인 경우만 업데이트 해야함.
			// PK로 조회
			pstmt=conn.prepareStatement(sql);
			System.out.println("sql >>> \n"+sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, t2);
			pstmt.setString(2, t1);
			// t2가 바꿀 내용이고, t1이 pk이다. 
			// 이 점 유의 하기
			
			System.out.println("Update 전 nCnt >>> : "+nCnt);
			nCnt=pstmt.executeUpdate();
			System.out.println("Update 후 nCnt >>> :"+nCnt);
		}catch(Exception e){
			System.out.println("에러가 >>> : "+e.getMessage());
		}
		return nCnt;
	}

	public static void main(String[] args) {
		String t1="7";
		String t2="YYS";
		String t3="";
		String t4="";
		String t5="";
		
		OracleTest_p13 ot13=new OracleTest_p13();
		int nCnt=ot13.t4Update(t1,t2);
		// t1은 pk ==7  t2는 업데이트 할 값 : 'YYS'
		
		System.out.println("OracleTest_p13 :: main(String[] args) :: nCnt >>> : "+nCnt);
		if (nCnt==1){
			System.out.println(nCnt+" 건 수정 성공");
		}else{
			System.out.println("수정 실패.");
		}
	} // main method
} // OracleTest_p13 class
