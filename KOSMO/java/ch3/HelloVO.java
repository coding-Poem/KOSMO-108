package a.b.c.ch3;

public class HelloVO {
	
	private String mid;
	private String mpw;
	private String mname;
	//  private 접근제한자는 class 밖을 벗어나지 못한다.
	// public 생성자를 만든뒤, this키워드를 통해 
	// 외부에서 사용가능하도록 한다. (정보의 은닉화)
	
	public HelloVO() {
		//super();
	} // 기본 생성자

	public HelloVO(String mid, String mpw, String mname) {
		//super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
	} // 매개변수가 있는 생성자
	
	// getter method
	public String getMid() {
		return mid;
		// 현재의 mid 변수를 return 값으로 반환한다.
	} 
	public String getMpw() {
		return mpw;
		// 현재의 mpw 변수를 return 값으로 반환한다.
	}
	public String getMname() {
		return mname;
		// 현재의 mname 변수를 return 값으로 반환한다.
	}
	
	// setter method
	public void setMid(String mid) {
		this.mid = mid;
		// 현재 HelloVO 클래스의 private String mid에 매개변수에 들어온 인수로 초기화 된,
		// mid를 대입한다.
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
		// 현재 HelloVO 클래스의  private String mpw에 매개변수에 들어온 인수로 초기화 된,
		// mpw를 대입한다.
	}
	public void setMname(String mname) {
		this.mname = mname;
		// 현재 HelloVO 클래스의  private String mname에 매개변수에 들어온 인수로 초기화 된,
		// mname을 대입한다.
	}
	
}
