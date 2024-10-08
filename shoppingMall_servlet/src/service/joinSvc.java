package service;

import dao.loginDaoImpl;
import dto.memberDto;

public class joinSvc {
	
	public static loginDaoImpl ldao = new loginDaoImpl();
	public static memberDto member = new memberDto();
	
	public int join(String id, String pw, String name) {		
		boolean tf = ldao.checkId(id);
		
		if(tf != true) {
			member.setId(id);
			member.setPw(pw);
			member.setMname(name);
			
			ldao.join(member);
			return 1;
		} else {
			return 2;
		}		

	}
}
