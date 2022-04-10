package a.b.c.prac.emp.search.scr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import a.b.c.prac.emp.search.service.EmpSearchServiceImpl_p;
import a.b.c.prac.emp.search.service.EmpSearchService_p;
import a.b.c.prac.emp.search.vo.EmpSearchVO_p;

public class EmpSearchScr_p2 {
	// 1. 전체 검색
	public ArrayList<EmpSearchVO_p> empSelectAll(){
		System.out.println("<<< 0. EmpSearchScr_p2 :: empSelectAll() :: 시작  >>>  \n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// 서비스 클래스 호출
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectAll();
		System.out.println("<<< 8. EmpSearchScr_p2 :: empSelectAll() :: EmpSearchService_p에서 결과 받아오기 성공 >>> \n");
		
		return aList;
	}
	
	// 2. 사번 검색
	public ArrayList<EmpSearchVO_p> empSelectEmpno(String empno){
		System.out.println("<<< 0. EmpSearchScr_p2 :: empSelectEmpno(String empno) :: 시작  >>>  \\n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// 서비스 클래스 호출
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setEmpno(empno);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectEmpno(evo);
		System.out.println("<<< 8. EmpSearchScr_p2 :: empSelectEmpno(String empno) :: EmpSearchService_p에서 결과 받아오기 성공 >>> \n");
	
		return aList;
	}
	
	// 3. 이름 검색
	public ArrayList<EmpSearchVO_p> empSelectEname(String ename){
		System.out.println("<<< 0. EmpSearchScr_p2 :: empSelectEname(String ename) :: 시작  >>>  \\n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// 서비스 클래스 호출
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setEname(ename);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectEname(evo);
		System.out.println("<<< 8. EmpSearchScr_p2 :: empSelectEname(String ename) :: EmpSearchService_p에서 결과 받아오기 성공 >>> \n");

		return aList;
	}
	
	// 4. 사번, 이름검색
	public ArrayList<EmpSearchVO_p> empSelectEmpnoEname(String empno, String ename){
		System.out.println("<<< 0. EmpSearchScr_p2 :: empSelectEmpnoEname(String empno, String ename) :: 시작  >>>  \\n");
		
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// 서비스 클래스 호출
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setEmpno(empno);
		evo.setEname(ename);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectEmpnoEname(evo);
		System.out.println("<<< 8. EmpSearchScr_p2 :: empSelectEmpnoEname(String empno, String ename) :: EmpSearchService_p에서 결과 받아오기 성공 >>> \n");
		
		return aList;
	}
	
	// 5. 직책 검색
	public ArrayList<EmpSearchVO_p> empSelectJob(String job){
		System.out.println("<<< 0. EmpSearchScr_p2 :: empSelectJob(String job) :: 시작  >>>  \n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// 서비스 클래스 호출
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setJob(job);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectJob(evo);
		System.out.println("<<< 8. EmpSearchScr_p2 :: empSelectJob(String job) :: EmpSearchService_p에서 결과 받아오기 성공 >>> \n");
		
		return aList;
	}
	
	// 6. 날짜 검색
	public ArrayList<EmpSearchVO_p> empSelectHiredate(String fromdate, String todate){
		System.out.println("<<< 0-3. EmpSearchScr_p2 :: empSelectHiredate(String fromdate, String todate) :: 시작  >>>  \n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// 서비스 클래스 호출
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setFromdate(fromdate);
		evo.setTodate(todate);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectHiredate(evo);
		System.out.println("<<< 8. EmpSearchScr_p2 :: empSelectHiredate(String fromdate, String todate) :: EmpSearchService_p에서 결과 받아오기 성공 >>> \n");
		
		return aList;
	}
	
	// 6-1. fromDate, toDate 비교 함수
	public boolean fromtoDate(String fromdate, String todate) {
		System.out.println("\n 0. EmpSearchScr_p2 :: fromtoDate(String fromdate, String todate) 시작 \n");
		
		boolean bool = false;
		
		try {
			SimpleDateFormat sDate = new SimpleDateFormat("yyyyMMdd");		
			Date fromDate = sDate.parse(fromdate);
			Date toDate = sDate.parse(todate);
			long f = fromDate.getTime();
			long t = toDate.getTime();
			
			bool = f < t;
			System.out.println("\n 0-1. EmpSearchScr_p2 :: fromtoDate(String fromdate, String todate) :: fromDate > toDate >>> : "+bool);
			
			if (!bool) {
				System.out.println("FROM 날짜가 TO 날짜보다 크면 안 됩니다. >>> : " + bool);
				System.out.println("프로그램을 종료합니다. 다시 실행해서 사용하시오 >>> : ");				
			}
		} catch (Exception e) {
			System.out.println("yyyyMMdd 형식으로 입력해야 비교가 가능합니다.");
			System.out.println("FROM TO 비교중 에러가 >>> : " + e.getMessage());
		}
		return bool;
	}

	public static void main(String[] args) {
		System.out.println("<<< EmpSearchScr_p2 :: main함수 시작  >>> \n");
		
		Scanner sc = null;
		
		try {
			while(true){
				System.out.println("검색한 번호는 		\n"
						+"1. 전체검색		\n"
						+"2. 사번검색 		\n"
						+"3. 이름검색		\n"
						+"4. 사번, 이름검색	\n"
						+"5. 직책검색		\n"
						+"6. 날짜검색		\n"
						+"7. 프로그램 종료 	\n");
				sc = new Scanner(System.in);
				int n = sc.nextInt();
				
				if (n==7){
					System.out.println(n+"번이 입력되었습니다.");
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					// // System을 종료하는 명령어
				}
				
				
				if (n>7 || n<1){
					boolean bool1=false;
					boolean bool2=false;
					
					bool1= n>6;
					bool2= n<1;
					System.out.println("입력한 번호가 6을 초과하는 숫자에 해당 >>> : "+bool1);
					System.out.println("입력한 번호가 1 미만의 숫자에 해당 >>> : "+bool2);
					System.out.println("입력한 번호가  잘못되었습니다. \n 입력한 번호 >>> : "+n);
					System.out.println("프로그램을 종료합니다. >>> ");
					System.exit(0);
					// System을 종료하는 명령어
				}
				
				while(true){
					if(1==n){
						System.out.println(n+" 번을 입력하셨습니다.");
						
						EmpSearchScr_p2 es1 = new EmpSearchScr_p2();
						ArrayList<EmpSearchVO_p> aList= es1.empSelectAll();
						
						System.out.println("<<< 9. EmpSearchScr_p2 :: main :: EmpSearchScr_p2.empSelectAll() 에서 결과 받아오기 성공 >>> \n");
						if (aList != null && aList.size() > 0){
							System.out.println("<<< 10. EmpSearchScr_p2 :: main :: getter method로 가져오겠습니다. >>> \n");
							
							System.out.println("\n ========================출력 결과================================");
							System.out.println("EMPNO : ENAME : JOB   : MGR  : HIREDATE   : SAL  : COMM : DEPTNO");
							System.out.println("=============================================================== \n");
							for (int i=0; i<aList.size(); i++){
								EmpSearchVO_p esvo=aList.get(i);
								System.out.print(esvo.getEmpno()+" : ");
								System.out.print(esvo.getEname()+" : ");
								System.out.print(esvo.getJob()+" : ");
								System.out.print(esvo.getMgr()+" : ");
								System.out.print(esvo.getHiredate()+" : ");
								System.out.print(esvo.getSal()+" : ");
								System.out.print(esvo.getComm()+" : ");
								System.out.print(esvo.getDeptno());
								System.out.println();
							}
							System.out.println("\n ============================================================== \n");
							System.out.println("\n <<< 11. EmpSearchScr_p2 :: main :: 출력 끝 >>> ");
						}else{
							boolean bool_a=false;
							boolean bool_b=false;
							bool_a = aList != null;
							bool_b = aList.size() > 0;
							System.out.println("aList != null >>> : "+bool_a);
							System.out.println("aList.size() > 0 >>> :"+bool_b);
							System.out.println("EmpSearchVO_p :: main :: aList 에러");
						}
						break;
					}
					
					if(2==n){
						System.out.println(n+" 번 입력 : 사원번호를 입력해주세요.");
						
						Scanner sc2=new Scanner(System.in);
						String empno=sc2.next();
						
						EmpSearchScr_p2 es2 = new EmpSearchScr_p2();
						ArrayList<EmpSearchVO_p> aList= es2.empSelectEmpno(empno);
						
						System.out.println("<<< 9. EmpSearchScr_p2 :: main :: EmpSearchScr_p2.empSelectEmpno(String empno) 에서 결과 받아오기 성공 >>> \n");
						if (aList != null && aList.size() > 0){
							System.out.println("<<< 10. EmpSearchScr_p2 :: main :: getter method로 가져오겠습니다. >>> \n");
							
							System.out.println("\n ===============출력 결과============== \n");
							System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
							for (int i=0; i<aList.size(); i++){
								EmpSearchVO_p esvo=aList.get(i);
								
								System.out.print(esvo.getEmpno()+" : ");
								System.out.print(esvo.getEname()+" : ");
								System.out.print(esvo.getJob()+" : ");

								System.out.print(esvo.getHiredate()+" : ");
								System.out.print(esvo.getDeptno());
								System.out.println();
							}
							System.out.println("\n ================================= \n");
							System.out.println("\n <<< 11. EmpSearchScr_p2 :: main :: 출력 끝 >>> ");
						}else{
							boolean bool_a=false;
							boolean bool_b=false;
							bool_a = aList != null;
							bool_b = aList.size() > 0;
							System.out.println("aList != null >>> : "+bool_a);
							System.out.println("aList.size() > 0 >>> :"+bool_b);
							System.out.println("EmpSearchVO_p :: main :: aList 에러");
						}
						break;
					}
					
					if(3==n){
						System.out.println(n+" 번 입력 : 사원이름를 입력해주세요.");
						
						Scanner sc3=new Scanner(System.in);
						String ename=sc3.next();
						
						EmpSearchScr_p2 es3 = new EmpSearchScr_p2();
						ArrayList<EmpSearchVO_p> aList= es3.empSelectEname(ename);
						
						System.out.println("<<< 9. EmpSearchScr_p2 :: main :: EmpSearchScr_p2.empSelectEname(String ename) 에서 결과 받아오기 성공 >>> \n");
						if (aList != null && aList.size() > 0){
							System.out.println("<<< 10. EmpSearchScr_p2 :: main :: getter method로 가져오겠습니다. >>> \n");
							
							System.out.println("\n ================출력 결과============= \n");
							System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
							for (int i=0; i<aList.size(); i++){
								EmpSearchVO_p esvo=aList.get(i);
								
								System.out.print(esvo.getEmpno()+" : ");
								System.out.print(esvo.getEname()+" : ");
								System.out.print(esvo.getJob()+" : ");

								System.out.print(esvo.getHiredate()+" : ");
								System.out.print(esvo.getDeptno());
								System.out.println();
							}
							
							System.out.println("\n ============================================================== \n");
							System.out.println("\n <<< 11. EmpSearchScr_p2 :: main :: 출력 끝 >>> ");
						}else{
							boolean bool_a=false;
							boolean bool_b=false;
							bool_a = aList != null;
							bool_b = aList.size() > 0;
							System.out.println("aList != null >>> : "+bool_a);
							System.out.println("aList.size() > 0 >>> :"+bool_b);
							System.out.println("EmpSearchVO_p :: main :: aList 에러");
						}
						break;
					}
					
					if(4==n){
						System.out.println(n+" 번을 입력 : 사원번호를 입력해주세요.");
						
						Scanner sc4=new Scanner(System.in);
						String empno=sc4.next();
						
						System.out.println(n+" 번 입력 : 사원이름을 입력해주세요.");
						sc4.nextLine();
						String ename=sc4.next();
						

						EmpSearchScr_p2 es4 = new EmpSearchScr_p2();
						ArrayList<EmpSearchVO_p> aList= es4.empSelectEmpnoEname(empno, ename);
						
						System.out.println("<<< 9. EmpSearchScr_p2 :: main :: EmpSearchScr_p2.empSelectEmpnoEname(String empno, String ename) 에서 결과 받아오기 성공 >>> \n");
						if (aList != null && aList.size() > 0){
							System.out.println("<<< 10. EmpSearchScr_p2 :: main :: getter method로 가져오겠습니다. >>> \n");
							
							System.out.println("\n ================출력 결과============= \n");
							System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
							for (int i=0; i<aList.size(); i++){
								EmpSearchVO_p esvo=aList.get(i);
								
								System.out.print(esvo.getEmpno()+" : ");
								System.out.print(esvo.getEname()+" : ");
								System.out.print(esvo.getJob()+" : ");

								System.out.print(esvo.getHiredate()+" : ");
								System.out.print(esvo.getDeptno());
								System.out.println();
							}
							
							System.out.println("\n ============================================================== \n");
							System.out.println("\n <<< 11. EmpSearchScr_p2 :: main :: 출력 끝 >>> ");
						}else{
							boolean bool_a=false;
							boolean bool_b=false;
							bool_a = aList != null;
							bool_b = aList.size() > 0;
							System.out.println("aList != null >>> : "+bool_a);
							System.out.println("aList.size() > 0 >>> :"+bool_b);
							System.out.println("EmpSearchVO_p :: main :: aList 에러");
						}
						break;
					}
					
					if(5==n){
						System.out.println(n+" 번 입력 : 직책를 입력해주세요.");
						
						Scanner sc5=new Scanner(System.in);
						String job=sc5.next();
						
						EmpSearchScr_p2 es5 = new EmpSearchScr_p2();
						ArrayList<EmpSearchVO_p> aList= es5.empSelectJob(job);
						
						System.out.println("<<< 9. EmpSearchScr_p2 :: main :: EmpSearchScr_p2.empSelectJob(String job) 에서 결과 받아오기 성공 >>> \n");
						if (aList != null && aList.size() > 0){
							System.out.println("<<< 10. EmpSearchScr_p2 :: main :: getter method로 가져오겠습니다. >>> \n");
							
							System.out.println("\n ================출력 결과============= \n");
							System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
							for (int i=0; i<aList.size(); i++){
								EmpSearchVO_p esvo=aList.get(i);
								
								System.out.print(esvo.getEmpno()+" : ");
								System.out.print(esvo.getEname()+" : ");
								System.out.print(esvo.getJob()+" : ");

								System.out.print(esvo.getHiredate()+" : ");
								System.out.print(esvo.getDeptno());
								System.out.println();
							}
							
							System.out.println("\n ============================================================== \n");
							System.out.println("\n <<< 11. EmpSearchScr_p2 :: main :: 출력 끝 >>> ");
						}else{
							boolean bool_a=false;
							boolean bool_b=false;
							bool_a = aList != null;
							bool_b = aList.size() > 0;
							System.out.println("aList != null >>> : "+bool_a);
							System.out.println("aList.size() > 0 >>> :"+bool_b);
							System.out.println("EmpSearchVO_p :: main :: aList 에러");
						}
						break;
					}
					
					if(6==n){
						
						System.out.println(n+" 번 입력 : FROM 날짜를 입력해주세요.");
						System.out.println("날짜형식을 yyyyMMdd 형식으로 입력해주십시오.");
						Scanner sc6=new Scanner(System.in);
						String fromdate=sc6.next();
						System.out.println("입력된 FROM 날짜 >>> : "+fromdate);
						
						System.out.println(n+" 번 입력 : TO 날짜를 입력해주세요.");
						System.out.println("날짜형식을 yyyyMMdd 형식으로 입력해주십시오.");
						sc6.nextLine();
						String todate=sc6.next();
						System.out.println("입력된 TO 날짜 >>> : "+todate);
									
						EmpSearchScr_p2 es6 = new EmpSearchScr_p2();
						
						boolean b=false;
						b=es6.fromtoDate(fromdate, todate);
						System.out.println("\n 0-2. EmpSearchScr_p2 :: main :: fromtoDate(fromdate, todate) :: fromDate < toDate >>> : "+b);
						
						if(b){
							ArrayList<EmpSearchVO_p> aList= es6.empSelectHiredate(fromdate, todate);
						
							System.out.println("<<< 9. EmpSearchScr_p2 :: main :: EmpSearchScr_p2.empSelectHiredate(String fromdate, String todate) 에서 결과 받아오기 성공 >>> \n");
							if (aList != null && aList.size() > 0){
								System.out.println("<<< 10. EmpSearchScr_p2 :: main :: getter method로 가져오겠습니다. >>> \n");
							
								System.out.println("\n ===============출력 결과============== \n");
								System.out.println("EMPNO : ENAME : JOB 	: HIREDATE : DEPTNO");
								for (int i=0; i<aList.size(); i++){
									EmpSearchVO_p esvo=aList.get(i);
								
									System.out.print(esvo.getEmpno()+" : ");
									System.out.print(esvo.getEname()+" : ");
									System.out.print(esvo.getJob()+" : ");

									System.out.print(esvo.getHiredate()+" : ");
									System.out.print(esvo.getDeptno());
									System.out.println();
								}
								
								System.out.println("\n ============================================================== \n");
								System.out.println("\n <<< 11. EmpSearchScr_p2 :: main :: 출력 끝 >>> ");
							}else{
								boolean bool_a=false;
								boolean bool_b=false;
								bool_a = aList != null;
								bool_b = aList.size() > 0;
								System.out.println("aList != null >>> : "+bool_a);
								System.out.println("aList.size() > 0 >>> :"+bool_b);
								System.out.println("EmpSearchVO_p :: main :: aList 에러");
							}
						}
						break;
					}
				} // 소 : while(true)						
			} // 대 :  while(true)
		}catch(Exception e){
			System.out.println("error >>> : "+e);
		}finally{
			if(sc!=null){
				try{sc.close(); sc=null;}catch(Exception e){}
				}
		} // try-catch-finally

	} // main method

} // EmpSearchScr_p2 class
