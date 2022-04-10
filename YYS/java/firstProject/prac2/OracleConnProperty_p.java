package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import a.b.c.common.OracleConnProperty;

public abstract class OracleConnProperty_p {
	// DataSource 정보 : 데이터베이스 연결 정보
	
	// C:\app\bella\product\11.2.0\dbhome_1\NETWORK\ADMIN

	// C:\app\bella\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar
	// C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\ojdbc6.jar	
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";
	
	// Connection 연결하는 함수 만들기
	public static Connection getConnection(){
		System.out.println("<<< OracleConnProperty_p 시작 :: getConnection()   >>> \n");
		Connection conn = null;
		try {
			Class.forName(OracleConnProperty_p.JDBC_DRIVER);
			conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			System.out.println("<<< OracleConnProperty_p :: getConnection() :: Oracle DB Connection 완료  >>> \n");
		}catch(Exception e){
			System.out.println("데이터베이스 연결에 문제가 있습니다. >>> : "+e.getMessage());
		}
		return conn;
	}
	
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		System.out.println("<<< OracleConnProperty_p :: conClose(Connection conn, PreparedStatement pstmt) 시작 >>> \n");
		try {
			if (pstmt != null) try {pstmt.close(); pstmt=null;} catch(Exception ex) {}
			if (conn != null) try {conn.close(); conn=null;} catch(Exception ex) {}
			System.out.println("<<< OracleConnProperty_p :: conClose(Connection conn, PreparedStatement pstmt) 완료 >>> \n");
		}catch(Exception e2) {
			System.out.println("OracleConnProperty_p :: conClose(Connection conn, PreparedStatement pstmt) :: error >>> : "+e2.getMessage());
		}
	}
}