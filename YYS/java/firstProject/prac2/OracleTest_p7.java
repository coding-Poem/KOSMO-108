package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


import a.b.c.prac2.vo.EmpVO_p;

import a.b.c.prac.oracleinfo.OracleInformation;

// 나중에 하기
// a.b.c.oracle.OracleTest_5

@SuppressWarnings("unused")
public class OracleTest_p7 {
	// sql Query
	// EMPNO = ? :: place holder 
	public static String sqlQuery="SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO=? AND ENAME=UPPER(?) ";
	// 1st place holder : EMPNO=? : 7499
	// 2nd place holder : ENAME=UPPER(?) : ALLEN
	
	//생성자
	public OracleTest_p7(){
		try {
			Class.forName(OracleInformation.JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't find JDBC Driver");
		}
	}
	
	// empSelect method
	public ArrayList<EmpVO_p> empSelect(String empno, String ename){
		ArrayList<EmpVO_p> aList = null;
		try{
			Connection conn=DriverManager.getConnection(OracleInformation.JDBC_URL, OracleInformation.JDBC_USER, OracleInformation.JDBC_PASSWORD);
			
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			System.out.println("Your Query >>> : \n"+sqlQuery);
			// SELECT EMPNO, ENAME, JOB, MGR FROM EMP 
			// WHERE EMPNO=? AND ENAME=UPPER(?) 
			pstmt.setString(1, empno); // 1st place holder
			pstmt.setString(2,  ename); // 2nd place holder
			
			ResultSet rsRs = pstmt.executeQuery();
			
			boolean bool= rsRs != null;
			System.out.println(" rsRs != null >>> : "+bool);
			// true
			
			if(rsRs!=null){
				aList=new ArrayList<EmpVO_p>();
				
				while(rsRs.next()){
					EmpVO_p evo=new EmpVO_p();
					
					// SELECT EMPNO, ENAME, JOB, MGR 
					// FROM EMPNO=? AND ENAME=UPPER(?)
					evo.setEmpno(rsRs.getString("EMPNO"));
					evo.setEname(rsRs.getString("ENAME"));
					evo.setJob(rsRs.getString("JOB"));
					evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(evo);
				}
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return aList;
	}
	
	public static void main(String[] args) {
		OracleTest_p7 ot7=new OracleTest_p7();
		
		System.out.println("검색할 사원의 사번과 이름을 입력하시오 >>> : ");
		Scanner sc = new Scanner(System.in);
		
		String empno = sc.next();
		System.out.println("검색할 사원의 사번 >>> : "+empno);
		// 7499
		String ename=sc.next();
		System.out.println("검색할 사원의 이름 >>> : "+ename);
		// ALLEN
		
		ArrayList<EmpVO_p> aList=ot7.empSelect(empno, ename);
		
		boolean bool1= aList != null;
		boolean bool2= aList.size() >0;
		System.out.println("aList != null >>> : "+bool1);
		// aList != null >>> : true
		System.out.println("aList.size() > 0 >>> : "+bool2);
		// aList.size() > 0 >>> : true
		
		if (aList != null && aList.size() > 0){
			System.out.println("aList.size() >>> : "+aList.size());
			// aList.size() >>> : 1
			System.out.println("aList.get(0) >>> : ");
			System.out.print(aList.get(0));
			// a.b.c.prac2.vo.EmpVO_p@4f933fd1
			System.out.println();
			
			for(int i=0; i<aList.size(); i++){
				EmpVO_p _evo=aList.get(i);
				System.out.print(_evo.getEmpno() + " : ");
				System.out.print(_evo.getEname() + " : ");
				System.out.print(_evo.getJob() + " : ");
				// 7499 : ALLEN : SALESMAN : 7698
				System.out.println(_evo.getMgr());
			}
		}
		
		sc.close(); 
	}

}
