package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.oracle.vo.EmpVO;

public class OracleTest_6 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclHBE00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	// sql Query 
	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO = ? AND ENAME = UPPER(?)";	
	
	// 생성자 
	public OracleTest_6() {

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
			pstmt.setString(2,  evo.getEname());
			
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

		OracleTest_6 ot6 = new OracleTest_6();
		
		System.out.println("검색할 사원의 사번 과 이름을 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		String empno = sc.next();
		System.out.println("검색할 사원의 사번 >>> : " + empno);
		String ename = sc.next();
		System.out.println("검색할 사원의 이름 >>> : " + ename);
		
//		EmpVO evo = new EmpVO();
		
		EmpVO evo = null;
		evo = new EmpVO();
		evo.setEmpno(empno);
		evo.setEname(ename);
		
		ArrayList<EmpVO> aList = ot6.empSelect(evo);
		
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
