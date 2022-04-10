package a.b.c.ch4.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.ch4.mem.service.MemberService;
import a.b.c.ch4.mem.service.MemberServiceImpl;
import a.b.c.ch4.mem.vo.MemberVO;

public class MemberScr {
	
	// 회원을 가입(입력), 수정, 삭제, 조회 
	// CRUD : CREATE 입력,  READ 조회,  UPDATE  수정, DELETE 삭제 
	// ISUD : INSERT 입력,  SELECT 조회,  UPDATE  수정, DELETE 삭제
	
	// 회원 조회
	public ArrayList<MemberVO> memSelect(){
		System.out.println("MemberScr.memSelect() 시작  >>> : ");
		return null;
	}
	
	// 회원 가입
	public int memInsert(MemberVO mvo) {
		return 0;
	}
	
	// 회원 수정
	public int memUpdate(MemberVO mvo) {
		return 0;
	}
	
	// 회원 삭제
	public int memDelete(MemberVO mvo) {
		return 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberScr mscr = new MemberScr();
		
		System.out.println("CRUD를 선택하세요  >>> ");
		System.out.println("I  입력,  S 조회, U 수정, D 삭제, Q 종료");
		Scanner sc = new Scanner(System.in);
		String crudType ="";
				
		while(true) {
			crudType=sc.next();
			crudType=crudType.toUpperCase();
			boolean bool_1=crudType.length()>0;
			boolean bool_2=crudType != null;
			System.out.println("crudType.length()가 0보다 크면 true, 아니면 false >>> : "+bool_1);
			System.out.println("crudType != null이면 true, 아니면 false >>> : "+bool_2);
			
		if ("I".equals(crudType)) {		
			System.out.println("MemberScr.main() 시작  >>> : crudType ::: " + crudType);
			MemberService sci=new MemberServiceImpl();
			MemberVO mvo = new MemberVO();
			sci.memInsert(mvo);
		}
		if ("S".equals(crudType)) {
			System.out.println("MemberScr.main() 시작  >>> : crudType >>> : " + crudType);
			MemberService sci=new MemberServiceImpl();
			MemberVO mvo=new MemberVO();
			sci.memSelect();
		}
		if ("U".equals(crudType)) {
			System.out.println("MemberScr.main() 시작  >>> : crudType >>> : " + crudType);
			MemberService sci=new MemberServiceImpl();
			MemberVO mvo = new MemberVO();
			sci.memUpdate(mvo);
		}
		if ("D".equals(crudType)) {
			System.out.println("MemberScr.main() 시작  >>> : crudType >>> : " + crudType);
			MemberService sci=new MemberServiceImpl();
			MemberVO mvo = new MemberVO();
			sci.memDelete(mvo);
		}
		if ("Q".equals(crudType)){
			System.out.println("\n 프로그램을 종료합니다.");
			break;
		}
		} // while
	} // main
} // MemberScr class







