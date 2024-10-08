package service;


import dao.loginDaoImpl;

public class loginSvc {
	public loginDaoImpl ldao = new loginDaoImpl();
	
	public int login(String id, String pw)  {
		int result = ldao.login(id, pw);
		return result;
	}
}
