package dao;

public interface loginDao {
	public static final String checkIdSql = 
			"SELECT COUNT(id) FROM member WHERE id = ?";
	
	public static final String joinSql = 
			"INSERT INTO member(mno, id, pw, mname, rank)"
			+ "VALUES(member_mno_seq.nextval, ?, ?, ?, 1)";
	
	public static final String loginSql = 
			"select * from member where id=? and pw =?";
	
	public static final String blackSql = 
			"SELECT m.mno FROM member m INNER JOIN black b ON m.mno = b.mno";
}
