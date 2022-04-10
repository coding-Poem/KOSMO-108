package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.oracle.vo.EmpVO;

public class OracleTest_7 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclHBE00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	// sql Query 
	// 오라클에서는 || 더하기 연산자  concat 연산자 
//	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE ? || '%' ";	
//	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE '%' || ? ";	
	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE '%' || ? || '%' ";	
	public static String sqlQuery_1 = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE ? ";	
	
	// 생성자 
	public OracleTest_7() {

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
			
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);	
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
			
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery_1);	
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

		OracleTest_7 ot7 = new OracleTest_7();
		
		System.out.println("검색할 사원의 사번을 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		String empno = sc.next();
		System.out.println("검색할 사원의 사번 >>> : " + empno);
		
		EmpVO evo = null;
		evo = new EmpVO();
		evo.setEmpno(empno);
		
//		ArrayList<EmpVO> aList = ot7.empSelect(evo);
		ArrayList<EmpVO> aList = ot7.empSelect_1(evo);
		
		if (aList !=null && aList.size() > 0) {
			
			for (int i=0; i < aList.size(); i++) {
				EmpVO _evo = aList.get(i);
				System.out.print(_evo.getEmpno() + " : ");
				System.out.print(_evo.getEname() + " : ");
				System.out.print(_evo.getJob() + " : ");			
				System.out.println(_evo.getMgr());
			}
		}
	}
}
