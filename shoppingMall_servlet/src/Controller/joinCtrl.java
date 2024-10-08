package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDto;
import service.joinSvc;

@WebServlet("/join")
public class joinCtrl extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private joinSvc jsvc = null;
	private memberDto mdto = new memberDto();
	
	@Override
	protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String htmlHead = "<html><head><meta charset='UTF-8'><title>Join</title>";
		String htmlBody = "<h2>회원가입</h2>"
				+ "<form method='GET' action='/shoppingMall_servlet/join' id='join-form'>"
				+ "<p><b>아이디: </b><input type='text' name='userId' placeholder='id'></p>"
				+ "<p><b>비밀번호: </b><input type='password' name='userPassword' placeholder='Password'></p>"
				+ "<p><b>이름: </b><input type='text' name='userName' placeholder='이름'></p>"
				+ "<input type='submit' value='가입'>"
				+ "</form>";
		String htmlTail = "</body></html>";
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// 파라메터 처리
		// req.getParameter("name");
		String id = req.getParameter("userId");		
		String pw = req.getParameter("userPassword");
		String name = req.getParameter("userName");
		
		// 서비스 호출
		jsvc = new joinSvc();
		int join = 0;
		if(id != null && !id.isEmpty()) {
			join = jsvc.join(id, pw, name);
		}
		
		// 웹브라우저 데이터 전송
		// out.println("");		
		if(join == 0) {
			out.println(htmlHead);
			out.println("</head><body>");
			out.println(htmlBody);
			out.println(htmlTail);
		}
		else if (join == 1) {
			resp.sendRedirect("/shoppingMall_servlet/login");
		} else {
			out.println(htmlHead);
			out.println("<script type='text/javascript'>alert('회원가입 실패'); </script>");
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
