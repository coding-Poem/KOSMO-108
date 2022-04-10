package a.b.c.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class KosmoConnProperty {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER 		= "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL 		= "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER 		= "scott";
	public static final String JDBC_PASSWORD 	= "tiger";

	// Connection 연결하는 함수 만들기 
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);	
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결에 문제가 있서요 >>> : " + e.getMessage());
		}
				
		return conn;		
	}
	
	// select
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		try{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}
		
	// insert, update, delete 
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}	
}
