package a.b.c.kos.mem.vo;

public class MemVO {
	private String mnum; 	     // 회원 번호
	private String mname; 	     // 회원 이름
	private String mid; 	     // 아이디
	private String mpw; 	     // 패스워드
	private String mhp; 	     // 핸드폰번호
	private String memail; 	     // 이메일
	private String mgender;      // 성별
	private String mhobby; 	     // 취미
	private String mzone; 		 // 우편번호
	private String mroad; 		 // 도로명주소
	private String mroaddetail;  // 도로명주소(상세)
	private String mjibun; 		 // 지번주소
	private String mlocal; 		 // 지역
	private String mmsg; 		 // 내용
	private String deleteyn; 	 // 회원여부
	private String insertdate; 	 // 등록일
	private String updatedate; 		 // 수정일
	private String searchFilter; // 검색조건
	private String keyword; 	 // 검색어
	private String fromdate; 	 // 검색기간 시작일
	private String todate; 		 // 검색기간 종료일

	// 생성자 오버로딩
	// 기본 생성자
	public MemVO(){
		
	}
	
	// 매개변수 있는 생성자
	public MemVO(String mnum, String mname, String mid, String mpw, String mhp, String memail, String mgender,
			String mhobby, String mzone, String mroad, String mroaddetail, String mjibun, String mlocal, String mmsg,
			String deleteyn, String insertdate, String updatedate, String searchFilter, String keyword, String fromdate,
			String todate) {
		super();
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.mhp = mhp;
		this.memail = memail;
		this.mgender = mgender;
		this.mhobby = mhobby;
		this.mzone = mzone;
		this.mroad = mroad;
		this.mroaddetail = mroaddetail;
		this.mjibun = mjibun;
		this.mlocal = mlocal;
		this.mmsg = mmsg;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.searchFilter = searchFilter;
		this.keyword = keyword;
		this.fromdate = fromdate;
		this.todate = todate;
	}
	
	// getter method
	public String getMnum() {
		return mnum;
	}

	public String getMname() {
		return mname;
	}

	public String getMid() {
		return mid;
	}

	public String getMpw() {
		return mpw;
	}

	public String getMhp() {
		return mhp;
	}

	public String getMemail() {
		return memail;
	}

	public String getMgender() {
		return mgender;
	}

	public String getMhobby() {
		return mhobby;
	}

	public String getMzone() {
		return mzone;
	}

	public String getMroad() {
		return mroad;
	}

	public String getMroaddetail() {
		return mroaddetail;
	}

	public String getMjibun() {
		return mjibun;
	}

	public String getMlocal() {
		return mlocal;
	}

	public String getMmsg() {
		return mmsg;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getFromdate() {
		return fromdate;
	}

	public String getTodate() {
		return todate;
	}
	
	// setter method
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public void setMhp(String mhp) {
		this.mhp = mhp;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public void setMhobby(String mhobby) {
		this.mhobby = mhobby;
	}

	public void setMzone(String mzone) {
		this.mzone = mzone;
	}

	public void setMroad(String mroad) {
		this.mroad = mroad;
	}

	public void setMroaddetail(String mroaddetail) {
		this.mroaddetail = mroaddetail;
	}

	public void setMjibun(String mjibun) {
		this.mjibun = mjibun;
	}

	public void setMlocal(String mlocal) {
		this.mlocal = mlocal;
	}

	public void setMmsg(String mmsg) {
		this.mmsg = mmsg;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}
}
