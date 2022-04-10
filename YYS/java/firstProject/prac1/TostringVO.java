package a.b.c.prac1;

public class TostringVO extends Object{
	private String sval;
	private int ival;
	public TostringVO(){
		
	} // 기본생성자
	
	public TostringVO(String sval, int ival) {
		this.sval=sval;
		this.ival=ival;
	} // 매개변수 있는 생성자

	public String getSval() {
		return sval;
	}

	public int getIval() {
		return ival;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	public void setIval(int ival) {
		this.ival = ival;
	}
	
	@Override
	public String toString(){
		return sval+ " , "+ival;
	}

}
