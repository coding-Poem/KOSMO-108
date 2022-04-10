package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.prac2.vo.EmpVO_p;

public class OracleTest_p3 {
	
	//  DataSource 정보: 데이터베이스 연결 정보
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";

	// sql Query
	public static String sqlQuery="SELECT A.EMPNO AS EMPNO, A.ENAME AS ENAME, A.JOB AS JOB, A.MGR FROM SCOTT.EMP A ORDER BY 1 DESC";
	
	/*
	 * 8.  SELECT A.EMPNO AS EMPNO, A.ENAME AS ENAME, A.JOB AS JOB, A.MGR 
	 * 	   FROM SCOTT.EMP A ORDER BY 1 DESC";
	 * */
	
	
	// 생성자
	public OracleTest_p3(){
		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't find JDBC Driver"+e.getMessage());	
		}
	}
	// 2. 생성자가 생성되면 oracle.jdbc.driver.OracleDriver 클래스를
	// Class.forName으로 찾는다. 찾지 못할 경우, Can't find JDBC Driver를  출력시킨다.
	
	public ArrayList<EmpVO_p> empSelect(){
		ArrayList<EmpVO_p> aList=null;
		// 4. ArrayList<EmpVO_p> aList 초기화
		try {
			Connection conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			System.out.println("Connection conn >>> : "+conn);
			// Connection conn >>> : oracle.jdbc.driver.T4CConnection@5fa7e7ff
			
			/* 5. java.sql.Conncetion 인터페이스를 Oracle Vender에서 jdbc 드라이버를 만드는 팀에서 실현한
			 *    oracle.jdbc.driver.T4CConnection@5fa7e7ff 클래스로 우리가 제공한  datasource 연결정보를 가지고
			 *    OracleTest_p3 클래스와 orclYYS00.scott 계정에 연결을 한다.
			 */
			
			Statement stmt=conn.createStatement();
			System.out.println("Statement stmt >>> : "+stmt);
			// Statement stmt >>> : oracle.jdbc.driver.OracleStatementWrapper@6adca536

			/* 6. java.sql.Statement를 상속한 oracle.jdbc.driver.OracleStatementWrapper@6adca536
			* 	    오라클 벤더 구현체 클래스가 createStatement() 함수에 적재된 쿼리로
			* 	    문자열을 가지고 오라클 데이터 베이스에 
			* 	  ("localhost:1521:orclYYS00", "scott","tiger")
			* 	    전달한다.
			*/
			
			ResultSet rsRs=stmt.executeQuery(sqlQuery);
			System.out.println("ResultSet rsRs >>> : "+rsRs);
			// ResultSet rsRs >>> : oracle.jdbc.driver.OracleResultSetImpl@d041cf 
			
			/*
			 * 7. 오라클 데이터베이스에 전달된 쿼리문 => 8번으로 
			 * 	   오라클 Optimizer가 실행을 해서 결과가 발생이 되면
			 *    oracle.jdbc.driver.OracleStatementWrapper@6adca536 겍체 발생된 결과를
			 *    java.sql.ResultSet 인터페이스를 상속한 오라클 벤더 구현체 클래스 
			 * 	  oracle.jdbc.driver.OracleResultSetImpl@d041cf 결과를 받는다.
			 * 	   그 결과를 파일형태의 메모리 구조를 가지고 있다.
			 * */
			
			
			boolean bool=rsRs!=null;
			System.out.println("rsRs!=null >>> : "+bool);
			// rsRs!=null >>> : true
			// 9. if문 수행 전에 rsRs가 null이 아닌지 체크한다.
			if (rsRs!=null){
				aList=new ArrayList<EmpVO_p>();
				// 10. ArrayList<EmpVO_p> 기본생성자를
				// 	   aList 변수로 할당한다.
				
				while(rsRs.next()){
					EmpVO_p evo=new EmpVO_p();
					// 11. EmpVO_p 클래스에 기본생성자를 생성한다.
					
					evo.setEmpno(rsRs.getString("EMPNO"));
					evo.setEname(rsRs.getString("ENAME"));
					evo.setJob(rsRs.getString("JOB"));
					evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(evo);
				}
				
			}
		}catch(Exception e){
			System.out.println("empSelect() 메서드 수행 중 에러 >>> : "+e);
			
		}
		
		System.out.println("aList >>> : "+aList);
		// aList >>> : [a.b.c.prac2.vo.EmpVO_p@2f7c7260, 
		// a.b.c.prac2.vo.EmpVO_p@2d209079, a.b.c.prac2.vo.EmpVO_p@6bdf28bb, 
		// a.b.c.prac2.vo.EmpVO_p@6b71769e, a.b.c.prac2.vo.EmpVO_p@2752f6e2, 
		// a.b.c.prac2.vo.EmpVO_p@e580929, a.b.c.prac2.vo.EmpVO_p@1cd072a9, 
		// a.b.c.prac2.vo.EmpVO_p@7c75222b, a.b.c.prac2.vo.EmpVO_p@4c203ea1, 
		// a.b.c.prac2.vo.EmpVO_p@27f674d, a.b.c.prac2.vo.EmpVO_p@1d251891, 
		// a.b.c.prac2.vo.EmpVO_p@48140564, a.b.c.prac2.vo.EmpVO_p@58ceff1, 
		// a.b.c.prac2.vo.EmpVO_p@7c30a502]
		System.out.println("aList.size() >>> : "+aList.size());
		// aList.size() >>> : 14
		
		// EMP 테이블
		// SELECT COUNT(EMPNO) FROM EMP; => 14
		// SELECT COUNT(ENAME) FROM EMP; => 14
		// SELECT COUNT(JOB) FROM EMP; => 14
		// SELECT COUNT(MGR) FROM EMP; => 13
		// MGR 같은 경우에는 null 값이 잇어서 count로 세면 13개지만, 
		// 7839 : KING : PRESIDENT : null 이렇게 가져옴. primary key가 EMPNO인데,
		// EMPNO가 14개이기 때문 (규칙 : primary key는  null값이 있으면 안  된다.)
		return aList;
	}
	
	public static void main(String[] args) {
		OracleTest_p3 ot3=new OracleTest_p3();
		// 1. OracleTest_p3 클래스를 인스턴스 한다.
		ArrayList<EmpVO_p> aList=ot3.empSelect();
		// 3. 참조변수 ot3의 자원인 함수를 
		// ArrayList<EmpVO_p> 클래스에 aList라는 참조변수로 선언한다.
		
		boolean bool=aList!=null;
		boolean bool2=aList.size() >0;
		
		System.out.println("main 함수 내의 aList != null >>> : "+bool);
		// main 함수 내의 aList != null >>> : true
		System.out.println("main 함수 내의 aList.size() > 0 >>> : "+bool2);
		// main 함수 내의 aList.size() > 0 >>> : true
		System.out.println("aList.size() >>> : "+aList.size());
		// aList.size() >>> : 14
		
		if (aList !=null && aList.size() > 0){
			for (int i=0; i<aList.size(); i++){
				EmpVO_p _evo=aList.get(i);
				System.out.print(_evo.getEmpno()+" : ");
				System.out.print(_evo.getEname()+" : ");
				System.out.print(_evo.getJob()+" : ");
				System.out.print(_evo.getMgr());
				System.out.println();
			}
			
		}

	}

}
