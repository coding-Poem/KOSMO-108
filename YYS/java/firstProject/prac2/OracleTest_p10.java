package a.b.c.prac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.prac.oracleinfo.OracleInformation;
import a.b.c.prac2.vo.EmpVO_p;

public class OracleTest_p10 {
	// sqlQuery
	public static String[] sqlQuery={
			"SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE '%' || ? || '%'"
			,"SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO LIKE ? "
	};
	
	// 생성자
	public OracleTest_p10(){
		try{
			Class.forName(OracleInformation.JDBC_DRIVER);
		}catch(Exception e){
			System.out.println("Can't find JDBC_DRIVER"+e.getMessage());
		}
	}
	
	// empSelect method
	public ArrayList<EmpVO_p> empSelect(EmpVO_p evo){
		 ArrayList<EmpVO_p> aList=null;
		 
			try {
				
				Connection conn = DriverManager.getConnection(OracleInformation.JDBC_URL, OracleInformation.JDBC_USER, OracleInformation.JDBC_PASSWORD);			
				
				PreparedStatement pstmt = conn.prepareStatement(OracleTest_p10.sqlQuery[0]);	
				pstmt.setString(1,  evo.getEmpno());
				
				ResultSet rsRs = pstmt.executeQuery();
				
				if (rsRs !=null) {
					aList = new ArrayList<EmpVO_p>();
					
					while (rsRs.next()) {
						
						EmpVO_p _evo = new EmpVO_p();
						
						_evo.setEmpno(rsRs.getString("EMPNO"));
						_evo.setEname(rsRs.getString("ENAME"));
						_evo.setJob(rsRs.getString("JOB"));
						_evo.setMgr(rsRs.getString("MGR"));
						
						aList.add(_evo);
					}				
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
		
		boolean bool= aList != null;
		System.out.println("empSelect : aList != null >>> : "+bool);
		return aList;
	}
	
	public ArrayList<EmpVO_p> empSelect_1(EmpVO_p evo) {
		
		ArrayList<EmpVO_p> aList = null;
		
		try {
			
			Connection conn = DriverManager.getConnection(OracleInformation.JDBC_URL, OracleInformation.JDBC_USER, OracleInformation.JDBC_PASSWORD);			
			
			PreparedStatement pstmt = conn.prepareStatement(OracleTest_p10.sqlQuery[1]);	
//			PreparedStatement pstmt = conn.prepareStatement(OracleTest_p10.sqlQuery[OracleTest_7_1.SQLQUERY_2]);			
			pstmt.setString(1,  "%" + evo.getEmpno() + "%");
			
			ResultSet rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<EmpVO_p>();
				
				while (rsRs.next()) {
					
					EmpVO_p _evo = new EmpVO_p();
					
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setMgr(rsRs.getString("MGR"));
					
					aList.add(_evo);
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		boolean bool= aList != null;
		System.out.println("empSelect_1 : aList != null >>> : "+bool);
		return aList;
	}
	
	
	public static void main(String[] args) {
		OracleTest_p10 ot10 = new OracleTest_p10();
		Scanner sc0=null;
		Scanner sc1=null;
		Scanner sc2=null;
		
		while (true){
			System.out.println("검색 방법을 선택 하시오 1: 2: 3: 검색 끝 ");
			sc0 = new Scanner(System.in);
			int c=sc0.nextInt();
			System.out.println("c (1)>>> : "+c);
			
			if (c==3) break;
			
			while(true){
				System.out.println("c (2)>>> : "+c);
				if (c==1){
					System.out.println(c+" 번을 선택하셨습니다.");
					
					System.out.println("검색할 사원의 사번을 입력하세요.");
					sc1=new Scanner(System.in);
					String empno=sc1.next();
					System.out.println("검색할 사원의 사번 >>> : "+empno);
					
					EmpVO_p evo=null;
					evo=new EmpVO_p();
					evo.setEmpno(empno);
					
					ArrayList<EmpVO_p> aList=ot10.empSelect(evo);
					
					if (aList !=null && aList.size() > 0){
						for (int i=0; i < aList.size(); i++) {
							EmpVO_p _evo = aList.get(i);
							System.out.print(_evo.getEmpno() + " : ");
							System.out.print(_evo.getEname() + " : ");
							System.out.print(_evo.getJob() + " : ");			
							System.out.println(_evo.getMgr());
							System.out.println();
							
						}	
					}
					break;
				}
				
				if (c==2){
					System.out.println(c+" 번을 선택하셨습니다.");
					
					System.out.println("검색할 사원의 사번을 입력하시오 >>> : ");
					sc2=new Scanner(System.in);
					String empno=sc2.next();
					System.out.println("검색할 사원의 사번 >>> : "+empno);
					
					EmpVO_p evo=null;
					evo=new EmpVO_p();
					evo.setEmpno(empno);
					
					ArrayList<EmpVO_p> aList = ot10.empSelect_1(evo);
					
					if (aList !=null && aList.size() > 0){
						for (int i=0; i < aList.size(); i++) {
							EmpVO_p _evo = aList.get(i);
							System.out.print(_evo.getEmpno() + " : ");
							System.out.print(_evo.getEname() + " : ");
							System.out.print(_evo.getJob() + " : ");			
							System.out.println(_evo.getMgr());
							System.out.println();
							
						}	
					}
					
					break;
					
				}
			}	
		}
		sc2.close();
		sc1.close();
		sc0.close();

	} // main method
} // OracleTest_p10 class
