package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.oracle.vo.DeptVO;

public class DeptTest {

	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	
	
	// sql Query 
	public static String sqlQuery = "SELECT DEPTNO, DNAME, LOC  FROM DEPT";	
	
	// 생성자 
	public DeptTest() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC 드라이버를 찾지 못했서요 >>> : " + e.getMessage());
		}
	}
	
	// deptSelect() 함수
	public ArrayList<DeptVO> deptSelect(){
		
		ArrayList<DeptVO> aList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		
		try {
			// 커넥션 연결
			conn = DriverManager.getConnection(	DeptTest.JDBC_URL, 
												DeptTest.JDBC_USER, 
												DeptTest.JDBC_PASSWORD);
			// 쿼리문전달통로 만들기
			stmt = conn.createStatement();
			
			// 쿼리문 전달 및 질의결과 받아오기 
			rsRs = stmt.executeQuery(DeptTest.sqlQuery);
			
			// 데이터베이스에 받아온 질의 결과 DeptVO 와 ArrayList에 넣기 
			
			// 데이터가 있으면 수행하기 
			if (rsRs !=null) {
				// DeptVO 클래스 담은 배열객체 ArrayList 를 인스턴스 한다. 
				aList = new ArrayList<DeptVO>();
				
				// rsRs 에서 데이터 추출해서 DeptVO 에 넣고 ArrayList에 담기
				// 1. while 구문으로 next() 함수 리절트셋에서 레코드 추출하기 
				while (rsRs.next()) {
					// DetpVO 클래스 선언 및 인스턴스 : 데이터베이스에서 가져온 데이터 담기 위해서 
					DeptVO dvo = new DeptVO();
					dvo.setDeptno(rsRs.getString(1));
					dvo.setDname(rsRs.getString(2));
					dvo.setLoc(rsRs.getString(3));
					
					// ArrayList 에 DeptVO 클래스 담기 
					aList.add(dvo);
				}
				
			}else {
				System.out.println("데이터베이스에서 가져온 데이터가 없습니다. >>> : ");
			}
			
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e.getMessage());
		}
		
		return aList;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeptTest dt = new DeptTest();
		
		ArrayList<DeptVO> aList = dt.deptSelect();
		
		if (aList !=null && aList.size() > 0) {
			System.out.println("몇 건인가  >>> : " + aList.size());
			
			for (int i=0; i < aList.size(); i++) {
				DeptVO _dvo = aList.get(i);
				System.out.print(_dvo.getDeptno() + " : ");
				System.out.print(_dvo.getDname() + " : ");
				System.out.println(_dvo.getLoc());
			}
		}		
	}
}
