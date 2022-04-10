package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest_p2 {
	
	// Data Source 정보 : 데이터베이스 연결정보
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";
	
	// sql Query
	public static String sqlQuery="SELECT EMPNO, ENAME, JOB, MGR FROM EMP ORDER BY 1 DESC";
	
	// 생성자
	public OracleTest_p2(){
		try{
			Class.forName(JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't fine JDBC DRIVER"+e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		try{
			Connection conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
			Statement stmt=conn.createStatement();
			// stmt.executeQuery("쿼리문"); 시작점
			ResultSet rsRs=stmt.executeQuery(sqlQuery);
			
			if (rsRs !=null){
				while(rsRs.next()){
					System.out.print(rsRs.getString("EMPNO")+" : ");
					System.out.print(rsRs.getString("ENAME")+" : ");
					System.out.print(rsRs.getString("JOB")+" : ");
					System.out.print(rsRs.getString("MGR"));
					System.out.println();
				}
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
