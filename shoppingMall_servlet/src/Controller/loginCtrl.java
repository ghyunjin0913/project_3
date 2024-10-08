package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDto;
import service.loginSvc;

@WebServlet("/login")
public class loginCtrl extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private loginSvc lsvc = null;
	private memberDto mdto = new memberDto();
	
	@Override
	protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String htmlHead = "<html><head><meta charset='EUC-KR'><title>입구</title>";
		String htmlBody = "<h2>안녕하세요.쇼핑몰입니다.^^</h2>"
				+ "<form method='GET' action='/shoppingMall_servlet/login' id='login-form'>"
				+ "<p><b>id: </b><input type='text' name='userId' placeholder='id'></p>"
				+ "<p><b>pw: </b><input type='password' name='userPassword' placeholder='Password'></p>"
				+ "<input type='submit' value='로그인'>"
				+ "<input type='button' value='회원가입' onClick=location.href='/shoppingMall_servlet/join'>"
				+ "</form>";
		String htmlTail = "</body></html>";
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// 파라메터 처리
		// req.getParameter("name");
		String id = req.getParameter("userId");		
		String pw = req.getParameter("userPassword");
		
		// 서비스 호출
		lsvc = new loginSvc();
		int loginResult = 0;
		if (id != null && !id.isEmpty()) {  // id값이 입력된 경우 로그인 메소드 실행
			loginResult = lsvc.login(id, pw);
		}
		// 웹브라우저 데이터 전송
		// out.println("");
		if (loginResult == 0) {  // 처음 접속 시
			out.println(htmlHead);
			out.println("</head><body>");
			out.println(htmlBody);
			out.println(htmlTail);
		} else if (loginResult == 1) {   // 로그인 성공
			resp.sendRedirect("http://localhost:8090/shoppingMall_servlet/product");
		} else if (loginResult == 2) {   // 블랙리스트
			out.println(htmlHead);
			out.println("<script type='text/javascript'>alert('권한이 없는 사용자 입니다. 종료합니다.'); </script>");
			out.println("</head><body>");
			out.println(htmlBody);
			out.println(htmlTail);
		} else if (loginResult == 3) {   // 로그인 실패
			out.println(htmlHead);
			out.println("<script type='text/javascript'>alert('로그인 실패'); </script>");
			out.println("</head><body>");
			out.println(htmlBody);
			out.println(htmlTail);
		} 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
