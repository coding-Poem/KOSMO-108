package a.b.c.com.kosmo.cart.vo;

public class KosmoCartVO {
	private String mcnum;
	private String kmnum;
	private String mid;
	private String mnum;
	private String mcnt;
	private String mname;
	private String mprice;
	private String mpricesum;
	private String mdes;
	private String mcom;
	private String mimg;
	private String minsertdate;
	private String mupdatedate;
	private String mdeleteyn;
	
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
	
	public KosmoCartVO(){
		
	}

	public KosmoCartVO(String mcnum, String kmnum, String mid, String mcnt, String mname, String mprice,
			String mpricesum, String mdes, String mcom, String mimg, String minsertdate, String mupdatedate,
			String mdeleteyn) {
		this.mcnum = mcnum;
		this.kmnum = kmnum;
		this.mid = mid;
		this.mcnt = mcnt;
		this.mname = mname;
		this.mprice = mprice;
		this.mpricesum = mpricesum;
		this.mdes = mdes;
		this.mcom = mcom;
		this.mimg = mimg;
		this.minsertdate = minsertdate;
		this.mupdatedate = mupdatedate;
		this.mdeleteyn = mdeleteyn;
	}
	
	

	public KosmoCartVO(String mcnum, String kmnum, String mid, String mcnt, String mname, String mprice,
			String mpricesum, String mdes, String mcom, String mimg, String minsertdate, String mupdatedate,
			String mdeleteyn, String keyword, String searchFilter, String startDate, String endDate, String pageSize,
			String groupSize, String curPage, String totalCount) {
		this.mcnum = mcnum;
		this.kmnum = kmnum;
		this.mid = mid;
		this.mcnt = mcnt;
		this.mname = mname;
		this.mprice = mprice;
		this.mpricesum = mpricesum;
		this.mdes = mdes;
		this.mcom = mcom;
		this.mimg = mimg;
		this.minsertdate = minsertdate;
		this.mupdatedate = mupdatedate;
		this.mdeleteyn = mdeleteyn;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getMcnum() {
		return mcnum;
	}

	public String getKmnum() {
		return kmnum;
	}

	public String getMid() {
		return mid;
	}

	public String getMnum() {
		return mnum;
	}

	public String getMcnt() {
		return mcnt;
	}

	public String getMname() {
		return mname;
	}

	public String getMprice() {
		return mprice;
	}

	public String getMpricesum() {
		return mpricesum;
	}

	public String getMdes() {
		return mdes;
	}

	public String getMcom() {
		return mcom;
	}

	public String getMimg() {
		return mimg;
	}

	public String getMinsertdate() {
		return minsertdate;
	}

	public String getMupdatedate() {
		return mupdatedate;
	}

	public String getMdeleteyn() {
		return mdeleteyn;
	}

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

	public void setMcnum(String mcnum) {
		this.mcnum = mcnum;
	}

	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public void setMcnt(String mcnt) {
		this.mcnt = mcnt;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setMprice(String mprice) {
		this.mprice = mprice;
	}

	public void setMpricesum(String mpricesum) {
		this.mpricesum = mpricesum;
	}

	public void setMdes(String mdes) {
		this.mdes = mdes;
	}

	public void setMcom(String mcom) {
		this.mcom = mcom;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public void setMinsertdate(String minsertdate) {
		this.minsertdate = minsertdate;
	}

	public void setMupdatedate(String mupdatedate) {
		this.mupdatedate = mupdatedate;
	}

	public void setMdeleteyn(String mdeleteyn) {
		this.mdeleteyn = mdeleteyn;
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
