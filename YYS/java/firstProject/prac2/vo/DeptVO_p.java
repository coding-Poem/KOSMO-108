package a.b.c.prac2.vo;

public class DeptVO_p {
	private String deptno;
	private String dname;
	private String loc;
	
	public DeptVO_p(){
		
	}
	
	public DeptVO_p(String deptno, String dname, String loc){
		this.deptno=deptno;
		this.dname=dname;
		this.loc=loc;
	}

	public String getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
