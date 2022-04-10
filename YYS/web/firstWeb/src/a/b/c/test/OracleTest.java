package a.b.c.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclHBE00", "scott", "tiger");						
			Statement stmt = conn.createStatement();
			ResultSet rsRs = stmt.executeQuery("SELECT * FROM TEST_T6 ORDER BY 1 DESC");

			while (rsRs.next()) {
				System.out.print(rsRs.getString(1) + " : ");
				System.out.print(rsRs.getString(2) + " : ");
				System.out.print(rsRs.getString(3) + " : ");
				System.out.print(rsRs.getString(4) + " : ");
				System.out.print(rsRs.getString(5) + " : ");
				System.out.println(rsRs.getString(6));			
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
