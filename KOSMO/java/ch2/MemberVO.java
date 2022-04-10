package a.b.c.ch2.vo;

// 회원가입 프로그램에서 회원정보를 나르는 클래스 

public class MemberVO {

	 public String mid;
	 public String mpw;
	 public String mname;
	 public String mhp;
	 public String maddr;

	public MemberVO() {
		System.out.println("mid >>> : " + mid);
		System.out.println("mpw >>> : " + mpw);
		System.out.println("mname >>> : " + mname);
		System.out.println("mhp >>> : " + mhp);
		System.out.println("maddr >>> : " + maddr);			
	}

	public MemberVO(String mid, String mpw, String mname, String mhp, String maddr) {
		System.out.println("mid >>> : " + mid);
		System.out.println(" mpw >>> : " + mpw);
		System.out.println(" mname >>> : " + mname);
		System.out.println(" mhp >>> : " + mhp);
		System.out.println(" maddr >>> : " + maddr + "\n");		
	}

}
