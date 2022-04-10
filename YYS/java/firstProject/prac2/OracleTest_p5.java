package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest_p5 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// oracle.jdbc.driver.OracleDriver 클래스를 찾는다.
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclYYS00","scott","tiger");
			
			// Statement stmt = conn.createStatement();
			// ResultSet rsRs = stmt.executeQuery("SELECT*FROM EMP ORDER BY 1 DESC");
			// 쿼리문이 executeQuery 함수 내에 있다.
			
			PreparedStatement stmt=conn.prepareStatement("SELECT*FROM EMP ORDER BY 1 DESC");
			// 반복된 SQL query문의 경우 PreparedStatement에 쿼리문을 계속 날리는 것이 좋으나
			// 현재 공공기관 및 금융기관에서는 사용하지 않는다. (QWERTY의 역설)
			// 쿼리문이 prepareStatement 함수 내에 있다.
			// 그 때 그 때 실행하는 쿼리문정도로만 알면 된다.
			
			// API 예시
			// PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
            // SET SALARY = ? WHERE ID = ?");
			
			// Connection 클래스의 methods
			// PreparedStatement = prepareStatement(String sql)
			// Creates a PreparedStatement object for sending parameterized 
			// SQL statements to the database.
			
			ResultSet rsRs=stmt.executeQuery();
			while (rsRs.next()){
				System.out.print(rsRs.getString(1)+" : ");
				System.out.print(rsRs.getString(2)+" : ");
				System.out.print(rsRs.getString(3)+" : ");
				System.out.print(rsRs.getString(4)+" : ");
				System.out.print(rsRs.getString(5)+" : ");
				System.out.print(rsRs.getString(6)+" : ");
				System.out.print(rsRs.getString(7)+" : ");
				System.out.print(rsRs.getString(8));
				System.out.println();
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
			
		}
		

	} // main method

} // OracleTest_p5 class
