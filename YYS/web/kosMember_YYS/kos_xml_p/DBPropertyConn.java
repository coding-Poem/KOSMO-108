package a.b.c.test.xml_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileReader;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DBPropertyConn {
	// Connection 연결하는 함수 만들기
	public static Connection getConnection(){
		Logger logger = LogManager.getLogger(DBPropertyConn.class);
		String path="C:\\00.KOSMO108\\30.Web\\eclipse_web_yys\\eclipse_yys_work\\kosMember_YYS2\\src";
		Connection conn=null;
		try {
			FileReader fr=new FileReader(path+"/"+"db.properties");
			Properties prop=new Properties();
			prop.load(fr);
			
			/*
			 * 	db.properties 파일 정보
			 * driver=oracle.jdbc.driver.OracleDriver
			 * url=jdbc:oracle:thin:@localhost:1521:orclYYS00
			 * username=scott
			 * password=tiger
			 * */
			
			
			// DataSource 정보 : 데이터베이스 연결 정보
			String JDBC_DRIVER=prop.getProperty("driver");
			logger.info("5. JDBC_DRIVER >>> : "+JDBC_DRIVER);
			// 5. JDBC_DRIVER >>> : oracle.jdbc.driver.OracleDriver
			String JDBC_URL=prop.getProperty("url");
			logger.info("6. JDBC_URL >>> : "+JDBC_URL);
			// 6. JDBC_URL >>> : jdbc:oracle:thin:@localhost:1521:orclYYS00
			String JDBC_USER = prop.getProperty("username");
			logger.info("7. JDBC_USER >>> : "+JDBC_USER);
			// 7. JDBC_USER >>> : scott
			String JDBC_PASSWORD = prop.getProperty("password");
			logger.info("8. JDBC_PASSWORD >>> : "+JDBC_PASSWORD);
			// 8. JDBC_PASSWORD >>> : tiger
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);	
			logger.info("9. conn >>> : "+conn);
			// 9. conn >>> : oracle.jdbc.driver.T4CConnection@47e251e9
			
			
		}catch(Exception e){
			logger.info("데이터베이스 연결에 문제가 있습니다 . >>> : :"+e.getMessage());
		}
		return conn;
	} // end of getConnection
	
	// select
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs){
		try {
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch(Exception e2){}
	}
	
	// insert, update, delete
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}
	
} // end of DBPropertyConn
