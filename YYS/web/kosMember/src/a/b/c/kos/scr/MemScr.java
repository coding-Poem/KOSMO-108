package a.b.c.kos.scr;

import java.util.ArrayList;

import a.b.c.common.ChabunUtil;
import a.b.c.common.DateUtil;
import a.b.c.kos.service.MemService;
import a.b.c.kos.service.MemServiceImpl;
import a.b.c.kos.vo.MemVO;
import java.util.Scanner;

public class MemScr {
	// **DQL :: SELECT**
	public ArrayList<MemVO> memSelectAll(){
		System.out.println("MemScr :: memSelectAll() :: Start");
		
		MemService ms=new MemServiceImpl();
		return ms.memSelectAll();
	};
	
	public ArrayList<MemVO> memSelectNum(String mnum){
		System.out.println("MemScr :: memSelectNum()  :: Start");
		System.out.println("MemScr :: memSelectNum() :: mnum >>> :"+mnum);
		
		MemService ms=new MemServiceImpl();
		MemVO mvo=null;
		mvo=new MemVO();
		mvo.setMnum(mnum);
		
		return ms.memSelectNum(mvo);
	};
	
	public ArrayList<MemVO> memSelectName(String mname){
		System.out.println("MemScr :: memSelectName() :: Start");
		System.out.println("MemScr :: memSelectName() :: mname >>> : "+mname);
		
		MemService ms=new MemServiceImpl();
		MemVO mvo=null;
		mvo=new MemVO();
		mvo.setMname(mname);
		
		return ms.memSelectName(mvo);
	};
	
	public ArrayList<MemVO> memSelectDate(String fromdate, String todate){
		System.out.println("MemScr :: memSelectDate() :: Start");
		System.out.println("MemScr :: memSelectDate() :: fromdate >>> : "+fromdate);
		System.out.println("MemScr :: memSelectDate() :: todate >>> : "+todate);
		
		MemService ms=new MemServiceImpl();
		MemVO mvo=null;
		mvo=new MemVO();
		mvo.setFromdate(fromdate);
		mvo.setTodate(todate);
		
		return ms.memSelectDate(mvo);
	};
	
	// **DML :: INSERT, UPDATE, DELETE**
	public boolean memInsert(String mnum, String mname,String mid,String mpw,String mhp,
							 String memail,String mgender,String mhobby,String mlocal,String mmsg){
		System.out.println("\n MemScr :: memInsert() :: Start");
		
		boolean bool=false;
		MemService ms =new MemServiceImpl();
		MemVO mvo=null;
		mvo=new MemVO();
		
		mvo.setMnum(mnum);
		mvo.setMname(mname);
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		mvo.setMhp(mhp);
		mvo.setMemail(memail);
		mvo.setMgender(mgender);
		mvo.setMhobby(mhobby);
		mvo.setMlocal(mlocal);
		mvo.setMmsg(mmsg);
		
		bool=ms.memInsert(mvo);
		
		return bool;
	};
	
	public boolean memUpdate(String mnum, String mname,String mid,String mpw,String mhp,
			 String memail,String mgender,String mhobby,String mlocal,String mmsg){
		System.out.println("\n MemScr :: memUpdate() :: Start");
		
		boolean bool=false;
		MemService ms =new MemServiceImpl();
		MemVO mvo=null;
		mvo=new MemVO();
		
		mvo.setMnum(mnum);
		mvo.setMname(mname);
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		mvo.setMhp(mhp);
		mvo.setMemail(memail);
		mvo.setMgender(mgender);
		mvo.setMhobby(mhobby);
		mvo.setMlocal(mlocal);
		mvo.setMmsg(mmsg);
		
		bool = ms.memUpdate(mvo);
		
		return bool;
	};
	
	public boolean memDelete(String mnum){
		System.out.println("\n MemScr :: memDelete()  :: Start");
		
		boolean bool=false;
		
		MemVO mvo=null;
		mvo=new MemVO();
		mvo.setMnum(mnum);
		
		MemService ms = new MemServiceImpl();
		bool=ms.memDelete(mvo);
		
		
		return bool;
	};


	public static void main(String[] args) {
		String mnum="";
		String mname="";
		String fromdate="";
		String todate="";
		String mid="";
		String mpw="";
		String mhp="";
		String memail="";
		String mgender="";
		String mhobby="";
		String mlocal="";
		String mmsg="";
		
		/*
		String deleteyn="";
		String insertdate="";
		String updatedate="";
		*/
		Scanner sc0=null;
		
		System.out.println("MemScr :: main :: Start 		\n");
		System.out.println("회원 정보 전체조회  : SA 				\n"
							+"회원 번호 조회    : SNUM			\n"
							+"회원 이름 조회    : SNAME 			\n"
							+"날짜 조회 	  : SD 				\n"
							+"회원 정보 입력    : I 				\n"
							+"회원 정보 수정    : U				\n"
							+"회원 정보 삭제    : D 				\n");
		
		sc0=new Scanner(System.in);

		String isudtype=sc0.next();
		if (isudtype!=null) isudtype = isudtype.toUpperCase();

/*************************************************************/		
		// 회원 정보 전체조회  : SA
		if("SA".equals(isudtype)){
			System.out.println("회원 정보 전체조회  : SA == "+isudtype+"\n");
			MemScr mem=new MemScr();
			ArrayList<MemVO> aList=mem.memSelectAll();
			
			if(aList!=null && aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					MemVO _mvo=aList.get(i);
					MemVO.printMemVO(_mvo);
					System.out.println();
				}
			}
		}
		// 회원 번호 조회    : SNum
		// 회원번호  	:: COLUMN_ID :: 1
		if("SNUM".equals(isudtype)){
			System.out.println("회원 번호 조회    : SNUM == "+isudtype+"\n");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("회원 번호 입력하기 >>> : ");
			mnum=sc.next();
			
			System.out.println("입력한 회원 번호  >>> : ");
			
			MemScr mem=new MemScr();
			ArrayList<MemVO> aList=mem.memSelectNum(mnum);
			
			if(aList!=null && aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					MemVO _mvo=aList.get(i);
					MemVO.printMemVO(_mvo);
					System.out.println();
				}
			}	
		}
		// 회원 이름 조회    : SName
		if("SNAME".equals(isudtype)){
			System.out.println("회원 이름 조회    : SNAME == "+isudtype+"\n");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("회원 이름 입력하기 >>> : ");
			mname=sc.next();
			System.out.println("입력한 이름 >>> : "+mname);
			
			MemScr mem=new MemScr();
			ArrayList<MemVO> aList=mem.memSelectName(mnum);
			
			if(aList!=null && aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					MemVO _mvo=aList.get(i);
					MemVO.printMemVO(_mvo);
					System.out.println();
				}
			}
			
		}
				
		// 날짜 조회 	  : SD
		if("SD".equals(isudtype)){
			System.out.println("날짜 조회 	  : SD == "+isudtype+"\n");
			System.out.println("날짜 검색 정보를 입력하시오 >>> : ");
			System.out.println("날짜형식은 YYYYMMDD 입니다. >>> : ");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("from 날짜 입력하기 >>> : ");
			fromdate=sc.next();
			System.out.println("입력한 from 날짜  >>> : " + fromdate);
			
			System.out.println("to 날짜 입력하기 >>> : ");
			todate = sc.next();
			System.out.println("입력한 to 날짜  >>> : " + todate);
			
			if (DateUtil.fromtoDate(fromdate, todate)) return;
			
			MemScr mem=new MemScr();
			ArrayList<MemVO> aList=mem.memSelectDate(fromdate, todate);
			// System.out.println("무사히 scr로 도착");
			
			// System.out.println("aList >>> :"+aList);
			
			if(aList!=null && aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					MemVO _mvo=aList.get(i);
					MemVO.printMemVO(_mvo);
					System.out.println();
				}
			}
		}

		
/*************************************************************/
		// 회원 정보 입력    : I
		if("I".equals(isudtype)){
			System.out.println("회원 정보 입력    : I == "+isudtype+"\n");
			Scanner sc=new Scanner(System.in);
			
			mnum=ChabunUtil.getMemChabun("d");
			
			System.out.println("회원이름을 입력하세요 >>> : ");
			mname=sc.next();
			System.out.println("아이디를 입력하세요 >>> : ");
			mid=sc.next();
			System.out.println("비밀번호를 입력하세요 >>> : ");
			mpw=sc.next();
			System.out.println("핸드폰 번호를 입력하세요 >>> : ");
			mhp=sc.next();
			System.out.println("이메일을 입력하세요 >>> : ");
			memail=sc.next();
			System.out.println("성별을 입력하세요 >>> : ");
			mgender=sc.next();
			System.out.println("취미를 입력하세요 >>> : ");
			mhobby=sc.next();
			System.out.println("지역을 입력하세요 >>> : ");
			mlocal=sc.next();
			System.out.println("내용을 입력하세요 >>> : ");
			mmsg=sc.next();
			
			String s[]= {mnum, mname, mid, mpw, mhp, memail, mgender, mhobby, mlocal, mmsg};
			System.out.println("들어온 입력값의 갯수 >>> : "+s.length);
			
			System.out.println("입력값은 다음과 같습니다. \n");
			for(int i=0; i<s.length; i++){
				System.out.print(s[i]+" :: ");
			}
			
			MemScr mem=new MemScr();
			boolean bool=mem.memInsert(mnum, mname, mid, mpw, mhp, memail, mgender, mhobby, mlocal, mmsg);
			
			if (bool) {
				System.out.println("입력 성공 >>> : " + bool);
				ArrayList<MemVO> aList = mem.memSelectAll();
				
				if (aList !=null && aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MemVO _mvo = aList.get(i);
						MemVO.printMemVO(_mvo);
						System.out.println();
					}
				}		
			}else {
				System.out.println("입력 실패 >>> : " + bool);
			}
		}

/*************************************************************/		
		// 회원 정보 수정    : U
		if("U".equals(isudtype)){
			System.out.println("회원 정보 수정    : U == "+isudtype+"\n");
			Scanner sc=new Scanner(System.in);
			System.out.println("회원 번호 입력하기 >>> : ");
			mnum=sc.next();
			System.out.println("입력한 회원번호 >>> : "+mnum);
			
			System.out.println("회원이름을 수정하세요 >>> : ");
			mname=sc.next();
			System.out.println("아이디를 수정하세요 >>> : ");
			mid=sc.next();
			System.out.println("비밀번호를 수정하세요 >>> : ");
			mpw=sc.next();
			System.out.println("핸드폰 번호를 수정하세요 >>> : ");
			mhp=sc.next();
			System.out.println("이메일을 수정하세요 >>> : ");
			memail=sc.next();
			System.out.println("성별을 수정하세요 >>> : ");
			mgender=sc.next();
			System.out.println("취미를 수정하세요 >>> : ");
			mhobby=sc.next();
			System.out.println("지역을 수정하세요 >>> : ");
			mlocal=sc.next();
			System.out.println("내용을 수정하세요 >>> : ");
			mmsg=sc.next();
			
			String s[]= {mnum, mname, mid, mpw, mhp, memail, mgender, mhobby, mlocal, mmsg};
			System.out.println("들어온 입력값의 갯수 >>> : "+s.length);
			
			System.out.println("입력값은 다음과 같습니다. \n");
			for(int i=0; i<s.length; i++){
				System.out.print(s[i]+" :: ");
			}
			
			MemScr mem=new MemScr();
			boolean bool=mem.memUpdate(mnum, mname, mid, mpw, mhp, memail, mgender, mhobby, mlocal, mmsg);
			
			if (bool) {
				System.out.println("수정 성공 >>> : " + bool);
			}else {
				System.out.println("수정 실패 >>> : " + bool);
			}
		}
		
/*************************************************************/		
		// 회원 정보 삭제    : D
		if("D".equals(isudtype)){
			System.out.println("회원 정보 삭제    : D == "+isudtype+"\n");
			System.out.println("회원 삭제할 데이터를 입력하세요. >>> : ");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("회원 번호 입력하기 >>> : ");
			mnum=sc.next();
			System.out.println("입력한 회원 번호 >>> : "+mnum);
			
			MemScr mem=new MemScr();
			boolean bool=mem.memDelete(mnum);
			
			if (bool) {
				System.out.println("삭제 성공 >>> : " + bool);
			}else {
				System.out.println("삭제 실패 >>> : " + bool);
			}
			
		}
/*************************************************************/		
	} // end of main

} // end of class MemScr
