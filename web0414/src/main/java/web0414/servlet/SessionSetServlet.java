package web0414.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionSetServlet
 */
@WebServlet("/SessionSetServlet")
public class SessionSetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("k1", new java.util.Date());
		//k1이라는 같은 정보로 접근하는게 중요!
		System.out.println("k1에 날짜 저장");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	//나중에 session에 정보 있으면 로그인한 애, 정보 없으면 로그인 안한 애 이런식으로 구분할 때 사용

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
