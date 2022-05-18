package a.b.c.com.kosmo.member.vo;

public class KosmoMemberVO {
	private String kmnum;
	private String kmid;
	private String kmpw;
	private String kmname;
	private String kmhp;
	private String kmemail;
	private String kmzone;
	private String kmroad;
	private String kmroad2;
	private String kmjibun;
	private String kmimage;
	private String mdeleteyn;
	private String minsertdate;
	private String mupdatedate;
	
	// search 변수
	// 회원 조회 시작일, 회원 조회 마감일 
	private String keyword;			// 검색어
	private String searchFilter;	// 검색조건
	private String startDate;		// 검색기간 시작일
	private String endDate;			// 검색기간 종료일
	
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	public KosmoMemberVO(){
		
	}

	public KosmoMemberVO(String kmnum, String kmid, String kmpw, String kmname, String kmhp, String kmemail,
			String kmzone, String kmroad, String kmroad2, String kmjibun, String kmimage, String mdeleteyn,
			String minsertdate, String mupdatedate) {
		this.kmnum = kmnum;
		this.kmid = kmid;
		this.kmpw = kmpw;
		this.kmname = kmname;
		this.kmhp = kmhp;
		this.kmemail = kmemail;
		this.kmzone = kmzone;
		this.kmroad = kmroad;
		this.kmroad2 = kmroad2;
		this.kmjibun = kmjibun;
		this.kmimage = kmimage;
		this.mdeleteyn = mdeleteyn;
		this.minsertdate = minsertdate;
		this.mupdatedate = mupdatedate;
	}
	
	

	public KosmoMemberVO(String kmnum, String kmid, String kmpw, String kmname, String kmhp, String kmemail,
			String kmzone, String kmroad, String kmroad2, String kmjibun, String kmimage, String mdeleteyn,
			String minsertdate, String mupdatedate, String keyword, String searchFilter, String startDate,
			String endDate, String pageSize, String groupSize, String curPage, String totalCount) {
		this.kmnum = kmnum;
		this.kmid = kmid;
		this.kmpw = kmpw;
		this.kmname = kmname;
		this.kmhp = kmhp;
		this.kmemail = kmemail;
		this.kmzone = kmzone;
		this.kmroad = kmroad;
		this.kmroad2 = kmroad2;
		this.kmjibun = kmjibun;
		this.kmimage = kmimage;
		this.mdeleteyn = mdeleteyn;
		this.minsertdate = minsertdate;
		this.mupdatedate = mupdatedate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getKmnum() {
		return kmnum;
	}

	public String getKmid() {
		return kmid;
	}

	public String getKmpw() {
		return kmpw;
	}

	public String getKmname() {
		return kmname;
	}

	public String getKmhp() {
		return kmhp;
	}

	public String getKmemail() {
		return kmemail;
	}

	public String getKmzone() {
		return kmzone;
	}

	public String getKmroad() {
		return kmroad;
	}

	public String getKmroad2() {
		return kmroad2;
	}

	public String getKmjibun() {
		return kmjibun;
	}

	public String getKmimage() {
		return kmimage;
	}

	public String getMdeleteyn() {
		return mdeleteyn;
	}

	public String getMinsertdate() {
		return minsertdate;
	}

	public String getMupdatedate() {
		return mupdatedate;
	}

	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
	}

	public void setKmid(String kmid) {
		this.kmid = kmid;
	}

	public void setKmpw(String kmpw) {
		this.kmpw = kmpw;
	}

	public void setKmname(String kmname) {
		this.kmname = kmname;
	}

	public void setKmhp(String kmhp) {
		this.kmhp = kmhp;
	}

	public void setKmemail(String kmemail) {
		this.kmemail = kmemail;
	}

	public void setKmzone(String kmzone) {
		this.kmzone = kmzone;
	}

	public void setKmroad(String kmroad) {
		this.kmroad = kmroad;
	}

	public void setKmroad2(String kmroad2) {
		this.kmroad2 = kmroad2;
	}

	public void setKmjibun(String kmjibun) {
		this.kmjibun = kmjibun;
	}

	public void setKmimage(String kmimage) {
		this.kmimage = kmimage;
	}

	public void setMdeleteyn(String mdeleteyn) {
		this.mdeleteyn = mdeleteyn;
	}

	public void setMinsertdate(String minsertdate) {
		this.minsertdate = minsertdate;
	}

	public void setMupdatedate(String mupdatedate) {
		this.mupdatedate = mupdatedate;
	}
	
	// 추가된 getter and setter
	public String getKeyword() {
		return keyword;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getPageSize() {
		return pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
}
