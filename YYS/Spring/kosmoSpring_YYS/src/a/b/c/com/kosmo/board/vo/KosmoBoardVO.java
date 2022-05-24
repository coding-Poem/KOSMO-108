package a.b.c.com.kosmo.board.vo;

public class KosmoBoardVO {
	private String kbnum;
	private String kbsubject;
	private String kbname;
	private String kbcontent;
	private String kbfile;
	private String kbpw;
	private String mdeleteyn;
	private String minsertdate;
	private String mupdatedate;
	
	public KosmoBoardVO(){
		
	}

	public KosmoBoardVO(String kbnum, String kbsubject, String kbname, String kbcontent, String kbfile, String kbpw,
			String mdeleteyn, String minsertdate, String mupdatedate) {
		this.kbnum = kbnum;
		this.kbsubject = kbsubject;
		this.kbname = kbname;
		this.kbcontent = kbcontent;
		this.kbfile = kbfile;
		this.kbpw = kbpw;
		this.mdeleteyn = mdeleteyn;
		this.minsertdate = minsertdate;
		this.mupdatedate = mupdatedate;
	}

	public String getKbnum() {
		return kbnum;
	}

	public String getKbsubject() {
		return kbsubject;
	}

	public String getKbname() {
		return kbname;
	}

	public String getKbcontent() {
		return kbcontent;
	}

	public String getKbfile() {
		return kbfile;
	}

	public String getKbpw() {
		return kbpw;
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

	public void setKbnum(String kbnum) {
		this.kbnum = kbnum;
	}

	public void setKbsubject(String kbsubject) {
		this.kbsubject = kbsubject;
	}

	public void setKbname(String kbname) {
		this.kbname = kbname;
	}

	public void setKbcontent(String kbcontent) {
		this.kbcontent = kbcontent;
	}

	public void setKbfile(String kbfile) {
		this.kbfile = kbfile;
	}

	public void setKbpw(String kbpw) {
		this.kbpw = kbpw;
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
	
}
