package dto;

public class memberDto {
	private int mno;
	private String id;
	private String pw;
	private static String mname;
	private static int rank;
	
	public memberDto() {;}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public static String getMname() {
		return mname;
	}
	@SuppressWarnings("static-access")
	public void setMname(String mname) {
		this.mname = mname;
	}
	public static int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
