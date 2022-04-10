package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.oracle.vo.EmpVO;

public class OracleTest_7_1 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclHBE00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	public static final short SQLQUERY_1 = 0;
	public static final short SQLQUERY_2 = 1;
	
	// sql Query 
	public static String[] sqlQuery = {
		"SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE '%' || ? || '%' ",	
		"SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE ? "
	};
	
//	sqlQuery[0], sqlQuery[OracleTest_7_1.SQLQUERY_1]
//	sqlQuery[1], sqlQuery[OracleTest_7_1.SQLQUERY_2]
			
	// 생성자 
	public OracleTest_7_1() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC 드라이버를 찾지 못했서요 >>> : " + e.getMessage());
		}
	}
	
	public ArrayList<EmpVO> empSelect(EmpVO evo) {
		
		ArrayList<EmpVO> aList = null;
		
		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			
			PreparedStatement pstmt = conn.prepareStatement(OracleTest_7_1.sqlQuery[OracleTest_7_1.SQLQUERY_1]);
//			PreparedStatement pstmt = conn.prepareStatement(OracleTest_7_1.sqlQuery[0]);
			pstmt.setString(1,  evo.getEmpno());
			
			ResultSet rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<EmpVO>();
				
				while (rsRs.next()) {
					
					EmpVO _evo = new EmpVO();
					
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));					
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(_evo);
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return aList;
	}
	
	public ArrayList<EmpVO> empSelect_1(EmpVO evo) {
		
		ArrayList<EmpVO> aList = null;
		
		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			
			PreparedStatement pstmt = conn.prepareStatement(OracleTest_7_1.sqlQuery[1]);	
//			PreparedStatement pstmt = conn.prepareStatement(OracleTest_7_1.sqlQuery[OracleTest_7_1.SQLQUERY_2]);			
			pstmt.setString(1,  "%" + evo.getEmpno() + "%");
			
			ResultSet rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<EmpVO>();
				
				while (rsRs.next()) {
					
					EmpVO _evo = new EmpVO();
					
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(_evo);
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return aList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OracleTest_7_1 ot71 = new OracleTest_7_1();
		
		Scanner sc0 = null;
		Scanner sc1 = null;
		Scanner sc2 = null;
		
		while (true) {

			System.out.println("검색 방법을 선택 하시오 1:  2:  3: 검색 끝");
			
			sc0 = new Scanner(System.in);
			int c = sc0.nextInt();
			
			if (c == 3) break;
			
			while(true) {
				
				if (c == 1) {
					System.out.println(c + " 번을 선택 하셨습니다.");
					
					System.out.println("검색할 사원의 사번을 입력하시오 >>> : ");
					
					sc1 = new Scanner(System.in);
					
					String empno = sc1.next();
					System.out.println("검색할 사원의 사번 >>> : " + empno);
					
					EmpVO evo = null;
					evo = new EmpVO();
					evo.setEmpno(empno);
					
					ArrayList<EmpVO> aList = ot71.empSelect(evo);
					
					if (aList !=null && aList.size() > 0) {
						
						for (int i=0; i < aList.size(); i++) {
							EmpVO _evo = aList.get(i);
							System.out.print(_evo.getEmpno() + " : ");
							System.out.print(_evo.getEname() + " : ");
							System.out.print(_evo.getJob() + " : ");			
							System.out.println(_evo.getMgr());
						}
					}
					
					break;
				}
				
				if (c == 2) {
					System.out.println(c + " 번을 선택 하셨습니다.");
					
					System.out.println("검색할 사원의 사번을 입력하시오 >>> : ");
					
					sc2 = new Scanner(System.in);
					
					String empno = sc2.next();
					System.out.println("검색할 사원의 사번 >>> : " + empno);
					
					EmpVO evo = null;
					evo = new EmpVO();
					evo.setEmpno(empno);
										
					ArrayList<EmpVO> aList = ot71.empSelect_1(evo);
					
					if (aList !=null && aList.size() > 0) {
						
						for (int i=0; i < aList.size(); i++) {
							EmpVO _evo = aList.get(i);
							System.out.print(_evo.getEmpno() + " : ");
							System.out.print(_evo.getEname() + " : ");
							System.out.print(_evo.getJob() + " : ");			
							System.out.println(_evo.getMgr());
						}
					}
					
					break;
				}
			}
		}
		if (sc2 !=null) sc2.close();
		if (sc1 !=null) sc1.close();
		if (sc0 !=null) sc0.close();
	}
}
