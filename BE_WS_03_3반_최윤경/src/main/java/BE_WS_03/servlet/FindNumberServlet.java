package BE_WS_03.servlet;

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
@WebServlet("/find_number.do")
public class FindNumberServlet extends HttpServlet {
	
	private int com_num;
	
	@Override
	public void init() throws ServletException {
		com_num = new Random().nextInt(100)+1;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/find_number.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_num = request.getParameter("user_num");
		int un = Integer.parseInt(user_num);
		
		if (com_num > un) {
			request.setAttribute("result", ": 올려주세요");
		} else if (com_num < un) {
			request.setAttribute("result", ": 내려주세요");
		} else {
			request.setAttribute("result", ": 정답입니다");
		}
		
		String url = "/find_number.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
