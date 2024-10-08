package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.productDto;
import service.productSvc;

@WebServlet("/product")
public class productCtrl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private productSvc psvc = null;
	private productDto pdto = new productDto();
	
	@Override
	protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String htmlHead = "<html><head><title>상품페이지</title><p><a href='/shoppingMall_servlet/login'>로그아웃</a></p></head><body>";
		String htmlTable = "<thead><tr>"		
        +"<th style='border-left: none;'>상품번호</th>"		
        +"<th>상품명</th>"
        +"<th style='border-right: none;'>가격</th>"	
        +"</tr></thead>";
		String htmlSearch = "<input type='text' placeholder='검색할 항목 입력' name='search'/>"
				+ "<input type='submit' value='검색'/>";
		String htmlTail = "</body></html>";
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// 파라메터 처리
		// req.getParameter("name");
		String word = req.getParameter("search");		
		
		// 서비스 호출
		psvc = new productSvc();
		List<productDto> pList = psvc.printList();
		List<productDto> sWord = null;
		
		if (word != null && !word.isEmpty()) {
		    sWord = psvc.search(word);
		}
		// 웹브라우저 데이터 전송
		// out.println("");
		out.println(htmlHead);
		out.println("<h2>상품리스트</h2>");
		out.println("<form method='GET' action='/shoppingMall_servlet/product' id='product-form'>");
		out.println(htmlSearch);
		out.println("</form>");
		out.println("<table border=\"1\">"); // 테이블 시작 태그
		out.println(htmlTable);
        // 각 항목을 테이블 행으로 추가
		if (sWord != null) {
		    for (productDto item : sWord) {
			    out.println("<tr><td>");
			    out.println(item.getPno());
			    out.println("</td><td>");
			    out.println(item.getPname());
			    out.println("</td><td>");
			    out.println(item.getPrice());
			    out.println("</td></tr>");
		    }
		} else { // 검색 결과가 없는 경우
		    // 각 항목을 테이블 행으로 추가
		    for (productDto item : pList) {
		        out.println("<tr><td>");
		        out.println(item.getPno());
		        out.println("</td><td>");
		        out.println(item.getPname());
		        out.println("</td><td>");
		        out.println(item.getPrice());
		        out.println("</td></tr>");
		    }
		}
        out.println("</table>"); // 테이블 종료 태그
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
