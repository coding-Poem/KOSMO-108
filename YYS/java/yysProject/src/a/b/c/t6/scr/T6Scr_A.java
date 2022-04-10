package a.b.c.t6.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.DateUtil;
import a.b.c.t6.service.T6Service_A;
import a.b.c.t6.service.T6Service_AImpl;
import a.b.c.t6.vo.T6VO;


//A : Actual Practice
public class T6Scr_A {
	// 전체 조회
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("T6Scr_A :: t6SelectAll()  :: 시작 ");
		
		T6Service_A ts = new T6Service_AImpl();
		return ts.t6SelectAll();
	} //t6SelectAll()
	
	
	// 이름 조회
	public ArrayList<T6VO> t6SelectName(String t2){
		System.out.println("T6Scr_A :: toSelectName(String name) :: 시작 ");
		System.out.println("name >>> : "+t2);
		
		T6Service_A ts= new T6Service_AImpl();
		T6VO tvo=null;
		tvo=new T6VO();
		tvo.setT2(t2);
		
		return ts.t6SelectName(tvo);
	}

	// 날짜 조회
	public ArrayList<T6VO> t6SelectDate(String fromdate, String todate){
		System.out.println("T6Scr_A :: toSelectDate(String fromdate, String todate)  :: 시작 ");
		
		T6Service_A ts= new T6Service_AImpl();
		T6VO tvo=null;
		tvo=new T6VO();
		tvo.setFromdate(fromdate);
		tvo.setTodate(todate);
		
		return ts.t6SelectDate(tvo);
	}
	
	// 입력
	public boolean t6Insert(String t1, String t2, String t3){
		System.out.println("T6Scr_A :: String t1, String t2, String t3) :: 시작 ");
	}
	
	// 수정
	public boolean t6Update(String t1, String t2, String t3){
		System.out.println("T6Scr_A :: t6Update(String t1, String t2, String t3) :: 시작 ");
	}
	
	// 삭제
	public boolean t6Delete(String t1){
		System.out.println("T6Scr_A :: t6Delete(String t1)  :: 시작 ");
	}
	
	public static void main(String[] args) {
		System.out.println("<<< T6Scr_A.main 시작 >>>");
		
		String t1="";
		String t2="";
		String t3="";
		String fromdate="";
		String todate="";
		
		System.out.println("\n 회원 ISUD, CRUD 정보를 입력하세요");
		System.out.println("회원 정보 전체 조회 		   		: SA 	\n"
						       + "회원 정보 이름으로 조회 		: SN 	\n"
							   + "회원 정보 날짜로 조회 		: SD 	\n"
						   	   + "회원 정보 입력 			: I 	\n"
							   + "회원 정보 수정 			: U 	\n"
							   + "회원 정보 삭제 			: D 	\n");
		
		Scanner sc0 = new Scanner(System.in);
		String isudtype=sc0.next();
		
		if (isudtype !=null) isudtype = isudtype.toUpperCase();
		System.out.println("입력한 정보 (대문자 변환) >>> : "+isudtype);
		
		// 전체 조회
		// 문자열 비교는 자바에서 equals를 쓴다.
		if("SA".equals(isudtype)){
			System.out.println("입력한 정보는 SA >>> : "+isudtype);
			
			T6Scr_A t6=new T6Scr_A();
			ArrayList<T6VO> aList=t6.t6SelectAll();
			
			if (aList!=null&&aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					T6VO _tvo=aList.get(i);
					T6VO.printmethod(_tvo);
				}
			}else{
				System.out.println("aList에 문제가 있습니다. aList >> : "+aList);
				System.out.println("혹은 aList.size()가 0보다 크지 않습니다. aList.size() >> : "+aList.size());
			}
		}
		
		// 이름 조회
		if ("SN".equals(isudtype)){
			System.out.println("입력한 정보 (대문자 변환) >>> : "+isudtype);
			Scanner sc=new Scanner(System.in);
			String name="";
			
			System.out.println("이름을 입력하여 주십시오.");
			t2=sc.next();
			System.out.println("입력한 이름 >>> : "+t2);
			
			T6Scr_A t6=new T6Scr_A();
			ArrayList<T6VO> aList=t6.t6SelectName(t2);
			
			if (aList!=null && aList.size() >0){
				for (int i=0; i< aList.size(); i++){
					T6VO _tvo=aList.get(i);
					T6VO.printmethod(_tvo);
					
				}
			}else{
				System.out.println("aList에 문제가 있습니다. aList >> : "+aList);
				System.out.println("혹은 aList.size()가 0보다 크지 않습니다. aList.size() >> : "+aList.size());
			}
		}
		
		// 날짜 조회
		if ("SD".equals(isudtype)){
			System.out.println("날짜 검색 정보를 입력하시오 >>> : ");
			System.out.println("날짜 형식을 YYYMMDD 입니다. >>> : ");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("from 날짜 입력하기 >> : ");
			fromdate=sc.next();
			System.out.println("입력한  from 날짜 >>> : "+fromdate);
			
			System.out.println("to 날짜 입력하기 >>> : ");
			todate=sc.next();
			System.out.println("입력한 to 날짜 >>> : "+todate);
			
			if (DateUtil.fromtoDate(fromdate, todate)) return;
			//  fromDate보다 toDate가 더 커야 함. 이를 확인
			
			T6Scr_A t6=new T6Scr_A();
			ArrayList<T6VO> aList=t6.t6SelectDate(fromdate, todate);
			
			if(aList!=null&&aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					T6VO _tvo = aList.get(i);
					T6VO.printmethod(_tvo);
				}
			}else{
				System.out.println("aList에 문제가 있습니다. aList >> : "+aList);
				System.out.println("혹은 aList.size()가 0보다 크지 않습니다. aList.size() >> : "+aList.size());
			}
		}
		
		//입력
		if ("I".equals(isudtype)){
			
		}
		
		// 수정
		if ("U".equals(isudtype)){
			
		}
		
		// 삭제
		if ("D".equals(isudtype)){
			
		}
		
		// 예외처리를 따로 하지 않는다.
		// 이유 : if문은 () 소괄호 내의 구문이
		// true 일 때만 실행되기 때문이다.
		
		
		
	} // main method

} // T6Scr_A class
