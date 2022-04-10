package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//==========================================
			// ojdbc6.jar <-- JDBC 드라이버
			// Oracle 11g 2 Release <--> Java Application jdk 1.8
			//==========================================
			
			// C:\app\kosmo\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar
			// oracle\jdbc\driver\OracleDriver.class
			// oracle.jdbc.driver.OracleDriver
			
			/*========================================================================
				0. 환경변수에 CLASSPATH 설정하기 
				
				//-----------------------------------------------------------------------------
				1. C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\ojdbc6.jar <-- 이것으로 사용한다.
				//-----------------------------------------------------------------------------
				
				2. C:\Program Files\Java\jre1.8.0_202\lib\ext\ojdbc6.jar 
				3. 이클립스 프로젝트에서 Bulid Path -> Configure Build Path... -> Librarias 탭-> Add External JARS...
			/*========================================================================
			
			/*
			   1. 	oracle.jdbc.driver.OracleDriver : ojdbc6.jar 오라클 드라이버 찾는 시작점 클래스의 네임스페이스 
			   		oracle.jdbc.driver : 패키지 이름 
			   		OracleDriver : 클래스 이름
			   
			   2. 	jdbc:oracle:thin: - 오라클 jdbc thin 드라이버 찾는 문자열
			   
			   3.   @ : 구분자 
			   
			   4. 	localhost - localhost : 데이터 베이스가 설치된 컴퓨터 이름
				                127.0.0.1 
				                192.168.219.103  
				                DESKTOP-ART1KUT  
				                     
			   5.	1521 - 오라클 데이터베이스 가르키는 port 번호 
			   
			   6.	orclHBE00 - 데이터베이스 식별자 : SID 또는 전역데이터베이스 이름
			   
			   7. 	scott : 계정 
			   
			   8. 	tiger : 비밀번호
			*/
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 1. 첫번째 라인에서 ojdbc6.jar 에서 oracle.jdbc.driver.OracleDriver 클래스를 찾아서 메모리에 올려 놓는다.
			System.out.println("1번째 라인 :: " + Class.forName("oracle.jdbc.driver.OracleDriver"));
			
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclYYS00", "scott", "tiger");
			// 2. 두번째 라인에서 java.sql.Connection 인터페이스를 
			//    상속해서 Oracle Vender에서  jdbc 드라이버를 만드는 팀에서 실현한 oracle.jdbc.driver.T4CConnection@3feba861 클래스로 
			//    우리가 제공한 datasource 연결정보를 가지고 OracleTest 클래스와 orclHBE00.scott 계정에 연결을 한다. 
			//    두 객체(자바어플 과 데이터베이스)가 연결이 되면 자동커밋(auto commit)으로 세션이 열리게 된다. 
			System.out.println("2번째 라인 :: " + conn);
			System.out.println("2번째 라인 :: conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			Statement stmt = conn.createStatement();
			// 3. 세번째 라인에서 java.sql.Statement 를 상속한 oracle.jdbc.driver.OracleStatementWrapper@10f87f48
			//    오라클 벤더 구현체 클래스가 createStatement() 함수에 적재된 쿼리문 문자열을 가지고 
			//    오라클 데이베이스에 (localhost:1521:orclHBE00", "scott", "tiger") 전달한다. 
			System.out.println("3번째 라인 :: " + stmt);
			
			// 쿼리전달의 시작 포인트는 executQuery() 함수 이다. 
			ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP ORDER BY 1 DESC");
			// 4. 네번째 라인에서 오라클 데이터베이스에 전달된 쿼리문을 오라클 Optimizer가 실행을 해서 결과가 발생이 되면 
			//    oracle.jdbc.driver.OracleStatementWrapper@10f87f48 객체 발생된 결과를 
			//    java.sql.ResultSet 인터페이스를 상속한 오라클 벤더 구현체 클래스  
			//    oracle.jdbc.driver.OracleResultSetImpl@b4c966a가  결과를 받는다.
			//    그 결과를 파일형태의 메모리 구조를 가지고 있다. 
			System.out.println("rsRs >>> : " + rsRs);
			
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
