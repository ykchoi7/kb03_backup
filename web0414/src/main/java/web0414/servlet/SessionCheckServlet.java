package web0414.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCheckServlet
 */
@WebServlet("/SessionCheckServlet")
public class SessionCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//브라우저 전용 저장공간 - 서버가 접속정보 없이 오면 브라우저가 쿠키를 제공함으로써 전용 사물함 번호 부여해줌
		HttpSession session = request.getSession();
		//값 추출
		Object v = session.getAttribute("k1");
		System.out.println("k1=" +v); //아무것도 들어가있지 않은 경우 console에 계속 null이 출력
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
