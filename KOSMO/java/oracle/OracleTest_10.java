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

public class OracleTest_10 {
	
	public int t4Update(String t1, String t2) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try  {
			conn = OracleConnProperty.getConnection();
			
			String sql = "UPDATE TEST_T4 SET T2 = ?, T5 = SYSDATE WHERE T4 = 'Y' AND T1 = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, t2);
			pstmt.setString(2, t1);
			
			nCnt = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}
		
		return nCnt;
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String t1 = "7";
		String t2 = "YYS";
		String t3 = "";
		String t4 = "";
		String t5 = "";
		
		
		OracleTest_10 ot9 = new OracleTest_10();		
		int nCnt = ot9.t4Update(t1, t2);
		
		if (nCnt == 1) {
			System.out.println(nCnt + " 건 수정 성공");
		}else {
			System.out.println("수정 실패. ");
		}
	}
}
