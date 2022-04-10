package a.b.c.t6.vo;

public class T6VO {

	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	
	// 날짜 검색 프로퍼티 추가 
	private String fromdate;
	private String todate;
	
	// Constructor
	public T6VO() {

	}

	public T6VO(String t1, String t2, String t3, String t4, String t5, String t6) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
	}
	
	// getter
	public String getT1() {
		return t1;
	}
	public String getT2() {
		return t2;
	}
	public String getT3() {
		return t3;
	}
	public String getT4() {
		return t4;
	}
	public String getT5() {
		return t5;
	}
	public String getT6() {
		return t6;
	}
	
	// setter 
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	public void setT5(String t5) {
		this.t5 = t5;
	}
	public void setT6(String t6) {
		this.t6 = t6;
	}
	
	// 날짜 데이터 getter/setter
	public String getFromdate() {
		return fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	// 프린트 함수 
	public static void printT6VO(T6VO tvo) {
		System.out.print(tvo.getT1() + ", ");
		System.out.print(tvo.getT2() + ", ");
		System.out.print(tvo.getT3() + ", ");
		System.out.print(tvo.getT4() + ", ");
		System.out.print(tvo.getT5() + ", ");
		System.out.println(tvo.getT6());
	}

	public static void printlnT6VO(T6VO tvo) {
		System.out.println("tvo.getT1() >>> : " + tvo.getT1());
		System.out.println("tvo.getT2() >>> : " + tvo.getT2());
		System.out.println("tvo.getT3() >>> : " + tvo.getT3());
		System.out.println("tvo.getT4() >>> : " + tvo.getT4());
		System.out.println("tvo.getT5() >>> : " + tvo.getT5());
		System.out.println("tvo.getT6() >>> : " + tvo.getT6());
		System.out.println("tvo.getFromdate() >>> : " + tvo.getFromdate());
		System.out.println("tvo.getTodate() >>> : " + tvo.getTodate());
	}

}
