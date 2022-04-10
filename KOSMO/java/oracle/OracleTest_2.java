package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.oracle.vo.EmpVO;

public class OracleTest_2 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	// sql Query 
	public static String sqlQuery = "SELECT EMPNO AS EA_1, ENAME EA_2, JOB EA_3, MGR EA_4 FROM EMP ORDER BY 1 DESC";
//	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP ORDER BY 1 DESC";	
	
	// 생성자 
	public OracleTest_2() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC 드라이버를 찾지 못했서요 >>> : " + e.getMessage());
		}
	}
	
	public ArrayList<EmpVO> empSelect() {
		
		ArrayList<EmpVO> aList = null;
		
		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			Statement stmt = conn.createStatement();			
			ResultSet rsRs = stmt.executeQuery(sqlQuery);
			
			if (rsRs !=null) {
				aList = new ArrayList<EmpVO>();
				
				while (rsRs.next()) {
					
					EmpVO evo = new EmpVO();
					
					evo.setEmpno(rsRs.getString("EMPNO"));
					evo.setEname(rsRs.getString("ENAME"));
					evo.setJob(rsRs.getString("JOB"));
					evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(evo);
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return aList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OracleTest_2 ot2 = new OracleTest_2();
		
		ArrayList<EmpVO> aList = ot2.empSelect();
		
		if (aList !=null && aList.size() > 0) {
			
			for (int i=0; i < aList.size(); i++) {
				EmpVO _evo = aList.get(i);
				System.out.print(_evo.getEmpno() + " : ");
				System.out.print(_evo.getEname() + " : ");
				System.out.print(_evo.getJob() + " : ");			
				System.out.println(_evo.getMgr());
			}
		}
	}
}
