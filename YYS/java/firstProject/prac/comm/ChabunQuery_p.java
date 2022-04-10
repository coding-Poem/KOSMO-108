package a.b.c.prac.comm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.prac2.OracleConnProperty_p;

public abstract class ChabunQuery_p {
	
	public static final short CHABUN_QUERY_TEST=0;
	
	public static String chabun_query[]={
		// 쿼리문을 작성
		"SELECT NVL(MAX(SUBSTR(A.T1, -4)), 0)+1 AS COMM_NUM FROM TEST_T4 A"
		// (SCOTT.)TEST_T4 테이블의 alias는 A이다. 해당 테이블에서
		// T1 칼럼을 뒤에서 부터 4번째 글짜까지와 0을 비교하여
		// 큰 값을 선택하라. (단, null값이면 0으로 대체)
		
			// 마지막에 직접 sqldeveloper 에서 실험해보기
	};
	
	
	public static String getTestChabumQuery() {
		System.out.println("<<< 2. ChabunQuery_p :: getTestChabumQuery() 시작 >>> ");
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		String commNum="";
		
		try {
			conn=OracleConnProperty_p.getConnection();
			// OracleConnProperty_p 클래스의
			// getConnection() 메서드
			
			String sql=ChabunQuery_p.chabun_query[CHABUN_QUERY_TEST];
			pstmt=conn.prepareStatement(sql);
			System.out.println("ChabunQuery_p 에서 작성 :: sql >>> \n"+sql);
			
			rsRs=pstmt.executeQuery();
			// 쿼리문을 ResultSet 클래스에 참조변수로 결과를 받아온다.
			
			// pstmt.clearParameters();
			// 클리어 해주기
			
			if (rsRs!=null){
				// rsRs가 null이 아닐 경우에만 실행
				while (rsRs.next()){
					commNum=rsRs.getString("COMM_NUM");
					// COMM_NUM 칼럼의 값을 String 클래스의 참조변수
					// commNum 에 대입한다.
				}
			}else{
				// rsRs != null 이 아니라서 else 문으로 온다. 확인해보기
				boolean bool= rsRs == null;
				System.out.println("OracleConnProperty_p :: rsRs == null >>> "+bool);
				System.out.println("OracleConnProperty_p :: rsRs >>> : "+rsRs);
			}			
		}catch(Exception e){
			System.out.println("OracleConnProperty_p :: getTestChabumQuery() 수행중 error >>> : "+e.getMessage());
		}
		
		return commNum;
	}

	// public static void main(String[] args) {
		// TODO Auto-generated method stub

	// }
}
