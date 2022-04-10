package a.b.c.ch4.mem.vo;

public class MemberVO {

	private String mid;
	private String mpw;
	private String mname;
	private String mhp;
	private String maddr;
	
	
	public MemberVO() {
	
	}

	public MemberVO(String mid, String mpw, String mname, String mhp, String maddr) {
		
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mhp = mhp;
		this.maddr = maddr;
	}
	
	public String getMid() {
		return mid;
	}
	public String getMpw() {
		return mpw;
	}
	public String getMname() {
		return mname;
	}
	public String getMhp() {
		return mhp;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setMhp(String mhp) {
		this.mhp = mhp;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
}
