package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.oracle.vo.EmpVO;

public class OracleTest_5 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	// sql Query 
	// EMPNO = ? 		:: place holer ? 1번 <-- pstmt.setString(1,  empno);
	// ENAME = UPPER(?) :: place holer ? 2번 <-- pstmt.setString(2,  ename);
	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO = ? AND ENAME = UPPER(?)";	
	
	// 생성자 
	public OracleTest_5() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC 드라이버를 찾지 못했서요 >>> : " + e.getMessage());
		}
	}
	
	public ArrayList<EmpVO> empSelect(String empno, String ename) {
		
		ArrayList<EmpVO> aList = null;
		
		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);	
			System.out.println("쿼리 \n"+ sqlQuery);
			pstmt.setString(1,  empno); // place holer ? 1번
			pstmt.setString(2,  ename); // place holer ? 2번
			
			ResultSet rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<EmpVO>();
				
				while (rsRs.next()) {
					
					EmpVO evo = new EmpVO();
					
					evo.setEmpno(rsRs.getString("EMPNO"));
					evo.setEname(rsRs.getString("ENAME"));
					evo.setJob(rsRs.getString("JOB"));
					evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(evo);
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return aList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OracleTest_5 ot5 = new OracleTest_5();
		
		System.out.println("검색할 사원의 사번 과 이름을 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		String empno = sc.next();
		System.out.println("검색할 사원의 사번 >>> : " + empno);
		String ename = sc.next();
		System.out.println("검색할 사원의 이름 >>> : " + ename);
		
		ArrayList<EmpVO> aList = ot5.empSelect(empno, ename);
		
		if (aList !=null && aList.size() > 0) {
			
			for (int i=0; i < aList.size(); i++) {
				EmpVO _evo = aList.get(i);
				System.out.print(_evo.getEmpno() + " : ");
				System.out.print(_evo.getEname() + " : ");
				System.out.print(_evo.getJob() + " : ");			
				System.out.println(_evo.getMgr());
			}
		}
		
		sc.close();
	}
}
