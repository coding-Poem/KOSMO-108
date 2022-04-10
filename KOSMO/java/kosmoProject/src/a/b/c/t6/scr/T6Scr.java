package a.b.c.t6.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.ChabunUtil;
import a.b.c.common.DateUtil;
import a.b.c.t6.servie.T6Service;
import a.b.c.t6.servie.T6ServiceImpl;
import a.b.c.t6.vo.T6VO;

public class T6Scr {

	// 전체 조회
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("T6Scr.t6SelectAll >>> :");
		
		T6Service ts = new T6ServiceImpl();
		return ts.t6SelectAll();
	}
	
	// 이름 조회
	public ArrayList<T6VO> t6SelectName(String t2){
		System.out.println("T6Scr.t6SelectName >>> :");
		
		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();		
		tvo.setT2(t2);
		
		return ts.t6SelectName(tvo);
	}
	
	// 날짜 조회
	public ArrayList<T6VO> t6SelectDate(String fromdate, String todate){
		System.out.println("T6Scr.t6SelectDate >>> :");
		
		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();		
		tvo.setFromdate(fromdate);
		tvo.setTodate(todate);
		
		return ts.t6SelectDate(tvo);
	}

	// 입력 
	public boolean t6Insert(String t1, String t2, String t3){
		System.out.println("T6Scr.t6Insert >>> :");
		
		boolean bool = false;
		
		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();
		tvo.setT1(t1);
		tvo.setT2(t2);
		tvo.setT3(t3);
		
		bool = ts.t6Insert(tvo);
		
		return bool;
	}
	
	// 수정
	public boolean t6Update(String t1, String t2, String t3){
		System.out.println("T6Scr.t6Update >>> :");
		
		boolean bool = false;

		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();
		tvo.setT1(t1);
		tvo.setT2(t2);
		tvo.setT3(t3);
		
		bool = ts.t6Update(tvo);
		
		return bool;
	}
	
	// 삭제
	public boolean t6Delete(String t1){
		System.out.println("T6Scr.t6Delete >>> :");
		
		boolean bool = false;
		
		T6VO tvo = null;
		tvo = new T6VO();
		tvo.setT1(t1);

		T6Service ts = new T6ServiceImpl();
		bool = ts.t6Delete(tvo);
		
		return bool;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("T6Scr.main 시작  >>> :");
		
		String t1 = "";
		String t2 = "";
		String t3 = "";
		String fromdate = "";
		String todate = "";
		
		System.out.println("회원 ISUD, CRUD 정보를 입력하시오 >>> : ");
		System.out.println(   "회원 정보 전체 조회 			: SA 	\n"
				            + "회원 정보 이름으로 조회 		: SN 	\n"
				            + "회원 정보 날짜로 조회		: SD 	\n"
				            + "회원 정보 입력			 	: I 	\n"
				            + "회원 정보 수정 			: U 	\n"
				            + "회원 정보 삭제 			: D 	\n");
		
		Scanner sc0 = new Scanner(System.in);
		
		String isudtype = sc0.next();
		if (isudtype !=null) isudtype = isudtype.toUpperCase(); 
		
		// 전체 조회
		if ("SA".equals(isudtype)) {
			System.out.println("회원 정보를 조회합니다. >>> : ");
			
			T6Scr  t6 = new T6Scr();
			ArrayList<T6VO> aList = t6.t6SelectAll();
			
			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {
					T6VO _tvo = aList.get(i);
					T6VO.printT6VO(_tvo);
				}
			}
		}
		
		// 이름 조회
		if ("SN".equals(isudtype)) {
			System.out.println("회원 조회할 이름을 입력하시오 >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("이름 입력하기 >>> : ");
			t2 = sc.next();
			System.out.println("입력한 이름  >>> : " + t2);
			
			T6Scr  t6 = new T6Scr();
			ArrayList<T6VO> aList = t6.t6SelectName(t2);
			
			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {
					T6VO _tvo = aList.get(i);
					T6VO.printT6VO(_tvo);
				}
			}			
		}
		
		// 날짜 조회
		if ("SD".equals(isudtype)) {
			
			System.out.println("날짝 검색 정보를 입력하시오 >>> : ");
			System.out.println("날짝형식은 YYYYMMDD 입니다. >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("from 날짜 입력하기 >>> : ");
			fromdate = sc.next();
			System.out.println("입력한 from 날짜  >>> : " + fromdate);
			
			System.out.println("to 날짜 입력하기 >>> : ");
			todate = sc.next();
			System.out.println("입력한 to 날짜  >>> : " + todate);
			
			if (DateUtil.fromtoDate(fromdate, todate)) return;
			
			T6Scr  t6 = new T6Scr();
			ArrayList<T6VO> aList = t6.t6SelectDate(fromdate, todate);
			
			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {
					T6VO _tvo = aList.get(i);
					T6VO.printT6VO(_tvo);
				}
			}			
			
		}
		
		// 입력
		if ("I".equals(isudtype)) {
			
			System.out.println("회원 가입할 데이터를 입력하시오 >>> : ");
			Scanner sc = new Scanner(System.in);
			// 인서트할 때 
			// 채번로직 함수를 호출해서 채번을 한다. 
			// 현재는 main() 함수에서 하는 데 
			// 실제로는 콘트롤러, 서버스, 다오에서 한다. <-- 채번함수를 호출하는 시점은 프로그램 마다 다 다르다. 
			
			// 현재 만든 채번로직에서는 getT6Chabun 함수를 호출 할 때  맥스값을 제외한 채번 형식을 정한다. 
			// 매개변수 d : YYYYMMDD, m : YYYYMM, y : YYYY, n : 
			
			// ChabunUtil.getT6Chabun("d");
			// ChabunUtil 클래스를 추상 클래스 (abstract class) 로 만드는 이유
			// 개발자가 new 하는 것을 막으려고 
			// getT6Chabun() 함수는 static 함수이다. 이 함수는 new 를 하면 않된다. 클래스이름으로 불러서 사용한다.
			
			// t1 = T202203180005;
			t1 = ChabunUtil.getT6Chabun("d");
			
			System.out.println("이름 입력하기 >>> : ");
			t2 = sc.next();
			System.out.println("입력한 이름  >>> : " + t2);
			
			System.out.println("나이 입력하기 >>> : ");
			t3 = sc.next();
			System.out.println("입력한 나이  >>> : " + t3);
			
			
			T6Scr  t6 = new T6Scr();		
			boolean bool = t6.t6Insert(t1, t2, t3);
			
			if (bool) {
				System.out.println("입력 성공 >>> : " + bool);
				ArrayList<T6VO> aList = t6.t6SelectAll();
				
				if (aList !=null && aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						T6VO _tvo = aList.get(i);
						T6VO.printT6VO(_tvo);
					}
				}
				
			}else {
				System.out.println("입력 실패 >>> : " + bool);
			}
		}
		
		// 수정 
		if ("U".equals(isudtype)) {
			System.out.println("회원 수정할 데이터를 입력하시오 >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("회원 번호 입력하기 >>> : ");
			t1 = sc.next();
			System.out.println("입력한 회원번호  >>> : " + t1);
			
			System.out.println("이름 입력하기 >>> : ");
			t2 = sc.next();
			System.out.println("입력한 이름  >>> : " + t2);
			
			System.out.println("나이 입력하기 >>> : ");
			t3 = sc.next();
			System.out.println("입력한 나이  >>> : " + t3);

			T6Scr  t6 = new T6Scr();		
			boolean bool = t6.t6Update(t1, t2, t3);
			
			if (bool) {
				System.out.println("수정 성공 >>> : " + bool);
			}else {
				System.out.println("수정 실패 >>> : " + bool);
			}
		}
		
		// 삭제 
		if ("D".equals(isudtype)) {
			System.out.println("회원 삭제할 데이터를 입력하시오 >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("회원 번호 입력하기 >>> : ");
			t1 = sc.next();
			System.out.println("입력한 회원번호  >>> : " + t1);
			
			
			T6Scr  t6 = new T6Scr();		
			boolean bool = t6.t6Delete(t1);
			
			if (bool) {
				System.out.println("삭제 성공 >>> : " + bool);
			}else {
				System.out.println("삭제 실패 >>> : " + bool);
			}
		}		
	}
}
