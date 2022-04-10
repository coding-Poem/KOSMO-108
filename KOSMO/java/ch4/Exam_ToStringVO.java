package a.b.c.ch4;

public class Exam_ToStringVO extends Object{
	
	private String sval;
	private int ival;
	
	public Exam_ToStringVO() {
		
	}

	public Exam_ToStringVO(String sval, int ival) {
		
		this.sval = sval;
		this.ival = ival;
	}
	
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
	public String toString() {		
		return sval + " , " + ival;
	}	
}
