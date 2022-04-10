package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class OracleTest_p {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println(""+Class.forName("oracle.jdbc.driver.OracleDriver"));
			// class oracle.jdbc.driver.OracleDriver
			// 1. 첫 번째 라인에서 ojdbc6.jar 에서 oracle.jdbc.driver.OracleDriver 클래스를 찾아서, 메모리에 올려 놓는다.
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclYYS00","scott","tiger");
			System.out.println("conn >>> : "+conn);
			// 2. 두 번째 라인에서 java.sql.Connection 인터페이스를
			// 	    상속해서 Oracle Vender에서 jdbc 드라이버를 만드는 팀에서 실현한
			// 	  oracle.jdbc.driver.T4CConnection@5fa7e7ff 클래스로
			//    우리가 제공한 datasource 연결정보를 가지고 OracleTest 클래스와
			// 	  orclYYS00.scott 계정에 연결을 한다. (+비밀번호)
			// 	    두  객체(자바이름과 데이터베이스)가 연결이 되면 자동커밋(auto commit)으로 세션이 열리게 된다.

			// jdbc:oracle의 종류는 여러 개가 있지만
			// 한국에서는 jdbc:oracle:thin:@localhost: 만 사용한다.
			
			// conn >>> : oracle.jdbc.driver.T4CConnection@5fa7e7ff
			
			
			Statement stmt=conn.createStatement();
			System.out.println("stmt >>> : "+stmt);
			// 3. 세 번째 라인에서 java.sql.Statement 를 상속한 
			// 	  oracle.jdbc.driver.OracleStatementWrapper@6adca536
			// 	    오라클 벤더 구현체 클래스가 createStatement() 함수에 적재된 쿼리로
			// 	    문자열을 가지고 오라클 데이터베이스에 (localhost:1521:orclYYS00","scott","tiger")전달한다.
			
			// stmt >>> : oracle.jdbc.driver.OracleStatementWrapper@6adca536
			
			// 쿼리전달의 시작 포인트는 executQuery() 함수이다.
			ResultSet rsRs=stmt.executeQuery("SELECT*FROM EMP ORDER BY 1 DESC");
			System.out.println("rsRs >>> : "+rsRs);
			// 4. 네번째 라인에서 오라클 데이터베이스에 전달된 쿼리문을 오라클 Optimizer가 실행을 해서 결과과 발생이 되면
			// 	  oracle.jdbc.driver.OracleStatementWrapper@6adca536 객체 발생된 결과를
			// 	  java.sql.ResultSet 인터페이스를 상속한 오라클 벤더 구현체 클래스
			// 	  oracle.jdbc.driver.OracleResultSetImpl@1134affc 결과를 받는다.
			//	   그 결과를 파일형태의 메모리 구조를 가지고 있다.
			

			
			// rsRs >>> : oracle.jdbc.driver.OracleResultSetImpl@1134affc
			
			while(rsRs.next()){
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
			System.out.println("error >>> : "+e);
		}
	}
}
