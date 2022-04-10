package a.b.c.emp.search.vo;

/*
자바 Beans 컴포넌트 개념(setter, getter 함수 사용) : 데이터를 담는 역활 

DTO : Data Transfer Object 패턴 : 데이터를 나르는 역활 <-- 이전 용어 

현재는 밸유 오브젝트라고 사용한다. 
VO : Value Object : 데이터를 담는 통 역활을 한다. : 깡통 클래스 

*/ 
public class EmpSearchVO {

	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
	
	// 날짜 검색 변수 추가 
	private String fromdate;
	private String todate;
		
	// 생성자
	public EmpSearchVO() {
		
	}

	public EmpSearchVO(String empno, String ename, String job, 
						String mgr, String hiredate, String sal, 
						String comm, String deptno) {		
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	// getter
	public String getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public String getMgr() {
		return mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public String getSal() {
		return sal;
	}
	public String getComm() {
		return comm;
	}
	public String getDeptno() {
		return deptno;
	}
	
	// setter
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	// 날짜 검색 getter, setter 추가 
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
}
