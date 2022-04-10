package a.b.c.t6.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.ChabunUtil;
import a.b.c.common.DateUtil;
import a.b.c.t6.service.T6Service;
import a.b.c.t6.service.T6ServiceImpl;
import a.b.c.t6.vo.T6VO;
import a.b.c.common.DateUtil;


public class T6_Scr {
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("\n T6_Scr :: t6SelectAll() 시작 ");
		
		
		T6Service ts=new T6ServiceImpl();
		ArrayList<T6VO> aList=ts.t6SelectAll();
		
		return aList;
	};
	
	public ArrayList<T6VO> t6SelectName(String name){
		System.out.println("\n T6_Scr ::  t6SelectName(T6VO tvo) 시작 ");
		System.out.println("입력하신 이름 :: "+name);
		
		T6Service ts=new T6ServiceImpl();
		
		// VO에 검색할 회원 이름을 세팅한다.
		T6VO tvo=null;
		// 기본생성자를 생성한다.
		tvo=new T6VO();
		// 회원 이름을 세팅한다.
		tvo.setT2(name);
		
		ArrayList<T6VO> aList=ts.t6SelectName(tvo);
		
		return aList;
	};
	
	
	
	public ArrayList<T6VO> t6SelectDate(String fromDate, String toDate){
		System.out.println("\n T6_Scr :: t6SelectDate(T6VO tvo) :: 시작 ");
		System.out.println("fromDate >>> : "+fromDate);
		System.out.println("toDate >>> : "+toDate);
			
		T6Service ts=new T6ServiceImpl();
		
		T6VO tvo=null;
		tvo=new T6VO();
		tvo.setFromdate(fromDate);
		tvo.setTodate(toDate);

		ArrayList<T6VO> aList=ts.t6SelectDate(tvo);
		return aList;
	};
	
	
	public boolean t6Insert(String name, String age){
		System.out.println("\n T6_Scr :: t6Insert(T6VO tvo) :: 시작 ");
		System.out.println("입력한 회원 이름 >>> : "+name);
		System.out.println("입력한 회원 나이 >>> : "+age);
		T6VO tvo=null;
		boolean bool=false;
		
		String t1=ChabunUtil.getT6Chabun("d");
		System.out.println("<<< T6_Scr :: t6Insert(String name, String age) ::t1 >>> : "+t1);
		tvo=new T6VO();
		tvo.setT1(t1);
		tvo.setT2(name);
		tvo.setT3(age);
		
		T6Service ts=new T6ServiceImpl();
		bool=ts.t6Insert(tvo);
		
		if(!bool){
			System.out.println("T6_Scr :: t6Insert(String name, String age) :: bool >>> "+bool);
		}
		
		return bool;
	};
	

	public boolean t6Update(String number, String name, String age){
		System.out.println("\n T6_Scr :: t6Update(T6VO tvo) :: 시작 ");
		System.out.println("입력한 회원 번호 >>> : "+number);
		System.out.println("수정할 회원 이름 >>> : "+name);
		System.out.println("수정할 회원 나이 >>> : "+age);
		T6VO tvo=null;
		boolean bool=false;
		
		tvo=new T6VO();
		tvo.setT1(number); // 회원번호 : T1 
		tvo.setT2(name); // 회원이름 : T2 
		tvo.setT3(age); // 회원나이  :T3
		
		T6Service ts=new T6ServiceImpl();
		bool=ts.t6Update(tvo);
		
		if(!bool){
			System.out.println("T6_Scr :: t6Insert(String name, String age) :: bool >>> "+bool);
		}
		
		return bool;
	};

	public boolean t6Delete(String number){
		System.out.println("\n T6_Scr :: t6Delete(T6VO tvo) :: 시작 ");
		T6VO tvo=null;
		tvo=new T6VO();
		boolean bool=false;
		
		tvo=new T6VO();
		tvo.setT1(number); // 회원번호 : T1 
		
		T6Service ts=new T6ServiceImpl();
		bool=ts.t6Delete(tvo);
		
		if(!bool){
			System.out.println("T6_Scr :: t6Insert(String name, String age) :: bool >>> "+bool);
		}
		
		return bool;
	};
	

	public static void main(String[] args) {
		System.out.println("<<< T6_Scr :: main함수 시작 >>>");
		
		
		System.out.println("ISUD 서비스를 시작합니다. \n");
		Scanner sc=null;
		sc=new Scanner(System.in);
		
		try {
			while(true){
				int ans=0;
				ArrayList<T6VO> aList=null;
				System.out.println("<<< 데이터 검색 방법 >>>");
				System.out.println("1 입력 :: 데이터를 추가합니다.(INSERT)  ");
				System.out.println("2 입력 :: 데이터를 조회합니다.(SELECT) ");
				System.out.println("3 입력 :: 데이터를 수정합니다.(UPDATE) ");
				System.out.println("4 입력 :: 데이터를 삭제합니다.(DELETE) ");
				System.out.println("0 입력 :: ISUD 서비스를 종료합니다. ");
				// sc.nextLine();
				ans=sc.nextInt();
					
				// INSERT
				if(ans==1){
					System.out.println(ans+"번을 입력하셨습니다.");
					T6_Scr ts1=new T6_Scr();
					boolean b1=false;
					String name="";
					String age="";
					
					System.out.println("입력할 회원 이름을 입력하여 주십시오.");
					Scanner sc2=new Scanner(System.in);
					name=sc2.next();
					sc2.nextLine();
					System.out.println("입력할 회원 나이를 입력하여 주십시오.");
					age=sc2.next();
				
					b1=ts1.t6Insert(name, age);
					
					if (b1) {
						System.out.println("INSERT 완료");
					}else {System.out.println("INSERT 실패 :: "+b1);}
				} // if(ans==1)

				
				// SELECT
				if (ans==2){
					System.out.println(ans+"번을 입력하셨습니다.");
					System.out.println("<<< SELECT 방법 >>>");
					System.out.println("1 입력 :: TEST_T6 테이블를 전체를 조회합니다.");
					System.out.println("2 입력 :: 회원이름를 조회합니다.(칼럼 ID : T2) ");
					System.out.println("3 입력 :: 입사일을 조회합니다. (칼럼 ID : T5) ");
					System.out.println("0 입력 :: 조회하고 싶은 데이터가 없습니다. 프로그램을 종료할게요.");
					sc.nextLine();
					int sel=0;
					sel=sc.nextInt();
					
					if(sel==1){
						System.out.println(sel+"번 입력 :: 전체 조회");
						T6_Scr ts21=new T6_Scr();
						aList=ts21.t6SelectAll();
						// 여기서 T6_Scr 클래스의 t6SelectAll() 메서드로 올라간다.
						

						if (aList != null && aList.size()>0){
							System.out.println("\n ======= 검색결과 ======= \n");
							for (int i=0; i<aList.size(); i++){
								T6VO tv21=aList.get(i);
								// aList 배열에서 원소를 T6VO 클래스의 참조변수로 대입한다.							
								// tv21.printlnmethod();
								tv21.printmethod();
								System.out.println();
							}
							System.out.println("\n ==================== \n");
						}else {
							System.out.println("T6_Scr :: main :: aList :: "+aList);
							System.out.println("aList.size() :: "+aList.size());
						}
					}
					
					if(sel==2){
						System.out.println(sel+"번 입력 :: 회원이름 조회");
						System.out.println("검색할 회원 이름을 입력하여 주십시오.");
						Scanner sc2=new Scanner(System.in);
						String name=sc2.next();
						
						T6_Scr ts22=new T6_Scr();
						aList=ts22.t6SelectName(name);
						
						if (aList != null && aList.size()>0){
							System.out.println("\n ======= 검색결과 ======= \n");
							for (int i=0; i<aList.size(); i++){
								T6VO tv22=aList.get(i);
								// tv22.printlnmethod();
								tv22.printmethod();
								System.out.println();
							}
							System.out.println("\n ==================== \n");
						}else {
							System.out.println("T6_Scr :: main :: aList :: "+aList);
							System.out.println("aList.size() :: "+aList.size());
						}
						
					}
					if(sel==3){
						System.out.println(sel+"번 입력 :: 입사일 조회");
						System.out.println("fromDate를 yyyyMMdd 형식으로 입력하여 주십시오.");
						String fromDate="";
						String toDate="";
						boolean bool=false;
							
						Scanner sc23=new Scanner(System.in);
						fromDate=sc23.next();
						System.out.println("toDate를 yyyyMMdd 형식으로 입력하여 주십시오.");
						sc23.nextLine();
						toDate=sc23.next();
											
						bool=DateUtil.fromtoDate(fromDate, toDate);
							
						// bool = f > t;
							
						if(!bool){
							
							T6_Scr ts23=new T6_Scr();
						
							aList=ts23.t6SelectDate(fromDate, toDate);
							// 여기서 T6_Scr 클래스의 t6SelectAll() 메서드로 올라간다.
							

							if (aList != null && aList.size()>0){
								System.out.println("\n ======= 검색결과 ======= \n");
								for (int i=0; i<aList.size(); i++){
									T6VO tv23=aList.get(i);
									// aList 배열에서 원소를 T6VO 클래스의 참조변수로 대입한다.
									
									// tv23.printlnmethod();
									tv23.printmethod();
									System.out.println();
									
									}
								System.out.println("\n ======= 검색결과 ======= \n");
								}else {
								System.out.println("T6_Scr :: main :: aList :: "+aList);
								System.out.println("aList.size() :: "+aList.size());
								}
							}else{
								System.out.println("bool = f > t >>> : "+bool);
								System.out.println("fromDate가 toDate 보다 크므로 ISUD 서비스를 종료합니다.");
								System.exit(0);
							}																													
					}
					
					if(sel==0){
						System.out.println(sel+"번 입력 :: 조회하지 않음 :: 프로그램 종료");
						System.exit(0);
					}
					if (sel>3 || sel<0){
						System.out.println("잘못된 값을 입력하셨습니다. 잘못 입력된 값 >>> : "+sel);
						System.out.println("ISUD 프로그램을 프로그램을 종료합니다.");
						sc.close();
						System.exit(0);
					}
				} // if(ans==2)
				
				
				// UPDATE
				if(ans==3){
					System.out.println(ans+"번을 입력하셨습니다.");
					T6_Scr ts3=new T6_Scr();
					boolean b3=false;
					String number="";
					String name="";
					String age="";
					
					System.out.println("입력할 회원 번호을 입력하여 주십시오.");
					Scanner sc2=new Scanner(System.in);
					number=sc2.next();
					sc2.nextLine();
					System.out.println("수정할 회원 이름을 입력하여 주십시오.");
					name=sc2.next();
					sc2.nextLine();
					System.out.println("수정할 회원 나이를 입력하여 주십시오.");
					age=sc2.next();
					
					if (number!=null && name!=null) {
						// 회원번호와 회원이름은 null값이 들어갈 수 없다.
						b3=ts3.t6Update(number, name, age);

						if (b3) {
							System.out.println("UPDATE 완료");
						}else {
							System.out.println("UPDATE 실패 :: "+b3);
						}
						
					}
					else{
						boolean bool1=false;
						boolean bool2=false;
						
						bool1= number==null;
						bool2= name==null;
						System.out.println("UPDATE :: number ==null >>> : "+bool1);
						System.out.println("입력된 회원번호 가 >>> : "+number);
						System.out.println("UPDATE :: name == null >>> : "+bool2);
						System.out.println("수정할 회원이름이 >>> : "+name);
					}
				} // if(ans==3)
				
				
				// DELETE
				if (ans==4){
					System.out.println(ans+"번을 입력하셨습니다.");
					T6_Scr ts4=new T6_Scr();
					boolean b4=false;
					String number="";
					
					System.out.println("삭제할 회원 번호을 입력하여 주십시오.");
					Scanner sc2=new Scanner(System.in);
					number=sc2.next();
					
					b4=ts4.t6Delete(number);
					
					if (b4){
						System.out.println("DELETE 완료");
					}else {System.out.println("DELETE 실패 :: "+b4);}
				} // if(ans==4)
				
				
				// EXIT
				if (ans==0){
					System.out.println("입력하신 번호는 "+ans+"번 입니다.");
					System.out.println("0 입력 :: ISUD 프로그램을 종료합니다. ");
					sc.close();
					System.exit(0);
				}
				
				// ERROR
				if (ans>4 || ans<0){
					System.out.println("잘못된 값을 입력하셨습니다. 잘못 입력된 값 >>> : "+ans);
					System.out.println("ISUD 프로그램을 프로그램을 종료합니다.");
					sc.close();
					System.exit(0);
				}
			}
		}catch(Exception e){
			System.out.println("T6_Scr :: main :: error >>> "+e.getMessage());
		}finally{
			if (sc!=null){
				try {sc.close(); sc=null;}catch(Exception e1){}
			}
			System.out.println("<<< ISUD 프로그램을 종료합니다. >>> ");
		}
	} // main method
} // T6_Scr class
