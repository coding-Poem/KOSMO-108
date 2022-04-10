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

import a.b.c.common.ChabunUtil;
import a.b.c.common.OracleConnProperty;
import a.b.c.oracle.vo.EmpVO;

public class OracleTest_9 {
	
	public int t4Insert(String t1, String t2, String t3) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try  {
			conn = OracleConnProperty.getConnection();
			
			String sql = "INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ( ?, ?, ?, 'Y', SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, t1);
			pstmt.setString(2, t2);
			pstmt.setString(3, t3);
			
			nCnt = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}
		
		return nCnt;
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

//		String t1 = "7";
		String t1 = ChabunUtil.getTestChabun("n");
		String t2 = "윤요섭";
		String t3 = "27";
		String t4 = "";
		String t5 = "";
		
		
		OracleTest_9 ot9 = new OracleTest_9();		
		int nCnt = ot9.t4Insert(t1, t2, t3);
		
		if (nCnt == 1) {
			System.out.println(nCnt + " 건 입력 성공");
		}else {
			System.out.println("입력 실패. ");
		}
	}
}
