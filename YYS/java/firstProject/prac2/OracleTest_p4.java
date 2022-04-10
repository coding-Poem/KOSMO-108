package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.prac2.vo.DeptVO_p;

/*
 * 요구사항
 * DEPT 테이블 조회하기 JDBC 연동하기
 * DeptTest 자바에서 deptSelect() 함수를 사용해서
 * Dept 테이블에 있는 컬럼 전체를 조회해서
 * main 함수에서 콘솔에 출력하시오.
 * 단, DeptVO 클래스를 사용하기
 * (연습이기 때문에 DeptVO_p 클래스로 연동)
 * */


public class OracleTest_p4 {
	
	// DataSource 정보: 데이터 베이스 연결 정보
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";
	
	// sql Query
	public static String sqlQuery="SELECT B.DEPTNO AS DEPTNO, B.DNAME AS DNAME, B.LOC AS LOC FROM SCOTT.DEPT B";
	
	// 생성자
	public OracleTest_p4(){
		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't find JDBC DRIVER >>> : "+e.getMessage());
		}
	}
	
	// 함수 만들기
	public ArrayList<DeptVO_p> deptSelect(){
		ArrayList<DeptVO_p> aList=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rsRs=null;
		// Connection => Statement => ResultSet
		// CSR 
		// Wrapper : public interface Wrapper
		// Connection, ResultSet, Statement의 상위 Interface
		
		// AutoCloseable : public interface AutoCloseable
		// Connection, ResultSet, Statement의 상위 Interface
		
		boolean bool=false;
		// 사용할 변수들 초기화 시켜 놓기 
		
		try{
			conn=DriverManager.getConnection(OracleTest_p4.JDBC_URL, OracleTest_p4.JDBC_USER, OracleTest_p4.JDBC_PASSWORD);
			// public interface Connection extends Wrapper, AutoCloseable
			// public class DriverManager extends Object
			
			// static Connection : getConnection(String url, String user, String password)
			// Attempts to establish a connection to the given database URL.
			
			System.out.println("Connection conn >>> : "+conn);
			// Connection conn >>> : oracle.jdbc.driver.T4CConnection@5fa7e7ff
			
			
			stmt=conn.createStatement();
			// public interface Statement extends Wrapper, AutoCloseable
			// public interface Connection extends Wrapper, AutoCloseable
			
			// Statement : createStatement()
			// Creates a Statement object for sending SQL statements to the database.
			
			System.out.println("Statement stmt >>> : "+stmt);
			// Statement stmt >>> : oracle.jdbc.driver.OracleStatementWrapper@6adca536

			rsRs=stmt.executeQuery(sqlQuery);
			// public interface ResultSet extends Wrapper, AutoCloseable
			// public interface Statement extends Wrapper, AutoCloseable
			
			// ResultSet : executeQuery(String sql)
			// Executes the given SQL statement, which returns a single ResultSet object.
			
			System.out.println("ResultSet rsRs >>> : "+rsRs);
			// ResultSet rsRs >>> : oracle.jdbc.driver.OracleResultSetImpl@d041cf
			
			bool=rsRs!=null;
			System.out.println("rsRs!=null >>> : "+bool);
			// rsRs!=null >>> : true
			
			if (rsRs!=null){
				aList=new ArrayList<DeptVO_p>();
				while (rsRs.next()){
					// ResultSet의 next 메서드는
					// 대용량 데이터를 다룰 때, 가끔 문제가 생길 때도 있다.
					DeptVO_p dvo=new DeptVO_p();
					dvo.setDeptno(rsRs.getString("DEPTNO"));
					dvo.setDname(rsRs.getString("DNAME"));
					dvo.setLoc(rsRs.getString("LOC"));
					
					aList.add(dvo);
				}
			}
			
		}catch(Exception e){
			System.out.println("deptSelect() 메서드 수행 중 에러 >>> : "+e);
			
		}
		
		System.out.println("aList >>> : "+aList);
		// aList >>> : [a.b.c.prac2.vo.DeptVO_p@6bdf28bb, 
		// a.b.c.prac2.vo.DeptVO_p@6b71769e, a.b.c.prac2.vo.DeptVO_p@2752f6e2, 
		// a.b.c.prac2.vo.DeptVO_p@e580929]
		System.out.println("aList.size() >>> : "+aList.size());
		// aList.size() >>> : 4
		// Dept 테이블 행의 갯수가 4개 (기본키 행의 갯수 : 4)
		return aList;
	}
	public static void main(String[] args) {
		OracleTest_p4 ot4=new OracleTest_p4();
		ArrayList<DeptVO_p> aList=ot4.deptSelect();
		
		boolean bool=aList!=null;
		boolean bool2=aList.size()>0;
		
		System.out.println("main 함수 내의 aList != null >>> : "+bool);
		// main 함수 내의 aList != null >>> : true
		System.out.println("main 함수 내의 aList.size() >>> : "+bool2);
		// main 함수 내의 aList.size() >>> : true
		
		if (aList!=null && aList.size() > 0){
			System.out.println("aList.size() >>> : "+aList.size());
			// aList.size() >>> : 4
			// aList.size()가 있는 것이 확인 될 경우만, size를 출력시킨다.
			for (int i=0; i<aList.size(); i++){
				DeptVO_p _dvo=aList.get(i);
				System.out.print(_dvo.getDeptno()+" : ");
				System.out.print(_dvo.getDname()+" : ");
				System.out.print(_dvo.getLoc()+" : ");
				System.out.println();
			}
		}
	}
}
