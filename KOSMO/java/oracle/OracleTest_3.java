package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclYYS00", "scott", "tiger");
			
//			Statement stmt = conn.createStatement();
			// 시작점 
//			ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP ORDER BY 1 DESC");

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMP ORDER BY 1 DESC");
			// 시작점 
			ResultSet rsRs = stmt.executeQuery();
			
			while (rsRs.next()) {
				System.out.print(rsRs.getString(1) + " : ");
				System.out.print(rsRs.getString(2) + " : ");
				System.out.print(rsRs.getString(3) + " : ");
				System.out.print(rsRs.getString(4) + " : ");
				System.out.print(rsRs.getString(5) + " : ");
				System.out.print(rsRs.getString(6) + " : ");
				System.out.print(rsRs.getString(7) + " : ");
				System.out.println(rsRs.getString(8));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
