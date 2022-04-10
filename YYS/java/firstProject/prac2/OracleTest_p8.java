package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import a.b.c.prac.oracleinfo.OracleInformation;
import a.b.c.prac2.vo.EmpVO_p;

public class OracleTest_p8 {
	
	// sql Query
	public static String sqlQuery="SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO=? AND ENAME=UPPER(?)";
	
	// 생성자
	public OracleTest_p8(){
		try{
			Class.forName(OracleInformation.JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't find JDBC Driver >>> "+e.getMessage());
		}
	}
	
	// empSelect(EmpVO_p evo) method
	public ArrayList<EmpVO_p> empSeleect(EmpVO_p evo){
		ArrayList<EmpVO_p> aList=null;
		
		try{
			Connection conn=DriverManager.getConnection(OracleInformation.JDBC_URL, OracleInformation.JDBC_USER, OracleInformation.JDBC_PASSWORD);
			
			PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
			pstmt.setString(1,  evo.getEmpno());
			pstmt.setString(2,  evo.getEname());
			
			ResultSet rsRs=pstmt.executeQuery();
			
			boolean bool= rsRs != null;
			System.out.println("rsRs != null >>> : "+bool);
			// rsRs != null >>> : true
			
			if (rsRs != null){
				aList=new ArrayList<EmpVO_p>();
				
				while (rsRs.next()){
					EmpVO_p _evo=new EmpVO_p();
					
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getNString("ENAME"));
					_evo.setJob(rsRs.getNString("JOB"));
					_evo.setMgr(rsRs.getNString("MGR"));
					
					aList.add(_evo);
				}
			}
		}catch(Exception e){
			System.out.println("error >>> : "+e);
		}
		
		boolean bool0= aList != null;
		System.out.println("aList != null >>> : "+bool0);
		// aList != null >>> : true
		
		return aList;
	}
	
	public static void main(String[] args) {
		OracleTest_p8 ot8=new OracleTest_p8();
		
		System.out.println("검색할 사원의 사번과 이름을 입력하시오 >>> : ");
		Scanner sc= new Scanner(System.in);
		String empno =sc.next();
		System.out.println("검색한 사원의 사번 >>> : "+empno);
		// 검색한 사원의 사번 >>> : 7499
		String ename=sc.next();
		System.out.println("검색할 사원의 이름 >>> : "+ename);
		// 검색할 사원의 이름 >>> : ALLEN
		
		EmpVO_p evo=null;
		
		evo = new EmpVO_p();
		evo.setEmpno(empno);
		evo.setEname(ename);
		
		ArrayList<EmpVO_p> aList = ot8.empSeleect(evo);
		
		boolean bool_a= aList != null;
		System.out.println("aList != null in main method >>> : "+bool_a);
		// aList != null in main method >>> : true
		boolean bool_b= aList.size() > 0;
		System.out.println("aList.size() > 0 >>> : "+bool_b);
		// aList.size() > 0 >>> : true
		
		if (aList != null && aList.size() > 0){
			System.out.println("aList.size() >>> : "+aList.size());
			// aList.size() >>> : 1
			System.out.println("aList.get(0) >>> : "+aList.get(0));
			// aList.get(0) >>> : a.b.c.prac2.vo.EmpVO_p@4f933fd1
			
			for (int i=0; i<aList.size(); i++){
				EmpVO_p _evo=aList.get(i);
				System.out.print(_evo.getEmpno() + " : ");
				System.out.print(_evo.getEname() + " : ");
				System.out.print(_evo.getJob() + " : ");
				System.out.println(_evo.getMgr());
				System.out.println();
				// 7499 : ALLEN : SALESMAN : 7698
			}
		}
		

	}

}
