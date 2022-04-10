package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OracleTest_4 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclHBE00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	// sql Query
//	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO = 7369 AND ENAME = ?";
//	? :  플레이스 홀더 place holer 
//  setString(1, 7369);
//  setString(2, 'ALLEN');
	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO = ? ";
	
	// 생성자 
	public OracleTest_4() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC 드라이버를 찾지 못했서요 >>> : " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("검색할 사번을 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		String empno = sc.next();
		System.out.println("검색할 사번은 >>> : " + empno);

		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			// WHERE EMPNO = ? <--- empno 7369
			pstmt.setString(1,  empno);
			
			// stmt.executeQuery("쿼리문"); 시작점 
			ResultSet rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					System.out.print(rsRs.getString("EMPNO") + " : ");
					System.out.print(rsRs.getString("ENAME") + " : ");
					System.out.print(rsRs.getString("JOB") + " : ");			
					System.out.println(rsRs.getString("MGR"));
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		sc.close();
	}
}
