package a.b.c.kos.vo;


public class MemVO {
		private String mnum; // 회원 번호
		private String mname; // 회원 이름
		private String mid; // 아이디
		private String mpw; // 패스워드
		private String mhp; // 핸드폰 번호
		private String memail; // 이메일
		private String mgender; // 성별
		private String mhobby; // 취미
		private String mlocal; // 지역
		private String mmsg; // 내용
		private String deleteyn; // 회원여부
		private String insertdate; // 등록일
		private String updatedate; // 수정일
		private String fromdate; // 날짜 조회 시작일 
		private String todate; // 날짜 조회 마지막일
		
		// 생성자 오버로딩
		// 생성자 : constructor
		public MemVO(){
			
		}
		
		// 매개변수 있는 생성자
		public MemVO(String mnum, String mname, String mid, String mpw, String mhp, String memail, String mgender,
				String mhobby, String mlocal, String mmsg, String deleteyn, String insertdate, String updatedate
				,String fromdate, String todate
				) {
			this.mnum = mnum;
			this.mname = mname;
			this.mid = mid;
			this.mpw = mpw;
			this.mhp = mhp;
			this.memail = memail;
			this.mgender = mgender;
			this.mhobby = mhobby;
			this.mlocal = mlocal;
			this.mmsg = mmsg;
			this.deleteyn = deleteyn;
			this.insertdate = insertdate;
			this.updatedate = updatedate;
			this.fromdate=fromdate;
			this.todate=todate;
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
		
		// fromdate
		public void setFromdate(String fromdate) {
			this.fromdate = fromdate;
		}
		
		// todate
		public void setTodate(String todate) {
			this.todate = todate;
		}		
		
		// 프린트 함수
		public static void printMemVO(MemVO mvo){
			System.out.print(mvo.getMnum()+" : ");
			System.out.print(mvo.getMname()+" : ");
			System.out.print(mvo.getMid()+" : ");
			System.out.print(mvo.getMpw()+" : ");
			System.out.print(mvo.getMhp()+" : ");
			System.out.print(mvo.getMemail()+" : ");
			System.out.print(mvo.getMgender()+" : ");
			System.out.print(mvo.getMhobby()+" : ");
			System.out.print(mvo.getMlocal()+" : ");
			System.out.print(mvo.getMmsg()+" : ");
			System.out.print(mvo.getDeleteyn()+" : ");
			System.out.print(mvo.getInsertdate()+" : ");
			System.out.print(mvo.getUpdatedate());
		}
		
		public static void printlnMemVO(MemVO mvo){
			System.out.println("mvo.getMnum() >>> : "+mvo.getMnum()+", ");
			System.out.println("mvo.getMname() >>> : "+mvo.getMname()+", ");
			System.out.println("mvo.getMid() >>> : "+mvo.getMid()+", ");
			System.out.println("mvo.getMpw() >>> : "+mvo.getMpw()+", ");
			System.out.println("mvo.getMhp() >>> : "+mvo.getMhp()+", ");
			System.out.println("mvo.getMemail() >>> : "+mvo.getMemail()+", ");
			System.out.println("mvo.getMgender() >>> : "+mvo.getMgender()+", ");
			System.out.println("mvo.getMhobby() >>> : "+mvo.getMhobby()+", ");
			System.out.println("mvo.getMlocal() >>> : "+mvo.getMlocal()+", ");
			System.out.println("mvo.getMmsg() >>> : "+mvo.getMmsg()+", ");
			System.out.println("mvo.getDeleteyn() >>> : "+mvo.getDeleteyn()+", ");
			System.out.println("mvo.getInsertdate() >>> : "+mvo.getInsertdate()+", ");
			System.out.println("mvo.getUpdatedate() >>> : "+mvo.getUpdatedate());
		}
}
