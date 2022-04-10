package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import a.b.c.oracle.vo.EmpVO;

public class OracleTest_8 {
	
	// DataSource 정보 : 데이터베이스 연결 정보
	public static final String JDBC_DRIVER 		= "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL 		= "jdbc:oracle:thin:@localhost:1521:orclHBE00";
	public static final String JDBC_USER 		= "scott";
	public static final String JDBC_PASSWORD 	= "tiger";
		
	// 생성자 
	public OracleTest_8() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC 드라이버를 찾지 못했서요 >>> : " + e.getMessage());
		}
	}
	
	public static String getEmpSelectQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT  												\n");
		sb.append(" 	 	 A.EMPNO 			EMPNO  						\n");
		sb.append(" 		,A.ENAME 			ENAME  						\n");
		sb.append(" 		,A.JOB 				JOB  						\n");
		sb.append(" 		,A.MGR 				MGR  						\n");		
		sb.append(" 		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD') HIREDATE  	\n");
		sb.append(" FROM  													\n");
		sb.append(" 	     EMP A											\n");
		sb.append(" WHERE 	 1=1											\n");
		sb.append(" AND      TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE(?), 'YYYYMMDD') 	\n");
		sb.append(" AND      TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE(?), 'YYYYMMDD') 	\n");
		
		return sb.toString();
		
	}
	
	public ArrayList<EmpVO> empSelect(EmpVO evo) {
		
		ArrayList<EmpVO> aList = null;
		
		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			
			PreparedStatement pstmt = conn.prepareStatement(OracleTest_8.getEmpSelectQuery());			
			pstmt.setString(1,  evo.getFromdate());
			pstmt.setString(2,  evo.getTodate());
			System.out.println("날짜 검색 쿼리 >>> : \n" + OracleTest_8.getEmpSelectQuery());
			
			ResultSet rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<EmpVO>();
				
				while (rsRs.next()) {
					
					EmpVO _evo = new EmpVO();
					
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setMgr(rsRs.getString("MGR"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					
					aList.add(_evo);
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return aList;
	}
	
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		OracleTest_8 ot8 = new OracleTest_8();
		
		System.out.println("검색할 날짜를 입력 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		String fromdate = sc.next();
		System.out.println("검색할 from 날짜 >>> : " + fromdate);		
		String todate = sc.next();
		System.out.println("검색할 to 날짜 >>> : " + todate);
		
//=================================================================================		
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy/MM/dd");
		Date fromDate = sDate.parse(fromdate);
		Date toDate = sDate.parse(todate);
		long f = fromDate.getTime();
		long t = toDate.getTime();
		System.out.println("fromDate >>> : " + f);
		System.out.println("toDate >>> : " + t);
		
		//=============================================================
		// 아래 루틴 수정하기 
		// from 이 to 보다 크면 로직이 수행되지 않게 한다.
		boolean bool = f > t;
		System.out.println("FROM 날짜가 TO 날짜보다 크면 않됩니다. >>> : " + bool);
		System.out.println("프로그램을 종료합니다. 다시 실행해서 사용하시오 >>> : ");
		if (bool) return;
		//=============================================================
//=================================================================================
		
		EmpVO evo = null;
		evo = new EmpVO();
		evo.setFromdate(fromdate);
		evo.setTodate(todate);
		
		ArrayList<EmpVO> aList = ot8.empSelect(evo);
		
		
		if (aList !=null && aList.size() > 0) {
			
			for (int i=0; i < aList.size(); i++) {
				EmpVO _evo = aList.get(i);
				System.out.print(_evo.getEmpno() + " : ");
				System.out.print(_evo.getEname() + " : ");
				System.out.print(_evo.getJob() + " : ");
				System.out.print(_evo.getMgr() + " : ");
				System.out.println(_evo.getHiredate());
			}
		}
	}
}
