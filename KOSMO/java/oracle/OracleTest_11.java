package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import a.b.c.common.OracleConnProperty;
import a.b.c.oracle.vo.EmpVO;

public class OracleTest_11 {
	
	public int t4Delete(String t1) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try  {
			conn = OracleConnProperty.getConnection();
			
			String sql = "UPDATE TEST_T4 SET T4 = 'N', T5 = SYSDATE WHERE T4 = 'Y' AND T1 = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n" + sql);
			
			pstmt.clearParameters();			
			pstmt.setString(1, t1);
			
			nCnt = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}
		
		return nCnt;
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String t1 = "7";
		String t2 = "";
		String t3 = "";
		String t4 = "";
		String t5 = "";
		
		
		OracleTest_11 ot9 = new OracleTest_11();		
		int nCnt = ot9.t4Delete(t1);
		
		if (nCnt == 1) {
			System.out.println(nCnt + " 건 삭제 성공");
		}else {
			System.out.println("삭제 실패. ");
		}
	}
}
