package web0414.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNumberServlet
 */
@WebServlet("/find_number")
public class FindNumberServlet extends HttpServlet {
	
	private int com_num;
	
	@Override
	public void init() throws ServletException {
		//서블릿이 최초 생성 이후 한번만 실행
		com_num = new Random().nextInt(100)+1; //random으로 뽑으면 0~99까지 출력되기 때문
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (com_num == 0) //초기화 안한 상태
//			com_num = new Random().nextInt(100) +1;
		
		String user_num = request.getParameter("user_num");
		int un = Integer.parseInt(user_num);
		String msg = "";
		if (com_num > un)
			msg = "높여주세요~";
		else if (com_num < un)
			msg = "낮춰주세요~";
		else
			msg = "정답입니다";
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(msg);
	}

}
