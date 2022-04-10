package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import a.b.c.common.ChabunUtil;
import a.b.c.common.OracleConnProperty;
import a.b.c.emp.search.sql.EmpSearchQueryMap;
import a.b.c.emp.search.vo.EmpSearchVO;
import a.b.c.oracle.vo.EmpVO;

public class OracleTest_9_1 {
	
	public ArrayList<HashMap<String, String>> t4Select() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<HashMap<String, String>> aList = null;		
		HashMap<String, String> hp = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = "SELECT T1, T2, T3, T4, TO_CHAR(T5, 'YYYYMMDD') AS T5 FROM TEST_T4 ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			System.out.println("전체 조회 >>> : \n" + sql);
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<HashMap<String, String>> ();

				while (rsRs.next()) {
					
					hp = new HashMap<String, String>();
					hp.put("T1", rsRs.getString(1));
					hp.put("T2", rsRs.getString(2));
					hp.put("T3", rsRs.getString(3));
					hp.put("T4", rsRs.getString(4));
					hp.put("T5", rsRs.getString(5));
					 
					aList.add(hp);					
				}
				
			}else {
				System.out.println("OracleTest_9_1 :: 전체조회 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("OracleTest_9_1 ::  전체조회중 에러가  >>> : " + e.getMessage());
		}
		
		return aList;
	}
	
	public boolean t4Insert(String t1, String t2, String t3) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
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
//			boolean b = !conn.getAutoCommit();
//			System.out.println("b >>> : " + b);
//			if (b) conn.commit();			
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");			
			if (nCnt > 0) { bool = true;}
			
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally {
			OracleConnProperty.conClose(conn, pstmt);
		}
		
		return bool;
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

//		String t1 = "7";
		String t1 = ChabunUtil.getTestChabun("n");
		String t2 = "윤요섭";
		String t3 = "27";
		String t4 = "";
		String t5 = "";
		
		
		OracleTest_9_1 ot91 = new OracleTest_9_1();		
		boolean bool = ot91.t4Insert(t1, t2, t3);
		
		if (bool) {
			System.out.println("입력 성공 >>> : " + bool);
			
			OracleTest_9_1 ot91_1 = new OracleTest_9_1();	
			ArrayList<HashMap<String, String>> aList = ot91_1.t4Select();
			
			if (aList !=null && aList.size() > 0) {
				
				for (int i=0; i < aList.size(); i++) {
					HashMap<String, String> _hp = aList.get(i);
				
					System.out.print(_hp.get("T1") + " : ");
					System.out.print(_hp.get("T2") + " : ");
					System.out.print(_hp.get("T3") + " : ");
					System.out.print(_hp.get("T4") + " : ");
					System.out.println(_hp.get("T5"));
					
				}
			}			
		}else {
			System.out.println("입력 실패 >>> : " + bool);
		}
	}
}
