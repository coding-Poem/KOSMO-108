package a.b.c.emp.search.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.DateUtil;
import a.b.c.emp.search.service.EmpSearchService;
import a.b.c.emp.search.service.EmpSearchServiceImpl;
import a.b.c.emp.search.vo.EmpSearchVO;

public class EmpSearchScr {
	
	// 화면과 서비스를 연결하는 함수하는 함수들 <-- 콘트롤러 
	
	// 전체 검색
	public ArrayList<EmpSearchVO> empSelectAll() {
		System.out.println("EmpSearchScr.empSelectAll() 함수 시작 >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		ArrayList<EmpSearchVO> aList = es.empSelectAll();
		
		return aList;
	}
	
	// 사번 검색
	public ArrayList<EmpSearchVO> empSelectEmpno(String empno) {
		System.out.println("EmpSearchScr.empSelectEmpno() 함수 시작 >>> : ");

		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO 에 검색 키워드 사번을 세팅한다. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setEmpno(empno);
		
		ArrayList<EmpSearchVO> aList = es.empSelectEmpno(evo);
		
		return aList;
	}

	// 이름 검색
	public ArrayList<EmpSearchVO> empSelectEname(String ename){
		System.out.println("EmpSearchScr.empSelectEname() 함수 시작 >>> : ");
		System.out.println("EmpSearchScr.empSelectEname() ename >>> : " + ename);
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO 에 검색 키워드 사번을 세팅한다. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setEname(ename);
		System.out.println("EmpSearchScr.empSelectEname() evo.getEname() >>> : " + evo.getEname());
		
		ArrayList<EmpSearchVO> aList = es.empSelectEname(evo);
		
		return aList;
	}
	
	// 사번 이름 검색
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(String empno, String ename) {		
		System.out.println("EmpSearchScr.empSelectEmpnoEname() 함수 시작 >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO 에 검색 키워드 사번을 세팅한다. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setEmpno(empno);
		evo.setEname(ename);
		
		ArrayList<EmpSearchVO> aList = es.empSelectEmpnoEname(evo);
		
		return aList;
	}
	
	// 직책 검색
	public ArrayList<EmpSearchVO> empSelectJob(String job) {	
		System.out.println("EmpSearchScr.empSelectJob() 함수 시작 >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO 에 검색 키워드 사번을 세팅한다. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setJob(job);
		
		ArrayList<EmpSearchVO> aList = es.empSelectJob(evo);
		
		return aList;
	}
	
	// 날짜 검색 
	public ArrayList<EmpSearchVO> empSelectHiredate(String fromdate, String todate) {
		System.out.println("EmpSearchScr.empSelectHiredate() 함수 시작 >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO 에 검색 키워드 사번을 세팅한다. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setFromdate(fromdate);
		evo.setTodate(todate);
		
		ArrayList<EmpSearchVO> aList = es.empSelectHiredate(evo);
		
		return aList;
	}
	
	
	// 메인 함수가 화면 역활을 한다. 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchScr.main() 함수 시작 >>> : ");
		
		Scanner sc = null;
		
		try {
			
			while (true) {
				
				System.out.println("검색한 번호는 			\n"
						+ "1. 전체검색 		\n"
						+ "2. 사번 검색 		\n"
						+ "3. 이름 검색 		\n"
						+ "4. 사번, 이름 검색 	\n"
						+ "5. 직책 검색 		\n"
						+ "6. 날짜 검색 		\n");
				
				sc = new Scanner(System.in);
				int n = sc.nextInt();
				
				if (9 == n) {
					System.out.println("프로그램을 종료합니다. >>> :");
					System.exit(0);
				}
				
				while (true) {
					
					if (1 == n) {
						System.out.println(n + " 전체 검색을 선택 했습니다 >>> : ");
					
						EmpSearchScr es1 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es1.empSelectAll();
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");
								System.out.print(esvo.getMgr() + " : ");
								System.out.print(esvo.getHiredate() + " : ");
								System.out.print(esvo.getSal() + " : ");
								System.out.print(esvo.getComm() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (2 == n) {
						System.out.println(n + " 사번 검색을 선택 했습니다 >>> : ");
						
						Scanner sc2 = new Scanner(System.in);
						String empno = sc2.next();
						
						EmpSearchScr es2 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es2.empSelectEmpno(empno);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (3 == n) {
						System.out.println(n + " 이름 검색을 선택 했습니다 >>> : ");
						
						System.out.println("이름을 입력하시오 >>> : " );
						Scanner sc3 = new Scanner(System.in);
						String ename = sc3.next();
						System.out.println("입력한 이름은 >>> : " + ename);
						
						EmpSearchScr es3 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es3.empSelectEname(ename);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (4 == n) {
						System.out.println(n + " 사번 이름 검색을 선택 했습니다  >>> : ");
						
						Scanner sc4= new Scanner(System.in);
						String empno = sc4.next();
						String ename = sc4.next();
						
						EmpSearchScr es4 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es4.empSelectEmpnoEname(empno, ename);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (5 == n) {
						System.out.println(n + " 직책 검색을 선택 했습니다 >>> : ");
						
						Scanner sc5 = new Scanner(System.in);
						String job = sc5.next();
						
						EmpSearchScr es5 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es5.empSelectJob(job);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
					}
					
					if (6 == n) {
						System.out.println(n + " 날짜 검색을 선택 했습니다 >>> : ");
						System.out.println("날짜 형식을 YYYYMMDD 입니다. >>> : ");
						
						Scanner sc6 = new Scanner(System.in);
						String fromdate = sc6.next();
						System.out.println("검색할 from 날짜 >>> : " + fromdate);
						String todate = sc6.next();
						System.out.println("검색할 to 날짜 >>> : " + todate);
						
						// from > to 비교
						if (DateUtil.fromtoDate(fromdate, todate)) return;
						
						EmpSearchScr es6 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es6.empSelectHiredate(fromdate, todate);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					} // end of if (6 == n)
				} // end of while()
			} // end of while()			
			
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e);
		}finally {
			if (sc !=null) sc.close();
		}
	} // end of main()
} // end of EmpSearchScr Class
