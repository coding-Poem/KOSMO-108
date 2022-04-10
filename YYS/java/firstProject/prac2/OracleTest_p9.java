package a.b.c.prac2;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.prac.oracleinfo.OracleInformation;
import a.b.c.prac2.vo.EmpVO_p;

public class OracleTest_p9 {

	// 생성자
	public OracleTest_p9(){
		try {
			Class.forName(OracleInformation.JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't fine JDBC Driver");
		}
	}
	
	// sqlQuery
	public static String sqlQuery="SELECT*FROM EMP WHERE EMPNO LIKE ?";
	
	// empSelect(EmpVO_p evo) method
	public ArrayList<EmpVO_p> empSelect(EmpVO_p evo){
		ArrayList<EmpVO_p> aList = null;
		String empno="";
		
		try {
			Connection conn=DriverManager.getConnection(OracleInformation.JDBC_URL, OracleInformation.JDBC_USER, OracleInformation.JDBC_PASSWORD);
			
			PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
			
			empno=evo.getEmpno();
			System.out.println("empno >>> : "+empno);
			// empno >>> : 4
			
			pstmt.setString(1, "%"+empno+"%");
			
			ResultSet rsRs=pstmt.executeQuery();
			
			boolean bool= rsRs != null;
			System.out.println("rsRs != null >>> :"+bool);
			// rsRs != null >>> :true
			
			if (rsRs!=null){
				aList=new ArrayList<EmpVO_p>();
				
				while(rsRs.next()){
					EmpVO_p _evo=new EmpVO_p();
					
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(_evo);
				}
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		boolean bool1= aList != null;
		System.out.println("aList != null >>> : "+bool1);
		// aList != null >>> : true
		
		return aList;
	}
	
	public static void main(String[] args) {
		OracleTest_p9 ot9 = new OracleTest_p9();
		
		System.out.println("검색할 사원의 사번을 입력하시오 >>> :");
		Scanner sc=new Scanner(System.in);
		
		String empno=sc.next();
		System.out.println("검색할 사원의 사번 >>> :"+empno);
		// 검색할 사원의 사번 >>> :4 
		
		EmpVO_p evo=null;
		evo=new EmpVO_p();
		evo.setEmpno(empno);
		
		ArrayList<EmpVO_p> aList = ot9.empSelect(evo);
		
		// 단락회로현상 방지 확인 작업
		boolean bool1= aList != null;
		boolean bool2= aList.size() > 0;
		System.out.println("aList != null >>> : "+bool1);
		// aList != null >>> : true
		System.out.println("aList.size() > 0 >>> : "+bool2);
		// aList.size() > 0 >>> : true
		
		if (aList != null && aList.size() > 0){
			System.out.println("aList.size() in main method >>> : "+aList.size());
			// aList.size() in main method >>> : 4
			System.out.println("aList.get(0) >>>> : "+aList.get(0));
			// aList.get(0) >>>> : a.b.c.prac2.vo.EmpVO_p@4f933fd1
			for (int i=0; i<aList.size(); i++){
				EmpVO_p _evo=aList.get(i);
				System.out.println("aList.get("+i+") >>> : "+_evo+"\n");
				System.out.print(_evo.getEmpno()+ " : ");
				System.out.print(_evo.getEname()+ " : ");
				System.out.print(_evo.getJob()+" : ");
				System.out.println(_evo.getMgr());
				System.out.println();
				// aList.get(0) >>> : a.b.c.prac2.vo.EmpVO_p
				// @4f933fd1
				// 7499 : ALLEN : SALESMAN : 7698
				// @548a9f61
				// 7654 : MARTIN : SALESMAN : 7698
				// @1753acfe
				// 7844 : TURNER : SALESMAN : 7698
				// @7c16905e
				// 7934 : MILLER : CLERK : 7782
			}
		}
		sc.close();
	}

}
