package a.b.c.oracle.vo;

public class EmpVO {

	/*
	사원번호		EMPNO		NUMBER
	사원이름		ENAME		VARCHAR2
	사원직책		JOB			VARCHAR2
	상관사원번호	MGR			VARCHAR2
	입사일		HIREDATE	DATE
	급여			SAL			NUMBER
	수당			COMM		NUMBER
	부서번호		DEPTNO		NUMBER
	*/

	// 컬럼명 --> 변수명 : 소문자
	// 데이터타입 NUMBER, VARCHAR2, DATE -> 전부다 문자열로 한다. String
	
	// empno : 멤버변수, 스트링,  인포메이션 하이딩 
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
	
	// constructor
	public EmpVO() {
		
	}
	
	public EmpVO(	String empno, String ename, 
					String job, String mgr, 
					String hiredate, String sal, 
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

	// 날짜 검색 관련 getter setter 함수 추가 
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
